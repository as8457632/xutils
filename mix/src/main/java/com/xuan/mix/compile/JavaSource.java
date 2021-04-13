package com.xuan.mix.compile;

/**
 * Java资源模型
 *
 * @author xuan
 * @since 2020/10/19
 */
public class JavaSource {

    /**
     * Java代码
     */
    private String sourceCode;
    /**
     * 类全路径，例如：com.xuan.mix.compile.DemoTestClass
     */
    private String fullClassName;

    public static JavaSource of(String sourceCode, String fullClassName) {
        JavaSource javaSource = new JavaSource();
        javaSource.setSourceCode(sourceCode);
        javaSource.setFullClassName(fullClassName);
        return javaSource;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }

}
