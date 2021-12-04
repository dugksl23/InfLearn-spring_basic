package com.example.study_inflearn.Service;


import com.example.study_inflearn.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private MyLogger myLogger;


    public String getUuid() {
        return myLogger.getUuId();
    }
}
