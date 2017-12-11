package com.app.api.service;

public interface LogSaveService {

	/**
	 * 增加X1请求日志
	 * @param  
	 */
	void addX1ReqLog(InterfaceLogEnum.X1 interfaceCode);
	
	/**
	 * 增加X1成功响应日志 
	 * @param interfaceCode
	 */
	void addX1AckSuccessLog(InterfaceLogEnum.X1 interfaceCode);
	/**
	 * 增加X1失败响应日志
	 * @param interfaceCode 
	 * @param failureReason
	 */
	void addX1AckFailureLog(InterfaceLogEnum.X1 interfaceCode,String failureReason);
	/**
	 * 增加x2 请求日志
	 * @param eventCode 
	 * @param success
	 */
	void addX2ReqLog(InterfaceLogEnum.X2 eventCode,boolean success);
	/**
	 * 增加x3请求日志
	 * @param eventCode
	 * @param success
	 */
	void addX3ReqLog(InterfaceLogEnum.X3 eventCode,boolean success);
	/**
	 * 增加x3内容上报成功日志。
	 * @param dataUsage
	 */
	void addX3ContentLog(int dataUsage);


}
