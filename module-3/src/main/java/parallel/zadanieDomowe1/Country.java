package parallel.zadanieDomowe1;

public final class Country {
    private final String countryName;
    private final Long peopleQuantity;

    Country(String countryName, Long peopleQuantity){
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    String getCountryName(){
        return this.countryName;
    }

    Long getPeopleQuantity(){
        return this.peopleQuantity;
    }
}
