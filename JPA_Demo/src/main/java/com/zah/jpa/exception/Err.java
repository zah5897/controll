package com.zah.jpa.exception;

/**
 * Created by zah on 2018/3/30.
 */
public enum Err {

    ERR_SUCCESS(-1, "操作成功"), ERR_FAILED(0, "操作失败");
    private int value;
    private String errorMsg;

    private Err(int code, String errorMsg) {
        this.value = code;
        this.errorMsg = errorMsg;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
