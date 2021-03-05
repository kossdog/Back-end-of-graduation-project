package com.ibm.wude.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.wude.mapper.DoctorMapper;
import com.ibm.wude.model.DoctorModel;
import com.ibm.wude.model.EmployeeModel;
import com.ibm.wude.model.Pager;
import com.ibm.wude.utils.ExcelUtil;

@Service
public class DoctorService {
	@Autowired
	DoctorMapper doctorMapper;

	public List<DoctorModel> getAllDoctor() {
		return doctorMapper.getAllDoctor();
	}
}
