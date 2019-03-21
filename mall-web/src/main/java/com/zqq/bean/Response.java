package com.zqq.bean;
/**
 * restFul 模式返回的数据
 * @author 17612
 *200:返回成功；500：返回失败
 */
public class Response {

	private String code;
	
	private String msg;
	
	private Product data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public Response(String code, String msg, Product data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Response() {
		super();
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
