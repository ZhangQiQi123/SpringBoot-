package com.zqq.mall_web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
 import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.zqq.bean.Response;


/**
 * 服务发现
 * 在进行服务调用的时候，需要先从注册中心获取服务地址，然后获取到的服务地址进行调用
 * @author 17612
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		
		//连接服务注册中心zookeeper，连接失败后的策略 试着每秒钟去连接一次
		CuratorFramework client=CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryOneTime(1000));
		//启动
		client.start();
		//直到连上为止
		client.blockUntilConnected();
		
		//注册节点
		ServiceDiscovery<Object> serviceDiscovery=ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();
		
		//获取服务product的信息
		Collection<ServiceInstance<Object>> list=serviceDiscovery.queryForInstances("product");
		final List<String> services=new ArrayList<>();
		
		list.forEach((service)->{
			services.add(service.getAddress()+":"+service.getPort());
		});
		
		LoadBalance lb=new LoadBalance(services);
		
		for (int i = 1; i <= 10; i++) {
			RestTemplate rt = new RestTemplate();
			String body = rt.getForObject("http://" + lb.choose() + "/soa/product/address", String.class);
			System.out.println(body);
//			Response response = new Gson().fromJson(body, Response.class);
			
		}
		
	
	}
}
