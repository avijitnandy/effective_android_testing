package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Avijit on 4/12/18.
 */

public class SharedPreferencesFavorites implements Favorites{
    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorites.xml",Context.MODE_PRIVATE);
    }

    public Boolean get(String id){
        return pref.getBoolean(id,false);
    }

    public void put(String id,Boolean favorite){
        SharedPreferences.Editor editor = pref.edit();
        if(favorite){
            editor.putBoolean(id,true);
        }else {
            editor.remove(id);
        }
        editor.apply();
    }

    public Boolean toggle(String id){
        boolean favorite = get(id);
        put(id,!favorite);
        return !favorite;
    }
}
