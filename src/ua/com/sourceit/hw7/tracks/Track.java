package ua.com.sourceit.hw7.tracks;

import ua.com.sourceit.hw7.tracks.types.Genres;

public abstract class Track implements Comparable<Track>
{
    protected String artist;
    protected String title;
    protected double length;
    protected byte rating;
    protected int size;
    protected Genres genre;

    public Track(String artist, String title, double length)
    {
        this.artist = artist;
        this.title = title;
        this.length = length;
        size = setSize();
    }

    protected int setSize()
    {
        int s = (int) (length * 3125);
        return s;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s - %2.2f min, %2.2f MB \n", artist, title, length, (double) (size / 1000));
    }

    public void setRating(byte rating)
    {
        if (rating < 0 || rating > 5)
        {
            System.out.println("The rating must be from 0 to 5");
        } else
            this.rating = rating;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getTitle()
    {
        return title;
    }

    public double getLength()
    {
        return length;
    }

    public byte getRating()
    {
        return rating;
    }

    public int getSize()
    {
        return size;
    }

    public Genres getGenre()
    {
        return genre;
    }

    @Override
    public int compareTo(Track track)
    {
        if (this.genre.getSortParameter() == track.getGenre().getSortParameter())
            return 0;
        else
            return this.genre.getSortParameter() - track.getGenre().getSortParameter();
    }
}
