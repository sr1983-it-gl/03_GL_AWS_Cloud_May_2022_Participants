package com.gl.awservices.repository;

import java.util.ArrayList;
import java.util.List;

import com.gl.awservices.entity.ServiceEntity;

public class ServiceRepository {

	static List<ServiceEntity> allEntities = new ArrayList<>();
	
	static {
		
		allEntities.add(new ServiceEntity(
				1L, "Elastic Container Service", "cluster, task definitions"));
		
		allEntities.add(new ServiceEntity(
				2L, "CI/CD", "commit, build, deploy"));
		
		allEntities.add(new ServiceEntity(
				3L, "RDS", "database, sql, schema, backup"));
		
		allEntities.add(new ServiceEntity(
				4L, "Load Balancer", "auto-scaling, target groups, listeners"));
		
	}
	
	public List<ServiceEntity> listAll(){
		return allEntities;
	}
}
