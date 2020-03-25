package edu.eci.arsw.Coronavirus.services;

import java.io.IOException;

public interface CoronavirusServices {
    public String getAll() throws IOException;
     public String getPais(String pais) throws IOException;
	public String getProvincias(String pais) throws IOException;
     
}