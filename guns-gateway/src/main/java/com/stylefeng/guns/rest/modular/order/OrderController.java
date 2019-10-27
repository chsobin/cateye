package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/order/")
public class OrderController {


    // private static TokenBucket tokenBucket = new TokenBucket();

    @Reference(interfaceClass = OrderServiceAPI.class, check = false)
    private OrderServiceAPI orderServiceAPI;

/*
    @Reference(interfaceClass = OrderServiceAPI.class, check = false, timeout = 8000, group = "order2017", filter = {"tracing"})
    private OrderServiceAPI orderServiceAPI2017;

    @Reference(interfaceClass = AliPayServiceAPI.class, check = false, filter = {"tracing"})
    private AliPayServiceAPI aliPayServiceAPI;

    @Value("${img.pre}")
    public String IMG_PRE;

*/
    /**
     * 服务降级方法，注意参数需要一致
     *
     * @param fieldId
     * @param soldSeats
     * @param seatsName
     * @return
     */
    public ResponseVO error(Integer fieldId, String soldSeats, String seatsName) {
        return null;
    }

    /**
     * 用户下单购票
     *
     * @param fieldId   场次编号
     * @param soldSeats 购买座位编号
     * @param seatsName 购买座位名称
     * @return
     */
    @RequestMapping(value = "buyTickets", method = RequestMethod.POST)
    public ResponseVO buyTickets(Integer fieldId, String soldSeats, String seatsName) {
        try {
            // 验证售出的座位是否存在
            boolean isTrue = orderServiceAPI.isTrueSeats(fieldId+"", soldSeats);

            // 判断是否有座位已经被买过
            boolean isNotSold = orderServiceAPI.isNotSoldSeats(fieldId+"", soldSeats);

            if(isTrue && isNotSold){
                // 创建订单
                String userId = CurrentUser.getCurrentUserId();
                if(userId==null || userId.trim().length()==0){
                    return ResponseVO.serviceFail("用户位登录");
                }

                OrderVO orderVO = orderServiceAPI.saveOrderInfo(fieldId, soldSeats, seatsName, Integer.parseInt(userId));
                if(orderVO == null ){
                    log.error("购票未成功");
                    return ResponseVO.serviceFail("购票业务异常");
                }else{
                    return ResponseVO.success(orderVO);
                }
            }else{
                return ResponseVO.serviceFail("订单中的座位编号有问题");
            }
        }catch (Exception e){
            log.error("购票业务异常", e);
            return ResponseVO.serviceFail("购票业务异常");
        }

    }

    /**
     * 获取订单信息
     *
     * @param nowPage  当前页
     * @param pageSize 每页多少条
     * @return
     */
    @RequestMapping(value = "getOrderInfo", method = RequestMethod.POST)
    public ResponseVO getOrderInfo(
            @RequestParam(name = "nowPage", required = false, defaultValue = "1") Integer nowPage,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        // 获取当前登陆人的信息
        String userId = CurrentUser.getCurrentUserId();

        // 使用当前登录人获取已经购买的订单
        Page<OrderVO> page = new Page<>(nowPage, pageSize);
        if(userId!=null && userId.trim().length()>0){
            Page<OrderVO> result = orderServiceAPI.getOrderByUserId(Integer.parseInt(userId), page);
            return ResponseVO.success(nowPage, (int)result.getPages(), "", result.getRecords());
        }else{
            return ResponseVO.serviceFail("用户未登录");
        }
    }

    /**
     * 获取支付二维码
     *
     * @param orderId 订单编号
     * @return
     */
    @RequestMapping(value = "getPayInfo", method = RequestMethod.POST)
    public ResponseVO getPayInfo(@RequestParam("orderId") String orderId) {
        return null;
    }

    /**
     * 获取支付结果
     *
     * @param orderId 订单编号
     * @param tryNums 重试次数
     * @return
     */
    @RequestMapping(value = "getPayResult", method = RequestMethod.POST)
    public ResponseVO getPayResult(
            @RequestParam("orderId") String orderId,
            @RequestParam(name = "tryNums", required = false, defaultValue = "1") Integer tryNums) {
        return null;
    }

}