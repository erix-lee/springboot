package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.ORDINAL;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.Cacheable;
import javax.persistence.SequenceGenerator;

@Entity
@Table
public class AlarmDegreeSetting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, unique = true, nullable = false, insertable = true)
	protected long id;
	
	
	@Column(unique = false)
	private String degree;
	@Column(name="setting_key",unique=true, columnDefinition = "haha")
	private String key;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	
}
