package com.app.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.service.ConfigLoadSevice;
import com.app.domain.Configration;
import com.app.repository.ConfigrationRepository;

@Service("configSevice")
public class ConfigLoadSeviceImpl implements ConfigLoadSevice{
 
	@Autowired
	ConfigrationRepository configrationRepository;
	
	Configration config=null;
	@Override
	public Configration getConfigration(boolean reload) {
		if(reload || config==null){
			
			config=loadConfigration();
		}
	
		return config;
	}

	@Override
	public Configration getConfigration() {
		
		return getConfigration(true);
	}

	private Configration loadConfigration(){
		List<Configration> cfgs = configrationRepository.findAll();
		if(cfgs==null || cfgs.size()==0){
			return null;
		}else{
			return cfgs.get(0);
		}
	}
}
