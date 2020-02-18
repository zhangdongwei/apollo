package com.spursgdp.apollo.quickstart;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @author zhangdongwei
 * @create 2020-02-18-10:38
 */
public class GetConfigTest {

    //VM Options:
    //-Dapp.id=apollo-quickstart -Denv=DEV -Ddev_meta=http://localhost:8080
    public static void main(String[] args) throws InterruptedException {
        Config config = ConfigService.getAppConfig();//获取的是默认Namespace（application）的配置
        String key = "sms.enable";
        while(true){
            Thread.sleep(1000);
            String value = config.getProperty(key,null);
            System.out.println("Time: " + System.currentTimeMillis() + " sms.enable: " + value);
        }
    }
}
