package com.app.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Configration;
import com.app.repository.ConfigrationRepository;

/**
 * 
 * @author liyiran
 * @date 2017年3月26日
 */
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/") 
public class ConfigRestController  extends AuditLogSupport{

	@Autowired
	private ConfigrationRepository configrationRepository;
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public Configration getNew() {
		return configrationRepository.findAll().get(0);
		
	}


	 

	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public Configration update(@RequestBody Configration Configration){

		
		try {
			Configration cfg = configrationRepository.save(Configration);
			//servers.restart();
			log("修改配置","成功");
			return cfg;
		} catch (Exception e) {
			e.printStackTrace();
			log("修改配置","失败");
			throw new RuntimeException(e);
			
		}
		
	}
}
