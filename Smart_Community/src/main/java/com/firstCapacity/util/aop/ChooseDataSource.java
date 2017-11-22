package com.firstCapacity.util.aop;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class ChooseDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
//		System.out.println("获取到的数据源为："+HandleDataSource.getDataSource());
		return HandleDataSource.getDataSource();
	}
	
}