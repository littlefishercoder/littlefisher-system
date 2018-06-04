package com.littlefisher.core.common.i18n;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.littlefisher.core.common.stereotype.constants.BaseConstants;
import com.littlefisher.core.common.utils.LittleFisherLogger;
import com.littlefisher.core.common.utils.StringUtil;

/**
 * 资源加载
 * <p>
 * Created on 2017年1月3日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Component
public class PropResourceImpl implements PropResource, InitializingBean {

    /** logger */
    private static LittleFisherLogger logger = LittleFisherLogger.getLogger(PropResourceImpl.class);

    private static final String WINDOWS = "windows";

    private static final String UNIX = "unix";

    /**
     * 缓存资源文件 第一层Map是根据语言进行分类，第二层是Properties
     */
    private static Map<String, Properties> resourceMap = Maps.newConcurrentMap();

    /**
     * 第一次加载时初始化资源文件
     */
    @Override
    public void init() {
        getResourceValueList(findFileNameSuffix());
    }

    /**
     * 遍历SYSTEM_HOME/resource目录下所有文件名，筛选出一共有几种语言
     * 
     * @return 所有的文件
     */
    private List<File> findFileNameSuffix() {
        String littleFisherHome = initHomePath();
        String resourceDir = littleFisherHome + File.separator + BaseConstants.I18N_RESOURCE_PATH;
        List<File> allFileList = getAllFileName(resourceDir);
        allFileList.forEach(file -> {
            String name = file.getName().substring(0, file.getName().length() - BaseConstants.PROPERTIES_LENGTH);
            int index = name.lastIndexOf(".");
            String local = name.substring(index + 1, name.length());
            resourceMap.put(local, new Properties());
        });
        return allFileList;
    }

    /**
     * 获取所有文件名
     *
     * @param path 根目录路径
     * @return 所有以properties结尾的文件
     */
    private List<File> getAllFileName(String path) {
        List<File> list = Lists.newArrayList();
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (ArrayUtils.isEmpty(files)) {
            return list;
        }
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isDirectory()) {
                    list.addAll(getAllFileName(file.getPath()));
                } else {
                    if (file.getName().endsWith(BaseConstants.PROPERTIES_SUFFIX)) {
                        list.add(file);
                    }
                }
            });
        }
        return list;
    }

    /**
     * 查询SYSTEM_HOME目录地址
     *
     * @return String
     */
    private String initHomePath() {
        Properties systemProperties = System.getProperties();
        String systemHome = systemProperties.getProperty(BaseConstants.SYSTEM_HOME);
        if (StringUtil.isNotEmpty(systemHome)) {
            return systemHome;
        } else {
            String os = System.getProperties().getProperty("os.name").toLowerCase();
            try {
                InputStream inStream;
                if (os.contains(WINDOWS)) {
                    inStream = Runtime.getRuntime().exec("cmd   /C   set").getInputStream();
                } else if (os.contains(UNIX)) {
                    inStream = Runtime.getRuntime().exec("env").getInputStream();
                } else {
                    inStream = Runtime.getRuntime().exec("env").getInputStream();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(inStream, Charsets.ISO_8859_1));
                String line;
                while ((line = br.readLine()) != null) {

                    if (line.contains(BaseConstants.SYSTEM_HOME)) {
                        int idx = line.indexOf('=');
                        return line.substring(idx + 1).trim();
                    }

                }
            } catch (IOException e) {
                logger.error("env loader error", e);
            }
        }

        return null;
    }

    /**
     * 遍历SYSTEM_HOME/resource目录下所有文件内容，i18n信息加入缓存
     *
     * @param allFileList resource目录下所有的资源文件
     */
    private void getResourceValueList(List<File> allFileList) {
        Set<String> keys = resourceMap.keySet();
        keys.forEach(key -> {
            Properties properties = new Properties();
            for (File file : allFileList) {
                if (file.getName().contains("." + key + ".")) {
                    properties.putAll(readFile(file));
                }
            }
            resourceMap.put(key, properties);
        });
    }

    /**
     * 读取File数据
     * 
     * @param file 文件
     * @return 解析出来的参数
     */
    private Properties readFile(File file) {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8)));
            return properties;
        } catch (IOException e) {
            logger.error("IOException", e);
        }
        return properties;
    }

    /**
     * 根据方言和编码查询对应值
     * <p>
     * 如果所用方言不是en，但是却根据key查不到value时，会默认使用en再查询一下
     *
     * @param dialect 方言
     * @param key 编码
     * @return String 值
     */
    @Override
    public String getValue(String dialect, String key) {
        String value = (String) resourceMap.get(dialect).get(key);
        if (!BaseConstants.DIALECT_EN.equals(dialect) && StringUtil.isBlank(value)) {
            return (String) resourceMap.get(BaseConstants.DIALECT_EN).get(key);
        } else {
            return value;
        }
    }

    @Override
    public Properties getResource(String dialect) {
        return resourceMap.get(dialect);
    }

    @Override
    public void afterPropertiesSet() {
        init();
    }
}
