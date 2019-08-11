package com.lianghaojie.haojie_redis.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lianghaojie.haojie_redis.domain.Employee;
import com.yangchunbo.common.utils.RandomUitl;
import com.yangchunbo.common.utils.StringUtil;
/**
 * 
 * @ClassName: RedisJsonTest 
 * @Description: TODO
 * @author:单击开始
 * @date: 2019年8月11日 下午8:05:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans2.xml")
public class RedisJsonTest {

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Test
	public void test_insert() {
		List<Employee> list = new ArrayList<Employee>();
		for (int p = 1; p < 100000; p++) {
			list.add(new Employee(p, StringUtil.generateChineseName()+StringUtil.randomChineseString(2), 
					"13"+RandomUitl.randomString(9), StringUtil.randomChineseString(10)));
		}
		long StartTimes = System.currentTimeMillis();
		for (Employee employee : list) {
			redisTemplate.opsForValue().set("u_"+employee.getId(), employee);
		}
		long endTimes = System.currentTimeMillis();
		System.out.println("采用Json序列化存储的时间是: "+(endTimes-StartTimes));
	}
}
