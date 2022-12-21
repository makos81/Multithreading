package parallel.zadanieDomowe1;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApp {
    public static void main(String[] args) {
        List<Country> countryList = Countries.generateCountries(1000);

        ForkJoinPool thePool = new ForkJoinPool();

        Long result = thePool.invoke(new CountryProcessTask(countryList));

        System.out.println(result);
    }
}
