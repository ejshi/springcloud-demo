package org.springcloud.provider.service;

import java.util.List;

import org.springcloud.api.model.Dept;

public interface DeptService {
	public boolean add(Dept dept);
    public Dept  get(Long id);
    public List<Dept> list();
}
