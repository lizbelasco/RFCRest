/**
 * 
 */
package com.soa.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soa.dto.Persona;
import com.soa.dto.Request;
import com.soa.dto.Response;
import com.soa.dto.Respuesta;

/**
 * 
 */
@RestController
public class RFCRest {
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/rfc")
    public ResponseEntity<Response> borrar(@RequestBody Persona persona){
        ResponseEntity<Response> re = null;
        Request request = new Request();
        request.setPersona(persona);
        
        Response response = new Response();
        Respuesta respuesta = new Respuesta();
        
        String rfc = "RFC a borrar: " + persona.getApellidoPaterno().substring(0,2) + 
                persona.getApellidoMaterno().substring(0,1) + 
                persona.getNombre().substring(0,1);
        
        response.setRespuesta(respuesta);
        respuesta.setMensaje(rfc.toUpperCase());
        
        re = new ResponseEntity<>(response, HttpStatus.OK);
        return re;
        
    }
}
