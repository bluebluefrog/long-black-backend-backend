package com.knowonespace.longblack.exception;

public class LongblackException extends RuntimeException {
    private final Integer code;
    private final String message;

    public LongblackException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public LongblackException(LongBlackExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
        //也是从外面的Enum进行传入，只不过Service层不能返回API所以要抛出异常
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
