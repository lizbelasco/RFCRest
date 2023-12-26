/**
 * 
 */
package com.soa.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.soa.dto.Persona;
import com.soa.dto.Response;

/**
 * 
 */
class RFCRestTest {

    @Test
    void test() {
        RFCRest rfcrest = new RFCRest();

        Persona persona = new Persona(); //Todo lo que pida el request lo inicio aqui
        persona.setNombre("Lizbeth");
        persona.setApellidoPaterno("Velasco");
        persona.setApellidoMaterno("Ricardez");
        
        ResponseEntity<Response> re = rfcrest.borrar(persona);

        Gson gson = new Gson();
        System.out.println(gson.toJson(re.getBody()));
        
        assertEquals(HttpStatus.OK, re.getStatusCode()); //VERIFICA LA PRUEBA
        assertEquals("RFC A BORRAR: VERL", re.getBody().getRespuesta().getMensaje());
    }

}
