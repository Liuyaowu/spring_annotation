package com.mobei.spring.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Boss {

	private Car car;

//	@Autowired
	public Boss(/*@Autowired*/ Car car){
		this.car = car;
		System.out.println("Boss...");
	}

	public Car getCar() {
		return car;
	}

	/**
	 * @Autowired 标注在方法上,Spring容器创建当前对象就会调用该方法完成赋值,方法使用的参数自动从容其中获取值
	 *
	 * @param car
	 */
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
	}

}
