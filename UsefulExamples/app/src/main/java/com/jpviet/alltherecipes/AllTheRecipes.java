package com.jpviet.alltherecipes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by nguyen.tien.viet on 2/28/2017.
 */

public class AllTheRecipes extends Activity {
    private ListView mListView;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alltherecipes);

        mListView = (ListView)findViewById(R.id.recipe_list_view);
        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", context);

        RecipeAdapter adapter = new RecipeAdapter(context, recipeList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recipe selectedRecipe = recipeList.get(position);
                Intent detailIntent = new Intent(context, RecipeDetailActivity.class);
                detailIntent.putExtra("title",selectedRecipe.title);
                detailIntent.putExtra("url",selectedRecipe.instructionUrl);
                startActivity(detailIntent);
            }
        });

        /*String[] listItems = new String[recipeList.size()];
        for (int i = 0; i < recipeList.size(); i++){
            Recipe recipe = recipeList.get(i);
            listItems[i] = recipe.title;
        }
        ArrayAdapter adapter = new ArrayAdapter(context, R.layout.activity_listview, listItems);
        mListView.setAdapter(adapter);*/
    }
}
