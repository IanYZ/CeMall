package com.demo.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.shop.common.ReturnData;
import com.demo.shop.common.StateCode;
import com.demo.shop.entity.add.OrderDemandAdd;
import com.demo.shop.entity.find.OrderFind;
import com.demo.shop.entity.find.ServiceFind;
import com.demo.shop.mapper.AdminMapper;
import com.demo.shop.mapper.UserMapper;
import com.demo.shop.service.AdminService;
import com.demo.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Author: yys
 * @Date: 2022/5/19 19:30
 */
@Service
public class AdminServiceImpl implements AdminService {
    //还得加 查看自己的历史订单（包括还没完成的） 通过这个可以获得orderId号码和serviceId
    //
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Resource
    AdminMapper adminMapper;

    @Override
    public ReturnData<IPage<ServiceFind>> allService(Page<ServiceFind> page){
        List<ServiceFind> serviceFinds = adminMapper.allService();
        page.setRecords(serviceFinds);
        return new ReturnData<>(StateCode.SUCCESS.getCode(),
                StateCode.SUCCESS.getMsg(), page);
    }
    @Override
    public ReturnData<IPage<OrderFind>> allOrder(Page<OrderFind> page){
        List<OrderFind> orderFinds = adminMapper.allOrder();
        page.setRecords(orderFinds);
        return new ReturnData<>(StateCode.SUCCESS.getCode(),
                StateCode.SUCCESS.getMsg(), page);

    }

//    @Scheduled(cron = "0 0 1 *  * ?")
    @Override
    public void updateRate(){
        try{
//            //update sql语句 使用加权将此服务的订单评分计算，更新到服务表中service_total
//            List<ServiceRate> currentRates = OrderMapper.getOrderRate();
//            for(ServiceRate serviceRate:currentRates){
//                userDemandMapper.submitComment(serviceRate.getId(),serviceRate.getQualityScore(),serviceRate.getSpeedScore(),serviceRate.getAttitudeScore());
//            }
//            logger.info("更新评分成功！");
        }catch (Exception e){
            logger.error("更新评分失败",e);
        }


    }


}