package ua.com.sourceit.sweets;

import java.util.Map;

public class Biscuit extends Cookies
{
    
    public Biscuit(Map<Integer, Ingredients> ingredients)
    {
        super("Maria", ingredients);
    }
    
    @Override
    protected void setPrice()
    {
        double price = 0;
        for(Ingredients ingredient: super.getIngredients())
        {
        price += ingredient.getPrice();
        }
        
        price = price*1.8;
        
        super.setPrice(price);
    }

}
