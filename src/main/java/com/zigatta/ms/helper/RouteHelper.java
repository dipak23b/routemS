package com.zigatta.ms.helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.zigatta.ms.constants.RouteConstants;

@Component
public class RouteHelper {

	@Autowired
	private FileReader fileReader;
	
	
	public boolean isConnectionExists(String source, String destination) throws IOException, URISyntaxException {
		List<String> cityRoutes = fileReader.readFile(RouteConstants.DATA_FILE_NAME);
		return findRouteBetween(cityRoutes, source, destination, new ArrayList<String>());
	}

	/**
	 * @param route : from city, to City
	 * @param source : from City
	 * @returns destination from route
	 */
	private String getDestination(String route, String source) {
		return route.split(RouteConstants.ROUTE_SPLITTER)[0].trim().equalsIgnoreCase(source.trim())
				? route.split(RouteConstants.ROUTE_SPLITTER)[1].trim().toLowerCase()
				: route.split(RouteConstants.ROUTE_SPLITTER)[0].trim().toLowerCase();
	}

	/**
	 * @param route : - from city, to City
	 * @param source :  city
	 * @return true if city is present on route
	 */
	private boolean existsInRoute(String route,String source) {
		return route!=null
				&& route.length()>0
				&& route.split(RouteConstants.ROUTE_SPLITTER).length==2
				&& (route.split(RouteConstants.ROUTE_SPLITTER)[0].trim().equalsIgnoreCase(source.trim())
				|| route.split(RouteConstants.ROUTE_SPLITTER)[1].trim().equalsIgnoreCase(source.trim()));
	}
	
	/**
	 * @param cityRoutes : routes retrieved from txt files. Routes are cached at server startup.
	 * @param source : start city
	 * @param destination : destination city
	 * @param alreadyVisitedCities : list of cities visited when finding connection from source to destination
	 * @return true if route exists between source and destination.
	 */
	private boolean findRouteBetween(List<String> cityRoutes, String source, String destination,List<String> alreadyVisitedCities) {
		if(StringUtils.isEmpty(source)
				|| StringUtils.isEmpty(destination))
			return false;
		Set<String> citiesReachablefromSource = null;
		
		citiesReachablefromSource = cityRoutes.stream()
										.filter(route -> existsInRoute(route, source))
										.map(route -> getDestination(route,source))
										.filter(city -> !alreadyVisitedCities.contains(city))
										.collect(Collectors.toSet());
		
		if(citiesReachablefromSource.contains(destination.trim().toLowerCase())){
			return true;
		} else if(citiesReachablefromSource==null
						|| citiesReachablefromSource.size()==0){
			return false;			
		}else{
			List<String> visitedCities = alreadyVisitedCities;
			alreadyVisitedCities.add(source.toLowerCase().trim());
			
			Optional<String> foundCity = citiesReachablefromSource
									.stream()
									.filter(city -> findRouteBetween(cityRoutes,city,destination,visitedCities))
									.findFirst();
			
			if(foundCity.isPresent())
				return true;
			
		}
		
		return false;
	}
}
