package com.sqisland.tutorial.recipes.data.local;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Avijit on 4/13/18.
 */

public class InMemoryFavorites implements Favorites{
    private  final Map<String,Boolean> map = new HashMap<>();

    @Override
    public Boolean get(String id) {
        Boolean value = map.get(id);
        return value == null ? false : value;
    }

    @Override
    public Boolean toggle(String id) {
        Boolean value = get(id);
        map.put(id,!value);
        return !value;
    }

    public  void put(String id,boolean value){
        map.put(id,value);
    }
}
