package com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.searchOnEventCode;

import com.example.DailyCheck.connection.ConnectionManager;
import com.example.DailyCheck.failedTransaction.fetchFailedEventCode.FetchEventCode;
import com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.GetCRMEvent.service.CRMService;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.HashMap;
import java.util.List;

public class SearchEventCode {

    private static SearchEventCode instance;

    public static SearchEventCode getInstance(){
        if(instance == null){
            instance = new SearchEventCode();
        }
        return instance;
    }

    public void eventCode(List<String> eventList){

        try {

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT * FROM `bmd_srva_generated_cmds`");
            queryBuilder.append(" WHERE status != 4");
            queryBuilder.append(" AND TRANSACTION_ID IN (");
            queryBuilder.append("SELECT TRANSACTION_ID FROM `bsa_transactions`");
            queryBuilder.append(" WHERE CREATE_DATE > '"+FetchEventCode.Dates.get("previousDate")+"' AND CREATE_DATE < '"+FetchEventCode.Dates.get("presentDate")+"'");
            queryBuilder.append(" AND status != 4 AND EVENT_CODE = ?)");
            queryBuilder.append(" ORDER BY CREATE_DATE DESC;");

            JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

            for(String eventCode : eventList) {
                jdbcTemplate.query(queryBuilder.toString(), rs -> {

                    if(rs.next()){   // Query returned data
                        if(eventCode.startsWith("CRM")){  // if event code start with CRM
                            // get response and request from Generated Table
                            Integer transaction_id = rs.getInt("TRANSACTION_ID");
                            Integer trans_api = rs.getInt("TRANS_API_ID");
                            CRMService.fetchCRM(transaction_id , trans_api , eventCode);
                        }else{
                            // this is a sample event move to table trans api for get the request
                            // then move to table generated command for get the response
                            Integer transaction_id = rs.getInt("TRANSACTION_ID");
                            Integer trans_api = rs.getInt("TRANS_API_ID");
                        }

                    }else{  // Query did not return any data
                        // IS Batch Move To Table Generated Command for take the response and request

                        //

                    }

                } , eventCode);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
