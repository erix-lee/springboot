package com.app.api.service;

import org.springframework.stereotype.Component;

@Component

public interface PersistFacade {

	/**
	 * 日志服务
	 * @return
	 */
	LogSaveService getLogService();
	
	/**
	 * 监控对象服务
	 * @return
	 */
	MonitorTargetService getMonitorTargetService();
	

	
	/**
	 * 告警服务
	 * @return
	 */
	AlarmLogService getAlarmService(); 
	

	
}