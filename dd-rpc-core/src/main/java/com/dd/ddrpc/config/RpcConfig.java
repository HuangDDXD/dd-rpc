package com.dd.ddrpc.config;

import lombok.Data;

/**
 *  RPC 框架配置
 */
@Data
public class RpcConfig {

    private String name = "dd-rpc";

    private String version = "1.0";

    private String serverHost = "localhost";

    private Integer serverPort = 8080;

    private boolean mock = false;
}
