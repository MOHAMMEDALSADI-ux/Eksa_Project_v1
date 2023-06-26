package com.example.DailyCheck.sadad;

import com.example.DailyCheck.connection.ConnectionManager;
import com.example.DailyCheck.sadad.model.SADAD_Model;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/SADAD")
public class Fetch_SADAD_INFO {

    @GetMapping("/INFO")
    public static ResponseEntity<List<SADAD_Model>> CheckLLastPayment() {

        System.err.println("INFO : SADAD API STARTUP");

        List<SADAD_Model> SADADModels = new ArrayList<SADAD_Model>();

        try {

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("select source 'API_NAME', max(CREATE_DATE) 'RECEIVED_DATE' ");
            queryBuilder.append("from `revamp_design_engines`.`bmd_srva_trans_api` ");
            queryBuilder.append("where CREATE_DATE <= sysdate() and SOURCE like 'SADAD-%' ");
            queryBuilder.append("group by source;");


            JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();
            jdbcTemplate.query(queryBuilder.toString() , rs -> {
                SADAD_Model SADADModel = new SADAD_Model();
                SADADModel.setSource(rs.getString("API_NAME"));
                SADADModel.setCreate_date(rs.getString("RECEIVED_DATE"));
                SADADModels.add(SADADModel);
            });


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.ok().body(SADADModels);
    }
}
