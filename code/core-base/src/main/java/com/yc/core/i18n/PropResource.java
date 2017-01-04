package com.yc.core.i18n;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.yc.core.i18n.utils.I18nConstants;
import com.yc.core.utils.Room1000Logger;
import com.yc.core.utils.StringUtil;

/**
 * 
 * Description: 资源加载
 *  
 * Created on 2017年1月3日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class PropResource {
    
    /** LOGGER */
    private static final Room1000Logger LOGGER = Room1000Logger.getLogger(PropResource.class);
    
    /**
     * 缓存资源文件
     * 第一层Map是根据语言进行分类，第二层Map根据Code查找Value
     */
    private static Map<String, Map<String, String>> resourceMap = new ConcurrentHashMap<String, Map<String, String>>();
    
    static {
        init();
    }
    
    /**
     * 单例构造函数
     */
    private PropResource() {
    }
    
    /**
     * 
     * Description: 第一次加载时初始化资源文件
     * 
     * @author jinyanan
     *
     */
    private static void init() {
        List<File> allFileList = findFileNameSuffix();
        getResourceValueList(allFileList);
    }

    /**
     * 
     * Description: 遍历YC_HOME/resource目录下所有文件名，筛选出一共有几种语言
     * 
     * @author jinyanan
     * 
     * @return List<File>
     */
    private static List<File> findFileNameSuffix() {
        String ycHome = initHomePath();
        String resourceDir = ycHome + File.separator + I18nConstants.I18N_RESOURCE_PATH;
        List<File> allFileList = new ArrayList<File>();
        getAllFileName(resourceDir, allFileList);
        for (File file : allFileList) {
            String name = file.getName().substring(0, file.getName().length() - I18nConstants.PROPERTIES_LENGTH);
            int index = name.lastIndexOf(".");
            String local = name.substring(index + 1, name.length());
            resourceMap.put(local, new ConcurrentHashMap<String, String>());
        }
        return allFileList;
    }
    
    /**
     * 
     * Description: 获取所有文件名
     * 
     * @author jinyanan
     *
     * @param path 根目录路径
     * @param list 所有文件名
     */
    private static void getAllFileName(String path, List<File> list) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFileName(file.getPath(), list);
            }
            else {
                if (file.getName().endsWith(".properties")) {
                    list.add(file);
                }
            }
        }
    }
    
    /**
     * 
     * Description: 查询YC_HOME目录地址
     * 
     * @author jinyanan
     *
     * @return String
     */
    private static String initHomePath() {
        Properties p = System.getProperties();
        String ycHome = p.getProperty(I18nConstants.YC_HOME);
        if (StringUtil.isNotEmpty(ycHome)) {
            return ycHome;
        }
        else {
            String os = System.getProperties().getProperty("os.name").toLowerCase();
            try {
                InputStream inStream = null;
                if (os.indexOf("windows") > -1) {
                    inStream = Runtime.getRuntime().exec("cmd   /C   set").getInputStream();
                }
                else if (os.indexOf("unix") > -1) {
                    inStream = Runtime.getRuntime().exec("env").getInputStream();
                }
                else {
                    inStream = Runtime.getRuntime().exec("env").getInputStream();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(inStream, "8859_1"));
                String line;
                while ((line = br.readLine()) != null) {

                    if (line.indexOf(I18nConstants.YC_HOME) >= 0) {
                        int idx = line.indexOf('=');
                        return line.substring(idx + 1).trim();
                    }
                    
                }
            }
            catch (IOException e) {
                LOGGER.error("env loader error", e);
            }
        }
        
        return null;
    }
    
    /**
     * 
     * Description: 遍历YC_HOME/resource目录下所有文件内容，i18n信息加入缓存
     * 
     * @author jinyanan
     * @param allFileList resource目录下所有的资源文件
     */
    private static void getResourceValueList(List<File> allFileList) {
        Set<String> keys = resourceMap.keySet();
        for (String key : keys) {
            Map<String, String> valueMap = new ConcurrentHashMap<String, String>();
            for (File file : allFileList) {
                if (file.getName().indexOf("." + key + ".") > -1) {
                    readFile(file, valueMap);
                }
            }
            resourceMap.put(key, valueMap);
        }
    }
    
    /**
     * 
     * Description: 读取File数据
     * 
     * @author jinyanan
     *
     * @param file file
     * @param valueMap valueMap
     */
    private static void readFile(File file, Map<String, String> valueMap) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                int idx = line.indexOf('=');
                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();
                valueMap.put(key, value);
            }
        }
        catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException", e);
        }
        catch (IOException e) {
            LOGGER.error("IOException", e);
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException e) {
                LOGGER.error("IOException", e);
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            }
            catch (IOException e) {
                LOGGER.error("IOException", e);
            }
        }
        
    }

    /**
     * 
     * Description: 根据语言和编码查询对应值
     * 
     * @author jinyanan
     *
     * @param local 语言
     * @param code 编码
     * @return String 值
     */
    public static String getValue(String local, String code) {
        return resourceMap.get(local).get(code);
    }
}
