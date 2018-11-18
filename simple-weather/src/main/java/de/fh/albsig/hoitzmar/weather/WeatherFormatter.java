package main.java.de.fh.albsig.hoitzmar.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class WeatherFormatter {
    private static Logger log = Logger.getLogger(WeatherFormatter.class);

    public String format(final Weather weather) throws Exception {
        log.info("Formatting Weather Data");
        final Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("output.vm"));
        final VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        final StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "", reader);
        return writer.toString();
    }
}