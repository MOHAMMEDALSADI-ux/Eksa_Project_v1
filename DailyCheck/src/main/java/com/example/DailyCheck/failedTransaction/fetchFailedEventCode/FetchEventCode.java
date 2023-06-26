package com.example.DailyCheck.failedTransaction.fetchFailedEventCode;

import com.example.DailyCheck.connection.ConnectionManager;
import com.example.DailyCheck.create_date.service.ServiceCreateDate;
import com.example.DailyCheck.failedTransaction.fetchRequestAndResponse.searchOnEventCode.SearchEventCode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class FetchEventCode {

    public static HashMap<String, String> Dates = new ServiceCreateDate().getDate();
    public static void getAllEventCode() {

        List<String> eventList = new ArrayList<>();

        try {

            StringBuilder EventBuilder = new StringBuilder();
            EventBuilder.append("SELECT EVENT_CODE, COUNT(EVENT_CODE) AS COUNT ");
            EventBuilder.append("FROM `bsa_transactions` ");
            EventBuilder.append("WHERE CREATE_DATE < '" + Dates.get("presentDate") + "' ");
            EventBuilder.append("AND CREATE_DATE > '" + Dates.get("previousDate") + "' ");
            EventBuilder.append("AND status != 4 ");
            EventBuilder.append("GROUP BY EVENT_CODE ");
            EventBuilder.append("ORDER BY COUNT DESC;");

            JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

            jdbcTemplate.query(EventBuilder.toString(), rs -> {
                eventList.add(rs.getString("EVENT_CODE"));
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SearchEventCode.getInstance().eventCode(eventList);
        }
        System.out.println("event List  :  " + eventList);

        Dates.clear();
    }
}
