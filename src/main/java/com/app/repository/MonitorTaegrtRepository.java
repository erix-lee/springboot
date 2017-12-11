package com.app.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.MonitorTarget;

public interface MonitorTaegrtRepository extends JpaRepository<MonitorTarget, Long> {
	public MonitorTarget findOneBySubid(String subid);
}
