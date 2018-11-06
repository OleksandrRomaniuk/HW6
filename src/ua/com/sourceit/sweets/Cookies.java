package ua.com.sourceit.sweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Cookies extends Sweet
{

    public Cookies(String name, Map<Integer, Ingredients> ingredients)
    {
        super(name, ingredients);
    }

    public boolean isAllergic()
    {
        boolean allergic = false;
        for(Ingredients ingredient: super.getIngredients())
        {
            if(ingredient.equals(Ingredients.flour))
                allergic = true;
        }
        return allergic;
    }

}
