package com.dotreign.justaitest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

  @Value("${spring.data.redis.host}")
  private String host;
  @Value("${spring.data.redis.port}")
  private Integer port;
  @Value("${spring.data.redis.database}")
  private Integer database;

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {

    RedisStandaloneConfiguration redisStandaloneConfiguration =
        new RedisStandaloneConfiguration(host, port);
    redisStandaloneConfiguration.setDatabase(database);
    return new JedisConnectionFactory(redisStandaloneConfiguration);
  }

  @Bean
  public <F, S> RedisTemplate<F, S> redisTemplate() {
    RedisTemplate<F, S> template = new RedisTemplate<>();

    template.setConnectionFactory(jedisConnectionFactory());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
    template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
    template.afterPropertiesSet();
    return template;
  }
}
