package com.xuan.mix.compile;

/**
 * @author xuan
 * @since 2020/10/19
 */
public class CompileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CompileException(String message) {
        super(message);
    }

    public CompileException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        //��д����������Է�ֹ�����ջ��Ϣ
        return this;
    }

}
