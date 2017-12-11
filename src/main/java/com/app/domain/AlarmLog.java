package com.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AlarmLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4913418592670526551L;

	

	private String level;
	private String tag;
	private Date date;
	private String description;
	/**
	 * 内部告警
	 */
	@Column(name="inside")
	private Boolean inner;


	public Boolean isInner() {
		return inner;
	}
	public void setInner(Boolean inner) {
		this.inner = inner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;


	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
