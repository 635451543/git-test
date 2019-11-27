package cn.itcast.travel.service.impl;

import cn.itcast.travel.service.WeixinPayService;
import cn.itcast.travel.util.HttpClient;
import com.github.wxpay.sdk.WXPayUtil;

import java.util.HashMap;
import java.util.Map;

public class WeixinPayServiceImpl implements WeixinPayService {
    @Override
    public Map createNative(String out_trade_no, String total_fee) {
        //参数封装
        Map param = new HashMap();
        param.put("appid","wx8397f8696b538317");
        param.put("mch_id","1473426802");
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        param.put("body", "博旺网络");
        param.put("out_trade_no", out_trade_no);
        param.put("total_fee","5000");
        param.put("spbill_create_ip","127.0.0.1");
        param.put("notify_url","http://a31ef7db.ngrok.io/WeChatPay/WeChatPayNotify");
        param.put("trade_type","NATIVE");
        param.put("sign","T6m9iK73b0kn9g5v426MKfHQH7X8rKwb");
        try {
            String paramXml = WXPayUtil.generateSignedXml(param, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb");
            System.out.println("请求的参数："+paramXml);
            //发送请求
            HttpClient httpClient = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(paramXml);
            httpClient.post();
            //获取结果
            String xmlResult = httpClient.getContent();
            Map<String, String> xmlToMap = WXPayUtil.xmlToMap(xmlResult);
            System.out.println("微信返回结果"+xmlToMap);
            Map map = new HashMap();
            map.put("code_url",xmlToMap.get("code_url"));//生成支付二维码的连接
            map.put("out_trade_no",out_trade_no);
            map.put("total_fee","1");
            return map;


        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }

    }
}
