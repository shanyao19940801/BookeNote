# Redis数据结构底层实现原理

* redis五大数据结构

	- String
	- Hash
	- List
	- Set
	- ZSet

### 字符串处理(String) 

我们都知道redis是用C语言写，但是C语言处理字符串和数组的成本是很高的，下面我分别说几个例子。

没有数据结构支撑的几个问题

* 及其容易造成缓冲区溢出问题，比如用strcat()，在用这个函数之前必须要先给目标变量分配足够的空间，否则就会溢出。
* 如果要获取字符串的长度，没有数据结构的支撑，可能就需要遍历，它的复杂度是O(N)
* 内存重分配。C字符串的每次变更(曾长或缩短)都会对数组作内存重分配。同样，如果是缩短，没有处理好多余的空间，也会造成内存泄漏。

所以，Redis自己构建了一种名叫Simple dynamic string(**SDS**)的数据结构(**<font color=red>支持自动动态扩容的字节数组</font>**)，他分别对这几个问题作了处理。我们先来看看它的结构源码：

	struct sdshdr{
	     //记录buf数组中已使用字节的数量
	     //等于 SDS 保存字符串的长度
	     int len;
	     //记录 buf 数组中未使用字节的数量
	     int free;
	     //字节数组，用于保存字符串
	     char buf[];
	}
	
* 优点

	- 发者不用担心字符串变更造成的内存溢出问题。
	- 常数时间复杂度获取字符串长度len字段。
	- 空间预分配free字段，会默认留够一定的空间防止多次重分配内存。

### 链表

> Redis的链表在双向链表上扩展了头、尾节点、元素数等属性。

![01](https://github.com/shanyao19940801/BookeNote/blob/master/Redis/image/01.png)

* 源码

ListNode节点数据结构：

	typedef  struct listNode{
	       //前置节点
	       struct listNode *prev;
	       //后置节点
	       struct listNode *next;
	       //节点的值
	       void *value;  
	}listNode
	
链表数据结构：
	
	typedef struct list{
	     //表头节点
	     listNode *head;
	     //表尾节点
	     listNode *tail;
	     //链表所包含的节点数量
	     unsigned long len;
	     //节点值复制函数
	     void (*free) (void *ptr);
	     //节点值释放函数
	     void (*free) (void *ptr);
	     //节点值对比函数
	     int (*match) (void *ptr,void *key);
	}list;

从上面可以看到，Redis的链表有这几个特点：

- 可以直接获得头、尾节点。
- 常数时间复杂度得到链表长度。
- 是双向链表。

### 字典(Hash)
>Redis的Hash，就是在数组+链表的基础上，进行了一些rehash优化等。

![01](https://github.com/shanyao19940801/BookeNote/blob/master/Redis/image/02.png)



## 参考

[面试官：你看过Redis数据结构底层实现吗？](https://www.cnblogs.com/javazhiyin/p/11063944.html)

[Redis中的数据结构](https://www.cnblogs.com/neooelric/p/9621736.html)