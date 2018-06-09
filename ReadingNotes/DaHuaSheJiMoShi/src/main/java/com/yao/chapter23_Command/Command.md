# 命令模式

将一个请求封装为一个对象，从而使你可以用不同的请求对客户端进行参数化；对请求排队或者记录请求日志，以支持可撤销的操作。

* 结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter23_Command/image/command.PNG)

* 优点

第一：他能较容易的设计一个命令队列；<br>
第二:在需要的情况下，可以将容易的将命令记入日志；<br>
第三：允许接收请求的一方决定是否要否决请求；<br>
第四：可以容易的实现对请求的撤销和重做；<br>
第五：由于加进新的具体命令类不影响其他的类，因此增加新的具体命令类很容易；<br>
第六：把请求一个操作的对象与知道怎么执行一个操作的对象分割开

## 实例

### 撸串点餐

* 结构图

![结构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter23_Command/image/command01.PNG)


