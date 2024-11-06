package com.dd.ddrpc.config;

import com.dd.ddrpc.serializer.SerializerKeys;
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

    private String serializer = SerializerKeys.JDK;

    private boolean mock = false;
}
