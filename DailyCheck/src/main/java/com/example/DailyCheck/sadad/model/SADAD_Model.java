package com.example.DailyCheck.sadad.model;

public class SADAD_Model {

    private String source;
    private String create_date;

    public SADAD_Model() {
    }

    public SADAD_Model(String source, String create_date) {
        this.source = source;
        this.create_date = create_date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

}
