package org.springcloud.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Dept implements java.io.Serializable{
	private static final long serialVersionUID = -5607959962428706552L;
	
	// 主键
	private Long deptno;
	// 部门名称
	private String dname;
	// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库。
	private String db_source;

	public Dept(String dname) {
		super();
		this.dname = dname;
	}
}
