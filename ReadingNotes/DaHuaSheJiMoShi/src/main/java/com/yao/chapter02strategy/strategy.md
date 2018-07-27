# 策略模式

策略模式定义了一系列的算法，并将每一个算法封装起来，而且使他们可以相互替换，让算法独立于使用它的客户而独立变化。

* 结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter02strategy/image/strategy01.PNG)

* 代码实现

[code](https://github.com/shanyao19940801/BookeNote/tree/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter02strategy/image/example)

*  策略模式的优点
　　（1）策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。恰当使用继承可以把公共的代码移到父类里面，从而避免代码重复。

　　（2）使用策略模式可以避免使用多重条件(if-else)语句。多重条件语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重条件语句里面，比使用继承的办法还要原始和落后。

* 策略模式的缺点
　　（1）客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道算法或行为的情况。

　　（2）由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。

### 在jdk中的应用

* Comparator比较器

用过这个比较器的都知道，这个比较器本身并不会提供任何比较规则。我们需要自己创建一个类实现Comparator然后自己制定一个比较规则。就是一个典型的策略模式。


