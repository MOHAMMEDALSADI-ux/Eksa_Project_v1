package com.example.DailyCheck.create_date.DAO;

import com.example.DailyCheck.connection.ConnectionManager;
import com.example.DailyCheck.create_date.model.TemplateCreateDate;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.HashMap;

public class FailedTransDate {

    public  HashMap<String,String> transDate(){

        HashMap<String , String> DateMap = new HashMap<>();

        String getDateQuery = "select SYSDATE() - INTERVAL 1 hour AS previous_Time , DATE_SUB(SYSDATE(), INTERVAL 10 MINUTE) AS present_Time";

        TemplateCreateDate templateCreateDate = new TemplateCreateDate();

        JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

        jdbcTemplate.query(getDateQuery , rs-> {
            DateMap.put("previousDate" , rs.getString("previous_Time"));
            DateMap.put("presentDate" ,  rs.getString("present_Time"));
        });

        return  DateMap;
    }
}
