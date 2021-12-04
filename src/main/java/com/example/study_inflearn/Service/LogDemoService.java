package com.example.study_inflearn.Service;


import com.example.study_inflearn.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Provider;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final Provider<MyLogger> myLoggerProvider;


    public String getUuid() {
        MyLogger myLogger = myLoggerProvider.get();
        return myLogger.getUuId();
    }
}
