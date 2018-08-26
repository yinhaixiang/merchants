package com.sean.passbook.service;

import com.alibaba.fastjson.JSON;
import com.sean.passbook.constant.Constants;
import com.sean.passbook.constant.ErrorCode;
import com.sean.passbook.dao.MerchantsDao;
import com.sean.passbook.entity.Merchants;
import com.sean.passbook.service.IMerchantsService;
import com.sean.passbook.vo.CreateMerchantsRequest;
import com.sean.passbook.vo.CreateMerchantsResponse;
import com.sean.passbook.vo.PassTemplate;
import com.sean.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户服务接口实现
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements IMerchantsService {

    /**
     * Merchants 数据库接口
     */
    private final MerchantsDao merchantsDao;

    @Autowired
    public MerchantsServiceImpl(MerchantsDao merchantsDao) {
        this.merchantsDao = merchantsDao;
    }


    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response = new Response();

        Merchants merchants = merchantsDao.findById(id);
        if (null == merchants) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }

        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();


        return response;
    }
}
