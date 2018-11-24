package ua.com.sourceit.hw8editor.main;

import ua.com.sourceit.hw8editor.editor.Editor;
import ua.com.sourceit.hw8editor.editor.FileWriter;
import ua.com.sourceit.hw8editor.editor.Printer;

public class Main
{

    public static void main(String[] args)
    {
        Editor ed = new Editor();
        
        FileWriter fw = new FileWriter();
        fw.write(ed.typeText());
        Printer printer = new Printer();
        printer.printTextFile(fw.getFile());
    }

}
