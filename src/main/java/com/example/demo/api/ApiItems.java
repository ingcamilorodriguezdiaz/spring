package com.example.demo.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.error.ItemException;
import com.example.demo.model.Body;
import com.example.demo.model.Response;
import com.example.demo.service.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiItems {
    @Autowired
    @Qualifier("servicio_item")
    private IItemService service;


    @GetMapping("/listar-item")
    public ResponseEntity <?> get() { 

        return new ResponseEntity<>(service.listarItems(),HttpStatus.OK); 
    }

    @PostMapping("/nivel1")
    public ResponseEntity <?> nivel1(@RequestBody Body body) throws ItemException {    
         
            String error="";    
            try {               
                descartar(body.getItem_ids());
                Map<String,Float> listar = service.listarItems();
                Map<String, Float> nuevo = new HashMap<String, Float>();
                for (String item : body.getItem_ids()) {                                  
                    nuevo.put(item,listar.get(item).floatValue());
                }      
                List <String> res =  service.calculate(nuevo, body.getAmount());
                if(!res.isEmpty() && res.size() > 0){
                    return new ResponseEntity<>(res,HttpStatus.OK);    
                } 

                return new ResponseEntity<>("Monto no es suficiente para comprar un producto",HttpStatus.NOT_FOUND); 
        
            } catch (ItemException e) {
                error =e.getMessage() ;
                System.out.println(e.getMessage());
            }      
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); 
    }

    public void descartar(List<String> items)throws ItemException {
        Map<String,Integer> res = new HashMap<>();
        for (String key : items) {      
            if(res.containsKey(key)){
                throw new ItemException(1,"Solo se puede comprar una unidad por itemsss");
            }else{
                res.put(key, 1);
            }
        }        
    }
    
    @PostMapping("/coupon")
    public ResponseEntity<?> nivel2(@RequestBody Body body) throws ItemException {     
            String error="";   
            try {
                descartar(body.getItem_ids());
                Map<String,Float> listar = service.listarItems();
                Map<String, Float> nuevo = new HashMap<String, Float>();
                for (String item : body.getItem_ids()) {                                  
                    nuevo.put(item,listar.get(item).floatValue());
                }
                List <String> sumar = service.calculate(nuevo, body.getAmount().floatValue());     
        
                Response response = new Response();            
                for (String string : sumar) {
                    response.setTotal(response.getTotal().intValue() + listar.get(string).intValue());
                }           
                response.setItem_ids(sumar);
                
                if(!sumar.isEmpty() && sumar.size() > 0){
                    return new ResponseEntity<Response>(response,HttpStatus.OK);  
                }
                return new ResponseEntity<>("Monto no es suficiente para comprar un producto",HttpStatus.NOT_FOUND); 
            } catch (ItemException e) {
                error = e.getMessage();
                System.out.println(e.getMessage());
            }
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND); 
          
               
    }

}
