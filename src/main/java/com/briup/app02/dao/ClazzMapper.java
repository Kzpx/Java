package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;


public interface ClazzMapper {
	// 查询所有学生信息
		List<Clazz> findAll();
		
		//find by ID
		Clazz findById(long id);
		
		// save 
		void save(Clazz clazz);
		
		// delete
	    void deleteById(Long id);
	    
	    //
		void update(Clazz clazz);


}
