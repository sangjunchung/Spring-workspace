package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.SC;
import com.khmall.mapper.SCMapper;

@Service
public class SCService {
	@Autowired
	private SCMapper scMapper;
	
	public List<SC> getAllSC(){
		return scMapper.getAllSC();
	}
	
	public SC getSnackById(int snack_id) {
		return scMapper.getSnackById(snack_id);
	}
	
	public SC getCompanyById(int company_id) {
		return scMapper.getCompanyById(company_id);
	}
}
