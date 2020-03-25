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
	 public String getAllCases() throws IOException{
		 if(!cc.isSave()){
			 cc.save(hcs.getAllCases());
			 
		 }
		 else {
			 if(!cc.isAlive()){
				 cc.save(hcs.getAllCases());
			 }
		 }
		 return cc.load();
	 }

	@Override
	public String getPais(String pais) throws IOException {
		return hcs.getPais(pais);
	}

	@Override
	public String getCasesByCountry(String pais) throws IOException{
		return hcs.getCasesByCountry(pais);
	}

}