package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Snacks;
import com.khmall.mapper.SnackMapper;

/*
	Controller에서 가져오거나 DB에서 가져온 값에
	추가적인 기능을 작성해주는 서비스 공간
	@Service DB에서 가져온 SQL 구문이나 HTML에서 DB에 넣어줄 값에다가
	추가적인 서비스를 적용하겠다 표시
*/
@Service
public class SnacksService {
	// Mapper 에 작성한 리스트를 모두 활용하겠다라는
	// @Autowired 어노테이션을 작성
	@Autowired // 객체 안에 한줄씩 참조할 때 작성
	private SnackMapper snackMapper;
	
	// 스낵 SQL에서 가져온 스낵들을 컨트롤러에 전달해주는 메서드(기능) 작성
	public List<Snacks> getAllSnacks(){
		// 상품 목록을 보여줄 떄 추가적으로 설정해서 넣어주고 싶은 기능을 나중에 추가적으로 작성
		// 예를 들어 상품 이미지 있는지 확인하고, 이미지 없으면 X 박스로 표시한다던지
		// 이외 여러가지 기능을 작성
		return snackMapper.getAllSnacks();
	};
}
