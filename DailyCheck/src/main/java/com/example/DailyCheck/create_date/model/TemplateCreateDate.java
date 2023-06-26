    package com.example.DailyCheck.create_date.model;

    import java.time.LocalDateTime;

    public class TemplateCreateDate {

        private String previous_Time;
        private String present_Time;

        private static TemplateCreateDate instance;

        public TemplateCreateDate(String previous_Time, String present_Time) {
            this.previous_Time = previous_Time;
            this.present_Time = present_Time;
        }

        public TemplateCreateDate() {
        }


        public static TemplateCreateDate getInstance(){
            if(instance == null){
                instance = new TemplateCreateDate();
            }
            return instance;
        }

        public String getPrevious_Time() {
            return previous_Time;
        }

        public void setPrevious_Time(String previous_Time) {
            this.previous_Time = previous_Time;
        }

        public String getPresent_Time() {
            return present_Time;
        }

        public void setPresent_Time(String present_Time) {
            this.present_Time = present_Time;
        }
    }
