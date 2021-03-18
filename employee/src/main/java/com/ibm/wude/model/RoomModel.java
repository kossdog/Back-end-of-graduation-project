package com.ibm.wude.model;

import io.swagger.annotations.ApiModel;

@ApiModel("病房信息Model")
public class RoomModel {
	private Integer id;
	private String num;
	private String type;
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
