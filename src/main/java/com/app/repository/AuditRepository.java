package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.AuditLog;

public interface AuditRepository extends JpaRepository<AuditLog,  Long>{

}