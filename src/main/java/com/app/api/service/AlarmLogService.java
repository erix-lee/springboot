package com.app.api.service;

import java.util.Map;

import com.app.domain.AlarmDegreeSetting;
import com.app.domain.AlarmLog;

public interface AlarmLogService {
	/**
	 * 保存告警对象
	 * @param alarm
	 */
	void addAlarm(AlarmLog alarm);
	
	/**
	 * 用参数保存告警
	 * @param level
	 * @param tag
	 * @param date
	 * @param description
	 */
	void addAlarm(String level, String tag, String description);
	
	/**
	 * 保存内部告警对象
	 * @param alarm
	 */
	void addInnerAlarm(AlarmLog alarm);
	
	/**
	 * 用参数保存内部告警
	 * @param level
	 * @param tag
	 * @param date
	 * @param description
	 */
	void addInnerAlarm(String level, String tag, String description);
	
	
	AlarmDegreeSetting saveSetting(AlarmDegreeSetting ads);
	
	Map<String ,AlarmDegreeSetting> getSettings();
}
