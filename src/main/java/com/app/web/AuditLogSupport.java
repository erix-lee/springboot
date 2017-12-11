package com.app.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.app.domain.AuditLog;
import com.app.repository.AuditRepository;

public abstract class AuditLogSupport {
	@Autowired
	protected AuditRepository auditRepository;
	public String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	protected void log(String action, String content) 
	{
		AuditLog log=new AuditLog();
		log.setLogTime(new Date());
		log.setUser(getUserName());
		log.setAction(action);
		log.setContent(content);
		auditRepository.save(log);
	}
	protected void log(String userName,String action, String content) 
	{
		AuditLog log=new AuditLog();
		log.setLogTime(new Date());
		log.setUser(userName);
		log.setAction(action);
		log.setContent(content);
		auditRepository.save(log);
	}
}
