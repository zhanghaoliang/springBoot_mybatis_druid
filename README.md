# springBoot_mybatis_druid
springBoot集成mybatis并使用druid连接池与PageHelper分页插件，项目模板（使用generator插件自动生成dao,mapper）




## １．准备数据库：
```
 CREATE TABLE tb_user(
 	id int(32) PRIMARY KEY AUTO_INCREMENT,
	username varchar(32),
	address varchar(256)
 );
 INSERT INTO tb_user VALUES (1,'小亮','北京市海淀区');
 INSERT INTO tb_user VALUES (２,'小思','沈阳市铁西区');
 INSERT INTO tb_user VALUES (３,'小明','兰州市安宁区');
```
## 2.application.yml中数据源位置更换为自己的数据库

## 3.运行项目访问　
	http://localhost:7777/user/getAll
	http://localhost:7777/user/page
## 4.打开druid的sql监控
	http://localhost:7777/druid　　　帐号名：zhl 密码:zhl    (application.yml中可以配置)
	
	
## 4.generator插件的使用
项目中已经自动生成了User实体，如需生成其他的类，按照如下方法生成：
### 4.1 generatorConfig.xml 更换为自己的数据库链接
```
<!--数据库链接URL，用户名、密码 -->
<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/chensi" userId="root" password="root">
```
### 4.2 generatorConfig.xml 更换准备生成实体与mapper的表
```
<!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名-->
<table tableName="tb_user" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"></table>
```
### 4.3 intellij 上配置generator插件run
run--> Edit Configurations... --> 新增＋　-->Maven -->Command line栏输入　mybatis-generator:generate -e　-->退出-->run 
