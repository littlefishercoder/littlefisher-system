### LittleFisher 环境搭建 个人学习
《计算机程序的构造和解释》中写到过  
**代码是写给人看的，不是写给机器看的，只是顺便计算机可以执行而已**
**所以请编写代码时注意代码编写规范，不要一段时间后自己都看不懂自己的代码**

#### 构建结果
[![Build Status](https://travis-ci.org/littlefishercoder/littlefisher-system.svg?branch=dev)](https://travis-ci.org/littlefishercoder/littlefisher-system)

#### 个人博客
[http://www.littlefisher.site/][1]
欢迎博客上评论

#### Github
欢迎加星!!!

#### 代码分层
代码全都放在`code`包下
```
littlefisher-parent 总的父包
-littlefisher-blog-parent 跟博客相关的业务内容
-littlefisher-core-parent 基础服务代码
-littlefisher-spring-boot-autoconfigure 配置application.yml可读的配置信息
-littlefisher-user-parent 跟用户相关的业务内容
-littlefisher-web-parent 包装以上内容，对外提供MVC服务
```

以littlefisher-user-parent 举例描述分层
```
littlefisher-user-biz 业务接口描述层
littlefisher-user-biz-impl 业务接口实现层
littlefisher-user-common 公共定义层，包括工具，枚举等
littlefisher-user-dal 数据访问及远程调用接口层
littlefisher-user-dal-impl 数据访问及远程调用实现层
littlefisher-user-deploy 发布层，定义配置文件及打war包
```

#### 项目搭建路径
http://swaggerui.littlefisher.site/  
由于整个工程都是后端内容，所以页面展示的内容仅是一个`Swagger`测试页面而已

#### 项目介绍
该工程使用`SpringBoot`搭建，其目的是封装业务底层框架，让开发人员更集中于业务的开发。

 - 该工程使用**命令模式**进行业务处理，在开发逻辑上屏蔽`Service`层过于庞大冗余的可能性（不知道是否遇到过某个`Service`层的类超过`7000`行的，这种代码的可读性实在是差）。使用命令模式强制拆分不同业务逻辑，避免超长类文件。
 - 使用`MyBatis`一整套的插件，包括`MyBatis 通用Mapper`（`XxxMapper.xml`无需配置`sql`，常用`sql`自动封装使用）；`MyBatis Generator`（自动生成文件，做了改造，包括生成的注释，针对于通用`Mapper`生成不同的注解，对`import`做顺序改造，对`model`生成`Builder`建造者模式工具类）；`PageHelper`（`MyBatis`的分页插件）
 - 使用`Swagger`接口测试工具，能够通过页面进行接口测试（针对于`Controller`层进行测试）
 - 其他的功能还有待大家去探索

#### 技术选型

 - `Maven`
 - `Spring`
 - `Spring Boot`
 - `SpringMVC`
 - `MyBatis`
 - `MyBatis Generator`
 - `MyBatis 通用Mapper`
 - `Swagger3`
 - `Log4j2`
 - `MySQL`
 - `Druid`
 - `PageHelper`
 - `Guava`
 - 部分功能的二次封装
 - `Kafka`
 - `Gson`
 - `Oval Validation`
 - `Apache Shiro`

1. 环境搭建
  - 配置`Maven`中央仓库：项目目录下有`Maven`的配置文件`settings.xml`文件，修改该文件中的本地仓库目录`localRepository`为自己系统下目录即可
  - IDE导入项目，需要 **JDK1.8+**
  - 配置`Spring Boot`启动参数，添加`-DSYSTEM_HOME=\PATH\TO\YOUR\SYSTEM_HOME`，`SYSTEM_HOME`在项目目录下；或者在系统环境变量中增加`SYSTEM_HOME`，对应值也是`SYSTEM_HOME`的系统路径

2.  开发前请安装相关检查工具，并将`pre-commit`文件复制到`.git\hooks`目录下，这样提交时会预先检查一遍代码规范（必须使用`Bash`命令行才有用）（暂时没有开发）

3.  使用`PMD`的配置文件时，`lint`目录下有`2`个版本的配置文件，分别对应`PMD`的不同的`2`个版本，导入的时候只要有其中一个能用即可，校验的规则是一样的

4.  所有的业务逻辑都写在对应的`Command`中，因为业务回滚是针对`Command`执行的，如果在`Command`外抛出异常，无法进行回滚

5.  抛出异常统一使用`BaseAppException`，同时需要在`SYSTEM_HOME/resource/`下进行配置，或者抛出异常的时候同时设置`message`，推荐在`SYSTEM_HOME/resource/`下进行配置，便于后续的修改

6.  不论是`svn`提交还是`git`(`git`所需忽略文件已放入`.gitignore`文件中)提交，统一忽略部分文件，因为这些文件在不同人的`PC`下，一般都是不一样的，如果提交了，其他人更新代码时容易产生冲突。具体忽略文件请参考`.gitignore`文件

7.  目录下各个以`.sample`结尾的都是样例文件，需要修改文件中部分内容后，同时把名字上的`.sample`删去

8.  `Controller`编写要带上`Swagger`相关注解，以便于接口测试时的阅读

9.  修改`IDE`中关于`xml`的配置，设置每行的最大长度为`120`，`Tab`替换为`2`个空格。`IDEA`中默认使用`2`个空格替换`Tab`的，如图为`Eclipse`中的配置位置
![修改xml文件的配置][2]

10.  集成功能使用与介绍
  - `Swagger UI`接口测试。启动启动`Spring B`后，进入`http://{ip}:{port}/{contextPath}/swagger-ui.html`查看，可以直接在界面中对接口进行测试。其中`ip`为本机`ip`；`port`为`application.yml`中`server.port`所配，默认为`8080`；`contextPath`为`application.yml`中`server.servlet.context-path`所配置
  - `Druid`监控界面，启动`Tomcat`后，进入`http://{ip}:{port}/{contextPath}/druid`查看
  - `Command`日志打印功能集成，每次请求`Command`都会进行日志的打印
![日志信息][3]
  - `PageHelper`使用。在列表查询之前调用`PageHelper.startPage(pageNum, pageSize);`，一定要是紧接着列表查询之前。具体`PageHelper`使用规则，参考[github-PageHelper][4]
![PageHelper][5]
  - `Mybatis generator`使用。在`blog-intf`项目下，有一个`generatorConfig.xml`文件，针对该文件做部分修改，然后执行`mybatis generator`生成`Mapper`的命令即可。生成的`model`已经附带`Swagger UI`所需注解，同时针对于`import`信息也进行了优化，可以通过`checkstype`的检查。生成的`Mapper`接口，集成了通用的`CRUD`操作，个性化的接口`SQL`操作再另外定义即可。具体通用`Mapper`可参考[github-Mapper][6]![generatorConfig.xml][7]
  - `Guava`工具介绍在博客中有介绍
  - `Kafka`的使用在工程中已经加入，只不过没有大规模使用例子，具体的配置信息参考`application.yml`配置内容
  - `Activiti`单独使用了一个模块，暂时没有引入到`littlefisher-parent`中，因为还没有使用到的地方
  - `Oval Validation`的校验框架引入在`Command`中，当代码执行到`Command`时会进行校验

#### 项目启动

 - 在`littlefisher-parent`工程上，执行`maven`命令`mvn clean install -DskipTests`
 - 在`blog-web`工程上，找到`Application`类，执行`main`方法即可
 - 在浏览器中输入`http://{ip}:8080/blog-web/swagger_ui.html`，即可访问到`swaggerUI`界面
 - 以上所涉及`maven`命令皆为完整命令，可根据不同`IDE`变更部分命令

#### 额外补充


  [1]: http://www.littlefisher.site/
  [2]: http://wx4.sinaimg.cn/large/7dde05d2gy1fd64xlnke7j20ye0ye7b6.jpg
  [3]: https://wx1.sinaimg.cn/large/7dde05d2gy1fpuqgmz5m7j21kw0ushdq.jpg
  [4]: https://github.com/pagehelper/Mybatis-PageHelper
  [5]: https://wx2.sinaimg.cn/large/7dde05d2gy1fpuqgl6koyj21as0z4jye.jpg
  [6]: https://github.com/litttlefisher/Mapper
  [7]: https://wx1.sinaimg.cn/large/7dde05d2gy1fpuqgmj48kj21kw0vwnga.jpg
