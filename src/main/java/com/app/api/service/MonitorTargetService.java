package com.app.api.service;

import java.util.Collection;
import java.util.Map;

import com.app.domain.MonitorTarget;

 
public interface MonitorTargetService {
	MonitorTarget getByTunnelx2ID(Long tunnelid);
	MonitorTarget getByTunnelx3ID(Long tunnelid);
	void setTunnelx2ID(String imsi,Long x2id);
	void setTunnelx3ID(String imsi,Long x2id);
	/**
	 * 保存新的监控对象，并更新map
	 * @param monitorTarget
	 */
	void saveMonitorTarget(MonitorTarget monitorTarget);
	
	/**
	 * 从数据库中获取结果集
	 * @return
	 */
	Collection<MonitorTarget>  listMonitorTarget();
	
	/**
	 * 获取监控对象Map， key =subid，，若对象不存在null，则查询数据库并创建。
	 * @return
	 */
	Map<String,MonitorTarget> getMonitorTargetMap();


	MonitorTarget getMonitorTarget(String subid);
	/**
	 * 更新结果集，并更新map
	 * @param monitorTarget
	 * @param subid
	 */
	void updateMonitorTarget(MonitorTarget monitorTarget,String subid);
	
	/**
	 * 删除结果集，并删除map
	 * @param subid
	 */
	void deleteMonitorTarget(String subid);
	
	/**
	 * 存在目标
	 * @param subid
	 * @return
	 */
	boolean isExits(String subid);
	
}
