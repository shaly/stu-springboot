package com.syf.study.mapper;

import java.util.List;

import com.syf.study.bean.Car;

public interface CarMapper {
	List<Car> queryAll1(Car car);
	List<Car> queryAll2(Car car);
	List<Car> queryAll3(Car car);
	List<Car> queryAll4(Car car);
	List<Car> queryAllChoose(Car car);
	List<Car> queryUtile(Car car);
	int update(Car car);
	List<Car> queryForeach(Car car);
	
	
}
