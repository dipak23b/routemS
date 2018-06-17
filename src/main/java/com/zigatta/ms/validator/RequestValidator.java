/**
 * 
 */
package com.zigatta.ms.validator;

import org.springframework.util.StringUtils;

/**
 * @author dipak
 *
 */
public class RequestValidator {

	public boolean isValidCity(String city) {
		return city!=null
				&& !StringUtils.isEmpty(city.trim());
	}

}
