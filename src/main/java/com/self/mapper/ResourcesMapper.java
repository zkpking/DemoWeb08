package com.self.mapper;

import java.util.List;

import com.self.entity.ResFormMap;
import com.self.mapper.base.BaseMapper;

public interface ResourcesMapper extends BaseMapper {
	public List<ResFormMap> findChildlists(ResFormMap map);

	public List<ResFormMap> findRes(ResFormMap map);

	public void updateSortOrder(List<ResFormMap> map);

	public List<ResFormMap> findUserResourcess(String userId);

	public List<ResFormMap> findRoleResourcess(String roleId);
}
