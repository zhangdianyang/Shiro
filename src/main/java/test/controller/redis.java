package test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.pojo.User;

@Controller
public class redis {
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private StringRedisSerializer serializer;
	
	@RequestMapping("/redis/view.do")
	public void index() {
		redisTemplate.setValueSerializer(serializer);
		User user = new User();
		user.setId("222");
		user.setName("333");
		redisTemplate.opsForValue().set("zzz", "33");
		redisTemplate.opsForValue().increment("zzz", 22);
		System.out.println(redisTemplate.opsForValue().get("zzz"));
	}
	
	@RequestMapping("/redis/see.do")
	public void index1() {
		User user = new User();
		user.setId("222");
		user.setName("333");
		redisTemplate.opsForValue().set("zzz1", user, 5, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().size("zzz3"));
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user1", user);
		paramMap.put("user2", user);
		redisTemplate.opsForValue().multiSet(paramMap);
		List<String> paramCollection = new ArrayList<String>();
		paramCollection.add("zzz1");
		paramCollection.add("user1");
		paramCollection.add("user2");
		System.out.println(redisTemplate.opsForValue().multiGet(paramCollection));
	}
	
	@RequestMapping("/redis/list.do")
	public void index2() {
		User user = new User();
		user.setId("222");
		user.setName("333");
		
		redisTemplate.opsForList().leftPush("mylist1", "22");
		System.out.println(redisTemplate.opsForList().range("mylist1", 0, -1));
	}
	
	@RequestMapping("/redis/hash.do")
	public void indexHash() {
		User user = new User();
		user.setId("222");
		user.setName("333");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user1", user);
		paramMap.put("user2", user);
		redisTemplate.opsForHash().putAll("myHash", paramMap);
		System.out.println(redisTemplate.opsForHash().entries("myHash"));
	}
	
	@RequestMapping("/redis/set.do")
	public void indexSet() {
		User user = new User();
		user.setId("222");
		user.setName("333");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user1", user);
		paramMap.put("user2", user);
		System.out.println(redisTemplate.opsForHash().entries("myHash"));
	}
}
