package com.dd;

import com.dd.ddrpc.config.RpcConfig;
import com.dd.ddrpc.utils.ConfigUtils;


public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        String name = rpc.getName();
        String version = rpc.getVersion();
        String serverHost = rpc.getServerHost();
        Integer serverPost = rpc.getServerPost();
        System.out.println(name);
        System.out.println(version);
        System.out.println(serverHost);
        System.out.println(serverPost);
    }
}
