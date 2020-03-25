package edu.eci.arsw.Coronavirus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.Coronavirus.services.CoronavirusServices;

@RestController
@RequestMapping(value = "/Coronavirus")
public class CoronavirusController {
	
    @Autowired
    @Qualifier("CoronavirusServicesImpl")
    CoronavirusServices cvs;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAirpotsByName() {
        try {
           
            return new ResponseEntity<>(cvs.getAll(),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/{pais}", method = RequestMethod.GET)
    public ResponseEntity<?> getPais(@PathVariable(name = "pais") String pais) {
        try {
           
            return new ResponseEntity<>(cvs.getPais(pais),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(path = "/byPais/{pais}", method = RequestMethod.GET)
    public ResponseEntity<?> getProvincias(@PathVariable(name = "pais") String pais) {
        try {
           
            return new ResponseEntity<>(cvs.getProvincias(pais),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            return new ResponseEntity<>("400 bad request", HttpStatus.NOT_FOUND);
        }
    }
    
}