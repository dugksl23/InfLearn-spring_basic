package com.example.study_inflearn.web;


import com.example.study_inflearn.Service.LogDemoService;
import com.example.study_inflearn.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //    private final Provider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("/log-demo")
    @ResponseBody
    public String getLog(HttpServletRequest request) {
        System.out.println("my loger : " + myLogger.getClass());
        String requestUrl = request.getRequestURI();
//        MyLogger myLogger = myLoggerProvider.get();
        myLogger.setRequestURL(requestUrl);

        myLogger.log("controller test");
        myLogger.setUuId(logDemoService.getUuid());

        return "ok";

    }

}
