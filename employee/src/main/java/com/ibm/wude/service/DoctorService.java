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
import org.springframework.web.bind.annotation.RequestBody;

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
	
	public int addDoctor(DoctorModel doctor) {
		return doctorMapper.addDoctor(doctor);
	}
	
	public DoctorModel getDoctorById(Integer id) {
		return doctorMapper.getDoctorModelById(id);
	}

	public DoctorModel getDoctorModelByDocname(String docname) {
		return doctorMapper.getDoctorModelByDocname(docname);
	}
	
	public boolean updateDoctor(DoctorModel doctorModel) {
		return doctorMapper.updateDoctor(doctorModel);
	}
	
	public Pager<DoctorModel> getDocByPage(Pager<DoctorModel> findPage) {
		Map<String, Object> params = new HashMap<String, Object>();
		int page = findPage.getPage();
		int size = findPage.getSize();
		params.put("page", (page - 1) * size);
		params.put("size", size);
		Pager<DoctorModel> pager = new Pager<DoctorModel>();
		List<DoctorModel> list = doctorMapper.getDocByPage(params);
		pager.setPage(page);
		pager.setSize(page);
		pager.setRows(list);
		pager.setTotal(doctorMapper.count());
		return pager;
	}
}
