package main.java.de.fh.albsig.hoitzmar.weather;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class YahooParser {
    private static Logger log = Logger.getLogger(YahooParser.class);

    private SAXReader createXmlReader() {
        final Map<String, String> uris = new HashMap<String, String>();
        uris.put("y", "http://xml.weather.yahoo.com/ns/rss/1.0");
        final DocumentFactory factory = new DocumentFactory();
        factory.setXPathNamespaceURIs(uris);
        final SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);
        return xmlReader;
    }

    public Weather parse(final InputStream inputStream) throws Exception {
        final Weather weather = new Weather();
        log.info("Creating XML Reader");
        final SAXReader xmlReader = createXmlReader();
        final Document doc = xmlReader.read(inputStream);
        log.info("Parsing XML Response");
        weather.setCity(doc.valueOf("/rss/channel/y:location/@city"));
        weather.setRegion(doc.valueOf("/rss/channel/y:location/@region"));
        weather.setCountry(doc.valueOf("/rss/channel/y:location/@country"));
        weather.setCondition(doc.valueOf("/rss/channel/item/y:condition/@text"));
        weather.setTemp(doc.valueOf("/rss/channel/item/y:condition/@temp"));
        weather.setChill(doc.valueOf("/rss/channel/y:wind/@chill"));
        weather.setHumidity(doc.valueOf("/rss/channel/y:atmosphere/@humidity"));
        return weather;
    }
}
