# 第二章 装配Bean

### 自动化装配bean

#### Spring从两个角度实现自动化装配

* 组件扫描
* 自动装配

### @Component注解

表明该类会作为组件类，并告知Spring要为这个类创建bean


### @ComponentScan注解

方法介绍：

* basePackages

[Java代码实例](https://github.com/shanyao19940801/BookeNote/blob/master/SringInAction/springinaction/chapter02/src/main/java/chapter02/CDPlayerConfig.java)

设置扫描组件的包，不写则是该配置类所在包，可以设置多个基础包:{"com.a","com.b"}<br>
代码可以看出来指定基础包是通过string字符串来指定，这样如果重构代码包名改变可能会出错，所以通过下面的方法

* basePackageClasses

通过指定包中包含的类或接口