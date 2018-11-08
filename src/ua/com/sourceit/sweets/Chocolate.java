package ua.com.sourceit.sweets;

import java.util.Map;

public class Chocolate extends Choco
{

    public Chocolate(Map<Integer, Ingredients> ingredients)
    {
        super("Milka", ingredients);
    }

    @Override
    protected void setPrice()
    {
        double price = 0;
        for(Ingredients ingredient: super.getIngredients())
        {
        price += ingredient.getPrice();
        }
        
        price = price*1.5;
        
        super.setPrice(price);
    }
}
