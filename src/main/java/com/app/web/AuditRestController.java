package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.AuditLog;
import com.app.repository.AuditRepository;

@RestController

@RequestMapping(value = "/")
public class AuditRestController {
	@Autowired
	private AuditRepository auditRepository;

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/auditlog", method = RequestMethod.POST)
	public Page<AuditLog> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "count", defaultValue = "15") Integer count) {

		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page - 1, count, sort);
		return auditRepository.findAll(pageable);
	}
}
