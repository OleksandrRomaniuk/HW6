package ua.com.sourceit.sweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Choco extends Sweet
{
    
    public Choco(String name, Map<Integer, Ingredients> ingredients)
    {
        super(name, ingredients);
    }
    
    
    public boolean isCertified()
    {
        boolean certified = true;
        for(Ingredients ingredient: super.getIngredients())
        {
            if(!ingredient.isBio())
                certified = false;
        }
        return certified;
    }
    
    public boolean getType()
    {
        boolean type = true;
        int weight = 0;
        int coffee = 0;
        for(Ingredients ingredient: super.getIngredients())
        {
            weight += ingredient.getWeight();
            if(ingredient.equals(Ingredients.blackChocolate))
                coffee += ingredient.getWeight();
        }
        
        if((coffee/weight*100) > 20)
            type = true;
        else 
            type = false;
            
        return type;
    }
}
