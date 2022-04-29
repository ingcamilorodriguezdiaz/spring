package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.example.demo.error.ItemException;
import com.example.demo.repo.IItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicio_item")
public class ITemServiceImpl implements IItemService {

    @Autowired
    @Qualifier("repo_item")
    private IItemRepo data;

    @Override
    public Map<String, Float> listarItems() {
        return data.listarItems();
    }

    @Override
    public List<String> calculate(Map<String, Float> items, Float amount) throws ItemException {
        descartar(items);

        Float res = sumar(items).floatValue();
        res = res <= amount.floatValue() ? amount : res.floatValue() - amount.floatValue();
        List<String> keys = new ArrayList<>();     
        List<Entry<String, Float>> list = new ArrayList<>(items.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        Float sum = new Float(0);
        for (Entry<String, Float> element : list) {
            keys.add(element.getKey());
            sum += element.getValue().floatValue();
            if (sum >= res) {
                break;
            }
        }
        for (String key : keys) {
            items.remove(key);
        } 
        return new ArrayList<String>(items.keySet());
    }

    @Override
    public Float sumar(Map<String, Float> items) {
        Float sumatoria = new Float(0);
        for (Map.Entry<String, Float> element : items.entrySet()) {
            sumatoria += element.getValue().floatValue();
        }
        return sumatoria;
    }

    @Override
    public void descartar(Map<String, Float> items)throws ItemException {
        Map<String,Integer> res = new HashMap<>();

        for (Map.Entry<String, Float> element : items.entrySet()) {
            if(res.containsKey(element.getKey())){
                throw new ItemException(1,"Solo se puede comprar una unidad por item");
            }else{
                res.put(element.getKey(), 1);
            }
        }
        
    }



}