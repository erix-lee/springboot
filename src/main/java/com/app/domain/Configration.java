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
public class Configration implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String licID;
	/**
	 * x1ip**
	 * 
	 */
	@Column(unique = true)
	private String tneID;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986949839665116110L;
	
	private String licX1Ki;
	private String licX1Password;
	private Long licX1SQN;
	private String licX2Ki;
	private String licX2Password;
	private Long licX2SQN;
	private String ligX1Addr;
	private Integer ligX1Port=10001;

	private String licX2Addr;
	private Integer licX2Port;
	private String licX3Addr;
	private Integer licX3Port;

	private String pdsnSshAddr;
	private Integer pdsnSshPort;
	private String pdsnSshUsername;
	private String pdsnSshPassword;

	private Integer monitorNumberMax;

	
	private Integer tX1NomsgTime;
	private Integer tX2NormalTime;
	public Integer gettX2NormalTime() {
		return tX2NormalTime;
	}

	public void settX2NormalTime(Integer tX2NormalTime) {
		this.tX2NormalTime = tX2NormalTime;
	}

	private Integer tX2CheckstateTime;

	private Integer tX3NormalTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicID() {
		return licID;
	}

	public void setLicID(String licID) {
		this.licID = licID;
	}

	public String getTneID() {
		return tneID;
	}

	public void setTneID(String tneID) {
		this.tneID = tneID;
	}

	public String getLicX1Ki() {
		return licX1Ki;
	}

	public void setLicX1Ki(String licX1Ki) {
		this.licX1Ki = licX1Ki;
	}

	public String getLicX1Password() {
		return licX1Password;
	}

	public void setLicX1Password(String licX1Password) {
		this.licX1Password = licX1Password;
	}

	public Long getLicX1SQN() {
		return licX1SQN;
	}

	public void setLicX1SQN(Long licX1SQN) {
		this.licX1SQN = licX1SQN;
	}

	public String getLicX2Ki() {
		return licX2Ki;
	}

	public void setLicX2Ki(String licX2Ki) {
		this.licX2Ki = licX2Ki;
	}

	public String getLicX2Password() {
		return licX2Password;
	}

	public void setLicX2Password(String licX2Password) {
		this.licX2Password = licX2Password;
	}

	public Long getLicX2SQN() {
		return licX2SQN;
	}

	public void setLicX2SQN(Long licX2SQN) {
		this.licX2SQN = licX2SQN;
	}

	public String getLigX1Addr() {
		return ligX1Addr;
	}

	public void setLigX1Addr(String ligX1Addr) {
		this.ligX1Addr = ligX1Addr;
	}

	public Integer getLigX1Port() {
		return ligX1Port;
	}

	public void setLigX1Port(Integer ligX1Port) {
		this.ligX1Port = ligX1Port;
	}

	public String getLicX2Addr() {
		return licX2Addr;
	}

	public void setLicX2Addr(String licX2Addr) {
		this.licX2Addr = licX2Addr;
	}

	public Integer getLicX2Port() {
		return licX2Port;
	}

	public void setLicX2Port(Integer licX2Port) {
		this.licX2Port = licX2Port;
	}

	public String getLicX3Addr() {
		return licX3Addr;
	}

	public void setLicX3Addr(String licX3Addr) {
		this.licX3Addr = licX3Addr;
	}

	public Integer getLicX3Port() {
		return licX3Port;
	}

	public void setLicX3Port(Integer licX3Port) {
		this.licX3Port = licX3Port;
	}

	public String getPdsnSshAddr() {
		return pdsnSshAddr;
	}

	public void setPdsnSshAddr(String pdsnSshAddr) {
		this.pdsnSshAddr = pdsnSshAddr;
	}

	public Integer getPdsnSshPort() {
		return pdsnSshPort;
	}

	public void setPdsnSshPort(Integer pdsnSshPort) {
		this.pdsnSshPort = pdsnSshPort;
	}

	public String getPdsnSshUsername() {
		return pdsnSshUsername;
	}

	public void setPdsnSshUsername(String pdsnSshUsername) {
		this.pdsnSshUsername = pdsnSshUsername;
	}

	public String getPdsnSshPassword() {
		return pdsnSshPassword;
	}

	public void setPdsnSshPassword(String pdsnSshPassword) {
		this.pdsnSshPassword = pdsnSshPassword;
	}

	public Integer getMonitorNumberMax() {
		return monitorNumberMax;
	}

	public void setMonitorNumberMax(Integer monitorNumberMax) {
		this.monitorNumberMax = monitorNumberMax;
	}

	public Integer gettX1NomsgTime() {
		return tX1NomsgTime;
	}

	public void settX1NomsgTime(Integer tX1NomsgTime) {
		this.tX1NomsgTime = tX1NomsgTime;
	}

	public Integer gettX2CheckstateTime() {
		return tX2CheckstateTime;
	}

	public void settX2CheckstateTime(Integer tX2CheckstateTime) {
		this.tX2CheckstateTime = tX2CheckstateTime;
	}

	public Integer gettX3NormalTime() {
		return tX3NormalTime;
	}

	public void settX3NormalTime(Integer tX3NormalTime) {
		this.tX3NormalTime = tX3NormalTime;
	}

	@Override
	public String toString() {
		return "Configration [id=" + id + ", licID=" + licID + ", tneID=" + tneID + ", licX1Ki=" + licX1Ki
				+ ", licX1Password=" + licX1Password + ", licX1SQN=" + licX1SQN + ", licX2Ki=" + licX2Ki
				+ ", licX2Password=" + licX2Password + ", licX2SQN=" + licX2SQN + ", ligX1Addr=" + ligX1Addr
				+ ", ligX1Port=" + ligX1Port + ", licX2Addr=" + licX2Addr + ", licX2Port=" + licX2Port + ", licX3Addr="
				+ licX3Addr + ", licX3Port=" + licX3Port + ", pdsnSshAddr=" + pdsnSshAddr + ", pdsnSshPort="
				+ pdsnSshPort + ", pdsnSshUsername=" + pdsnSshUsername + ", pdsnSshPassword=" + pdsnSshPassword
				+ ", monitorNumberMax=" + monitorNumberMax + ", tX1NomsgTime=" + tX1NomsgTime + ", tX2NormalTime="
				+ tX2NormalTime + ", tX2CheckstateTime=" + tX2CheckstateTime + ", tX3NormalTime=" + tX3NormalTime + "]";
	}


}
