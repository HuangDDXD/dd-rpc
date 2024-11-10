package com.dd.ddrpc.loadbalancer;

import com.dd.ddrpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

/**
 *  负载均衡（消费端使用）
 */
public interface LoadBalancer {

    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);
}
