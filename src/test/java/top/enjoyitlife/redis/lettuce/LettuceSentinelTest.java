package top.enjoyitlife.redis.lettuce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.lettuce.LettucePool;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

import redis.clients.jedis.JedisPool;

@SpringBootTest
@ActiveProfiles("lettuceSentinel")
class LettuceSentinelTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	@Test
	void contextLoads() {
		String name = redisTemplate.opsForValue().get("name").toString();
		System.out.println(name);
	}

}
