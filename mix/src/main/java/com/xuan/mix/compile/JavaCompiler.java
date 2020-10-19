package com.xuan.mix.compile;

/**
 * ����ӿ�
 *
 * @author xuan
 * @since 2020/10/19
 */
public interface JavaCompiler {

    /**
     * ����
     *
     * @param javaSource    Դ����
     * @param compileOption ����ѡ��
     * @return ���Class����
     */
    Class<?> compile(JavaSource javaSource, CompileOption compileOption);
}
