package main.java.de.fh.albsig.hoitzmar.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(final String[] args) throws Exception {
        // Configure Log4J
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
        // Read the zip code from the command line
        // (if none supplied, use 60202)
        String zipcode = "60202";
        try {
            zipcode = args[0];
        } catch (final Exception e) {
        }
        // Start the program
        new Main(zipcode).start();
    }

    private final String zip;

    public Main(final String zip) {
        this.zip = zip;
    }

    public void start() throws Exception {
        // Retrieve Data
        final InputStream dataIn = new YahooRetriever().retrieve(zip);
        // Parse Data
        final Weather weather = new YahooParser().parse(dataIn);
        // Format (Print) Data
        System.out.print(new WeatherFormatter().format(weather));
    }
}
