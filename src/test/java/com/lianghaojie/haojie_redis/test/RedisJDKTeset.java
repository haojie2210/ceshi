package com.lianghaojie.haojie_redis.test;
/**
 * 
 * @ClassName: RedisJDKTeset 
 * @Description: TODO
 * @author:单击开始
 * @date: 2019年8月10日 上午9:36:29
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lianghaojie.haojie_redis.domain.Employee;
import com.yangchunbo.common.utils.RandomUitl;
import com.yangchunbo.common.utils.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class RedisJDKTeset {
	
	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Test
	public void test_insert() {
		List<Employee> list = new ArrayList<Employee>();
		for (int p = 1; p < 100000; p++) {
			list.add(new Employee(p, StringUtil.generateChineseName() + StringUtil.randomChineseString(2),
					"13" + RandomUitl.randomString(9), StringUtil.randomChineseString(10)));
		}
		long startTimes = System.currentTimeMillis();
		for (Employee employee : list) {
			redisTemplate.opsForValue().set("u_"+employee.getId(), employee);
		}
		long endTimes = System.currentTimeMillis();
		System.out.println("采用jdk序列化存储的时间："+(endTimes-startTimes));
	}
}
