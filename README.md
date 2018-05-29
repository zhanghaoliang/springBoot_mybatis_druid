# springBoot_mybatis_druid
springBoot集成mybatis并使用druid连接池与PageHelper分页插件，项目模板（使用generator插件自动生成dao,mapper）

## １．准备数据库：
 CREATE TABLE tb_user(
 	id int(32) PRIMARY KEY AUTO_INCREMENT,
	username varchar(32),
	address varchar(256)
 );
 INSERT INTO tb_user VALUES (1,'小亮','北京市海淀区');
 INSERT INTO tb_user VALUES (２,'小思','沈阳市铁西区');
 INSERT INTO tb_user VALUES (３,'小明','兰州市安宁区');

## ２．添加插件依赖：		
<!-- mybatis generator 自动生成代码插件 -->
<plugin>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.3.2</version>
	<configuration>
		<configurationFile>${basedir}/src/main/resources/gaaenerator/generatorConfig.xml</configurationFile>
		<overwrite>true</overwrite>
		<verbose>true</verbose>
	</configuration>
	<dependencies>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.30</version>
			<scope>runtime</scope>
		</dependency>
	</dependencies>
</plugin>

## ３．generatorConfig.xml 更换为自己的数据库链接
<!--数据库链接URL，用户名、密码 -->
<jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/chensi" userId="root" password="root">
	
## ４．intellij 上配置generator插件run
	run--> Edit Configurations... --> 新增＋　-->Maven -->Command line栏输入　mybatis-generator:generate -e　-->退出-->run 
