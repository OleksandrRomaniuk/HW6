package ua.com.sourceit.sweets;

import java.util.ArrayList;

public class PrintReport
{

    public void printReport(ArrayList<Sweet> list)
    {
        System.out.println("Filtered list: ");
        
        StringBuilder sb = new StringBuilder();
        for(Sweet sweet: list)
            sb.append(sweet.toString()+"\n");
        System.out.println(sb);
    }

}
