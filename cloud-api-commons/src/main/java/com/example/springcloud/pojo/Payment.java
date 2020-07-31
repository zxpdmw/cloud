package com.example.springcloud.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-05 22:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment implements Serializable {

    private Integer id;

    private String serial;
}
