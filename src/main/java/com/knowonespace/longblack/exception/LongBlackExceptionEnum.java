package com.knowonespace.longblack.exception;

public enum LongBlackExceptionEnum {
    NEED_USER_NAME(10001, "用户名不能为空"),
    NEED_PASSWORD(10002, "密码不能为空"),
    PASSWORD_TOO_SHORT(10003, "密码长度太短"),
    NAME_EXISTED(10004, "不允许重名"),
    INSERT_FAIL(10005, "插入失败请重试"),
    WRONG_PASSWORD(10006, "密码错误"),
    NEED_LOGIN(10007, "用户未登录"),
    UPDATE_FAIL(10008, "更新失败"),
    NOT_ADMIN(10009, "无管理员权限"),
    PARA_NOT_NULL(10010, "参数不能为空"),
    CRATE_FAILED(10011, "新增失败"),
    REQUEST_PARAM_ERROR(10012, "需要参数"),
    DELETE_FAIL(10013, "删除失败"),
    MAKE_DIR_FAIL(10014, "文件夹创建失败"),
    UPLOAD_FAIL(10015, "图片上传失败"),
    ARTICLE_NOT_EXISTED(10016, "文章不存在"),
    NOT_READ(10017, "文章状态异常"),
    NO_ENUM(10018, "枚举异常"),
    NOT_YOUR_ARTICLE(10019, "文章无操纵权限"),
    USER_NOT_EXISTED(10020,"用户不存在"),
    EVALUATE_FAIL(10021,"评论失败"),
    SYSTEM_ERROR(20000, "系统异常");

    Integer code;

    String msg;

    LongBlackExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
