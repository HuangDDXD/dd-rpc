package com.dd.example.provider;

import cn.hutool.core.net.NetUtil;
import com.dd.ddrpc.RpcApplication;
import com.dd.ddrpc.config.RegistryConfig;
import com.dd.ddrpc.config.RpcConfig;
import com.dd.ddrpc.model.ServiceMetaInfo;
import com.dd.ddrpc.registry.LocalRegistry;
import com.dd.ddrpc.registry.Registry;
import com.dd.ddrpc.registry.RegistryFactory;
import com.dd.ddrpc.server.HttpServer;
import com.dd.ddrpc.server.VertxHttpServer;
import com.dd.example.common.service.UserService;

/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        Registry registry = RegistryFactory.getInstance(rpcConfig.getRegistryConfig().getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
