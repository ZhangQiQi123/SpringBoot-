package com.zqq.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zqq.bean.Product;
import com.zqq.mapper.ProductMapper;
import com.zqq.web.Response;
/**
 * product restFul 服务
 * @author 17612
 *
 */
@RestController
public class ProductController {
	@Autowired
	private ProductMapper productMapper;
	
	@PostMapping("/soa/product/add")
	public Object add(Product product){
		Integer res =productMapper.addProduct(product);
		return res==1 ? new Response("200", "Success", null) : new Response("500","Fail",null);
	}
	@PutMapping("/soa/product/update")
	public Object updateById(Product product){
		Integer res =productMapper.update(product);
		return res==1 ? new Response("200", "Success", null) : new Response("500","Fail",null);
	}
	@DeleteMapping("/soa/product/{pId}")
	public Object deleteById(@PathVariable("pId") Integer pId){
		Integer res =productMapper.deleteById(pId);
		return res==1 ? new Response("200", "Success", null) : new Response("500","Fail",null);
	}
	@GetMapping("/soa/product/{pId}")
	public Object getById(@PathVariable("pId") Integer pId){
		Product product=productMapper.getById(pId);
		return new Response("200", "Success", product);
	}
	@GetMapping("/soa/product/getAllProduct")
	public Object getAllProduct(){
		List<Product> products=productMapper.getAllProducts();
		return new Response("200", "Success", products);
	}
	@GetMapping("/soa/product/address")
	public Object address(){
		return new Response("200", "Success", "127.0.0.1:8080");
	}
}
 