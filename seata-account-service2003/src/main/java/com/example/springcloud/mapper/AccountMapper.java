package com.example.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 16:18
 **/
@Mapper
public interface AccountMapper {
    /**
     * 扣减账户余额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
