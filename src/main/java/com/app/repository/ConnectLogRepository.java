package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.domain.ConnectLog;
 
public interface ConnectLogRepository extends JpaRepository<ConnectLog,  Long> {

	
	@Query(value = "select count(if(interface_code='ConnectionReq' and interface_type='x1',true,null)) as x1ReqCount ,count(if(interface_code='ConnectionAck' and interface_type='x1',true,null)) as x1AckCount,count(if(interface_type='x2' and interface_code like '%Event',true,null )) as x2ReqCount,count(if(interface_code='CreateLICTReq' and interface_type='x3' ,true,null)) as x3ReqCount,count(if(interface_code='CreateLICTAck' and interface_type='x3' ,true,null)) as x3ReqCountSuccess,SUM(x3data_usage) as x3DataUsage from connect_log" ,nativeQuery=true) 
	  Object[] statisticCount( ); 
}
