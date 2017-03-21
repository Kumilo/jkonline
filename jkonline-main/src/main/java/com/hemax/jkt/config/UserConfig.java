/**
 * 
 */
package com.hemax.jkt.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/** 
 * created by quan.zhang@msxf.com
 */
@Configuration
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:config/config.properties")
@Component
public class UserConfig implements Serializable{

	private static final long serialVersionUID = -96114184598059167L;

	
	private String name;
	
	private String phone;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
