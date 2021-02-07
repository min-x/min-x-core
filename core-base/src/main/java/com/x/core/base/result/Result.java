package com.x.core.base.result;

import com.x.core.base.constant.HttpStatusConstant;
import com.x.core.base.constant.MinXConstant;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Optional;

/**
 * API统一返回结果
 *
 * @author min-x
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回结果数据
     */
    private T data;
    /**
     * 返回消息
     */
    private String message;

    private Result(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private Result(IResultCode resultCode, String message) {
        this(resultCode, null, message);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private Result(IResultCode resultCode, T data, String message) {
        this(resultCode.getCode(), data, message);
    }

    private Result(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.success = ResultCode.SUCCESS.code == code;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(Result<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtils.nullSafeEquals(ResultCode.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(Result<?> result) {
        return !Result.isSuccess(result);
    }

    /**
     * 返回Result
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return Result
     */
    public static <T> Result<T> data(T data) {
        return data(data, MinXConstant.DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 返回Result
     *
     * @param data    数据
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return Result
     */
    public static <T> Result<T> data(T data, String message) {
        return data(HttpStatusConstant.SC_OK, data, message);
    }

    /**
     * 返回Result
     *
     * @param code    状态码
     * @param data    数据
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return Result
     */
    public static <T> Result<T> data(int code, T data, String message) {
        return new Result<>(code, data, data == null ? MinXConstant.DEFAULT_NULL_MESSAGE : message);
    }

    /**
     * 返回Result
     *
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(String message) {
        return new Result<>(ResultCode.SUCCESS, message);
    }

    /**
     * 返回Result
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    /**
     * 返回Result
     *
     * @param resultCode 业务代码
     * @param message    消息
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> success(IResultCode resultCode, String message) {
        return new Result<>(resultCode, message);
    }

    /**
     * 返回Result
     *
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.FAILURE, message);
    }


    /**
     * 返回Result
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, null, message);
    }

    /**
     * 返回Result
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    /**
     * 返回Result
     *
     * @param resultCode 业务代码
     * @param message    消息
     * @param <T>        T 泛型标记
     * @return Result
     */
    public static <T> Result<T> fail(IResultCode resultCode, String message) {
        return new Result<>(resultCode, message);
    }

    /**
     * 返回Result
     *
     * @param flag 成功状态
     * @return Result
     */
    public static <T> Result<T> status(boolean flag) {
        return flag ? success(MinXConstant.DEFAULT_SUCCESS_MESSAGE) : fail(MinXConstant.DEFAULT_FAILURE_MESSAGE);
    }

}
