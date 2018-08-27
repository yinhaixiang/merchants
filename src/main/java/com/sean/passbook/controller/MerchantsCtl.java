package com.sean.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.sean.passbook.service.IMerchantsService;
import com.sean.passbook.vo.CreateMerchantsRequest;
import com.sean.passbook.vo.PassTemplate;
import com.sean.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务 Controller
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsCtl {

    /**
     * 商户服务接口
     */
    private final IMerchantsService merchantsService;

    @Autowired
    public MerchantsCtl(IMerchantsService merchantsService) {
        this.merchantsService = merchantsService;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {

        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return merchantsService.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {

        log.info("BuildMerchantsInfo: {}", id);
        return merchantsService.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {

        log.info("DropPassTemplate: {}", passTemplate);
        return merchantsService.dropPassTemplate(passTemplate);
    }
}
