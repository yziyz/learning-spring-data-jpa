package yz.learning.springdatajpa.util;

/**
 * @author 袁臻
 * 2017/08/04 14:30
 */
public class StringUtils {
    public static String leftWildcard(final String source) {
        return String.format("%%%s", source);
    }

    public static String rightWildcard(final String source) {
        return String.format("%s%%", source);
    }

    public static String wildcard(final String source) {
        return String.format("%%%s%%", source);
    }
}
