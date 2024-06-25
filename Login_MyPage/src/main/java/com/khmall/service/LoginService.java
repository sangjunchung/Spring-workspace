package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Member;
import com.khmall.mapper.LoginMapper;

@Service
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		// 추후에 서비스에 비밀번호 암호화해서 DB에 저장하고
		// 암호화된 비밀번호를 가져와서 로그인하는 코드를 추가로 작성할 예정
		return loginMapper.getLogin(member_name, member_phone);
	}
	
	public void updateMember(Member member) {
		loginMapper.updateMember(member);
	}
	
	public void deleteMember(int member_id) {
		loginMapper.deleteMember(member_id);
	}
	
	public List<Member> searchMembers(String keyword){
		return loginMapper.searchMembers(keyword);
	}
}
