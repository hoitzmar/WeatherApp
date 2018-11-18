package main.java.de.fh.albsig.hoitzmar.weather;

public class Weather {
    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    public Weather() {
    }

    public String getChill() {
        return chill;
    }

    public String getCity() {
        return city;
    }

    public String getCondition() {
        return condition;
    }

    public String getCountry() {
        return country;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getRegion() {
        return region;
    }

    public String getTemp() {
        return temp;
    }

    public void setChill(final String chill) {
        this.chill = chill;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setCondition(final String condition) {
        this.condition = condition;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setHumidity(final String humidity) {
        this.humidity = humidity;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public void setTemp(final String temp) {
        this.temp = temp;
    }

}
