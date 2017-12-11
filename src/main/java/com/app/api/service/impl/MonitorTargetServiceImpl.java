package com.app.api.service.impl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.service.MonitorTargetService;
import com.app.domain.MonitorTarget;
import com.app.repository.MonitorTaegrtRepository;

@Service("monitorTargetService")
public class MonitorTargetServiceImpl implements MonitorTargetService {
	private static Logger logger = LoggerFactory.getLogger(MonitorTargetService.class);

	@Autowired
	MonitorTaegrtRepository monitorTaegrtRepository;

	private Map<String, MonitorTarget> monitorTargets = null;

	@Override
	public void setTunnelx2ID(String imsi, Long tunnelid) {
		MonitorTarget mt = monitorTaegrtRepository.findOneBySubid(imsi);
		mt.setX2tunnelid(tunnelid);

		saveMonitorTarget(mt);
	}

	@Override
	public void setTunnelx3ID(String imsi, Long tunnelid) {
		MonitorTarget mt = monitorTaegrtRepository.findOneBySubid(imsi);
		mt.setX2tunnelid(tunnelid);

		saveMonitorTarget(mt);
	}

	@Override
	public MonitorTarget getByTunnelx2ID(Long tunnelid) {
		Collection<MonitorTarget> c = this.getMonitorTargetMap().values();
		for (MonitorTarget mt : c) {
			if (mt.getX2tunnelid() == tunnelid) {
				return mt;
			}
		}
		return null;
	}

	@Override
	public MonitorTarget getByTunnelx3ID(Long tunnelid) {
		Collection<MonitorTarget> c = this.getMonitorTargetMap().values();
		for (MonitorTarget mt : c) {
			if (mt.getX3tunnelid() == tunnelid) {
				return mt;
			}
		}
		return null;
	}

	public void saveMonitorTarget(MonitorTarget monitorTarget) {
		monitorTaegrtRepository.save(monitorTarget);

		getMonitorTargetMap().put(monitorTarget.getSubid(), monitorTarget);

	}

	public Collection<MonitorTarget> listMonitorTarget() {
		return monitorTaegrtRepository.findAll();

	}

	@Override
	public MonitorTarget getMonitorTarget(String subid) {
		
		
		return monitorTaegrtRepository.findOneBySubid(subid);
	}

	public  Map<String, MonitorTarget> getMonitorTargetMap() {
		if (this.monitorTargets == null) {

			initMap(listMonitorTarget());

		} else {
			initMap(listMonitorTarget());
		}
		return monitorTargets;
	}

	public void updateMonitorTarget(MonitorTarget monitorTarget, String subid) {
		monitorTaegrtRepository.save(monitorTarget);
		getMonitorTargetMap().put(monitorTarget.getSubid(), monitorTarget);

	}

	public void deleteMonitorTarget(String subid) {
		MonitorTarget monitorTarget = getMonitorTargetMap().get(subid);
		logger.info(monitorTarget.getSubid());

		monitorTaegrtRepository.delete(monitorTarget);
		if (monitorTarget != null) {
			getMonitorTargetMap().remove(subid);
		}
	}

	public boolean isExits(String subid) {

		return getMonitorTargetMap().containsKey(subid);
	}

	private void initMap(Collection<MonitorTarget> listMonitorTargets) {
		monitorTargets = new LinkedHashMap<String, MonitorTarget>();
		for (MonitorTarget m : listMonitorTargets) {
			monitorTargets.put(m.getSubid(), m);
		}

	}

}
