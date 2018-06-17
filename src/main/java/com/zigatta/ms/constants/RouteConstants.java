package com.zigatta.ms.constants;

import javax.ws.rs.core.Response.Status;

public class RouteConstants {

	public static final String DATA_FILE_NAME = "./opt/etc/config/city.txt";
	public static final String ROUTE_SPLITTER = ",";
	public static final String ROUTE_FOUND = "Yes";
	public static final String ROUTE_NOT_FOUND = "No";
	public static final String INVALID_INPUT_ERROR = "Invalid input received.";
	public static final int HTTP_STATUS_CODE_BAD_REQUEST= 400;
	public static final int HTTP_STATUS_CODE_INTERNAL_SERVER_ERROR = 500;
}
