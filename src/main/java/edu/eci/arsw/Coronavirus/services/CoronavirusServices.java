package edu.eci.arsw.Coronavirus.services;

import java.io.IOException;

public interface CoronavirusServices {
    public String getAllCases() throws IOException;
     public String getPais(String pais) throws IOException;
	public String getCasesByCountry(String pais) throws IOException;
     
}