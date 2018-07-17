package com.briup.app02.dao;

import java.util.List;


import com.briup.app02.bean.User;

public interface userMapper {
	
	
	List<User> findAll();
	
	User findById(long id);
	// save 
	void save(User user);
	// delete
	void deleteById(Long id);
	
	void update(User user);
	
	

}
