package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	Member getLogin(String membera_name, String member_phone);
}
