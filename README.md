### 银城千万间 工程系统
1. 环境搭建
  - 配置`Maven`中央仓库：项目目录下有`Maven`的配置文件`settings.xml`文件，修改该文件中的本地仓库目录`localRepository`为自己系统下目录即可
  - IDE导入项目，需要 **JDK1.7, Tomcat7+**
  - 配置`Tomcat`启动参数，添加`-DYC_HOME=\PATH\TO\YOUR\YC_HOME`，`YC_HOME`在项目目录下
2. 开发前请安装相关检查工具，并将`pre-commit`文件复制到`.git\hooks`目录下，这样提交时会预先检查一遍代码规范（必须使用`Bash`命令行才有用）
3. 后续补充