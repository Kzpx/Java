package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentsService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")

public class StudentController {

	@Autowired
	private IStudentsService studentService;
	
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public List<Student> findAllStudent() throws Exception {
        List<Student> list = studentService.findAll();
		return list; 
	}
	
	@GetMapping("findStudentById")
	public Student findStudentById (long id){
		try {
			Student student = studentService.findById(id);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * save学生信息
	 * @author 23194
	 * @param student
	 * @return
	 */
	@PostMapping("saveStudent")
	public String savaStudent(Student student) {
		try {
			studentService.save(student);
			return "保存成功";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("updateStudent")
	public String updateStudent(Student student) {
		try {
			studentService.update(student);
			return "修改成功";
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("deleteStudentById")
	public MsgResponse deleteStudentById(Long id) {
		try {
			studentService.deleteById(id);
			return MsgResponse.success("删除成功!", null);
		}catch(Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
