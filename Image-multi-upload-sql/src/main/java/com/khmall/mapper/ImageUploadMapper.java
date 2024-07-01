package com.khmall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.ImageUpload;

@Mapper
public interface ImageUploadMapper {
	void insertImageUpload(Map<String, Object> paramMap);
}
