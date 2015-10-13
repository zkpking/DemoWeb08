package com.self.controller.system;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.self.annotation.SystemLog;
import com.self.controller.index.BaseController;
import com.self.entity.MessageFormMap;
import com.self.exception.SystemException;
import com.self.mapper.MessageMapper;
import com.self.plugin.PageView;
import com.self.util.Common;

@Controller
@RequestMapping("/msg/")
public class MessageController extends BaseController {
	@Inject
	private MessageMapper msgMapper;

	@RequestMapping("list")
	public String listUI(Model model) throws Exception {
		model.addAttribute("res", findByRes());
		return Common.BACKGROUND_PATH + "/system/msg/list";
	}

	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage(String pageNow, String pageSize) throws Exception {
		MessageFormMap msgFormMap = getFormMap(MessageFormMap.class);
		msgFormMap = toFormMap(msgFormMap, pageNow, pageSize);
		pageView.setRecords(msgMapper.findMessagePage(msgFormMap));
		return pageView;
	}

	@RequestMapping("addUI")
	public String addUI(Model model) throws Exception {
		return Common.BACKGROUND_PATH + "/system/msg/add";
	}

	@ResponseBody
	@RequestMapping("addEntity")
	@SystemLog(module = "系统管理", methods = "系统管理-新增消息") // 凡需要处理业务逻辑的.都需要记录操作日志
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	public String addEntity() {
		try {
			MessageFormMap msgFormMap = getFormMap(MessageFormMap.class);
			msgMapper.addEntity(msgFormMap);// 新增后返回新增信息
		} catch (Exception e) {
			throw new SystemException("添加消息异常");
		}
		return "success";
	}

	@RequestMapping("editUI")
	public String editUI(Model model) throws Exception {
		String id = getPara("id");
		if (Common.isNotEmpty(id)) {
			model.addAttribute("user", msgMapper.findbyFrist("id", id, MessageFormMap.class));
		}
		return Common.BACKGROUND_PATH + "/system/msg/edit";
	}

	@ResponseBody
	@RequestMapping("editEntity")
	@Transactional(readOnly = false) // 需要事务操作必须加入此注解
	@SystemLog(module = "系统管理", methods = "系统管理-修改消息") // 凡需要处理业务逻辑的.都需要记录操作日志
	public String editEntity() throws Exception {
		MessageFormMap msgFormMap = getFormMap(MessageFormMap.class);
		msgMapper.editEntity(msgFormMap);
		return "success";
	}

}