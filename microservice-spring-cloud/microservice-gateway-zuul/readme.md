Zuul（30.Zuul简介-32.Zuul指定Path+url以及指定可用的服务节点时如何负载均衡）
-------------------------------------------------
#### application.yml.bak1
* 添加zuul的依赖及eureka的依赖spring-cloud-starter-zuul、spring-cloud-starter-eureka
* 在启动类中添加注解@EnableZuulProxy
* 定制化代理的mapping以及忽略其他服务请参考application.yml.bak1中zuul配置

**结果：http://192.168.80.1:8040/mircoservice-provider-user/simple/1可以访问成功即zuul代理了privider-user**

#### application.yml.bak2
* 定制化代理的mapping还有另一种形式请参考application.yml.bak2中zuul配置

#### application.yml.bak3
* 定制化代理的mapping还有url配置形式请参考application.yml.bak3中zuul配置

#### application.yml.bak4
* zuul负载均衡的配置请参考application.yml.bak4中zuul配置

#### application.yml.bak5
* 添加前缀配置及忽略路径的配置请参考application.yml.bak5中zuul配置

