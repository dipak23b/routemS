/**
 * 
 */
package com.zigatta.ms.request.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.zigatta.ms.common.CommonConstants;
import com.zigatta.ms.common.TransactionInfo;
import com.zigatta.ms.resource.RouteResourceImpl;

/**
 * @author dipak
 *
 */
@Component
public class InputRequestFilter implements ContainerRequestFilter {
	private static final Logger log = LoggerFactory.getLogger(InputRequestFilter.class);
	
	@Autowired
	private Environment env;
	
	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		TransactionInfo txInfo = new TransactionInfo();
		txInfo.setTxId(env.getProperty(CommonConstants.MS_NAME)+"~"+UUID.randomUUID().toString());
		txInfo.setStartTime(System.currentTimeMillis());
		initializeMDC(txInfo);
		request.setProperty(CommonConstants.TX_INFO, txInfo);
		log.info("Request method : {}, url : {}",request.getRequest().getMethod(),request.getUriInfo().getRequestUri());
		
	}

	private void initializeMDC(TransactionInfo txInfo){
		try{
			MDC.clear();
			MDC.put(CommonConstants.HOSTNAME, InetAddress.getLocalHost().getCanonicalHostName());
			MDC.put(CommonConstants.MS, env.getProperty(CommonConstants.MS_NAME));
			MDC.put(CommonConstants.TRANS_ID, txInfo.getTxId());
		}catch(Exception ex){
			MDC.put(CommonConstants.MS, env.getProperty(CommonConstants.MS_NAME));			
		}
		
		
	}

}
