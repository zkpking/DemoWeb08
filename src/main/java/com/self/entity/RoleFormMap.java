package com.self.entity;

import com.self.annotation.TableSeg;
import com.self.util.FormMap;

/**
 * 实体表
 * 
 * @author kaider
 *
 */
@TableSeg(tableName = "sys_role", id = "id")
public class RoleFormMap extends FormMap<String, Object> {

	private static final long serialVersionUID = 1L;

}
