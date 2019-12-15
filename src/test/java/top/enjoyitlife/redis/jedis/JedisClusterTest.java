package top.enjoyitlife.redis.jedis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("JedisCluster")
class JedisClusterTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Test
	void contextLoads() {
		String name=redisTemplate.opsForValue().get("name").toString();
		redisTemplate.opsForValue().set("hahha", "enjoyitlife2020");
		System.out.println(name);
	}
}
