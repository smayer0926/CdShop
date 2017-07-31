package theCdStore;

/**
 * Created by Guest on 7/31/17.
 */


public class cdStore {
    public String artistName;
    public String albumName;
    public int releaseYear;
    public int price;

    public cdStore (String name, String album, int year, int cost) {
        artistName = name;
        albumName = album;
        releaseYear = year;
        price = cost;
    }
    public boolean Y2K (boolean post) {
        if (post) {
            return (releaseYear >= 2000);
        } else {
            return (releaseYear < 2000);
        }
    }
    public boolean budget (int cost) {
        return (cost >= price);
    }

    public String printCD () {
        return "Artist name: " + artistName + " Album: " + albumName + " Year: " + releaseYear + " Price: $" + price;
    }

}

