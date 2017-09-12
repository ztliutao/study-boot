package com.study.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.dto.AppProtocolDto;
import com.model.dto.AppProtocolDtoExample;
import com.model.mapper.AppProtocolDtoMapper;
import com.vo.AppVO;

@Service
public class AppServiceImpl extends BaseService{
	@Autowired
	private AppProtocolDtoMapper appMapper;
	public int addOrder(AppVO vo){
		AppProtocolDto record=new AppProtocolDto();
		record.setAppCode(vo.getAppCode());
		record.setAppName(vo.getAppName());
		record.setIpAddress(vo.getIpAddress());
		record.setMd5Key(vo.getMd5Key());
		record.setStatus(vo.getStatus());
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		
		
		return appMapper.insert(record);
	}
	
	public List<AppVO> queryOrder(){
		AppProtocolDtoExample example=new AppProtocolDtoExample();
		List<AppProtocolDto> dtoList=appMapper.selectByExample(example);
		for (AppProtocolDto dto : dtoList) {
			AppVO vo=dozerBean().map(dto, AppVO.class);
			System.out.println(vo);
		}
		return null;
	}
}
