
package nl.rdj;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IpStripperTest {
    private final String ip;
    private final String expected;

    public IpStripperTest(String ip, String expected) {
        this.ip = ip;
        this.expected = expected;
    }
    
    @Test
    public void testIps() {
        assertThat(new IpStripper().strip(ip), is(expected));
    }
    
    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
                new Object[][] {
                    { "00192.00168.00123.000001", "192.168.123.1" },
                    { "192.168.123.1", "192.168.123.1" },
                    { "0000000192.168.123.01", "192.168.123.1" },
                    { "000192.00168.00123.000001", "192.168.123.1" },
                    { "0000192.00168.00123.0000010", "192.168.123.10" },
                    { "0192.00168.000123.00001", "192.168.123.1" },
                }
        );
    }
}
