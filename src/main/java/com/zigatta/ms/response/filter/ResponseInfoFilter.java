/**
 * 
 */
package com.zigatta.ms.response.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zigatta.ms.common.CommonConstants;
import com.zigatta.ms.common.TransactionInfo;
import com.zigatta.ms.request.filter.InputRequestFilter;

/**
 * @author dipak
 *
 */
@Component
public class ResponseInfoFilter implements ContainerResponseFilter {
	private static final Logger log = LoggerFactory.getLogger(ResponseInfoFilter.class);
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		TransactionInfo txInfo = requestContext.getProperty(CommonConstants.TX_INFO) !=null
											? (TransactionInfo)requestContext.getProperty(CommonConstants.TX_INFO) : null;
		if(txInfo!=null){
			txInfo.setEndTime(System.currentTimeMillis());
			log.info("Total Execution time of resource (ms) : {}" , (txInfo.getEndTime()-txInfo.getStartTime()));
			responseContext.getHeaders().add(CommonConstants.TRANS_ID, txInfo.getTxId());
		}

	}

}
