### 银城千万间 工程系统
**代码是给人看的，并不是给机器看的，请编写代码时注意代码编写规范，不要一段时间后自己都看不懂自己的代码**

#### 技术选型

 - Maven
 - Spring
 - SpringMVC
 - MyBatis
 - MyBatis Generator
 - MyBatis 通用Mapper
 - Swagger
 - Log4j
 - MySQL
 - Druid
 - Nginx
 - PageHelper
 - 部分功能的二次封装

1、 环境搭建
  - 配置`Maven`中央仓库：项目目录下有`Maven`的配置文件`settings.xml`文件，修改该文件中的本地仓库目录`localRepository`为自己系统下目录即可
  - IDE导入项目，需要 **JDK1.7, Tomcat7+**
  - 配置`Tomcat`启动参数，添加`-DYC_HOME=\PATH\TO\YOUR\YC_HOME`，`YC_HOME`在项目目录下；或者在系统环境变量中增加`YC_HOME`，对应值也是`YC_HOME`的系统路径
2、 开发前请安装相关检查工具，并将`pre-commit`文件复制到`.git\hooks`目录下，这样提交时会预先检查一遍代码规范（必须使用`Bash`命令行才有用）
3、 使用`PMD`的配置文件时，`lint`目录下有`2`个版本的配置文件，分别对应`PMD`的不同的`2`个版本，导入的时候只要有其中一个能用即可，校验的规则是一样的
4、 修改`tomcat`目录下的`service.xml`文件 
   `tomcat7/conf/server.xml`
    给该行代码加上`URIEncoding="UTF-8"`的编码属性
``` 
<Connector port="8080" protocol="HTTP/1.1"
 
               connectionTimeout="20000"
 
               redirectPort="8443" URIEncoding="UTF-8" /> 
```

5、 所有的业务逻辑都写在对应的`Command`中，因为业务回滚是针对`Command`执行的，如果在`Command`外抛出异常，无法进行回滚
6、 抛出异常统一使用`BaseAppException`，同时需要在`YC_HOME/resource/`下进行配置，或者抛出异常的时候同时设置`message`，推荐在`YC_HOME/resource/`下进行配置，便于后续的修改
7、 不论是`svn`提交还是`git`(`git`所需忽略文件已放入`.gitignore`文件中)提交，统一忽略部分文件，因为这些文件在不同人的`PC`下，一般都是不一样的，如果提交了，其他人更新代码时容易产生冲突。具体忽略文件请参考`.gitignore`文件
8、目录下各个以`.sample`结尾的都是样例文件，需要修改文件中部分内容后，同时把名字上的`.sample`删去
9、`Controller`编写要带上`Swagger`相关注解，以便于接口测试时的阅读
10、修改`IDE`中关于`xml`的配置，设置每行的最大长度为`120`，Tab替换为`2`个空格，如图为Eclipse中的配置位置
![修改xml文件的配置][1]


  [1]: http://wx4.sinaimg.cn/large/7dde05d2gy1fd64xlnke7j20ye0ye7b6.jpg