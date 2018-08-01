package org.springcloud.provider.service.impl;

import java.util.List;

import org.springcloud.api.model.Dept;
import org.springcloud.provider.dao.DeptDao;
import org.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="deptService")
public class DeptServiceimpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

}
