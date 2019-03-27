 spring:
  cloud:
    config:
     server:
        native:
          search-locations: classpath:configs/ # 搜索src/main/resource 下的properties文件夹下的文件
  profiles:
   active: native   # 配置使用本地储存

URL与配置文件的映射关系如下：
 /{name}-{profiles}.yml
 /{label}/{name}-{profiles}.yml

 name : 文件名，一般以服务名来命名
 profiles : 一般作为环境标识
 lable : 分支（branch），指定访问某分支下的配置文件
 
 spring.cloud.config.server.git.uri：配置git仓库地址
 spring.cloud.config.server.git.searchPaths：配置仓库路径
 spring.cloud.config.label：配置仓库的分支
 spring.cloud.config.server.git.username：访问git仓库的用户名
 spring.cloud.config.server.git.password：访问git仓库的用户密码
