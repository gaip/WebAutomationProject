package dateParser;

import base.BaseTest;
import com.propine.parser.component.DateParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateParserTest extends BaseTest {

    @Test
    public void testDate() {

        DateParser dateParser = new DateParser(driver);

        // fill date
        dateParser.enterDate("25 Dec 2019");

        // click submit
        dateParser.clickSubmitButton();

        // check result
        String result = dateParser.fetchResult();
        Assert.assertEquals(result, "abc");

    }
}
