package com.spursgdp.apollo.springboot.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangdongwei
 * @create 2020-02-20-9:48
 */

@RestController
public class AccountController {

    //法1：通过
    @Value("${sms.enable}")
    private Boolean smsEnable;

    @GetMapping("/db-driver")
    public String getDBConfig(@Value("${spring.datasource.driver-class-name}") String driver){
        return driver;
    }

    @ApolloConfig
    private Config config1;  //application namespace

    @GetMapping("/sms-enable")
    public String getSmsEnable() {
        String p = config1.getProperty("sms.enable", null);
        return smsEnable + System.lineSeparator() + p;
    }

    @ApolloConfig("micro_service.spring-druid")
    private Config config2; //micro_service.spring-druid namespace

    @GetMapping("/druid-driver")
    public String getDriver() {
        String driver = config2.getProperty("spring.datasource.driver-class-name", null);
        return driver;
    }

    //通过静态方法获取配置信息
    @GetMapping("/config")
    public String getConfig(){
        Config c1 = ConfigService.getAppConfig();  //默认Namespace
        String smsEnable = c1.getProperty("sms.enable", null);
        Config c2 = ConfigService.getConfig("micro_service.spring-druid");  //特定Namespace
        String driver = c2.getProperty("spring.datasource.driver-class-name", null);
        return smsEnable + System.lineSeparator() + driver;

    }


}
