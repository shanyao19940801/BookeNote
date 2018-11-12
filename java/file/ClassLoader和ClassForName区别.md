# ClassLoader和ClassForNamequbie

java中class.forName()和classLoader都可用来对类进行加载。<br>
class.forName()前者除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。<br>
而classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。<br>
Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象。

[代码实例参考](https://github.com/shanyao19940801/BookeNote/blob/master/java/code/src/com/code/classloader_and_classforname_different/ClassloaderAndForNameTest.java)


[非常好的文章](https://blog.csdn.net/justloveyou_/article/details/72466105)
