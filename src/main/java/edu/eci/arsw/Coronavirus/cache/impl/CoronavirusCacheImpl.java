package edu.eci.arsw.Coronavirus.cache.impl;

import org.springframework.stereotype.Service;

import edu.eci.arsw.Coronavirus.cache.CoronavirusCache;

@Service("CoronavirusCacheImpl")
public class CoronavirusCacheImpl implements CoronavirusCache{

	@Override
	public void save(String name, String json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSave(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String load(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}