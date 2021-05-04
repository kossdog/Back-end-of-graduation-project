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

import com.ibm.wude.model.RoomModel;
import com.ibm.wude.model.DoctorModel;
import com.ibm.wude.model.Pager;
import com.ibm.wude.service.RoomService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(tags = "病房信息Controller")
public class RoomController {

	@Autowired
	RoomService roomService;
   //test

	@ApiOperation(value = "获取所有病房信息", notes = "不必传入参数")
	@GetMapping("/getAllRoom")
	public List<RoomModel> getAllRoom() {
		List<RoomModel> list = roomService.getAllRoom();
		return list;
	}
	//闲置病房
	@ApiOperation(value = "获取闲置病房", notes = "不必传入参数")
	@GetMapping("/getRoomState")
	public List<RoomModel> getRoomState() {
		List<RoomModel> list = roomService.getRoomState();
		return list;
	}

   //添加医生
	@ApiOperation(value = "添加病房信息", notes = "传入一个POJO（JSON格式）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "num", value = "病房编号", dataType = "String", paramType = "path", required = true),
			@ApiImplicitParam(name = "type", value = "病房类型", dataType = "String", paramType = "path", required = true),
			@ApiImplicitParam(name = "state", value = "病房状态", dataType = "String", paramType = "path", required = true),
			})
	@PostMapping("/addRoom")
	public int addRoom(@RequestBody RoomModel room) {
		return roomService.addRoom(room);
	}
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	@ApiOperation(value = "分页查询员工信息", notes = "传入一个POJO（JSON格式），其中“page”（页数）和“size”（每页数据量大小）是必须的")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page ", value = "页数", dataType = "Integeter", paramType = "path", required = true),
			@ApiImplicitParam(name = "size", value = "每页内容数量", dataType = "Integeter", paramType = "path", required = true) })
	@PostMapping("/getRoomByPage")
	public Pager<RoomModel> getDocByPage(@RequestBody Pager<RoomModel> page) {
		return roomService.getRoomByPage(page);
	}
    
	/**
	 * 
	 * 
	 * @param roomModel
	 * @return
	 */
	@ApiOperation(value = "更新病房信息", notes = "传入一个POJO（JSON格式），其中“id”是必须的")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "num", value = "病房编号", dataType = "String", paramType = "path", required = true),
		@ApiImplicitParam(name = "type", value = "病房类型", dataType = "String", paramType = "path", required = true),
		@ApiImplicitParam(name = "state", value = "病房状态", dataType = "String", paramType = "path", required = true), })
	@PostMapping("/updateRoom")
	public boolean updateRoom(@RequestBody RoomModel room) {
		if (getRoomModelById(room.getId()) != null) {
			return roomService.updateRoom(room);
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
	@ApiOperation("通过ID查询病房信息")
	@GetMapping("/getRoomById/{id}")
	public RoomModel getRoomModelById(@PathVariable("id") Integer id) {
		return roomService.getRoomById(id);
	}
	
	/**
	 * 删除医生信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("通过ID删除病房信息")
	@DeleteMapping("/delRoomById/{id}")
	public boolean deleteRoomById(@PathVariable("id") Integer id) {
		RoomModel room = new RoomModel();
		room.setId(id);
		if (getRoomModelById(id) != null) {
			return roomService.deleteRoomById(id);
		} else {
			return false;
		}

	}
	
	/**
	 * 模糊查询病房信息
	 * 
	 * @param string
	 * @return
	 */
	@ApiOperation("模糊查询病房信息")
	@GetMapping("/findRoom/{string}")
	public List<RoomModel> findRoomModel(@PathVariable String string) {
		return roomService.findRoomModel(string);
	}

}

