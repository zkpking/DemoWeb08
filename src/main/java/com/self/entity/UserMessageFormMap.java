package com.self.entity;

import com.self.annotation.TableSeg;
import com.self.util.FormMap;

/**
 * 用户消息实体表
 * 
 * @author kaider
 *
 */
@TableSeg(tableName = "sys_user_message", id = "id")
public class UserMessageFormMap extends FormMap<String, Object> {

	private static final long serialVersionUID = 1L;

}