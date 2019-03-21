package com.zqq.mall_web;

import java.util.List;

/**
 * 负载均衡的策略
 * @author 17612
 *
 */
public class LoadBalance {

	private int index=0;
	private List<String> services;
	
	public LoadBalance(List<String> services){
		this.services=services;
	}
	public String choose(){
		String service=services.get(index);
		index++;
		if (index>=services.size()) {
			index=0;
		}
		return service;
	}
}
