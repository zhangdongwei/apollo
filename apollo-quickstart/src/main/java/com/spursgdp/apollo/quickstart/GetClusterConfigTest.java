package com.spursgdp.apollo.quickstart;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * @author zhangdongwei
 * @create 2020-02-18-10:38
 */
public class GetClusterConfigTest {

    //VM Options:
    //-Dapp.id=apollo-quickstart -Denv=DEV -Ddev_meta=http://localhost:8080
    public static void main(String[] args) throws InterruptedException {
//        Config config = ConfigService.getAppConfig();//获取的是默认Namespace（application）的配置
        Config config = ConfigService.getConfig("TEST1.SPRINT.ROCKETMQ_CONF");  //获取指定NameSpace的数据
        String k1 = "rocketmq.name-server";
        String k2 = "rocketmq.producer.group";
        while(true){
            Thread.sleep(1000);
            String v1 = config.getProperty("rocketmq.name-server",null);
            String v2 = config.getProperty("rocketmq.producer.group",null);
            System.out.println("Time: " + System.currentTimeMillis() + k1 + ": " + v1 + "," + k2 + ": " + v2);
        }
    }
}
