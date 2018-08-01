package org.springcloud.provider.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springcloud.api.model.Dept;

@Mapper
public interface DeptDao {
	
	public boolean addDept(Dept dept);
	 
    public Dept findById(Long id);
 
    public List<Dept> findAll();
}
