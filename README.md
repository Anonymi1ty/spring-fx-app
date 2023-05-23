# springboot-javafx-app-demo

## Spring Boot-JavaFX 2.0 applications

> Many people's first reaction to Java native program development still stays in the dark gray single style of Java GUI interface, development style still stays in AWT or Swing. This article focuses on developing a Demo based on SpringBoot and JavaFX to show you how far Java Native applications can go. Of course, JavaFX 2.0 did not catch on for a reason, and now there are many native options, front-end frameworks will make a native...

[TOC]



### Technical background - Javafx 2.0, a new feature of Java 8

#### A new modern theme: Modena

New Modena theme to replace the original Caspian theme. However, in the start() method of the Application, we can continue to use the Caspian theme by calling setUserAgentStylesheet(STYLESHEET_CASPIAN).

Refer to http://fxexperience.com/2013/03/modena-theme-update/


#### Public API for CSS structure

+ CSS styling is one of the main features of JavaFX
+ CSS implemented specifically in a private API (com.sun.javafx.css package)
+ CSS public apis are required by several tools (e.g. Scene Builder)
+ Developers will be able to define custom CSS styles

#### JavaFX Scene Builder 2.0

Visualization tools to accelerate the development of JavaFX GUI:

Like NetBeans, JavaFX Scene Builder can configure the interface by dragging and dropping. After the interface is completed, it is saved as a FXML file. The file describes the object configuration in XML and is processed by JavaFX program, so it can reduce the difficulty of directly writing the interface in JavaFX.

JavaFX Scene Builder 2.0 added JavaFX Theme Preview function, the menu "Preview" → "JavaFX Theme" to select different themes, including

+ Modena (FX8).
+ Modena Touch (FX8).
+ Modena High Contrast – Black on White (FX8).
+ Modena High Contrast – White on Black (FX8).
+ Modena High Contrast – Yellow on Black (FX8).
+ Caspian (FX2).
+ Caspian Embedded (FX2).
+ Caspian Embedded QVGA (FX2).

#### JavaFX 3D

JavaFX8 provides a 3D image processing API, Including Shape3D (Box, Cylinder, MeshView, Sphere subclasses),SubScene, Material, PickResult, LightBase (AmbientLight and PointLight subclasses),SceneAntialiasing, etc. The Camera class has also been updated. You can find more information in JavaDoc.

#### Rich text

Enhanced support for rich text

#### TreeTableView

TreeTable support

#### Date control DatePicker

Adding date controls


### Spring Boot+JavaFX2 Demo introduction


#### Program loading - Loader

![image-20230523211622043](https://my-typora-p1.oss-cn-beijing.aliyuncs.com/typoraImgs/202305232118698.png)

#### Clean looking GUI

![image-20230523211755087](https://my-typora-p1.oss-cn-beijing.aliyuncs.com/typoraImgs/202305232118700.png)

### How to deploy
Here's the script to run the maven installation (here D:\git\github\springboot-javafx-app-demo is my local project directory, so change it to your own) :

```bash
mvn install:install-file -DgroupId=gn -DartifactId=GNCalendar -Dversion=v1.0 -Dpackaging=jar -Dfile=D:\git\github\springboot-javafx-app-demo\lib\GNCalendar-1.0-alpha.jar

mvn install:install-file -DgroupId=gn -DartifactId=GNButton -Dversion=v1.1.0 -Dpackaging=jar -Dfile=D:\git\github\springboot-javafx-app-demo\lib\GNButton-1.1.0.jar

mvn install:install-file -DgroupId=gn -DartifactId=GNCarousel -Dversion=v2.1.5 -Dpackaging=jar -Dfile=D:\git\github\springboot-javafx-app-demo\lib\GNCarousel-2.1.5.jar

mvn install:install-file -DgroupId=gn -DartifactId=GNDecorator -Dversion=v2.1.2-alpha -Dpackaging=jar -Dfile=D:\git\github\springboot-javafx-app-demo\lib\GNDecorator-2.1.2-alpha.jar

mvn install:install-file -DgroupId=gn -DartifactId=GNAvatarView -Dversion=v1.0-rc -Dpackaging=jar -Dfile=D:\git\github\springboot-javafx-app-demo\lib\GNAvatarView-1.0-rc.jar

```


+ pom.xml is as following:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
		 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.4.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>spring-fx-app</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-fx-app</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<!-- mvn install:install-file -DgroupId=gn -DartifactId=GNAvatarView -Dversion=v1.0-rc -Dpackaging=jar -Dfile=D:\git\github\springb
oot-javafx-app-demo\lib\GNAvatarView-1.0-rc.jar
-->
		<dependency>
			<groupId>gn</groupId>
			<artifactId>GNAvatarView</artifactId>
			<version>v1.0-rc</version>
		</dependency>
		<dependency>
			<groupId>gn</groupId>
			<artifactId>GNButton</artifactId>
			<version>v1.1.0</version>
		</dependency>
		<dependency>
			<groupId>gn</groupId>
			<artifactId>GNCalendar</artifactId>
			<version>v1.0</version>
		</dependency>
		<dependency>
			<groupId>gn</groupId>
			<artifactId>GNCarousel</artifactId>
			<version>v2.1.5</version>
		</dependency>
		<dependency>
			<groupId>gn</groupId>
			<artifactId>GNDecorator</artifactId>
			<version>v2.1.2-alpha</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.github.typhon0/AnimateFX -->
		<dependency>
			<groupId>io.github.typhon0</groupId>
			<artifactId>AnimateFX</artifactId>
			<version>1.2.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.controlsfx/controlsfx -->
		<dependency>
			<groupId>org.controlsfx</groupId>
			<artifactId>controlsfx</artifactId>
			<version>8.40.14</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/de.jensd/fontawesomefx -->
		<dependency>
			<groupId>de.jensd</groupId>
			<artifactId>fontawesomefx</artifactId>
			<version>8.9</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.jfoenix/jfoenix -->
		<dependency>
			<groupId>com.jfoenix</groupId>
			<artifactId>jfoenix</artifactId>
			<version>8.0.7</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/eu.hansolo/tilesfx -->
		<dependency>
			<groupId>eu.hansolo</groupId>
			<artifactId>tilesfx</artifactId>
			<version>1.6.5</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/eu.hansolo/colors -->
		<dependency>
			<groupId>eu.hansolo</groupId>
			<artifactId>colors</artifactId>
			<version>1.4</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.10</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.26</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.15.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-csv -->
		<dependency>
			<groupId>com.fasterxml.jackson.dataformat</groupId>
			<artifactId>jackson-dataformat-csv</artifactId>
			<version>2.15.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-core</artifactId>
			<version>2.15.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			<version>2.15.0</version>
		</dependency>



	</dependencies>

	<build>
		<plugins>
			<!--			<plugin>-->
			<!--				<groupId>org.springframework.boot</groupId>-->
			<!--				<artifactId>spring-boot-maven-plugin</artifactId>-->
			<!--			</plugin>-->

			<plugin>
				<groupId>com.zenjava</groupId>
				<artifactId>javafx-maven-plugin</artifactId>
				<version>8.8.3</version>
				<configuration>
					<vendor>pdai</vendor>
					<mainClass>com.pdai.javafx.app.SpringFxAppApplication</mainClass>
					<allPermissions>true</allPermissions>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```

+ To start the program with SpringBoot, simply click on the class:

![image-20230523212158083](../../../../../../../Typora/myimage/image-20230523212158083.png)

+ Take the jar run as an example:

```bash
D:\git\github\springboot-javafx-app-demo>java -jar D:\git\github\springboot-javafx-app-demo\target\jfx\native\spring-fx-app-0.0.1-SNAPSHOT\app\spring-fx-app-0.0.1-SNAPSHOT-jfx.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

2020-07-01 06:27:46.091  INFO 144952 --- [onPool-worker-1] o.s.boot.SpringApplication               : Starting application on pdai with PID 144952 (started by pdai in D:\git\github\springboot-javafx-app-demo)
2020-07-01 06:27:46.099  INFO 144952 --- [onPool-worker-1] o.s.boot.SpringApplication               : No active profile set, falling back to default profiles: default
2020-07-01 06:27:47.099  INFO 144952 --- [onPool-worker-1] o.s.boot.SpringApplication               : Started application in 1.784 seconds (JVM running for 2.838)
2020-07-01 06:27:47.163  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:51.932  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:53.084  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:54.166  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:54.207  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:54.263  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:54.322  WARN 144952 --- [JavaFX-Launcher] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:56.569  WARN 144952 --- [lication Thread] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:56.590  WARN 144952 --- [lication Thread] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:56.694  WARN 144952 --- [lication Thread] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
2020-07-01 06:27:56.707  WARN 144952 --- [lication Thread] javafx                                   : Loading FXML document with JavaFX API of version 8.0.171 by JavaF
X runtime of version 8.0.65
```

### Remote repository

@See https://github.com/Anonymi1ty/spring-fx-app
