# Java动态代理

* 何为代理

	首先代理模式是一种[设计模式](https://github.com/shanyao19940801/BookeNote/blob/master/ReadingNotes/DaHuaSheJiMoShi/src/main/java/com/yao/chapter07_daili/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F.md)。正常情况下，我们访问一个对下个只需要实例化然后通过实例对象调用方法。而代理模式就是先创建一个代理对象，这个时候如果我们想要访问元对象的方法就可以通过代理对象访问。来个栗子：某天在上班的路上你看到一条非常可爱的狗，于是摸了一下，这时候狗主人不让了非说你非礼了她的狗狗，于是要把你告上法庭，可是你还要上班啊，没时间处理这些事，只好请个律师帮你处理了：你->律师->法官 律师就是你的代理对象。这时候肯定会有人问，干嘛这么麻烦绕一圈呢？直接调用不就好了。

* 为什么要用代理模式
	
	上面说到律师的例子，我们知道打官司费时费力还需要法律专业知识，我们自己肯定是搞不来的，而且我们有自己的事情要做没时间管这些事，这就需要我们的代理对象了：律师。把专业的或者繁琐的事情交给律师去处理。我们该干嘛干嘛只需要开庭的时候到场就可以了，开庭到场就是我们自己的方法，代理对象处理好开庭前的事情通知我就相当于调用我，开庭结束律师在处理后续事情。这就是代理的作用，把专业的繁琐的事情交给别人来做，我们只关心我们自己的事情就好了。

### Java动态代理

> java中动态代理主要用到java.lang.reflect包下的Proxy类InvocationHandler接口

* InvocationHandler

		public interface InvocationHandler {
		    public Object invoke(Object proxy, Method method, Object[] args)
		        throws Throwable;
		}
		proxy:　　指代我们所代理的那个真实对象
		method:　　指代的是我们所要调用真实对象的某个方法的Method对象
		args:　　指代的是调用真实对象某个方法时接受的参数


	每一个动态代理类都必须要实现InvocationHandler这个接口，并且每个代理类的实例都关联到了一个handler，当我们通过代理对象调用一个方法的时候，这个方法的调用就会被转发为由InvocationHandler这个接口的 invoke 方法来进行调用。我们来看看InvocationHandler这个接口的唯一一个方法 invoke 

### 拓展

jdk动态代理和cglib动态代理的区别