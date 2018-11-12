package ua.com.sourceit.hw7.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.com.sourceit.hw7.tracks.Track;

public class Disc
{
    private double length;

    private static List<Disc> discs = new ArrayList();
    private Map<Integer, Track> records;

    private Disc()
    {
    }

    public Disc(Map<Integer, Track> records)
    {
        this.records = records;
        discs.add(this);
        length = setLehgth();
    }

    private double setLehgth()
    {
        double len = 0;
        for (Map.Entry<Integer, Track> entry : records.entrySet())
        {
            len += entry.getValue().getLength();
        }
        return len;
    }

    public double getLength()
    {
        return length;
    }

    public void sortByGenre()
    {
        List<Track> list = new ArrayList<Track>(records.values());

        list = list.stream().sorted().collect(Collectors.toList());

        int i = 0;
        for (Track item : list)
        {
            records.put(i, item);
            i++;
        }
    }

    public List<Track> filterByLength(double min, double max)
    {
        List<Track> list = new ArrayList();
        for (Map.Entry<Integer, Track> entry : records.entrySet())
        {
            if (entry.getValue().getLength() > min && entry.getValue().getLength() < max)
                list.add(entry.getValue());
        }

        return list;
    }

    public void print()
    {
        for (Map.Entry<Integer, Track> entry : records.entrySet())
        {
            System.out.print(entry.getValue());
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Track> entry : records.entrySet())
        {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
