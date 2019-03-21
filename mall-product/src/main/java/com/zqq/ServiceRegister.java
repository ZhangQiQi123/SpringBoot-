package com.zqq;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class ServiceRegister implements ApplicationRunner {
	@Value("${zookeeper.address}")
	private String zkAddress;
	
	public void run(ApplicationArguments arg0) throws Exception {
		//连接zookeeper失败后的策略
		CuratorFramework client=CuratorFrameworkFactory.newClient(zkAddress, new RetryOneTime(1000));
		//启动
		client.start();
		//直到连上为止
		client.blockUntilConnected();
		
		//创建服务实例 product（服务名 所在的IP port）
		ServiceInstance<Object> instance= ServiceInstance.builder().name("product").address("192.168.0.84").port(8080).build();
		//注册节点
		ServiceDiscovery<Object> serviceDiscovery=ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();
		//注册服务
		serviceDiscovery.registerService(instance);
		//开启服务
		serviceDiscovery.start();
		System.out.println("服务1注册成功");
	}

}
