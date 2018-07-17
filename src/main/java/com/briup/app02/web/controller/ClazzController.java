package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;


@RestController
@RequestMapping("/clazz")

public class ClazzController {
	
	@Autowired
	private IClazzService clazzService;
	
	@GetMapping("findAllClazz")
	public List<Clazz> findAllClazz() throws Exception{
		List<Clazz> list=clazzService.findAll();
		return list;
	}
	
	@GetMapping("findClazzById")
	public Clazz findClazzById (long id) {
		try {
			Clazz clazz = clazzService.findById(id);
			return clazz;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("saveClazz")
	public String savaClazz(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return "修改成功";
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("deleteClazzById")
	public MsgResponse deleteClazzById(Long id) {
		try {
			clazzService.deleteById(id);
			return MsgResponse.success("删除成功!", null);
		}catch(Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
