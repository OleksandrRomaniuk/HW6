package ua.com.sourceit.sweets;

import java.util.HashMap;
import java.util.Map;

public class Recipes
{

    public Recipes()
    {
    }
    
    public Map<Integer, Ingredients> getRecipeCandy()
    {
            Map<Integer, Ingredients> ingredientsMap = new HashMap();
            ingredientsMap.put(20, Ingredients.cacao);
            ingredientsMap.put(20, Ingredients.milk);
            ingredientsMap.put(20, Ingredients.blackChocolate);
            ingredientsMap.put(10, Ingredients.butter);
            ingredientsMap.put(80, Ingredients.nuts);
            ingredientsMap.put(80, Ingredients.sugar);
            return ingredientsMap;
    }
    
    public Map<Integer, Ingredients> getRecipeChocolate()
    {
            Map<Integer, Ingredients> ingredientsMap = new HashMap();
            ingredientsMap.put(40, Ingredients.cacao);
            ingredientsMap.put(5, Ingredients.milk);
            ingredientsMap.put(40, Ingredients.blackChocolate);
            ingredientsMap.put(5, Ingredients.butter);
            ingredientsMap.put(5, Ingredients.nuts);
            return ingredientsMap;
    }
    
    public Map<Integer, Ingredients> getRecipeBiscuit()
    {
            Map<Integer, Ingredients> ingredientsMap = new HashMap();
            
            ingredientsMap.put(40, Ingredients.flour);
            ingredientsMap.put(10, Ingredients.milk);
            ingredientsMap.put(5, Ingredients.butter);
            ingredientsMap.put(5, Ingredients.eggs);
            return ingredientsMap;
    }
    
    

}
