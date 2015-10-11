package com.self.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.self.mapper.UserLoginMapper;
import com.self.controller.index.BaseController;
import com.self.entity.UserLoginFormMap;
import com.self.plugin.PageView;
import com.self.util.Common;

/**
 * 
 * @version 3.0v
 */
@Controller
@RequestMapping("/userlogin/")
public class UserLoginController extends BaseController {
	@Inject
	private UserLoginMapper userLoginMapper;

	@RequestMapping("listUI")
	public String listUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/userlogin/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		UserLoginFormMap userLoginFormMap = getFormMap(UserLoginFormMap.class);
		userLoginFormMap = toFormMap(userLoginFormMap, pageNow, pageSize);
		pageView.setRecords(userLoginMapper.findByPage(userLoginFormMap));
		return pageView;
	}

}