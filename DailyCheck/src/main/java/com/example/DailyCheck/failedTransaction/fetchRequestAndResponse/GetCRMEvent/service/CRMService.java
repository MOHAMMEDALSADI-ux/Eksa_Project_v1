package com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.GetCRMEvent.service;

import com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.GetCRMEvent.CRMInfo.GetRequestAndResponse;

public class CRMService {

    public static void fetchCRM(Integer transaction_id , Integer trans_api , String eventCode){

        GetRequestAndResponse.getInstance().getReqAndRes(transaction_id , trans_api, eventCode);
    }
}
