package ua.com.sourceit.hw7.tracks.types;

public enum Genres
{
    ROCK((byte) 1), POP((byte) 2), CASSICAL((byte) 3), LOUNGE((byte) 4), HOUSE((byte) 5), FOLK((byte) 6), TECHNO(
            (byte) 7), JAZZ((byte) 8), RAP((byte) 9);

    private byte sortParameter;

    Genres(byte sortParameter)
    {
        this.sortParameter = sortParameter;
    }

    public byte getSortParameter()
    {
        return sortParameter;
    }
}
