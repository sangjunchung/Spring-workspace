package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
	Getter 와 Setter 는 Lombok 라이브러리 활용해서 길게 작성하지 않음
	기본 생성자
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
	// 나중에 DB 랑 연결할 모델들 작성
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
	// Getter -> lombok @Getter 자동완성 사용하기
	// Setter -> lombok @Setter 자동완성 사용하기
	// 기본 생성자 -> lombok @NoArgsConstructor 자동완성 사용하기
	// 필수 생성자 -> lombok @AllArgsConstructor 자동완성 사용하기
	// toString -> lombok @ToString 자동완성 사용하기
	
}
