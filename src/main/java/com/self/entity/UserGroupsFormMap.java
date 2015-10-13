package com.self.entity;

import com.self.annotation.TableSeg;
import com.self.util.FormMap;

/**
 * 实体表
 * @author kaider
 *
 */
@TableSeg(tableName = "sys_user_role", id = "userId")
public class UserGroupsFormMap extends FormMap<String, Object> {

	/**
	 * @descript
	 */
	private static final long serialVersionUID = 1L;

}
