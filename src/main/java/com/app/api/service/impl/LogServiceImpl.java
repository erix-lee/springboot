package com.app.api.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.service.InterfaceLogEnum;
import com.app.api.service.LogSaveService;
import com.app.domain.ConnectLog;
import com.app.repository.ConnectLogRepository;

@Service("logService")
public class LogServiceImpl implements LogSaveService {
    private static Logger logger = LoggerFactory.getLogger(LogSaveService.class);
	@Autowired
	ConnectLogRepository connectLogRepository;

	public void addX1ReqLog(InterfaceLogEnum.X1 interfaceCode) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X1");
		log.setInterfaceCode(interfaceCode.getName());
		log.setSuccess(true);
		
		saveLog(log);
	}

	public void addX1AckSuccessLog(InterfaceLogEnum.X1 interfaceCode) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X1");
		log.setInterfaceCode(interfaceCode.getName());
		log.setSuccess(true);
		
		saveLog(log);
		
	}
	
	public void addX1AckFailureLog(InterfaceLogEnum.X1 interfaceCode, String failureReason) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X1");
		log.setInterfaceCode(interfaceCode.getName());
		
		log.setSuccess(false);
		log.setReason(failureReason);
		saveLog(log);
		
	}
	
	public void addX2ReqLog(InterfaceLogEnum.X2 eventCode, boolean success) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X2");
		log.setInterfaceCode(eventCode.getName());
		log.setSuccess(success);
		
		saveLog(log);
		
	}

	public void addX3ReqLog(InterfaceLogEnum.X3 eventCode, boolean success) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X3");
		log.setInterfaceCode(eventCode.getName());
		log.setSuccess(success);
		
		saveLog(log);
		
	}

	public void addX3ContentLog(int dataUsage) {
		ConnectLog log=new ConnectLog();
		log.setInterfaceType("X3");
		log.setInterfaceCode(InterfaceLogEnum.X3.CommunicationContentReport.getName());
		log.setSuccess(true);
		log.setX3dataUsage(dataUsage);
		
		saveLog(log);
		
	}
	
	private void saveLog(ConnectLog log) {
		log.setLogTime(new Date());
		logger.debug(log.toString());
		connectLogRepository.save(log);

	}

	
	
	
}
