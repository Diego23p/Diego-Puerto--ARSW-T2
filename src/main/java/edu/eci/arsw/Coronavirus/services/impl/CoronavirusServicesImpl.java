package edu.eci.arsw.Coronavirus.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.Coronavirus.cache.CoronavirusCache;
import edu.eci.arsw.Coronavirus.services.CoronavirusServices;
import edu.eci.arsw.Coronavirus.services.HttpConnectionService;

@Service("CoronavirusServicesImpl")
public class CoronavirusServicesImpl implements CoronavirusServices {

	 @Autowired
	 @Qualifier("HttpConnectionServiceImpl")
	 HttpConnectionService hcs;
	 
	 
	 @Autowired
	 @Qualifier("CoronavirusCacheImpl")
	 CoronavirusCache cc;
	    
	 @Override
	 public String getAll() throws IOException{
		 return hcs.getAll();
	 }

}