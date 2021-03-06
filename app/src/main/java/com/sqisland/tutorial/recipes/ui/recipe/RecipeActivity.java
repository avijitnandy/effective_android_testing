package com.sqisland.tutorial.recipes.ui.recipe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.local.SharedPreferencesFavorites;
import com.sqisland.tutorial.recipes.data.model.Recipe;

/**
 * Created by Avijit on 4/12/18.
 */

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = (TextView) findViewById(R.id.title);
        TextView desView = (TextView) findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this,"recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if(recipe == null){
            titleView.setVisibility(View.GONE);
            desView.setText(R.string.recipe_not_found);
            return;
        }

        final SharedPreferencesFavorites sharedPreferencesFavorites = new SharedPreferencesFavorites(this);
        final boolean favorite = sharedPreferencesFavorites.get(recipe.id);

        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = sharedPreferencesFavorites.toggle(recipe.id);
                titleView.setSelected(result);
            }
        });
        desView.setText(recipe.description);

    }
}
