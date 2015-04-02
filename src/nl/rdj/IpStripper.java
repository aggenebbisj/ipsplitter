package nl.rdj;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;

public class IpStripper {

    public String strip(String ip) {
        return Stream.of(ip.split("\\."))
                .map(part -> valueOf(parseInt(part)))
                .collect(joining("."));
    }

}
