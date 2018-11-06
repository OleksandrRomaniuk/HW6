package ua.com.sourceit.sweets;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Gift
{
    private ArrayList<Sweet> sweets = new ArrayList();
    private int weight = 0;
    private int sugar = 0;
    private int calories = 0;
    private double price = 0;
    private String name;
    private boolean bio = true;
    
    private Gift()
    {
    }
    
    public Gift(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Sweet> getSweets()
    {
        return sweets;
    }
    
    public ArrayList<Sweet> filterBySugar(int min, int max)
    {
        ArrayList<Sweet> sweetsFiltered = new ArrayList();
        
        sweetsFiltered = (ArrayList<Sweet>) sweets.stream().filter(item -> item.getSugar()>min && item.getSugar()<max).collect(Collectors.toList());
        return sweetsFiltered;
    }
    
    public void addSweet(Sweet sweet)
    {
        sweets.add(sweet);
        weight += sweet.getWeight();
        sugar += sweet.getSugar();
        calories += sweet.getCalories();
        price += sweet.getPrice();
        
        if(!sweet.isBio())
            bio = false;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Sweet sweet: sweets)
            sb.append(sweet.toString()+"\n");
        
        return name+": \n"+ sb;
    }
}
