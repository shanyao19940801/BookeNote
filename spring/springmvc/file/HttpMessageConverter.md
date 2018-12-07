# HttpMessageConverter进行http序列化和反序列化
在SpringMVC中，可以使用@RequestBody和@ResponseBody两个注解，分别完成请求报文到对象和对象到响应报文的转换，底层这种灵活的消息转换机制，就是Spring3.x中新引入的HttpMessageConverter即消息转换器机制。<br>
[参考文档](https://www.cnblogs.com/page12/p/8166935.html)<br>
[参考文档二(写的不错)](https://my.oschina.net/lichhao/blog/172562)<br>
[官方文档](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/AbstractHttpMessageConverter.html#setSupportedMediaTypes-java.util.List-)

### HttpMessageConverter在SpringMVC流程中位置

![p1](https://github.com/shanyao19940801/BookeNote/blob/master/spring/springmvc/file/picture_1.png)


* 什么是http序列化和反序列化

