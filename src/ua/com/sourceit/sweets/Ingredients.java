/**
 * 
 */
package ua.com.sourceit.sweets;

public enum Ingredients
{
    milk(2, 3, 0, true), nuts(8, 10, 0.05, true), flour(20, 2, 0, true), sugar(25, 8, 1, true), cream(18, 7, 0.01, false), 
        eggs(3, 4, 0, false), cacao(12, 15, 0.08, true), butter(23, 13, 0.01, true), coffee(1, 3, 0, true), blackChocolate(18, 7, 0.2, true);
    
    private int weight = 0;
    private int sug = 0;
    private double sugarPerGram = 0;
    private int calories = 0;
    private int caloriesPerGram = 0;
    private boolean bio = false;
    private double price = 0;
    private double pricePerGram = 0;
    
    Ingredients (int caloriesPerGram, int pricePerGram, double sugarPerGram, boolean bio)
    {
        this.caloriesPerGram = caloriesPerGram;
        this.pricePerGram = pricePerGram;
        this.sugarPerGram = sugarPerGram;
        this.bio = bio;
    }
    
    public void setPricePerGram(double pricePerGram)
    {
        this.pricePerGram = pricePerGram;
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
        sug = (int) (weight*sugarPerGram);
        calories = weight*caloriesPerGram;
        price = weight*pricePerGram;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getSug()
    {
        return sug;
    }

    public double getSugarPerGram()
    {
        return sugarPerGram;
    }

    public int getCalories()
    {
        return calories;
    }

    public int getCaloriesPerGram()
    {
        return caloriesPerGram;
    }

    public boolean isBio()
    {
        return bio;
    }

    public double getPrice()
    {
        return price;
    }

    public double getPricePerGram()
    {
        return pricePerGram;
    }
}
