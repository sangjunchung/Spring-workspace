package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.KHMember;

@Mapper
public interface KHMemberMapper {
	void insertMember(KHMember member);
	
	List<KHMember> getAllMember();
}
