package com.sqisland.tutorial.recipes.data.local;

/**
 * Created by Avijit on 4/13/18.
 */

public interface Favorites {
    Boolean get(String id);
    Boolean toggle(String id);
}
