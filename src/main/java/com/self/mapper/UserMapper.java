package com.self.mapper;

import java.util.List;

import com.self.entity.UserFormMap;
import com.self.mapper.base.BaseMapper;

public interface UserMapper extends BaseMapper {

	public List<UserFormMap> findUserPage(UserFormMap userFormMap);

}
