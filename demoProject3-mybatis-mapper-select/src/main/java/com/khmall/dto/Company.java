package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
}
