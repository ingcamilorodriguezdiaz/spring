package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.error.ItemException;

public interface IItemService {
    
    Map<String,Float> listarItems();
    List<String> calculate(Map<String,Float> items, Float amount) throws ItemException;
    Float sumar(Map<String, Float> items);

    void descartar(Map<String, Float> items)throws ItemException;
}
