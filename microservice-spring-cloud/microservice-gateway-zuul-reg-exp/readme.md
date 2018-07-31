Zuul（30.Zuul简介-33.Zuul使用正则表达式指定路由规则）
-------------------------------------------------
* 添加zuul的依赖及eureka的依赖spring-cloud-starter-zuul、spring-cloud-starter-eureka
* 在启动类中添加注解@EnableZuulProxy
* 在启动类中添加 

``  
@Bean
public PatternServiceRouteMapper serviceRouteMapper() {
    return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
}
`` 
#### 结论：使用正则表达式改变zuul访问的映射代理，如“http://192.168.80.1:8040/v1/mircoservice-provider-user/simple/1”
