package com.self.entity;

import com.self.annotation.TableSeg;
import com.self.util.FormMap;

/**
 * 实体表
 * @author kaider
 *
 */
@TableSeg(tableName = "sys_res_user", id = "userId")
public class ResUserFormMap extends FormMap<String, Object> {

	/**
	 * @descript
	 */
	private static final long serialVersionUID = 1L;

}
