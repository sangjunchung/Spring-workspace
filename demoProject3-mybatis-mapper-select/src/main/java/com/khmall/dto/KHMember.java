package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KHMember {
	private int member_id;
	private String username;
	private String password;
	private String email;
	private String created_at;
}
