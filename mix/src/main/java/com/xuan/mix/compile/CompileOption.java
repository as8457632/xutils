package com.xuan.mix.compile;

import java.io.File;

/**
 * ����ʱ��ѡ��
 *
 * @author xuan
 * @since 2020/10/19
 */
public class CompileOption {

    /**
     * �����class��Ŀ¼
     */
    private String compileDir = System.getProperty("user.dir") + File.separator
        + ".xUtils_compile_dir" + File.separator;

    public String getCompileDir() {
        return compileDir;
    }

    public void setCompileDir(String compileDir) {
        this.compileDir = compileDir;
    }

}
