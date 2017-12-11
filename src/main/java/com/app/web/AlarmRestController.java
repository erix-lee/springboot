package com.app.web;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.service.AlarmLogService;
import com.app.domain.AlarmDegreeSetting;
import com.app.domain.AlarmLog;
import com.app.repository.AlarmRepository;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/")
public class AlarmRestController {
	@Autowired
	private AlarmRepository alarmRepository;
	@Autowired
	private AlarmLogService alarmLeavelRepository;

	@RequestMapping(value = "/alarm", method = RequestMethod.GET)
	public Page<AlarmLog> list(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		return alarmRepository.findAll(pageable);
	}

	@RequestMapping(value = "/alarm/query", method = RequestMethod.POST)
	public Page<AlarmLog> query(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size, @RequestBody AlarmLog alarmLog) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		NullHandler nullHandler = NullHandler.IGNORE;
		if (StringUtils.equals("0", alarmLog.getTag())) {
			alarmLog.setTag(null);
		}
		if (StringUtils.equals("0", alarmLog.getLevel())) {
			alarmLog.setLevel(null);
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id").withIgnorePaths("date")
				.withIgnorePaths("description").withNullHandler(nullHandler);
		Example<AlarmLog> example = Example.of(alarmLog, matcher);

		return alarmRepository.findAll(example, pageable);
	}

	@RequestMapping(value = "/alarm", method = RequestMethod.POST)
	public ResponseEntity<AlarmLog> create(@RequestBody AlarmLog alarmLog) {

		return new ResponseEntity<AlarmLog>(alarmRepository.save(alarmLog), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/alarm/level", method = RequestMethod.POST)
	public ResponseEntity<String> saveLevel(@RequestBody List<AlarmDegreeSetting> list) {
		for (AlarmDegreeSetting ads : list) {
			alarmLeavelRepository.saveSetting(ads);
		}
		return new ResponseEntity<String>("{\"success\":true}", HttpStatus.OK);
	}

	@RequestMapping(value = "/alarm/level", method = RequestMethod.GET)
	public Collection<AlarmDegreeSetting> list() {

		return alarmLeavelRepository.getSettings().values();
	}
}
