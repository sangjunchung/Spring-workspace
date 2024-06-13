package com.example.demo.dto;

import lombok.*;

/*
	Spring 같은 경우 Getter 가 필수로 있어야 함
	-> ${StudentDTO.getName()} == ${StudentDTO.name}
	getter 대신 필드명 호출하는 형식 작성
	이게 가능한 이유? getter 를 자동으로 호출하여 동작하기 때문
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
	private String studentNo;
	private String name;
	private int age;
}
