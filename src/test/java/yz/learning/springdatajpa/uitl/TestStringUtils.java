package yz.learning.springdatajpa.uitl;

import org.junit.Assert;
import org.junit.Test;
import yz.learning.springdatajpa.util.StringUtils;

/**
 * @author 袁臻
 * 2017/08/04 14:35
 */
public class TestStringUtils {
    private String source = "Jack";

    @Test
    public void testLeftWildcard() {
        String target = "%Jack";
        Assert.assertEquals(target, StringUtils.leftWildcard(source));
    }

    @Test
    public void testRightWildcard() {
        String target = "Jack%";
        Assert.assertEquals(target, StringUtils.rightWildcard(source));
    }

    @Test
    public void testWildcard() {
        String target = "%Jack%";
        Assert.assertEquals(target, StringUtils.wildcard(source));
    }
}
