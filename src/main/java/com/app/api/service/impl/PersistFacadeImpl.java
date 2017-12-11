package com.app.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.service.AlarmLogService;
import com.app.api.service.LogSaveService;
import com.app.api.service.MonitorTargetService;
import com.app.api.service.PersistFacade;
@Service("persistFacade")  
public class PersistFacadeImpl implements PersistFacade {
	
	@Autowired
	LogSaveService logService;
	@Autowired
	MonitorTargetService monitorTargetService;

	@Autowired
	AlarmLogService alarmService;
	
	public LogSaveService getLogService() {
		return logService;
	}

	public MonitorTargetService getMonitorTargetService() {
		return monitorTargetService;
	}



	public AlarmLogService getAlarmService() {
		return alarmService;
	}

 

}
