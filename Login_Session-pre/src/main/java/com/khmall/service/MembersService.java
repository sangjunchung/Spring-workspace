package com.khmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Members;
import com.khmall.mapper.MembersMapper;

@Service
public class MembersService {
	@Autowired
	private MembersMapper membersMapper;
	
	public Members getLoginInfo(String username, String password) {
		return membersMapper.getLoginInfo(username, password);
	}
}
