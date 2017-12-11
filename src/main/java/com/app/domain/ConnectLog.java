package com.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.api.service.InterfaceLogEnum;

@Entity
@Table
public class ConnectLog implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7426266928599278840L;
	private Date logTime;
	/**
	 * 取值为 ：X1| X2 | X3
	 */
	private String interfaceType;

	/**
	 * 取值为 , X1 :（1~10） X2 :（11~15） X3 :（21~30）
	 */
	private String interfaceCode;
	/**
	 * 失败原因
	 */
	private String reason;
	/**
	 * X3内容上报only
	 */
	private long x3dataUsage;

	private boolean success;

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public String getInterfaceCodeDesp() {
		String desp="";
		if (interfaceType.equalsIgnoreCase("X1")) {
			desp = InterfaceLogEnum.X1.valueOf(interfaceCode).getDesp();
		}
		if (interfaceType.equalsIgnoreCase("X2")) {
			desp = InterfaceLogEnum.X2.valueOf(interfaceCode).getDesp();
		}
		if (interfaceType.equalsIgnoreCase("X3")) {
			desp = InterfaceLogEnum.X3.valueOf(interfaceCode).getDesp();
		}
		return desp;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public long getX3dataUsage() {
		return x3dataUsage;
	}

	public void setX3dataUsage(long x3dataUsage) {
		this.x3dataUsage = x3dataUsage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConnectLog [logTime=" + logTime + ", interfaceType=" + interfaceType + ", interfaceCode="
				+ interfaceCode + ", reason=" + reason + ", x3dataUsage=" + x3dataUsage + ", success=" + success + "]";
	}

}
