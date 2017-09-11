package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.dto.AppProtocolDtoExample;
import com.study.service.AppServiceImpl;
import com.vo.AppVO;

@Controller
public class AddOrderAction {
	@Autowired
	private AppServiceImpl appService;
	@RequestMapping("/addOrder")
	public String addOrder(){
		AppVO vo=new AppVO();
		vo.setAppCode("123");
		vo.setAppName("OTS");
		vo.setIpAddress("127.0.0.1");
		vo.setMd5Key("!@#$%^&");
		vo.setStatus(1);
		appService.addOrder(vo);
		return "cheng gong le";
	}
	
	@RequestMapping("/query")
	public String queryOrder(){
		System.out.println("========================");
		appService.queryOrder();
		return "cheng gong le";
	}
}
