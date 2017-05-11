### LittleFisher 环境搭建 个人学习
《计算机程序的构造和解释》中写到过  
**代码是写给人看的，不是写给机器看的，只是顺便计算机可以执行而已**
**所以请编写代码时注意代码编写规范，不要一段时间后自己都看不懂自己的代码**

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

1. 环境搭建
  - 配置`Maven`中央仓库：项目目录下有`Maven`的配置文件`settings.xml`文件，修改该文件中的本地仓库目录`localRepository`为自己系统下目录即可
  - IDE导入项目，需要 **JDK1.7, Tomcat7+**
  - 配置`Tomcat`启动参数，添加`-DSYSTEM_HOME=\PATH\TO\YOUR\SYSTEM_HOME`，`SYSTEM_HOME`在项目目录下；或者在系统环境变量中增加`SYSTEM_HOME`，对应值也是`SYSTEM_HOME`的系统路径

2.  开发前请安装相关检查工具，并将`pre-commit`文件复制到`.git\hooks`目录下，这样提交时会预先检查一遍代码规范（必须使用`Bash`命令行才有用）（暂时没有开发）

3.  使用`PMD`的配置文件时，`lint`目录下有`2`个版本的配置文件，分别对应`PMD`的不同的`2`个版本，导入的时候只要有其中一个能用即可，校验的规则是一样的

4.  修改`tomcat`目录下的`service.xml`文件 
   `tomcat7/conf/server.xml`
    给该行代码加上`URIEncoding="UTF-8"`的编码属性
![URIEncoding][1]

5.  所有的业务逻辑都写在对应的`Command`中，因为业务回滚是针对`Command`执行的，如果在`Command`外抛出异常，无法进行回滚

6.  抛出异常统一使用`BaseAppException`，同时需要在`SYSTEM_HOME/resource/`下进行配置，或者抛出异常的时候同时设置`message`，推荐在`SYSTEM_HOME/resource/`下进行配置，便于后续的修改

7.  不论是`svn`提交还是`git`(`git`所需忽略文件已放入`.gitignore`文件中)提交，统一忽略部分文件，因为这些文件在不同人的`PC`下，一般都是不一样的，如果提交了，其他人更新代码时容易产生冲突。具体忽略文件请参考`.gitignore`文件

8.  目录下各个以`.sample`结尾的都是样例文件，需要修改文件中部分内容后，同时把名字上的`.sample`删去

9.  `Controller`编写要带上`Swagger`相关注解，以便于接口测试时的阅读

10.  修改`IDE`中关于`xml`的配置，设置每行的最大长度为`120`，Tab替换为`2`个空格，如图为Eclipse中的配置位置
![修改xml文件的配置][2]

11.  集成功能使用与介绍
  - `Swagger UI`接口测试。启动启动`Tomcat`后，进入`http://{ip}:{port}/{projectName}/swagger/index.html`查看，可以直接在界面中对接口进行测试
  - `Druid`监控界面，启动`Tomcat`后，进入`http://{ip}:{port}/{projectName}/druid`查看
  - `Command`日志打印功能集成，每次请求`Command`都会进行日志的打印
![日志信息][3]
  - `PageHelper`使用。在列表查询之前调用`PageHelper.startPage(pageNum, pageSize);`，一定要是紧接着列表查询之前。具体PageHelper使用规则，参考[github-PageHelper][4]
![PageHelper][5]
  - `Mybatis generator`使用。在`core-base`项目下，有一个`generatorConfig.xml`文件，针对该文件做部分修改，然后执行`mybatis generator`生成`Mapper`的命令即可。生成的`model`已经附带`Swagger UI`所需注解，同时针对于`import`信息也进行了优化，可以通过`checkstype`的检查。生成的`Mapper`接口，集成了通用的`CRUD`操作，个性化的接口`SQL`操作再另外定义即可。具体通用`Mapper`可参考[github-Mapper][6]![通用Mapper][7]


  [1]: http://wx1.sinaimg.cn/mw690/7dde05d2gy1ffhi4mdb04j21kw0zmk4h.jpg
  [2]: http://wx4.sinaimg.cn/large/7dde05d2gy1fd64xlnke7j20ye0ye7b6.jpg
  [3]: http://wx1.sinaimg.cn/large/7dde05d2gy1ffhi1ry0prj21kw04tdla.jpg
  [4]: https://github.com/pagehelper/Mybatis-PageHelper
  [5]: http://wx1.sinaimg.cn/large/7dde05d2gy1ffhia4rac9j21hu106tgp.jpg
  [6]: https://github.com/litttlefisher/Mapper
  [7]: http://wx4.sinaimg.cn/large/7dde05d2gy1ffhin0d3epj21kw0zhwup.jpg