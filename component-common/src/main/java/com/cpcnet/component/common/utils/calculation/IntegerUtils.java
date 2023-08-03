package com.cpcnet.component.common.utils.calculation;

/**
 * 整形数字工具类
 *
 * @author 网评管理项目开发组
 * @date 2019/9/10
 */
public class IntegerUtils {
    private IntegerUtils() {
    }

    public static boolean isEqual(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a.intValue() == b.intValue();
    }

    /**
     * 判断整数a是否大于整数b
     *
     * @return a是否大于b
     */
    public static boolean isGreaterThan(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a.intValue() > b.intValue();
    }

    /**
     * 判断整数a是否大于等于整数b
     *
     * @return a是否大于等于b
     */
    public static boolean isGreaterThanOrEqualTo(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a.intValue() >= b.intValue();
    }

    /**
     * 判断整数a是否小于整数b
     *
     * @return a是否小于b
     */
    public static boolean isLessThan(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a.intValue() < b.intValue();
    }

    /**
     * 判断整数a是否小于等于整数b
     *
     * @return a是否小于等于b
     */
    public static boolean isLessThanOrEqualTo(Integer a, Integer b) {
        if (a == null || b == null) {
            return false;
        }
        return a.intValue() <= b.intValue();
    }

    public static boolean isGreaterThanZero(Integer i) {
        return i != null && i > 0;
    }

    public static boolean isZero(Integer i) {
        return i != null && i == 0;
    }

    public static boolean isGreaterThanOrEqualToZero(Integer i) {
        return i != null && i >= 0;
    }

    public static boolean isLessThanOrEqualToZero(Integer i) {
        return i != null && i <= 0;
    }

    public static Integer parseInt(Object object, Integer defaultValue) {
        if (object == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(String.valueOf(object).trim());
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    public static Integer parseInt(Object object) {
        return parseInt(object, 0);
    }

    public static boolean isAllEqual(Integer a, Integer... b) {
        for (int i : b) {
            if (!isEqual(a, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isContain(Integer a, Integer... b) {
        for (int i : b) {
            if (isEqual(a, i)) {
                return true;
            }
        }
        return false;
    }
}
