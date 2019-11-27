package cn.itcast.travel.service;

import java.util.Map;

public interface WeixinPayService {
    /*
    生成二维码
     */

    public Map createNative(String out_trade_no,String total_fee);
}
