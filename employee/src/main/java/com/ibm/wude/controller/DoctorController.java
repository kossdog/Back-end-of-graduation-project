package com.ibm.wude.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.wude.model.DoctorModel;
import com.ibm.wude.model.EmployeeModel;
import com.ibm.wude.model.Pager;
import com.ibm.wude.service.DoctorService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "医生信息Controller")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
   //test

	@ApiOperation(value = "获取所有医生信息", notes = "不必传入参数")
	@GetMapping("/getAllDoctor")
	public List<DoctorModel> getAllDoctor() {
		List<DoctorModel> list = doctorService.getAllDoctor();
		return list;
	}

   //添加医生
	@ApiOperation(value = "添加医生信息", notes = "传入一个POJO（JSON格式）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docname", value = "医生姓名", dataType = "String", paramType = "path", required = true),
			@ApiImplicitParam(name = "docsex", value = "性别", dataType = "String", paramType = "path", required = true),
			@ApiImplicitParam(name = "docage", value = "年龄", dataType = "Integeter", paramType = "path", required = true),
			//尝试一下
			@ApiImplicitParam(name = "doclevel", value = "职称", dataType = "String", paramType = "path", required = true),
			})
	@PostMapping("/addDoctor")
	public int addDoctor(@RequestBody DoctorModel doctor) {
		return doctorService.addDoctor(doctor);
	}
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	@ApiOperation(value = "分页查询员工信息", notes = "传入一个POJO（JSON格式），其中“page”（页数）和“size”（每页数据量大小）是必须的")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docpage ", value = "页数", dataType = "Integeter", paramType = "path", required = true),
			@ApiImplicitParam(name = "docsize", value = "每页内容数量", dataType = "Integeter", paramType = "path", required = true) })
	@PostMapping("/getDocByPage")
	public Pager<DoctorModel> getDocByPage(@RequestBody Pager<DoctorModel> page) {
		return doctorService.getDocByPage(page);
	}
    
	/**
	 * 
	 * 
	 * @param doctorModel
	 * @return
	 */
	@ApiOperation(value = "更新医生信息", notes = "传入一个POJO（JSON格式），其中“id”是必须的")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "编号", dataType = "Integeter", paramType = "path", required = true),
			@ApiImplicitParam(name = "docsex", value = "性别", dataType = "String", paramType = "path", required = true),
			@ApiImplicitParam(name = "docage", value = "年龄", dataType = "Integeter", paramType = "path", required = true),
			//尝试一下
			@ApiImplicitParam(name = "doclevel", value = "职称", dataType = "String", paramType = "path", required = true), })
	@PostMapping("/updateDoc")
	public boolean updateDoctor(@RequestBody DoctorModel doc) {
		if (getDoctorModelById(doc.getId()) != null) {
			return doctorService.updateDoctor(doc);
		} else {
			return false;
		}
	}

	/**
	 * 查询员工信息
	 * 
	 * @param id
	 * @return 查询结果
	 */
	@ApiOperation("通过ID查询医生信息")
	@GetMapping("/getDocById/{id}")
	public DoctorModel getDoctorModelById(@PathVariable("id") Integer id) {
		return doctorService.getDoctorById(id);
	}

}

