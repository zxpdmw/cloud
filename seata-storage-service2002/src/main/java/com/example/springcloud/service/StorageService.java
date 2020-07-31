package com.example.springcloud.service;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 16:04
 **/
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
