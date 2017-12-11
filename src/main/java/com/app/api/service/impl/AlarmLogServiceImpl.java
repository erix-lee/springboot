package com.app.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.service.AlarmLogService;
import com.app.domain.AlarmDegreeSetting;
import com.app.domain.AlarmLog;
import com.app.repository.AlarmDegreeSettinglRepository;
import com.app.repository.AlarmRepository;

@Service("alarmService")
public class AlarmLogServiceImpl implements AlarmLogService {

	@Autowired
	AlarmRepository alarmRepository;

	@Autowired
	AlarmDegreeSettinglRepository settingRepository;
	
	private void save(AlarmLog alarm){
		settings=getSettings();
		AlarmDegreeSetting ads = settings.get(alarm.getDescription());
		if(ads!=null){
			alarm.setLevel(ads.getDegree());
		}
		alarmRepository.save(alarm);
		
	}
	
	public void addAlarm(AlarmLog alarm) {
		save(alarm);

	}

	public void addAlarm(String level, String tag, String description) {

		AlarmLog alarm = new AlarmLog();
		alarm.setDate(new Date());
		alarm.setDescription(description);
		alarm.setTag(tag);
		alarm.setLevel(level);
		alarm.setInner(false);
		save(alarm);

	}

	@Override
	public void addInnerAlarm(AlarmLog alarm) {
		alarm.setInner(true);
		save(alarm);

	}

	@Override
	public void addInnerAlarm(String level, String tag, String description) {
		AlarmLog alarm = new AlarmLog();
		alarm.setDate(new Date());
		alarm.setDescription(description);
		alarm.setTag(tag);
		alarm.setLevel(level);
		alarm.setInner(true);
		save(alarm);
	}

	@Override
	public AlarmDegreeSetting saveSetting(AlarmDegreeSetting ads) {
		settingRepository.save(ads);
		settings=null;
		getSettings();
		return ads;
	}

	private  Map<String, AlarmDegreeSetting>  settings;
	@Override
	public Map<String, AlarmDegreeSetting> getSettings() {
	  if(settings==null){
		  settings=new HashMap<String, AlarmDegreeSetting>();
		  List<AlarmDegreeSetting> l = settingRepository.findAll();
		  for(AlarmDegreeSetting a:l){
			  settings.put(a.getKey(), a);
		  }
	  }
		return settings;

	}

}
