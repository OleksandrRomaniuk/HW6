package ua.com.sourceit.hw8editor.editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWriter
{

    private File file;
    
    public File write(String enteredText)
    {
        String path = "newFile.txt";
        try
        {
            Files.write(Paths.get(path), enteredText.getBytes(), StandardOpenOption.CREATE);
            file = new File(path);
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return file;
    }

    public File getFile()
    {
        return file;
    }
}
