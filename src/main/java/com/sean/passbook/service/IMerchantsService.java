package com.sean.passbook.service;

import com.sean.passbook.vo.CreateMerchantsRequest;
import com.sean.passbook.vo.PassTemplate;
import com.sean.passbook.vo.Response;

/**
 * 对商户服务接口定义
 */
public interface IMerchantsService {

    /**
     * 创建商户服务
     *
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据 id 构造商户信息
     *
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * 投放优惠券
     *
     * @param template {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
