package com.briup.app02.dao;

import com.briup.app02.bean.User;

public interface UserMapper {
	User findById(long id);
}
