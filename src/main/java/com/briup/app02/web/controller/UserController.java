package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/user")


public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//
	@GetMapping("findAllUser")
	public List<User> findAllUser() throws Exception{
		List<User> list = userService.findAll();
		return list; 
	}
	
	@GetMapping("findUserById")
	public User findUserById (long id){
		try {
			User user = userService.findById(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * save学生信息
	 * @author 23194
	 * 
	 */
	@PostMapping("saveUser")
	public String saveUser(User user) {
		try {
			userService.save(user);
			return "保存成功";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("updateUser")
	public String updateUser(User user) {
		try {
			userService.update(user);
			return "修改成功";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("deleteUserById")
	public MsgResponse deleteUserById(Long id) {
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功!", null);
		}catch(Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}


