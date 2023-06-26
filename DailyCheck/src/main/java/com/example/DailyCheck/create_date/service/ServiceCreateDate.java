package com.example.DailyCheck.create_date.service;

import com.example.DailyCheck.create_date.DAO.FailedTransDate;

import java.util.Date;
import java.util.HashMap;

public class ServiceCreateDate {

    private final FailedTransDate failedTransDate;

    public ServiceCreateDate(){
        failedTransDate = new FailedTransDate();
    }
    public HashMap<String,String> getDate(){
        return failedTransDate.transDate();
    }


}
