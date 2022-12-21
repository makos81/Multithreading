package parallel.zadanieDomowe1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Countries {
    private Countries(){

    }

    public static List<Country> generateCountries(int n){
        List<Country> countryList = new ArrayList<>();
        for (int i=0; i < n; i++){
            long population = ThreadLocalRandom.current().nextLong(100000,100000000);
            countryList.add(new Country("country " + i, population));
        }
        return countryList;
    }

}
