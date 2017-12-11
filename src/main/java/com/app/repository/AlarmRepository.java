package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.AlarmLog;

public interface AlarmRepository extends JpaRepository<AlarmLog,  Long>{
	
}
