package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.service.AppServiceImpl;
import com.vo.AppVO;


@Controller
public class AddOrderAction {
	private static final Logger logger = LoggerFactory.getLogger(AddOrderAction.class);
	@Autowired
	private AppServiceImpl appService;
	@RequestMapping("/addOrder")
	public String addOrder(AppVO appInfo){
		logger.info("addOrder init");
		AppVO vo=new AppVO();
		vo.setAppCode("123");
		vo.setAppName("OTS");
		vo.setIpAddress("127.0.0.1");
		vo.setMd5Key("!@#$%^&");
		vo.setStatus(1);
		int i=appService.addOrder(vo);
		logger.info("addOrder init i"+i);
		
		return "cheng gong le";
	}
	
	@RequestMapping("/query")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String queryOrder(){
		appService.queryOrder();
		return "userlist";
	}
}
