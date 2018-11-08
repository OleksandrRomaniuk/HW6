package ua.com.sourceit.sweets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Sweet implements Comparable<Sweet>
{
    
    private Sweet()
    {}
    
    public Sweet(String name, Map<Integer, Ingredients> ingredientsMap)
    {
        this.name = name;
        
        for (Map.Entry<Integer, Ingredients> entry : ingredientsMap.entrySet()) 
        {
            addIngredient(entry.getKey(), entry.getValue());
        }
        
        setPrice();
    }
    
    private int weight;
    private int sugar;
    private int calories;
    private double price;
    private String name;
    private boolean bio = true;
    private ArrayList<Ingredients> ingredients = new ArrayList(); 
    
    public ArrayList<Ingredients> getIngredients()
    {
        return ingredients;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public int getSugar()
    {
        return sugar;
    }

    public int getCalories()
    {
        return calories;
    }

    public double getPrice()
    {
        return price;
    }

    public String getName()
    {
        return name;
    }

    public boolean isBio()
    {
        return bio;
    }

    protected abstract void setPrice();
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    private void addIngredient(int weight, Ingredients ingredient)
    {
        ingredient.setWeight(weight);
        ingredients.add(ingredient);
        this.weight += weight;
        this.sugar += ingredient.getSug();
        this.calories += ingredient.getCalories();
        if(!ingredient.isBio())
            bio = false;
    }
    
    @Override
    public String toString()
    {
        String st = (bio) ? "yes" : "no";
        
        return name+": "+"weight = " + weight + ", sugar = " + sugar + ", calories = " + calories + ", price = " + price
                 + ", bio = " + st;
    }
    
    @Override
    public int compareTo(Sweet sweet)
    {
        if(this.weight == sweet.getWeight())
            return 0;
        else 
            return this.weight - sweet.getWeight();
    }
}
