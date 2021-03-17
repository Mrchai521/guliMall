/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.cxf.gulimall.renren.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    public R(int code, String msg, Object data) {
        put(CODE_TAG, code);
        put(MSG_TAG, msg);
        put(DATA_TAG, data);

    }

    public R(int code, String msg) {
        put(CODE_TAG, code);
        put(MSG_TAG, msg);
    }

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        return new R(code,msg);
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R success() {
        return R.ok("操作成功！");
    }

    /**
     * 返回成功数据
     * @param data
     * @return
     */
    public static R success(Object data) {
        return R.success("操作成功！",data);
    }

    /**
     * 返回成功数据
     * @param msg
     * @param data
     * @return
     */
    public static R success(String msg, Object data) {
        return new R(HttpStatus.SC_OK, msg, data);
    }

    /**
     * 返回成功数据
     * @param msg
     * @return
     */
    public static R success(String msg){
        return R.success(msg,null);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
