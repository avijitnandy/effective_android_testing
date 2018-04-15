package com.sqisland.tutorial.recipes.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Avijit on 4/10/18.
 */

public class Recipe {

    private static final String ID_PREFIX = "id=";
    private static final String TITLE_PREFIX = "title=";
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe readFromStream(InputStream stream){
        String id = null;
        String title = null;
        StringBuilder desBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            for(String line = reader.readLine();line !=null;line=reader.readLine()){
                if(line.startsWith(ID_PREFIX)){
                    id = line.substring(ID_PREFIX.length());
                    continue;
                }

                if(line.startsWith(TITLE_PREFIX)){
                    title = line.substring(TITLE_PREFIX.length());
                    continue;
                }

                if(desBuilder.length() > 0){
                    desBuilder.append("\n");
                }
                desBuilder.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Recipe(id,title,desBuilder.toString());
    }
}
