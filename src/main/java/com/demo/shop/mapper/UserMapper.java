package com.demo.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.shop.entity.OrderTotal;
import com.demo.shop.entity.find.ServiceFind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author: yys
 * @Date: 2022/5/19 19:31
 */
@Mapper
public interface UserMapper extends BaseMapper<OrderTotal> {
    int register(String userId,String account, String password,String category);

    int login(String account, String password,String category);

    void makeOrder(String orderId, String serviceId, String userId, String price, String cycle,Date createTime);
    void completeOrder(String orderId, String serviceId, String userId,Date completeTime);
    List<ServiceFind> allService(String detectObject,String detectProject);
    //用户提交对某项服务的评分
    void submitComment(@Param("orderId") String orderId, @Param("serviceId") String serviceId, @Param("userId") String userId, @Param("qualityScore") String qualityScore,
                       @Param("speedScore") String speedScore, @Param("attitudeScore") String attitudeScore, @Param("comment") String comment);
}
