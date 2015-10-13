package com.self.mapper;

import java.util.List;

import com.self.entity.MessageFormMap;
import com.self.mapper.base.BaseMapper;

public interface MessageMapper extends BaseMapper {

	public List<MessageFormMap> findMessagePage(MessageFormMap msgFormMap);

}