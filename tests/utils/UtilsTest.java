package utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void testHidePasswordWithParamGreaterThanZero() {
        int stringLength = 5;
        String expectString = "*****";
        String actualString = Utils.hidePassword(stringLength);
        Assert.assertEquals(expectString, actualString);
    }

    @Test
    public void testHidePasswordWithParamZero() {
        int stringLength = 0;
        String expectString = "";
        String actualString = Utils.hidePassword(stringLength);
        Assert.assertEquals(expectString, actualString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHidePasswordWithNegativeParam() {
        int negativeParam = -5;
        Utils.hidePassword(negativeParam);
    }
}
