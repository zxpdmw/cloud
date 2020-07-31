package com.example.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 16:03
 **/
@Mapper
public interface StorageMapper {


    //扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
