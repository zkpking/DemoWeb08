package com.self.entity;

import com.self.annotation.TableSeg;
import com.self.util.FormMap;

/**
 * user实体表
 */
@TableSeg(tableName = "sys_user", id = "id")
public class UserFormMap extends FormMap<String, Object> {

	private static final long serialVersionUID = 1L;

}
