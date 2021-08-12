package com.xuan.spring.utils.extp.core;

import java.util.List;

import com.xuan.spring.utils.extp.model.BizExt;

/**
 * ҵ����չ�������
 *
 * @author xuan
 * @since 2019/11/5
 */
public interface BizExtMgr {

    /**
     * ����ҵ�����ͺ���չ��ӿ�Class��ȡ��չ��ʵ��
     *
     * @param bizCode      ҵ�����
     * @param extInterface ��չ��ӿ�Class
     * @return ��չ��ʵ��
     */
    List<BizExt> getBizExts(String bizCode, Class extInterface);

}
