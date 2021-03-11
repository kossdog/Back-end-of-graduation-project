package com.ibm.wude.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.ibm.wude.model.DoctorModel;


@Mapper
public interface DoctorMapper {
	
	public DoctorModel getDoctorModelByDocname(String docname);

	public DoctorModel getDoctorModelById(Integer id);

	public List<DoctorModel> getAllDoctor();
	
	public int addDoctor(DoctorModel doctor);
	
	public List<DoctorModel> getDocByPage(Map<String, Object> params);
	
	public boolean updateDoctor(DoctorModel doctorModel);

	public long count();
}
