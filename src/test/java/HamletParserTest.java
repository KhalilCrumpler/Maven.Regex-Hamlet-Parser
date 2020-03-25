import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    private String leonRegex = "[^e][lL][Ee][oO][Nn]'?s?";
    private String tariqRegex = "[Tt][aA][Rr][Ii][Qq]'?s?";
    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        int actual = 472;
        hamletParser.changeHamletToLeon();
        Pattern pattern = Pattern.compile(leonRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        int expected = 0;
        while(matcher.find()){
            expected++;
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        int actual = 158;
        hamletParser.changeHoratioToTariq();
        Pattern pattern = Pattern.compile(tariqRegex);
        Matcher matcher = pattern.matcher(hamletParser.getHamletData());
        int expected = 0;
        while(matcher.find()){
            expected++;
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        int actual = hamletParser.numberOfHoratio();
        int expected = 158;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int actual = hamletParser.numberOfHamlet();
        int expected = 472;
        Assert.assertEquals(expected, actual);
    }
}