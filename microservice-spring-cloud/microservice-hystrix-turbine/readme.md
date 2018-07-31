Hystrix的turbine(一个将所有/hystrix.stream聚合到/turbine.stream中的应用程序)
-------------------------------------------------
* 添加turbine的依赖spring-cloud-starter-turbine
* 在启动类添加注解@EnableTurbine
* 需要注册到eureka，添加必须的eureka.client配置yml
* 添加turbine的所需要yml配置    

###### 注意：1.集群与非集群以及项目前缀需要特定的配置声明
###### 注意：2.配置actuator的管理端口management.port请参考28.turbine下