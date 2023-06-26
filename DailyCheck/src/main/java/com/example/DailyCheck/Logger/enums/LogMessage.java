package com.example.DailyCheck.Logger.enums;

public class LogMessage {

    public static enum MessageType{ALL,DRIVE,CONV,FILT,DUMP};
    public static enum MessageLevel{ALL,INFO,ERROR,EMERG,WARN,DEBUG,FATAL};

    public static MessageType passMessageType(String msgType){
        if(msgType.toUpperCase().equals("DRIVE")){
            return MessageType.DRIVE;
        }else if(msgType.toUpperCase().equals("CONV")){
            return  MessageType.CONV;
        }else if(msgType.toUpperCase().equals("FILT")){
            return MessageType.FILT;
        }else if(msgType.toUpperCase().equals("DUMP")){
            return  MessageType.DUMP;
        }else {
            return MessageType.ALL;
        }
    }

    public static MessageLevel passMessageLevel(String msgLevel){

        if(msgLevel.toUpperCase().equals("INFO")){
            return MessageLevel.INFO;
        } else if (msgLevel.toUpperCase().equals("ERROR")) {
            return MessageLevel.ERROR;
        }else if (msgLevel.toUpperCase().equals("EMERG")){
            return MessageLevel.EMERG;
        } else if(msgLevel.toUpperCase().equals("WARN")){
            return MessageLevel.WARN;
        } else if (msgLevel.toUpperCase().equals("DEBUG")) {
            return  MessageLevel.DEBUG;
        } else if (msgLevel.toUpperCase().equals("FATAL")) {
            return  MessageLevel.FATAL;
        } else{
            return MessageLevel.ALL;
        }
    }

}
