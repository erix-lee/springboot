package com.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MonitorTarget implements Serializable{
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6440829032958752202L;

	/**
	 * 被监控的imsi .数据库为unq ，
	 */
	@Column(unique = true,length=50)
	private String subid;

	/**
	 * 上报x2地址
	 */
	private String x2address;
	/**
	 * 上报x2端口
	 */
	private int x2port;

	/**
	 * 上报x3地址 
	 */
	private String x3address;
	/**
	 * 上报x3端口
	 */
	private  int x3port;
	/**
	 * 监控类型。同CcOutPut的枚举name 
	 */
	private String ccOutput;
	@Column(columnDefinition="bigint default -1")
	private  long x2tunnelid;
	@Column(columnDefinition="bigint default -1")
	private  long x3tunnelid;

	public long getX2tunnelid() {
		return x2tunnelid;
	}

	public void setX2tunnelid(long x2tunnelid) {
		this.x2tunnelid = x2tunnelid;
	}

	public long getX3tunnelid() {
		return x3tunnelid;
	}

	public void setX3tunnelid(long x3tunnelid) {
		this.x3tunnelid = x3tunnelid;
	}



	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
 
	public String getX2address() {
		return x2address;
	}
	public void setX2address(String x2address) {
		this.x2address = x2address;
	}
	public int getX2port() {
		return x2port;
	}
	public void setX2port(int x2port) {
		this.x2port = x2port;
	}
	public String getX3address() {
		return x3address;
	}
	public void setX3address(String x3address) {
		this.x3address = x3address;
	}
	public int getX3port() {
		return x3port;
	}
	public void setX3port(int x3port) {
		this.x3port = x3port;
	}
	public String getCcOutput() {
		return ccOutput;
	}
	public void setCcOutput(String ccOutput) {
		this.ccOutput = ccOutput;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}