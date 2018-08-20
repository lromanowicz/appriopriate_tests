package utility;

import com.github.javafaker.Faker;

public class DataFaker {

    private Faker faker;

    public DataFaker() {
        faker = new Faker();
    }

    public String getFakeFirstname() {
        return faker.name().firstName();
    }

    public String getFakeLastname() {
        return faker.name().lastName();
    }

    public String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakePassword() {
        return faker.internet().password();
    }

    public String getFakeStreet() {
        return faker.address().streetName();
    }

    public String getFakeCity() { return faker.address().cityName(); }

    public String getFakeZipCode() {
        return faker.address().zipCode().substring(0,6);
    }

    public String getFakeState() {
        return faker.address().state();
    }

    public String getFakeMobilePhone() { return faker.phoneNumber().cellPhone(); }
}
