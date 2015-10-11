package com.self.mapper;

import java.util.List;

import com.self.entity.RoleFormMap;
import com.self.mapper.base.BaseMapper;

public interface RoleMapper extends BaseMapper {
	public List<RoleFormMap> seletUserRole(RoleFormMap map);

	public void deleteById(RoleFormMap map);
}
