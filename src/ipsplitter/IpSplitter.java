package ipsplitter;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class IpSplitter {

    public String split(String rawIp) {
        return asList(rawIp.split("\\.")).stream()
                .map(ip -> valueOf(parseInt(ip)))
                .collect(joining("."));
    }

}
