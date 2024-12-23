package com.dd.ddrpc.loadbalancer;

public interface LoadBalancerKeys {

    /**
     * 轮询
     */
    String ROUND_ROBIN = "roundRobin";

    /**
     * 随机
     */
    String RANDOM = "random";

    /**
     * 一致性 HASH
     */
    String CONSISTENT_HASH = "consistentHash";
}
