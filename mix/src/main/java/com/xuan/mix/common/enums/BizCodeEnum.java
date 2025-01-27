package com.xuan.mix.common.enums;

import java.text.MessageFormat;

/**
 * bizCode错误码定义规范
 * <p>
 * Created by xuan on 17/8/2.
 */
public enum BizCodeEnum {
    /**
     * bizCode的格式一般我们定义为: 业务域范围前缀 + 编码
     * 一些通用提示最好使用MessageFormat.format处理,这样在返回时可以再定制一些值
     */
    PARAM_IS_EMPTY("common_001", "参数[{0}]不能为空."),
    DATABASE_OPERATE_FAIL("common_002", "数据库操作失败,提示[{0}]."),
    ;

    private String bizCode;

    private String msg;

    BizCodeEnum(String bizCode, String msg) {
        this.bizCode = bizCode;
        this.msg = msg;
    }

    public String getBizCode() {
        return bizCode;
    }

    public String getMsg() {
        return msg;
    }

    public String buildMsg(Object... params) {
        if (params != null) {
            return MessageFormat.format(msg, params);
        }
        return msg;
    }

}
