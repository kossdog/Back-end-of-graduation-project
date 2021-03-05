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


	


}

