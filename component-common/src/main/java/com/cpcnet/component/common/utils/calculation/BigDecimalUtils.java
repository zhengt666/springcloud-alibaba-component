package com.cpcnet.component.common.utils.calculation;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * BigDecimal_DOUBLE计算类
 *
 * @author taozheng
 * @date 2020/10/23
 */
@Slf4j
public class BigDecimalUtils {

    /**
     * 默认保留2位小数
     */
    public static final int LOCATION = 2;

    public static final int LOCATION_FOUR = 4;

    /**
     * 定义加法方法，参数为加数与被加数
     *
     * @param value1 相加的第一个数
     * @param value2 相加的第二个数
     * @return 两数之和
     */
    public static BigDecimal add(double value1, double value2) {
        //实例化 Decimal 对象
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        //调用加法方法
        return b1.add(b2);
    }

    /**
     * 定义减法方法，参数为减数与被减数
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 运算结果
     */
    public static BigDecimal sub(double value1, double value2) {
        //实例化 Decimal 对象
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        //调用减法方法
        return b1.subtract(b2);
    }

    /**
     * 定义乘法方法，参数为乘数与被乘数
     *
     * @param value1 第一个乘数
     * @param value2 第二个乘数
     * @return 运算结果
     */
    public static BigDecimal mul(double value1, double value2) {
        //实例化 Decimal 对象
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        //调用乘法方法
        return b1.multiply(b2);
    }

    /**
     * 定义除法方法，参数为除数与被除数
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 运算结果
     */
    public static BigDecimal div(double value1, double value2) {
        //调用自定义除法方法
        return div(value1, value2, LOCATION);
    }

    /**
     * 定义除法方法，参数为除数与被除数
     *
     * @param value1 被除数
     * @param value2 除数
     * @return 运算结果
     */
    public static BigDecimal div(double value1, double value2, double value3, int b) {
        //调用自定义除法方法
        return div(div(value1, value2, LOCATION).doubleValue(), value3, b);
    }

    public static BigDecimal div(double value1, double value2, int b) {
        if (b < 0) {
            log.warn("b 值必须大于等于 0");
        }
        if (value2 == 0) {
            log.warn("分母不能为0");
            return new BigDecimal(0);
        }
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        //调用除法方法，商小数点保留 b 位，并将结果进行四舍五入操作
        return b1.divide(b2, b, BigDecimal.ROUND_HALF_UP);
    }


    public static BigDecimal div(BigDecimal value1, BigDecimal value2, int b) {
        if (b < 0) {
            log.warn("b 值必须大于等于 0");
        }
        if (value2.equals(BigDecimal.ZERO)) {
            log.warn("分母不能为0");
            return new BigDecimal(0);
        }
        //调用除法方法，商小数点保留 b 位，并将结果进行四舍五入操作
        return value1.divide(value2, b, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 值1 大于 值2 的比较结果
     *
     * @param value1 值1
     * @param value2 值2
     * @return 运算结果
     */
    public static boolean gt(BigDecimal value1, BigDecimal value2) {
        if (null == value1 || null == value2) {
            return false;
        }
        return value1.compareTo(value2) > 0;
    }

    /**
     * 值1 大于或等于 值2 的比较结果
     *
     * @param value1 值1
     * @param value2 值2
     * @return 运算结果
     */
    public static boolean ge(BigDecimal value1, BigDecimal value2) {
        if (null == value1 || null == value2) {
            return false;
        }
        return value1.compareTo(value2) >= 0;
    }

    /**
     * 值1 小于 值2 的比较结果
     *
     * @param value1 值1
     * @param value2 值2
     * @return 运算结果
     */
    public static boolean lt(BigDecimal value1, BigDecimal value2) {
        if (null == value1 || null == value2) {
            return false;
        }
        return value1.compareTo(value2) < 0;
    }

    /**
     * 值1 小于或等于 值2 的比较结果
     *
     * @param value1 值1
     * @param value2 值2
     * @return 运算结果
     */
    public static boolean le(BigDecimal value1, BigDecimal value2) {
        if (null == value1 || null == value2) {
            return false;
        }
        return value1.compareTo(value2) <= 0;
    }

    /**
     * 转换成BigDecimal
     *
     * @param v1 值1
     * @return BigDecimal
     */
    public static BigDecimal change(Float v1) {
        return new BigDecimal(v1);
    }

    /**
     * 转换成BigDecimal
     *
     * @param v1 值1
     * @return BigDecimal
     */
    public static BigDecimal change(Integer v1) {
        return new BigDecimal(v1);
    }

    /**
     * 转换成BigDecimal
     *
     * @param v1 值1
     * @return BigDecimal
     */
    public static BigDecimal change(Double v1) {
        return new BigDecimal(v1);
    }

    public static Boolean eq(BigDecimal v1, BigDecimal v2) {
        if (Objects.isNull(v1) && Objects.isNull(v2)) {
            return true;
        }
        if ((Objects.nonNull(v1) && Objects.isNull(v2)) || (Objects.nonNull(v2) && Objects.isNull(v1))) {
            return false;
        }
        BigDecimal value1 = v1.divide(BigDecimal.valueOf(1), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal value2 = v2.divide(BigDecimal.valueOf(1), 2, BigDecimal.ROUND_HALF_UP);
        return value1.equals(value2);
    }

    /**
     * 四舍五入保留几位小数
     *
     * @param v     值
     * @param scale 保留小数位
     * @return double
     */
    public static double round(BigDecimal v, Integer scale) {
        if (Objects.isNull(v)) {
            return 0;
        }
        if (scale == 0) {
            return v.intValue();
        }
        return v.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入保留几位小数
     *
     * @param v 值
     * @return double
     */
    public static int round(BigDecimal v) {
        if (Objects.isNull(v)) {
            return 0;
        }
        return v.intValue();
    }
}
