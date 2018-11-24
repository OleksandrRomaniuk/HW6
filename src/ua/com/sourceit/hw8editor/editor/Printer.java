package ua.com.sourceit.hw8editor.editor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Printer implements Criteriable
{
    public void printTextFile(File file)
    {
        try
        {
            String text = new String(Files.readAllBytes(file.toPath()));
            System.out.println(text);
            System.out.println("Number of chars in the text: " + countChars(text));
            int[] linesAndVowels = checkLines(file);
            System.out.println("The line with the max number of vowels is " + linesAndVowels[0] + "\n"
                    + "Number of vowels in the line is " + linesAndVowels[1]);
            System.out.println("Number of words is " + countWords(text));
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private int countChars(String text)
    {
        int numberOfChars = 0;
        char[] charsFromText = text.toCharArray();
        for (int i = 0; i < charsFromText.length; i++)
        {
            if (!Character.isWhitespace(charsFromText[i]))
            {
                numberOfChars++;
            }
        }
        return numberOfChars;
    }

    private int[] checkLines(File file)
    {
        int maxNumberOfVowels = 0;
        int lineNumber = 0;
        int[] linesAndVowels = new int[2];
        try
        {
            Object[] lines = Files.readAllLines(file.toPath()).toArray();
            for (int i = 0; i < lines.length; i++)
            {
                int vowels = countVowels((String) lines[i]);
                if (vowels > maxNumberOfVowels)
                {
                    maxNumberOfVowels = vowels;
                    lineNumber = i;
                }
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        linesAndVowels[0] = lineNumber;
        linesAndVowels[1] = maxNumberOfVowels;
        return linesAndVowels;
    }

    private int countVowels(String text)
    {
        char[] arrayOfChars = text.toCharArray();
        int numberOfVowels = 0;
        for (int i = 0; i < arrayOfChars.length; i++)
        {
            if (isVowel(arrayOfChars[i]))
                numberOfVowels++;
        }
        return numberOfVowels;
    }

    private boolean isVowel(char ch)
    {
        char[] vowels = getVowel();
        boolean result = false;
        for (int i = 0; i < vowels.length; i++)
        {
            if (ch == vowels[i])
            {
                result = true;
                break;
            }
        }
        return result;
    }

    private int countWords(String text)
    {
        int counter = 0;
        Pattern pattern = Pattern.compile("(\\s+)?\\S+(\\s*)?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find())
            counter++;

        return counter;
    }
}
