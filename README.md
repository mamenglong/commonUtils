# [jitPack.io官方文档](https://jitpack.io/docs/ANDROID/)
# commonUtils[![](https://jitpack.io/v/mamenglong/commonUtils.svg)](https://jitpack.io/#mamenglong/commonUtils)
一些常用工具类的集合

To get a Git project into your build:

* gradle
   
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
 ```
	allprojects {
		repositories { 
			maven { url 'https://jitpack.io' }
		}
	}
 ```
Step 2. Add the dependency
 ```
	dependencies {
		implementation 'com.github.mamenglong:commonUtils:v1.0'
	}
 ```
* maven
   
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
 ```<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	     </repositories>
 ```
Step 2. Add the dependency

```
<dependency>
    <groupId>com.github.mamenglong</groupId>
    <artifactId>commonUtils</artifactId>
    <version>Tag</version>
</dependency>
```
