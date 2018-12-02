# 第二章 装配Bean

### 自动化装配bean

#### Spring从两个角度实现自动化装配

* 组件扫描
* 自动装配

### @Component注解

表明该类会作为组件类，并告知Spring要为这个类创建bean


### @ComponentScan注解

属性介绍：

* basePackages

[Java代码实例](https://github.com/shanyao19940801/BookeNote/blob/master/SringInAction/springinaction/chapter02/src/main/java/chapter02/CDPlayerConfig.java)

设置扫描组件的包，不写则是该配置类所在包