package top.enjoyitlife.redis.jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Profile("jedisSingle")
public class JedisSingleConfig {

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWaitMillis;
	
	  @Bean
	   public JedisConnectionFactory redisConnectionFactory()  throws Exception{
	        RedisStandaloneConfiguration rc= new RedisStandaloneConfiguration();
			rc.setHostName(host);
			rc.setPort(port);
			rc.setPassword(password);
			JedisConnectionFactory connectionFactory = new JedisConnectionFactory(rc);
	        return connectionFactory;
	 }
	  
	  
	  @Bean
		public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
			RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
			template.setKeySerializer(new StringRedisSerializer());
			template.setValueSerializer(new StringRedisSerializer());
			template.setConnectionFactory(redisConnectionFactory);
			return template;
		}
	  
}
