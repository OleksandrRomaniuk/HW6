package ua.com.sourceit.hw7.main;

import ua.com.sourceit.hw7.record.Disc;
import ua.com.sourceit.hw7.record.Record;
import ua.com.sourceit.hw7.tracks.Classic;
import ua.com.sourceit.hw7.tracks.Modern;
import ua.com.sourceit.hw7.tracks.Track;
import ua.com.sourceit.hw7.tracks.types.Genres;

public class Main
{

    public static void main(String[] args)
    {

        Track t1 = new Modern("Shakira", "love-love-love", 6.88, "Golden", 2019, Genres.POP);
        Track t2 = new Modern("Eminem", "good-good-good", 7.78, "GP", 2020, Genres.RAP);
        Track t3 = new Modern("Riana", "love-love", 5.88, "Golden", 2019, Genres.LOUNGE);
        Track t4 = new Modern("Jay-Z", "Super", 4.88, "Night", 2021, Genres.RAP);
        Track t5 = new Modern("Shakira", "Just good", 3.88, "Golden", 2019, Genres.FOLK);
        Track t6 = new Classic("Bethoven", "Just good", 3.88);
        Track[] t = { t1, t2, t3, t4, t5, t6 };
        Record r1 = new Record(t);

        Disc d1 = r1.getDisc();

        System.out.println(d1);

        d1.sortByGenre();

        System.out.println(d1);

        System.out.println(d1.filterByLength(5, 9));

    }

}
