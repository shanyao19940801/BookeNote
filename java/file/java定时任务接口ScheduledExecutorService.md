# java定时任务接口ScheduledExecutorService

是基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响。

需要注意,**只有当调度任务来的时候,ScheduledExecutorService才会真正启动一个线程,其余时间ScheduledExecutorService都是出于轮询任务的状态**。

### 两个常用的调度方式

* ScheduleAtFixedRate 

	每次执行时间为上一次任务**开始**起向后推一个时间间隔

* ScheduleWithFixedDelay

	每次执行时间为上一次任务**结束**起向后推一个时间间隔

#### [代码示例](https://github.com/shanyao19940801/BookeNote/blob/master/java/code/src/com/scheduledexecutor/ScheduledExecutorServiceTest.java)

### ScheduledExecutorService 和 Timer 的区别

Timer的**内部只有一个线程**，如果有多个任务的话就会顺序执行，这样我们的延迟时间和循环时间就会出现问题。
ScheduledExecutorService是线程池，所以就不会出现这个情况，在对延迟任务和循环任务要求严格的时候，就需要考虑使用ScheduledExecutorService了。