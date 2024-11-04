package com.dd.example.provider;

import com.dd.ddrpc.registry.LocalRegistry;
import com.dd.ddrpc.server.VertxHttpServer;
import com.dd.example.common.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web服务
        VertxHttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}