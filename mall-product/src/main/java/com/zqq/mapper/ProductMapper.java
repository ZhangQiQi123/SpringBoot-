package com.zqq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zqq.bean.Product;

@Mapper
public interface ProductMapper {

	@Insert("insert into products(pname,type,price) values(#{pName},#{pType},#{price})")
	public Integer addProduct(Product product);
	//arg1表示第一个参数
	@Delete("delete from products where pid=#{arg1}")
	public Integer deleteById(Integer productId);
	@Update("update products set pname=#{pName},type=#{pType},price=#{price} where pid=#{pId}")
	public Integer update(Product product);
	@Select("select pid,pname,type,price,create_time from products where pid=#{arg1}")
	@Results(id="productMap",value={@Result(column="pid",property="pId"),
			@Result(column="pname",property="pName"),
			@Result(column="type",property="pType"),
			@Result(column="price",property="price")})
	public Product getById(Integer productId);
	@Select("select * from products order by pid desc")
	@ResultMap("productMap")
	public List<Product> getAllProducts();
}
