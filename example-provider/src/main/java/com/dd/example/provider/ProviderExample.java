package com.dd.example.provider;

import com.dd.ddrpc.RpcApplication;
import com.dd.ddrpc.config.RegistryConfig;
import com.dd.ddrpc.config.RpcConfig;
import com.dd.ddrpc.model.ServiceMetaInfo;
import com.dd.ddrpc.registry.LocalRegistry;
import com.dd.ddrpc.registry.Registry;
import com.dd.ddrpc.registry.RegistryFactory;
import com.dd.ddrpc.server.tcp.VertxTcpServer;
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
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
