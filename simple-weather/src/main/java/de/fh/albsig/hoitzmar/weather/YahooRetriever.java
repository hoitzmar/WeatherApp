package main.java.de.fh.albsig.hoitzmar.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class YahooRetriever {
    private static Logger log = Logger.getLogger(YahooRetriever.class);

    public InputStream retrieve(final String zipcode) throws Exception {
        log.info("Retrieving Weather Data");
        final String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;
        final URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}