package com.self.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.self.mapper.LogMapper;
import com.self.controller.index.BaseController;
import com.self.entity.LogFormMap;
import com.self.plugin.PageView;
import com.self.util.Common;

/**
 * @version 3.0v
 */
@Controller
@RequestMapping("/log/")
public class LogController extends BaseController {
	@Inject
	private LogMapper logMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/log/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize, String column, String sort) throws Exception {
		LogFormMap logFormMap = getFormMap(LogFormMap.class);
		String order = "";
			if(Common.isNotEmpty(column)){
				order = " order by "+column+" "+sort;
			}else{
				order = " order by id asc";
			}
		logFormMap.put("$orderby", order);
		logFormMap = toFormMap(logFormMap, pageNow, pageSize);
		pageView.setRecords(logMapper.findByPage(logFormMap));
		return pageView;
	}
}