package ua.com.sourceit.hw7.record;

import java.util.HashMap;
import java.util.Map;

import ua.com.sourceit.hw7.tracks.Track;
import ua.com.sourceit.hw7.tracks.interfaces.Licence;

public class Record implements Licence
{
    private Map<Integer, Track> records;

    public Record()
    {
        records = new HashMap();
    }

    public Record(Track[] tracks)
    {
        this();
        for (Track track : tracks)
        {
            addTrack(track);
        }
    }

    public void addTrack(Track track)
    {
        if (checkLicence(track))
        {
            records.put(getMaxKey(), track);
        } else
            System.out.println("Can not record the track without licence");
    }

    private int getMaxKey()
    {
        int max = 0;
        for (Map.Entry<Integer, Track> entry : records.entrySet())
        {
            if (entry.getKey() >= max)
                max = entry.getKey() + 1;
        }
        return max;
    }

    public Disc getDisc()
    {
        return new Disc(records);
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
