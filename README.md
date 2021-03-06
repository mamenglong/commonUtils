@[TOC](目录)
- [jitPack.io官方文档](https://jitpack.io/docs/ANDROID/)用于创建第三方依赖库的说明
# commonUtils[![](https://jitpack.io/v/mamenglong/commonUtils.svg)](https://jitpack.io/#mamenglong/commonUtils)
一些常用工具类的集合
# Quick Setup
  To get a Git project into your build:
  * gradle  
    * Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
 ```
	allprojects {
		repositories { 
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 * gradle
   * Step 2. Add the dependency
 ```
	dependencies {
		implementation 'com.github.mamenglong:commonUtils:v1.0'
	}
 ```
* maven
   
  * Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
 ```
 	<repositories>
			<repository>
			    <id>jitpack.io</id>
			    <url>https://jitpack.io</url>
			</repository>
	 </repositories>
 ```
 * maven
   * Step 2. Add the dependency
```
<dependency>
    <groupId>com.github.mamenglong</groupId>
    <artifactId>commonUtils</artifactId>
    <version>v1.0</version>
</dependency>
```

Configure UtilsApplication

You don't want to pass the Context param all the time. To makes the APIs simple, just configure the UtilsApplication in AndroidManifest.xml as below:

<manifest>
    <application
        android:name="com.mml.utilslibrary.UtilsApplication"
        ...
    >
        ...
    </application>
</manifest>
Of course you may have your own Application and has already configured here, like:

<manifest>
    <application
        android:name="com.example.MyOwnApplication"
        ...
    >
        ...
    </application>
</manifest>
That's OK. Utils  can still live with that. Just call UtilsApplication.initialize(context) in your own Application:

```java
public class MyOwnApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilsApplication.initialize(this);
    }
}
```

Make sure to call this method as early as you can. In the onCreate() method of Application will be fine. And always remember to use the application context as parameter. Do not use any instance of activity or service as parameter, or memory leaks might happen.

目录结构：
-----java

------com.mml.utilslibrary

-------android

--------widget

----------...

-------common

--------assist

--------data

--------io

--------receiver

--------service

--------utils

-------
## 类介绍
 + android
   + ActivityManager：活动管理
   + DateUtil：时间信息
   + NetUtil：网络检查工具类
   + SPUtils：sharepreference管理
   + LogUtils： 日志捕获器， 将某个程序、级别的日志记录，方便远程调试。
 + widget
   + ClearEditText:带清除按钮的EditText
   + CountdownView:验证码倒计时
   + SimpleLayout:简单的Layout
   + ExpandableListView 添加带动画的ExpandableListView
 + common-assist
   + Averager： 均值器， 添加一些列数字或时间戳，获取其均值。
   + Base64： Base64， 兼容到android1.0版本的Base64编解码器。
   + Check： 检测类， 检测各种对象是否为null或empty。
   + FlashLight： 闪光灯， 开启、关闭闪光灯。
   + KeyguardLock： 锁屏管理， 锁屏、禁用锁屏，判断是否锁屏
   + Network： 网络探测器， 判断网络是否打开、连接、可用，以及当前网络状态。
   + SilentInstaller： 安装器， 静默安装、卸载（仅在root过的手机上）。
   + TimeAverager： 计时均值器， 统计耗时的同时，多次调用可得出其花费时间均值。
   + TimeCounter： 计时器， 顾名思义，统计耗时用的。
   + Toastor： 吐司， 解决多次连续弹出提示问题，可只弹出最后一次，也可连续弹出轻量级提示。
   + WakeLock： 屏幕管理， 点亮、关闭屏幕，判断屏幕是否点亮
 + data包：数据处理
   + DataKeeper： 加密存储器，持久化工具，可加密，更简单、安全的存储（持久化）、获取数字、布尔值、甚至对象。
   + chipher包： 放置加解密辅助类。
   + io包：文件与IO
   + Charsets： 字节编码类
 + io
   + FilenameUtils： 通用的文件名字、路径操作工具类
   + FileUtils： 通用文件操作工具类
   + IOUtils： 通用IO流操作工具类
   + StringCodingUtils：字符串编码工具类
   + stream包： IO流操作辅助类
 + receiver包：通用广播接收器
   + ScreenReceiver： 屏幕接收器，可收到屏幕点亮、关闭的广播，并通过回调通知给调用者
   + PhoneReceiver： 电话监听，来电、去电、通话、挂断的监听以及来去电话号码的获取。
   + SmsReceiver： 短信接收器，可获取短信内容，发送者号码，短信中心号码等。
 + utils包：常用工具类
   + AndroidUtil： android信息， 获取android手机品牌、商家、版本号等信息
   + AppUtil： app工具， 检测是否前台运行
   + BitmapUtil： 位图操作， 拍照，裁剪，圆角，byte、string互转，压缩，放缩，保存等
   + ByteUtil： byte工具类
   + ClassUtil： 类工具， 新建实例，判断类的类型等
   + DialogUtil： 对话框工具类， 统一全局对话框
   + FieldUtil： 属性工具类，获取属性值、获取属性泛型类型等
   + FileUtil： 文件工具类
   + HexUtil： 16进制工具类，16进制和byte、char像话转化
   + MD5Util： MD5工具类
   + NotificationUtil：通知工具类，便捷显示到顶部栏
   + NumberUtil： 数字工具类，各种数字安全转化
   + PackageUtil： 应用程序类，打开、安装，卸载，启动应用以及获取应用信息
   + RandomUtil： 随机工具类，产生随机string或数字，随机洗牌等
   + ShellUtil： shell 命令工具类
   + TelephoneUtil： 电话工具类，手机号、运营商、IMEI、IMSI等信息
   + VibrateUtil： 震动工具类，调用系统震动功能
   + service包：通用服务
   + NotificationService：通知监听，各类通知服务的监听，获取通知的简述、标题、内容等信息，可以获取诸如QQ、微信、淘宝、浏览器等所有的在通知栏提示的消息。
   + KeyboardUtils：软键盘工具类