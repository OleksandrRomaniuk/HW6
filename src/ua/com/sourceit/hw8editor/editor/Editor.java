package ua.com.sourceit.hw8editor.editor;

import java.util.Scanner;

public class Editor
{
    private String text;

    public String typeText()
    {
        String line = "";
        Scanner typing = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder();

        while (!line.equals("exit"))
        {
            textBuilder.append(line);
            textBuilder.append("\n");
            line = typing.nextLine();
        }

        typing.close();
        this.text = textBuilder.toString();
        return this.text;
    }

}
