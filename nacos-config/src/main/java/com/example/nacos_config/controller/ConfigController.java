package com.example.nacos_config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope // 支持nacos的动态刷新功能
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/get/info")
    public String getConfigInfo() {
        return configInfo;
    }

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}
