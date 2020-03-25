package edu.eci.arsw.Coronavirus.services.impl;

import java.io.IOException;

import edu.eci.arsw.Coronavirus.services.HttpConnectionService;
import edu.eci.arsw.Coronavirus.services.HttpConnectionService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service("HttpConnectionServiceImpl")
public class HttpConnectionServiceImpl implements HttpConnectionService {

	@Override
	public String getAllCases() throws IOException {
		String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "7d7a74b781msh34bbc38d8b73c1fp1b0bdfjsn3111b612a512");
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
  
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {

            return "GET request not worked";
        }
        
	}

	@Override
	public String getPais(String pais) throws IOException {
		String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://restcountries-v1.p.rapidapi.com/name/"+pais;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "7d7a74b781msh34bbc38d8b73c1fp1b0bdfjsn3111b612a512");
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
  
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {

            return "GET request not worked";
        }
	}

	@Override
	public String getCasesByCountry(String pais) throws IOException{
		String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+pais;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
        con.setRequestProperty("x-rapidapi-key", "7d7a74b781msh34bbc38d8b73c1fp1b0bdfjsn3111b612a512");
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
  
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {

            return "GET request not worked";
        }
	}

}
