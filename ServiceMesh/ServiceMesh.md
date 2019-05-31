# ServiceMesh

## 微服务
介绍ServiceMesh之前，首先要说的就是微服务
![微服务](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice.jpg)

* 企业常用的微服务架构 
![架构图](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-1.png)

* **服务接入层**：企业暴露到外部访问的入口，一般通过防火墙等。
* **网关层**：服务网关是介于客户端和服务端的中间层，所有的外部请求会先经过服务网关，为企业应用提供统一的访问控制入口。服务网关是微服务架构下的服务拆分，聚合，路由，认证以及流控综合体现。
* **支撑服务层**：为企业应用提供运行所需的支撑环境，包括注册发现，集中配置，容错限流，认证授权，日志聚合，监测告警，消息服务等
* **业务服务层**：业务服务是企业应用的核心所在，为企业领域应用的具体实现，一般进一步拆分为基础服务（基础功能）和聚合服务（综合场景）。
* **平台服务层**：为企业应用提供运行所需的软件资源，包括应用服务器，应用发布管理，应用镜像包管理，服务治理。
* **基础设施层**：为企业应用提供运行所需的硬件资源，包括计算资源，网络资源，存储资源，基本的安全策略控制等。



* 微服务的优点：

	关键点：复杂度可控，独立按需扩展，技术选型灵活，容错，可用性高

### 微服务组件使用

![图2](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-2.png)

上面的图中可以得到一个结论：在微服务架构下，核心都在网关服务、支撑服务两个层面。

目前的Spring Cloud以及Dubbo都有完整套件来实现，如果需要直接拿来用就可以了，很爽也很方便，使用方式就是在每一个服务器加上相应的组件就ok了

![数据收集](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-3.png)

![服务注册与发现](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-4.png)


##### 微服务的痛点：
1. 业务技术团队需要花时间精力去学习这些组件，
2. 只要增加一个服务就必须要引入所有的组件
3. 组件升级周期长
4. 多版本语言需要开发多个版本的Client

### 如何解决？

问题是有了，下面就要想办法解决问题了

既然问题是因为业务和支撑模块耦合，那就想办法解耦喽

* **将服务拆成两个进程**

![chai](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-6.png)

> * 一个进程实现业务逻辑，即上面的白色方块
> * 一个进程实现底层技术体系，上面的蓝色方块

这样就实现了<font color=red >**业务归业务，技术归技术** </font>，如果所有的服务都实现解耦，最终整个架构就会变成：
![tu10](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-10.png)

这种模式也被形象的成为SideCar模式：
![tu11](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-11.png)

## 落地

ServiceMesh本质上只是一概念，目前页已经有开源框架真正做到了落地，如Linkerd和Istio。
下面主要说一说Istio，它是由Google和IBM合作开发

## Istio

### Istio是什么？
Istio是谷歌、IBM、Lyft等公司贡献的开源Service Mesh组件。它实现的目标就是让业务开发不再关注微服务之间如何调用、管理、监控等非功能性需求，而是让Istio来处理这些问题。Istio和Kubernetes有天然的支持。
### Istio做了什么？
先来看一下一个常规的微服务需要用到的组件
![tu11](https://github.com/shanyao19940801/BookeNote/blob/master/ServiceMesh/file/microservice-12.png)

前面也说到过，ServiceMesh的理念就是把技术层与业务分开，让业务技术人员专注于业务开发，Istio就要替代一些组件。如下：


### 怎么做的？

# 参考

[企业应用架构演化探讨：从微服务到Service Mesh](https://www.kubernetes.org.cn/5349.html)

[ServiceMesh究竟解决什么问题？](https://mp.weixin.qq.com/s?__biz=MjM5ODYxMDA5OQ==&mid=2651962194&idx=2&sn=7a2d8305181a394e1d01e885286a7dde&chksm=bd2d0e8e8a5a8798c17b6dcbbd0fb87ed519b685856bc480437b9ca03a665e5536d03264d91b&scene=21#wechat_redirect)

[使用 Istio治理微服务入门](https://mp.weixin.qq.com/s?__biz=MzU0MTMyMDg1NQ==&mid=2247483756&idx=1&sn=ee475f20b9900aec7e56ae03313bf149&chksm=fb2af294cc5d7b82509ef23d7268370588b997d1b169970bbbce08810488f098024a5a84cb78&scene=21#wechat_redirect)

[Service Mesh 在华为公有云的实践](https://gitbook.cn/books/5a1e7dca387c5b4ee351790b/index.html)

[微服务运维减负：Istio Service Mesh原理+实战](https://dbaplus.cn/news-134-2030-1.html?ad_check=1)
