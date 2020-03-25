package edu.eci.arsw.Coronavirus.cache.impl;

import org.springframework.stereotype.Service;

import edu.eci.arsw.Coronavirus.cache.CoronavirusCache;

@Service("CoronavirusCacheImpl")
public class CoronavirusCacheImpl implements CoronavirusCache{
	
	boolean b = false;
	String json;
	Long time;

	@Override
	public void save(String j) {
		b = true;
		json = j;
		time =System.currentTimeMillis(); 
		
	}

	@Override
	public boolean isSave() {
		return b;
	}

	@Override
	public boolean isAlive() {
		long timeLoad =( System.currentTimeMillis()-time)/1000;
		
		if (timeLoad>300){
            b=false;
            time =System.currentTimeMillis(); 
            return false;
        }
		 return true;
	}

	@Override
	public String load() {
		return json;
	}
	
	
}