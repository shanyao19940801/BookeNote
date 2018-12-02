# 第二章 装配Bean

## 自动化装配bean

#### Spring从两个角度实现自动化装配

* 组件扫描
* 自动装配
## 隐式装配
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

###  @Autowired

自动装配bean，<br>
可以放在属性上面

	@Autowired
	private CompactDisc cd;
也可以放在方法上面

    @Autowired
    public DVDPlayer(CompactDisc disc) {
        this.disc = disc;
    }

上面都会实现自动装配bean，通过这种方式装配bean要注意，满足条件的bean**有且只能有**一个，多个都会报错，没有也会报错（如果required=false就不会报错，此时的bean是未装配状态）

## 显示装配

有些情况下自动化装配行不通，比如想要装配第三方库中的组件，这时候可以用显示装配方式

显示装配有两种方案，java和xml