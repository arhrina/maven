package com.biz.sec.mapper;

import java.util.List;
import java.util.Map;

import com.biz.sec.persistence.IolistDTO;

public interface IolistDao {
	/*
	 * mapper.xml에 설정된 resultMap에 각 record data를 담고 resultMap의 column들을 List로 묶어서 return
	 */
	public List<Map<String, Object>> selectAllMap();
	public List<IolistDTO> selectAll();
}
