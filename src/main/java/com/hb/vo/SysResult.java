package com.hb.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
	private Integer status;//状态码  200表示成功 201表示失败
	private String msg;	   //返回状态信息
	private Object data;   //表示传回的数据
	
	public static SysResult ok() {
		return new SysResult(200,null,null);
	}
	
	public static SysResult ok(Object data) {
		return new SysResult(200,null,data);
	}
	
	public static SysResult ok(String msg,Object data) {
		return new SysResult(200,msg,data);
	}
	
	public static SysResult fail() {
		return new SysResult(201,null,null);
	}
	
	public static SysResult fail(String msg,Object data) {
		return new SysResult(201,msg,null);
	}
}
