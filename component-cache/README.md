1.redis主从模式支持(单机模式)
(1)单个redis数据源时，配置spring.redis.default相关key即可，注入以下实例操作Redis
--redisTemplate：Key为String序列化，Value为JDK序列化
--stringRedisTemplate：Key和Value为String序列化
--jsonRedisTemplate：Key为String序列化，Value为Json序列化

2.spring-cache集成(多个redis节点时，如何选择写入到那个redis节点?)
(1)需要在应用中@EnableCaching
(2)若关闭默认的RedisCacheManager，当自定义多个RedisCacheManager时，需要在其中一个上设置@Primary
(3)应用中关闭以下自动AutoConfiguration,RedisAutoConfiguration.class,RedisRepositoriesAutoConfiguration.class

遇到问题：
1.Error creating bean with name 'redisReferenceResolver'
https://github.com/spring-projects/spring-boot/issues/5386