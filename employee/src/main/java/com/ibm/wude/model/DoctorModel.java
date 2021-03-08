package com.ibm.wude.model;

import io.swagger.annotations.ApiModel;

@ApiModel("医生信息Model")
public class DoctorModel {
	private Integer id;
	private String docname;
	private String docsex;
	private Integer docage;
	private String doclevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getDocsex() {
		return docsex;
	}
	public void setDocsex(String docsex) {
		this.docsex = docsex;
	}
	public Integer getDocage() {
		return docage;
	}
	public void setDocage(Integer docage) {
		this.docage = docage;
	}
	public String getDoclevel() {
		return doclevel;
	}
	public void setDoclevel(String doclevel) {
		this.doclevel = doclevel;
	}
	
}
