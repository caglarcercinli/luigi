package be.vdab.luigi.restclients;

import be.vdab.luigi.exceptions.KoersClientException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
public class FixerKoersClient implements KoersClient {
    private static final Pattern PATTERN= Pattern.compile(".*\"USD\":");
    private final URL url;
    FixerKoersClient(){
        try {
            url=new URL(
                   "http://data.fixer.io/api/latest?access_key=6ac701e5f407de2451cd2c462d092a62&symbols=USD"
            );
        } catch (MalformedURLException e) {
           throw new KoersClientException("fixer URL is verkeerd");
        }
    }
    @Override
    public BigDecimal getDollarKoers() {
        try (var scanner=new Scanner(url.openStream())){
              scanner.skip(PATTERN);
              scanner.useDelimiter("}");
              return new BigDecimal(scanner.next());
        } catch (IOException|NumberFormatException e) {
            throw new KoersClientException("kan koeers niet lezen via fixer",e);
        }
    }
}
