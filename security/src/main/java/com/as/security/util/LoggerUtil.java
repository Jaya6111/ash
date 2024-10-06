package com.as.security.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

	public static Logger getLogger() {
		return LoggerFactory.getLogger(LoggerUtil.class);
	}
}
