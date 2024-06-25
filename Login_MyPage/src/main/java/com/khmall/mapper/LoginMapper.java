package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

/* 
@MapperScan = mapper 위치가 아예 찾아지지 않을 때 
			  main 메서드에 mapper 주소를 작성해주는 어노테이션
사용법
	@MapperScan("com.khmall.mapper.LoginMapper") - 매퍼 하나 가져오기
	@MapperScans("com.khmall.mapper.*") - 매퍼 여러종류 가져오기
*/

@Mapper
public interface LoginMapper {
	Member getLogin(@Param("member_name") String member_name, @Param("member_phone") String member_phone);
	void updateMember(Member member);
	void deleteMember(@Param("member_id") int member_id);
	List<Member> searchMembers(@Param("keyword") String keyword);
}
