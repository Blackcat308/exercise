# SpringCloud 练手项目

------
2019年3月27日 8:20:21

写在前边:
    这个项目只是为了自己练习与提高对springcloud的理解、每个人代码实现水平不均、有不合理的地方请提出来，thanks!
    
## 工程结构
``` 
exercise
├── bc-admin --  admin服务
├── bc-app --  app服务
├── bc-config --  公共配置
├── bc-feign -- 对外API
├── bc-web -- web服务
├── bc-zuul -- 网关
├── common -- 常用工具封装包
└── eureka-server -- 服务注册
```

慢慢加上数据库连接,redis缓存,elk日志分析工具,定时器等日常中间件

-------

2019年3月27日 22:37:06
将bc-config配置为公共远程访问

------

2019年5月10日 10:47:19
增加数据源、配置mybatis、为zuul增加过滤



blog地址:https://blog.csdn.net/ProGram_BlackCat/article/details/88850097