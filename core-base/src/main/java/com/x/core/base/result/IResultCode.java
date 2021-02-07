package com.x.core.base.result;

/**
 * 业务返回状态码接口
 *
 * @author min-x
 */
public interface IResultCode {

    /**
     * 消息
     */
    String getMessage();

    /**
     * 状态码
     */
    int getCode();

}