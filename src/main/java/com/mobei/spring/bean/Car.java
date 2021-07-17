package com.mobei.spring.bean;

//@Component
public class Car {

	/**
	 * 单实例:容器启动的时候创建对象
	 * 多实例:每次获取的时候创建对象
	 */
	public Car(){
		System.out.println("car constructor...");
	}

	/**
	 * 初始化的时候被调用:对象创建完成,并赋值好,调用初始化方法
	 */
	public void init(){
		System.out.println("car ... init...");
	}

	/**
	 * 单实例: 容器关闭的时候被调用,比如执行AnnotationConfigApplicationContext的close方法
	 * 多实例: 容器不会管理这个bean,容器销不会调用该方法
	 */
	public void destroy(){
		System.out.println("car ... destroy...");
	}

}
