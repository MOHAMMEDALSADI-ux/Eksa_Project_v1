package com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.GetCRMEvent.CRMInfo;

import com.example.DailyCheck.connection.ConnectionManager;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetRequestAndResponse {

    private static GetRequestAndResponse instance;

    public static GetRequestAndResponse getInstance() {

        if (instance == null) {
            instance = new GetRequestAndResponse();
        }
        return instance;
    }

    // + is Batch
    public void getReqAndRes(Integer transaction_id , Integer trans_api , String eventCode) {

        try {

            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM `go_engines`.bmd_srva_generated_cmds ");
            query.append("WHERE TRANSACTION_ID IN (?) ");
            query.append("ORDER BY GEM_ID DESC;");

            JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

            jdbcTemplate.query(query.toString() , rs -> {

                String ex_request = rs.getString("EX_REQUEST");
                String response_msg = rs.getString("RESPONSE_MSG");
                String create_date = rs.getString("CREATE_DATE");
                Integer status = rs.getInt("STATUS");

            } , transaction_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
