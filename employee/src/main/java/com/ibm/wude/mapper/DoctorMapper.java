package com.ibm.wude.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.ibm.wude.model.DoctorModel;

@Mapper
public interface DoctorMapper {
	
	public DoctorModel getDoctorModelByName(String name);

	public DoctorModel getDoctorModelById(Integer id);

	public List<DoctorModel> getAllDoctor();
}
