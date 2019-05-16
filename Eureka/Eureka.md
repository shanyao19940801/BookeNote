# Eureka 服务注册与发现

## Eureka服务端

### 服务端常用配置
	
	#主机名
	eureka.instance.hostname=localhost
	# 注册时显示ip
	eureka.instance.prefer-ip-address=true
	#是否注册为服务
	eureka.client.register-with-eureka=false
	#是否检索服务
	eureka.client.fetch-registry=false
	#eureka默认空间的地址
	eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
	#关闭自我保护(生产时打开该选项)
	eureka.server.enable-self-preservation=false
	#扫描失效服务的间隔时间（缺省为60*1000ms）
	eureka.server.eviction-interval-timer-in-ms=5000
[更多配置](https://blog.csdn.net/asdfsadfasdfsa/article/details/79282036)
## Eureka客户端

### 客户端常用配置

	#注册到eureka中心，获取到配置服务
	eureka.client.service-url.defaultZone=http://localhost:7000/eureka/
	#设置实例的ID为ip:port
	eureka.instance.instance-id=${spring.cloud.client.ipAddress}:${server.port}
	#================================续约配置============================
	# 心跳时间，即服务续约间隔时间（缺省为30s）
	eureka.instance.lease-renewal-interval-in-seconds=5
	# 发呆时间，即服务续约到期时间（缺省为90s）
	eureka.instance.lease-expiration-duration-in-seconds=10
	# 开启健康检查（依赖spring-boot-starter-actuator）
	eureka.client.healthcheck.enabled=true


# # eureka分区的深入讲解

[参考](https://segmentfault.com/a/1190000014107639)

