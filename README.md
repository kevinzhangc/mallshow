# 商城- 微服务架构实战

# 项目用到的技术

项目采用前后端分离开发，前端需要独立部署。目前核心的技术栈采用的是SpringBoot2.1.5.RELEASE+Dubbo2.7.2,  

## 前端使用的技术

* nodejs
* axios
* es6
* vue
* sass
* Element UI
* webpack
* vue router
* mockjs

## 后端使用的技术

后端的主要架构是基于springboot+dubbo+mybatis.

* SpringBoot2.1.6
* Mybatis
* Dubbo2.7.2
* Zookeeper
* Mysql
* Redis
* Kafka
* druid
* mybatis generator


# 项目模块说明

| db_script  本项目的数据库脚本                                | 使用mysql | 暂时未做分表处理，不过有考虑到分表的情况             |
| ------------------------------------------------------------ | --------- | ---------------------------------------------------- |
| mall-commons 公共的组件                                    | jar       | 公共组件，很多地方都有引用，改动的时候要注意         |
| mall-front  商城的前端项目                             | 前端项目  | 使用vue、node、es等前端技术开发                      |
| mall-parent 父控文件，用来统一管理所有jar包                | 父控文件  | 用来统一管理所有项目的jar包的版本                    |
| mall-shopping  商品/购物车/首页渲染等交互                  | web项目   | 8081端口                                             |
| mall-user  提供用户相关的交互，如登录、注册、个人中心等    | web项目   | 8082端口                                             |
| shopping-service，提供购物车、推荐商品、商品等服务           | dubbo服务 | 20881端口                                            |
| user-service ，提供用户相关服务                              | dubbo服务 | 20880端口                                            |
| order-service ，提供订单服务                                 | dubbo服务 | 20882端口                                            |


#项目启动方式(顺序)
* user-service
* shoppint-service
* order-service
* comment-service
* mall-user
* mall-shopping
* gpmall-fornt

后续会在项目中逐步增加支付，事物等（计划采用 redis 分布式事务索）