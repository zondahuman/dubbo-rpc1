package com.abin.lee.dubbo.rpc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by abin on 2017/9/7 13:52.
 * march-svr
 * com.abin.lee.march.svr.dubbo.model
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderInfo implements Serializable {

    private Integer id;
    private String businessName;
    private BigDecimal price;
    private Date createTime;

    public static class BasicInfo{
        private List<BigDecimal> basicPrice;
        private Map<String, BigDecimal> multiPrice;
        private Set<BigDecimal> basicDesc;
    }

}
