package com.hemax.jkt.data.repository;


import java.util.Collection;
import java.util.List;

import com.hemax.jkt.data.BaseRepository;
import com.hemax.jkt.domain.Xueyuan;

/**
 * 
 * created by quan.zhang@msxf.com 2016年5月19日
 */
public interface XueyuanRepository extends BaseRepository<Xueyuan, Long>{
	
	List<Xueyuan> findByName(String name);
	
	List<Xueyuan> findByNameAndStep(String name,int step);
	
	List<Xueyuan> findByStep(Integer step);
}
