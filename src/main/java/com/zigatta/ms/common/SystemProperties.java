package com.zigatta.ms.common;

public class SystemProperties {
	public static void loadSystemProperties(){
		System.setProperty(CommonConstants.LOGGING_CONFIG, CommonConstants.LOGBACK_CONFIG_PATH);
		System.setProperty(CommonConstants.SPRING_CONFIG_LOCATION, CommonConstants.SPRING_CONFIG_PATH);
	}
}
