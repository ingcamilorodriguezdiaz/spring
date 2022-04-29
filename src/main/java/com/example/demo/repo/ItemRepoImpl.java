package com.example.demo.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("repo_item")
public class ItemRepoImpl implements IItemRepo {

   
    @Override
    public Map<String, Float> listarItems() {
        Map<String,Float> items = new HashMap<String,Float>();
        items.put("MLA1", new Float("100"));
        items.put("MLA2", new Float("210"));
        items.put("MLA3", new Float("260"));
        items.put("MLA4", new Float("80"));
        items.put("MLA5", new Float("90"));
        return items;
    }
    
}
