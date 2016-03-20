XXXX科技有限公司项目最终版:

	项目名: 施工企业基础建设工作承载能力评估分析系统(cca)
	访问路径：http://localhost:8080/index.jsp
	用户名 ： admin
	密码：admin

项目构建组成: 
	
	maven+springMVC4.X(注解)+mybatis(注解方式)+mysql5.X+jetty+extjs4+js+html+css+jdk7

项目文档结构说明：

	src/main/java: 存放项目java业务代码。
	src/main/resources: 存放项目配置文件；spring 配置文件，数据库配置文件，日子配置文件，mybatis 代码生成配置文件(安装mybatis-generotor的eclipse插件后，鼠标右键，选择mybatis generotor 就可以在配置文件中指定的路径下生成代码)等。
	src/test/java : 测试代码文件路径，一般单元测试代码存放于该路径下。
	doc : 存放项目核心文件，数据库脚步，mybatis-generator(代码生成插件)等。
	src/main/webapp : 存放前端显示代码，exjts4+js+html+css等。
	src/main/test : 存放前端测试代码，用户前端功能测试。
	Syslogs : log4j生成的系统日志路径，系统日志存放于该路径下。
	target : maven 项目编译打包文件存放路径。
	pom.xml : maven 项目jar加载配置
	README.md : 项目说明文件。
	webdefault.xml : 默认web配置文件，提供项目代码修改后，web容器重新自动编译，从而可以不用重新启动服务器。

项目构建组成详解：
	
	数据库持久化层(mybatis): 
		1、采用mybatis框架，其中mybaits通过mybaits-generator生成基于mysql数据库的注解或xml格式的dao层代码（对应的包 com.ronyao.cca.da.dao;com.ronydao.cca.da.model;对应的生成配置文件 mybatis/genratorConfig.xml）。调用时，直接从service层直接调用自动生成dao层代码即可对数据库进行操作。
		2、优点： 采用该方式可以不用编写dao层以及实体类代码，生成的代码中封装了sql语句的编写规则以及代码，开发时可以基本写sql语句，很大程度提高了开发效率。生成的代码是对应数据库单张表为生成依据的，相应的对数据库单表的增删查改非常方便。
		3、缺点：生成的代码是对应数据库单张表为生成依据的，相应的对数据库同时多表操作困难，及无法写入复杂的多表查询或其他多表操作，只能一张表完成操作后，在操作下张表,对dao层对数据库操作的灵活性下降。
	
	前端显示框架（exjts4）
		1、exjts4及其以后的版本官方定义了其推荐的mvc结构，开发方式与以前的版不同，一般采用官方推荐的mvc结构进行开发。
		2、采用extjs4可以在使用极少原生的js+html代码可以实现适应绝大部分业务的功能。
		3、优点：exjts4后，采用官方推荐的mvc结构，代码容易管理维护，采用其定义的组件可以快速开发出一些比较复杂的功能。
		4、缺点：当用户需要一些特别的复杂或者不常见的功能是，extjs4就难以实现，不容易扩展。这是由于exjts4是前端总量级框架，框架本身功能的扩展或者修改难道非常高。
		
				
项目开发部署：

	1、开发部署时选用jetty容器，配置与pom.xml文件，即可使用，无需安装单独的服务容器。
	2、生产部署时采用jetty服务器进行部署，最佳选择linux服务器。
	3、生产部署时采用tomcat服务器。请注意，开发时使用了jetty嵌入式服务器，在部署到tomcat时，项目应去除项目名，将项目的运行文件存放于tomcat中webapp/root文件下， 否则会存在相对路径定位出现错误。


