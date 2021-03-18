package com.ibm.wude.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import com.ibm.wude.model.RoomModel;


@Mapper
public interface RoomMapper {
	
	public RoomModel getRoomModelByNum(String num);

	public RoomModel getRoomModelById(Integer id);

	public List<RoomModel> getAllRoom();
	
	public int addRoom(RoomModel room);
	
	public boolean deleteRoomById(Integer id);
	
	public List<RoomModel> getRoomByPage(Map<String, Object> params);
	
	public boolean updateRoom(RoomModel roomModel);

	public long count();
}
