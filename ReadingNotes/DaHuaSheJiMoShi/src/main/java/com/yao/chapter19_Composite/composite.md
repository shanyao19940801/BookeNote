# 组合模式

讲对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对党个对象和组合对象的使用具有一致性

* 结构图
![解构图](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter19_Composite/image/composite.PNG)

**Component**：对象生命接口，在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component的子部件

**Composite:**定义有节点行为，用来存储子部件，在Component接口中实现与子部件有关的操作，比如增加Add删除remove

**Leaf**：在组合中表示叶节点对象，叶节点没有子节点