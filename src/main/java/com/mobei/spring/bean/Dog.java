package com.mobei.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

	
	public Dog(){
		System.out.println("dog constructor...");
	}

	/**
	 * bean完成初始化并且属性赋值后调用
	 */
	@PostConstruct
	public void init(){
		System.out.println("Dog....@PostConstruct...");
	}

	/**
	 * 容器销毁bean之前调用
	 */
	@PreDestroy
	public void detory(){
		System.out.println("Dog....@PreDestroy...");
	}

}
