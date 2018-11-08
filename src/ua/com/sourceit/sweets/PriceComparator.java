package ua.com.sourceit.sweets;

import java.util.Comparator;

public class PriceComparator implements Comparator<Sweet>
{

    public PriceComparator()
    {
    }

    @Override
    public int compare(Sweet sweet1, Sweet sweet2)
    {
        if(sweet1.getPrice() == sweet2.getPrice())
            return 0;
        else 
            return (int) (sweet1.getPrice() - sweet2.getPrice());
    }
    
}
