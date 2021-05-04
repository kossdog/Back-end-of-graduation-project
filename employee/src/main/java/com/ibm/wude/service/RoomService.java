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

import com.ibm.wude.model.RoomModel;
import com.ibm.wude.mapper.RoomMapper;
import com.ibm.wude.model.DoctorModel;
import com.ibm.wude.model.Pager;
import com.ibm.wude.utils.ExcelUtil;

@Service
public class RoomService {
	@Autowired
	RoomMapper roomMapper;

	public List<RoomModel> getAllRoom() {
		return roomMapper.getAllRoom();
	}
	
	public List<RoomModel> getRoomState() {
		return roomMapper.getRoomState();
	}
	
	public int addRoom(RoomModel room) {
		return roomMapper.addRoom(room);
	}
	
	public RoomModel getRoomById(Integer id) {
		return roomMapper.getRoomModelById(id);
	}

	public RoomModel getRoomModelByNum(String num) {
		return roomMapper.getRoomModelByNum(num);
	}
	
	public boolean updateRoom(RoomModel roomModel) {
		return roomMapper.updateRoom(roomModel);
	}
	
	public boolean deleteRoomById(Integer id) {
		return roomMapper.deleteRoomById(id);
	}
	
	public Pager<RoomModel> getRoomByPage(Pager<RoomModel> findPage) {
		Map<String, Object> params = new HashMap<String, Object>();
		int page = findPage.getPage();
		int size = findPage.getSize();
		params.put("page", (page - 1) * size);
		params.put("size", size);
		Pager<RoomModel> pager = new Pager<RoomModel>();
		List<RoomModel> list = roomMapper.getRoomByPage(params);
		pager.setPage(page);
		pager.setSize(page);
		pager.setRows(list);
		pager.setTotal(roomMapper.count());
		return pager;
	}
	
	public List<RoomModel> findRoomModel(String string) {
		return roomMapper.findRoomModel(string);
	}
}