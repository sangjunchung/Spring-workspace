package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Members;

@Mapper
public interface MembersMapper {
	Members getLoginInfo(String username, String password);
}
