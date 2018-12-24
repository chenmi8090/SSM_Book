package com.baizhi.test;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class HelloWorld{
	
	@Test
	public void test(){
		System.out.println("AAA");
	}
}