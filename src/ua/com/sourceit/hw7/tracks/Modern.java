package ua.com.sourceit.hw7.tracks;

import java.util.Calendar;

import ua.com.sourceit.hw7.tracks.types.Genres;

public class Modern extends Track
{
    protected int licence;
    protected String publisher;

    public Modern(String artist, String title, double length, String publisher, int licence, Genres genre)
    {
        super(artist, title, length);
        this.publisher = publisher;
        this.licence = licence;
        this.genre = genre;
    }

    public void setLicence(int licence)
    {
        if (licence < Calendar.getInstance().get(Calendar.YEAR))
            System.out.println("The licence has been expired.");
        else
            this.licence = licence;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public int getLicence()
    {
        return licence;
    }

    public String getPublisher()
    {
        return publisher;
    }
}
