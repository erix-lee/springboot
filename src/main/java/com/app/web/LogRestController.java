package com.app.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.service.InterfaceLogEnum;
import com.app.domain.ConnectLog;
import com.app.repository.ConnectLogRepository;

@RestController

@RequestMapping(value = "/")
public class LogRestController {
	@Autowired
	private ConnectLogRepository connectLogRepository;

	@PreAuthorize("hasRole('OP')")
	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public Page<ConnectLog> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "count", defaultValue = "5") Integer count) {

		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, count, sort);
		return connectLogRepository.findAll(pageable);
	}
	
	@PreAuthorize("hasRole('OP')")
    @RequestMapping(value = "/log/query/", method = RequestMethod.POST)
    public Page<ConnectLog> query(@RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "count", defaultValue = "5") Integer count,@RequestBody ConnectLog connectLog) {

        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page-1, count, sort);
        
        if(StringUtils.isBlank(connectLog.getInterfaceCode())){
            connectLog.setInterfaceCode(null);
        }
        if(StringUtils.isBlank(connectLog.getInterfaceType())){
            connectLog.setInterfaceType(null);
        }
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id","logTime","reason","x3dataUsage","success").withNullHandler(NullHandler.IGNORE);
        Example<ConnectLog> example = Example.of(connectLog, matcher); 
        return connectLogRepository.findAll(example,pageable);
    }

	@RequestMapping(value = "/status", method = RequestMethod.GET)

	public ResponseEntity<Object[]> status() {

		Object[] status = connectLogRepository.statisticCount();
		return new ResponseEntity<Object[]>(status, HttpStatus.OK);
	}

	@PreAuthorize("permitAll")
	@RequestMapping(value = "/log/enum", method = RequestMethod.GET)

	public ResponseEntity<Map> logEnum() {
		Map m=new HashMap();
		m.put("X1", InterfaceLogEnum.X1.valueMap)		;
		m.put("X2", InterfaceLogEnum.X2.valueMap);
		m.put("X3", InterfaceLogEnum.X3.valueMap);
		return new ResponseEntity<Map>(m, HttpStatus.OK);
	}
}
