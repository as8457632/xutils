package com.xuan.mix.http.server;

import java.util.Map;

/**
 * Http��������
 *
 * @author xuan
 * @since 2020/10/16
 */
public interface HttpHandler {

    /**
     * ִ�д���
     *
     * @param path   ·��
     * @param params get����
     * @return ������
     */
    String handle(String path, Map<String, String> params);
}
