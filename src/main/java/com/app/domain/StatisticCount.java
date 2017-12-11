package com.app.domain;

public class StatisticCount {

	/**
	 * 
	 */
	private long x1ReqCount;
	/**
	 * 
	 */
	private long x1AckCount;
	private long x2ReqCount;
	private long x3TunnelCreateCount;
	private long x3TunnelConnectCount;
	private long x3DataUsage;
	
	public long getX1ReqCount() {
		return x1ReqCount;
	}
	public long getX3DataUsage() {
		return x3DataUsage;
	}
	public void setX3DataUsage(long x3DataUsage) {
		this.x3DataUsage = x3DataUsage;
	}
	public void setX1ReqCount(long x1ReqCount) {
		this.x1ReqCount = x1ReqCount;
	}
	public long getX1AckCount() {
		return x1AckCount;
	}
	public void setX1AckCount(long x1AckCount) {
		this.x1AckCount = x1AckCount;
	}
	public long getX2ReqCount() {
		return x2ReqCount;
	}
	public void setX2ReqCount(long x2ReqCount) {
		this.x2ReqCount = x2ReqCount;
	}
	public long getX3TunnelCreateCount() {
		return x3TunnelCreateCount;
	}
	public void setX3TunnelCreateCount(long x3TunnelCreateCount) {
		this.x3TunnelCreateCount = x3TunnelCreateCount;
	}
	public long getX3TunnelConnectCount() {
		return x3TunnelConnectCount;
	}
	public void setX3TunnelConnectCount(long x3TunnelConnectCount) {
		this.x3TunnelConnectCount = x3TunnelConnectCount;
	}
}
