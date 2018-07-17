package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.bean.User;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.dao.userMapper;
import com.briup.app02.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private userMapper USERMapper;
	
	@Override
	public List<User> findAll() throws Exception {
		List<User> list = USERMapper.findAll();
		return list;
	}

	@Override
	public User findById(long id) throws Exception {
		return USERMapper.findById(id);
	}

	@Override
	public void save(User user) throws Exception {
		USERMapper.save(user);
		
	}

	@Override
	public void update(User user) throws Exception {
		USERMapper.update(user);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		User user = USERMapper.findById(id);
		if(user!=null)
		{
			USERMapper.deleteById(id);
		}
		else 
		{
			throw new Exception("要删除的学生不存在");
		}
		
	}
	

}
