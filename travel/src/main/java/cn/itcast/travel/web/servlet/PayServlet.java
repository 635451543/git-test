package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.WeixinPayService;
import cn.itcast.travel.service.impl.WeixinPayServiceImpl;
import cn.itcast.travel.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/payServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = UuidUtil.getUuid();
        WeixinPayService weixinPayService = new WeixinPayServiceImpl();
        Map aNative = weixinPayService.createNative(uuid, "50000");
        System.out.println(aNative.toString()+"----------------");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),aNative);
    }
}
