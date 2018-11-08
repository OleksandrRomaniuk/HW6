package ua.com.sourceit.sweets;

import java.util.Collections;

public class main
{

    public static void main(String[] args)
    {
        Recipes recipes = new Recipes();
        Gift gift = new Gift("My gift");
        gift.addSweet(new Candy(recipes.getRecipeCandy()));
        gift.addSweet(new Biscuit(recipes.getRecipeBiscuit()));
        gift.addSweet(new Chocolate(recipes.getRecipeChocolate()));
        System.out.println(gift);
        Collections.sort(gift.getSweets());
        System.out.println(gift);
        
        Collections.sort(gift.getSweets(), new PriceComparator());
        System.out.println(gift);
        
        new PrintReport().printReport(gift.filterBySugar(5, 100));
    }

}
