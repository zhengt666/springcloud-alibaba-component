package com.cpcnet.component.common.utils.asserts;

import com.cpcnet.component.common.exception.DefaultBusinessException;
import com.cpcnet.component.common.resp.ResponseCode;
import com.cpcnet.component.common.resp.ResponseResult;
import com.cpcnet.component.common.utils.calculation.IntegerUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 * @author 机考（企业版）项目组
 * @date 2020/6/1
 */
public class AssertUtils {
    private AssertUtils() {
    }

    /**
     * boolean表达式断言, 如果表达式为{@code false}则抛出异常{@code IllegalArgumentException}
     *
     * @param expression boolean 表达式
     * @param message    抛出的异常信息
     * @throws IllegalArgumentException 如果表达式为 {@code false}，则抛出此异常
     */
    public static void isTrueOrElseThrow(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * boolean表达式断言, 如果表达式为 {@code false} 则抛出异常 {@code T}
     *
     * @param expression        boolean 表达式
     * @param exceptionSupplier supplier对象，指定抛出的异常对象
     * @throws T                    如果表达式为 {@code false} 抛出异常
     * @throws NullPointerException 如果{@code exceptionSupplier} 为 {@code null}，则抛出此异常
     */
    public static <T extends Throwable> void isTrueOrElseThrow(boolean expression, Supplier<T> exceptionSupplier) throws T {
        if (!expression) {
            throw exceptionSupplier.get();
        }
    }

    public static <T extends Throwable> void isTrueOrElseThrow(boolean expression, String msg, Function<String, T> exceptionSupplier) throws T {
        if (!expression) {
            throw exceptionSupplier.apply(msg);
        }
    }

    /**
     * boolean表达式断言, 如果表达式为 {@code true} 则执行action代码
     *
     * @param expression boolean 表达式
     * @param arg        待执行的参数对象
     * @param action     待执行的代码片段，以args为参数
     */
    public static <T> void isTrueAndThen(boolean expression, T arg, Consumer<T> action) {
        if (expression) {
            Objects.requireNonNull(arg);
            Objects.requireNonNull(action);
            action.accept(arg);
        }
    }

    /**
     * boolean表达式断言, 如果表达式为 {@code true} 则执行action代码, 否则，执行elseAction代码
     *
     * @param expression boolean 表达式
     * @param arg        待执行的参数对象
     * @param action     待执行的代码片段，以args为参数
     */
    public static <T> void isTrueAndThen(boolean expression, T arg, Consumer<T> action, Consumer<T> elseAction) {
        Objects.requireNonNull(arg);
        Objects.requireNonNull(action);
        if (expression) {
            action.accept(arg);
        } else {
            elseAction.accept(arg);
        }
    }

    /**
     * 判断集合是否为空，如果为空，则抛出异常{@code IllegalArgumentException}
     *
     * @param collection 待判断的集合对象
     * @param message    抛出的异常信息
     * @throws IllegalArgumentException 集合为空，则抛出此异常
     */
    public static void notEmptyOrElseThrow(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判断集合是否为空，如果为空，则抛出异常 {@code T}
     *
     * @param collection        待判断的集合对象
     * @param exceptionSupplier supplier对象，指定抛出的异常对象
     * @throws T                    如果集合为空，则抛出此异常
     * @throws NullPointerException 如果{@code exceptionSupplier} 为 {@code null}，则抛出此异常
     */
    public static <T extends Throwable> void notEmptyOrElseThrow(Collection<?> collection, Supplier<T> exceptionSupplier) throws T {
        if (CollectionUtils.isEmpty(collection)) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * 判断对象是不是 null，如果不是 null，则抛出异常 {@code IllegalArgumentException}
     *
     * @param object  待判断的对象
     * @param message 抛出的异常信息
     * @throws IllegalArgumentException 如果对象为 {@code null}，则抛出此异常
     */
    public static void isNullOrElseThrow(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判断对象是否为 {@code null}，如果不是 {@code null}，则抛出异常  {@code T}
     *
     * @param object            待判断的对象
     * @param exceptionSupplier supplier对象，指定抛出的异常对象
     * @throws T                    如果对象不为 {@code null}，则抛出此异常
     * @throws NullPointerException 如果{@code exceptionSupplier} 为 {@code null}，则抛出此异常
     */
    public static <T extends Throwable> void isNullOrElseThrow(Object object, Supplier<T> exceptionSupplier) throws T {
        if (object != null) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * 判断对象是否不为 {@code null}，如果是 {@code null}，则抛出异常 {@code IllegalArgumentException}
     *
     * @param object  待判断的对象
     * @param message 抛出的异常信息
     * @throws IllegalArgumentException 如果对象为 {@code null}，则抛出此异常
     */
    public static void notNullOrElseThrow(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 判断对象是否不为 {@code null}，如果是 {@code null}，则抛出异常  {@code T}
     *
     * @param object            待判断的对象
     * @param exceptionSupplier supplier对象，指定抛出的异常对象
     * @throws T                    如果对象不为 {@code null}，则抛出此异常
     * @throws NullPointerException 如果{@code exceptionSupplier} 为 {@code null}，则抛出此异常
     */
    public static <T extends Throwable> void notNullOrElseThrow(Object object, Supplier<T> exceptionSupplier) throws T {
        if (object == null) {
            throw exceptionSupplier.get();
        }
    }

    public static <T extends Throwable> void notNullOrElseThrow(Object object, String msg, Function<String, T> exceptionSupplier) throws T {
        if (object == null) {
            throw exceptionSupplier.apply(msg);
        }
    }

    /**
     * boolean表达式断言, 如果表达式为{@code true}则抛出异常{@code IllegalArgumentException}, 用于校验
     *
     * @param expression boolean 表达式
     * @param message    抛出的异常信息
     * @throws IllegalArgumentException 如果表达式为 {@code true}，则抛出此异常
     */
    public static void ifTrueWillThrow(boolean expression, String message) {
        if (expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * boolean表达式断言, 如果表达式为 {@code true} 则抛出异常 {@code T}
     *
     * @param expression        boolean 表达式
     * @param exceptionSupplier supplier对象，指定抛出的异常对象
     * @throws T                    如果表达式为 {@code true} 抛出异常
     * @throws NullPointerException 如果{@code exceptionSupplier} 为 {@code null}，则抛出此异常
     */
    public static <T extends Throwable> void ifTrueWillThrow(boolean expression, Supplier<T> exceptionSupplier) throws T {
        if (expression) {
            throw exceptionSupplier.get();
        }
    }

    public static <T, E extends RuntimeException> void isSuccessElseThrow(ResponseResult<T> result, Function<String, E> exception) {
        AssertUtils.isTrueOrElseThrow(IntegerUtils.isEqual(result.getCode(), ResponseCode.SUCCESS.getCode()), () -> {
            throw (RuntimeException) exception.apply(result.getMessage());
        });
    }

    public static <T> T isSuccessElseThrow(ResponseResult<T> result) {
        isSuccessElseThrow(result, DefaultBusinessException::new);
        return result.getData();
    }
}
