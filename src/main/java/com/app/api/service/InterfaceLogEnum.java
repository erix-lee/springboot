package com.app.api.service;

import java.util.HashMap;
import java.util.Map;

public interface InterfaceLogEnum {
	enum X1 implements InterfaceLogEnum {
		ConnectionReq("创建链接请求"),
		SetMonitorTargetReq("设置布控对象请求"),
		DeleteMonitorTargetReq("删除布控对象请求"),
		UpdateMonitorTargetReq("更新布控对象请求"),
		QueryMonitorTargetAttributeReq("查询布控参数请求"),
		QueryTimeReq("查询时间请求"),
		ListMonitorTargetReq("列示布控请求"),
		
		ConnectionRelease("释放连接"),
		ConnectionAck("创建链接应答"),
		SetMonitorTargetAck("设置布控对象应答"),
		DeleteMonitorTargetAck("删除布控对象应答"),
		UpdateMonitorTargetAck("更新布控对象应答"),
		QueryMonitorTargetAttributeAck("查询布控参数应答"),
		QueryTimeAck("查询时间应答"),
		ListMonitorTargetAck("列示布控应答") 
		;

		public static Map<String, String> valueMap = new HashMap<>();  
	      
	    static {  
	        for(X1 e : X1.values()) {  
	            valueMap.put(e.getName(),e.getDesp());  
	        }  
	    }  
		private String desp;  
	    private X1(String desp) {  
	        this.desp = desp;  
	    }
	    @Override
		public String getName() {
			return this.name();
		}
	    @Override
		public String getDesp() {
			return desp;
		}  


	}

	enum X2 implements InterfaceLogEnum {
		ConnectionReq("创建链接请求"),
		ConnectionAck("创建链接应答"),
		ConnectionRelease("释放连接"),
		CheckState("心跳"),

		PacketSetupEvent("分组会话建立事件"),
		PacketReleaseEvent("分组会话释放事件"),
		PacketHandOffEvent("分组会话切换事件"),
		SubOnlineNtfEvent("用户在线事件"),
		X3TunnelSetupEvent("隧道建立事件"),
		X3TunnelCloseEvent("隧道关闭事件")
		 
		;

		public static Map<String, String> valueMap = new HashMap<>();  
	      
	    static {  
	        for(X2 e : X2.values()) {  
	            valueMap.put(e.getName(),e.getDesp());  
	        }  
	    }  
		private String desp;  
	    private X2(String desp) {  
	        this.desp = desp;  
	    }
	    @Override
		public String getName() {
			return this.name();
		}
	    @Override
		public String getDesp() {
			return desp;
		}  

	}
	enum X3 implements InterfaceLogEnum {
		CreateLICTReq("创建隧道请求"),
		CreateLICTAck("创建隧道应答"),
		DeleteLICTReq("删除隧道请求"),
		DeleteLICTAck("删除隧道应答"),
		CommunicationContentReport("内容上报") 
		;

		public static Map<String, String> valueMap = new HashMap<>();  
	      
	    static {  
	        for(X3 e : X3.values()) {  
	            valueMap.put(e.getName(),e.getDesp());  
	        }  
	    }  	
		private String desp;  
	    private X3(String desp) {  
	        this.desp = desp;  
	    }
	    @Override
		public String getName() {
			return this.name();
		}
	    @Override
		public String getDesp() {
			return desp;
		}  

	}

	
	public String getName()  ;
	public String getDesp() ;

}
