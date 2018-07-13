package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Student;

public interface StudentMapper {
	
	// 查询所有学生信息
	List<Student> findAll();
	
	//find by ID
	Student findById(long id);
	
	// save 
	void save(Student student);
	
	// delete
    void deleteById(Long id);

	void update(Student student);
	
	
}
