# springBoot_mybatis_druid
springBoot集成mybatis并使用druid连接池与PageHelper分页插件，项目模板（使用generator插件自动生成dao,mapper）

准备数据库：

添加插件依赖：
<!-- mybatis generator 自动生成代码插件 -->
			<plugin>
				<groupId>org.mybatis.generator</groupId>
				<artifactId>mybatis-generator-maven-plugin</artifactId>
				<version>1.3.2</version>
				<configuration>
					<configurationFile>${basedir}/src/main/resources/generator/generatorConfig.xml</configurationFile>
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
