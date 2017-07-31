import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import theCdStore.cdStore;

/**
 * Created by Guest on 7/31/17.
 */
public class App {
    public static void main(String[] args) {

        cdStore CD1 = new cdStore ("Lupe Fiasco", "Food and Liquor", 2008, 12);
        cdStore CD2 = new cdStore ("OutKast", "ABC", 1971, 15);
        cdStore CD3 = new cdStore ("The White Stripes", "Sympathy for the Record Industry", 1999, 12);
        cdStore CD4 = new cdStore ("MGMT", "Columbia", 2008, 20);

        cdStore[] allCompacts = {CD1, CD2, CD3, CD4};

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our epic CD store. We only have 4 in stock, but have a look. Search by: All CDs, Release year, Price, or Name");

        try {
            String searchChoice = bufferedReader.readLine();

            if (searchChoice.equals("All CDs")) {
                System.out.println("Here are all of our albums ");
                for (cdStore compacts: allCompacts) {
                    System.out.println("--------------");
                    System.out.println(compacts.artistName);
                    System.out.println(compacts.albumName);
                    System.out.println(compacts.releaseYear);
                    System.out.println(compacts.price);
                }
            } else if(searchChoice.equals("Release Year")) {
                System.out.println("Do you want albums from pre or post-Y2K?");
                String when = bufferedReader.readLine();
                if (when.equals("pre")) {
                    for (cdStore compacts: allCompacts) {
                        if (compacts.Y2K(false)) {
                            System.out.println("------------");
                            System.out.println(compacts.artistName);
                            System.out.println(compacts.albumName);
                            System.out.println(compacts.releaseYear);
                            System.out.println(compacts.price);
                        }
                    }

                } else if (when.equals("post")) {
                    for (cdStore compacts: allCompacts) {
                        if (compacts.Y2K(true)) {
                            System.out.println("------------");
                            System.out.println(compacts.artistName);
                            System.out.println(compacts.albumName);
                            System.out.println(compacts.releaseYear);
                            System.out.println(compacts.price);
                        }
                    }
                }
            } else if (searchChoice.equals("Price")) {
                System.out.println("What is your maximum price?");
                int userPrice = Integer.parseInt( bufferedReader.readLine() );

                for (cdStore compacts: allCompacts) {
                    if (compacts.budget(userPrice)) {
                        System.out.println("------------");
                        System.out.println(compacts.artistName);
                        System.out.println(compacts.albumName);
                        System.out.println(compacts.releaseYear);
                        System.out.println(compacts.price);
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("We have an error!");
        }
    }
}
