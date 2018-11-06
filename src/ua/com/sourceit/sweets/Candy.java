package ua.com.sourceit.sweets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Candy extends Choco
{
    
    public Candy(Map<Integer, Ingredients> ingredients)
    {
        super("Prometei", ingredients);
    }
    

    @Override
    protected void setPrice()
    {
        double price = 0;
        for(Ingredients ingredient: super.getIngredients())
        {
        price += ingredient.getPrice();
        }
        
        price = price*1.3;
        
        super.setPrice(price);
    }

}
