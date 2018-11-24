package ua.com.sourceit.hw8editor.editor;

public interface Criteriable
{
    default char[] getVowel()
    {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        return vowels;
    }
}
