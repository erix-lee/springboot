package com.app.api.service;

import com.app.domain.Configration;
public interface ConfigLoadSevice {


	/**
	 *获取配置 
	 * @param reload 是否从数据库加载
	 * @return
	 */
	Configration getConfigration(boolean reload);
	/**
	 * 获取可用配置 ，若已缓存，则从缓存中取。
	 * @return
	 */
	Configration getConfigration();
}
