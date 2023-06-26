package com.example.DailyCheck.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Generator {

    public static String welcomeMessage()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("-----------------------------------------------------------------------------");
        builder.append("\n");
        builder.append(Constraints.COMPANY);
        builder.append("\n");
        builder.append(Constraints.NAME);
        builder.append(" ");
        builder.append(Constraints.VERSION);
        builder.append("\n");
        builder.append(Constraints.COPY_RIGHTS);
        builder.append("\n");
        builder.append("Started on ").append(Generator.getFormattedLocalDataAndTime());
        builder.append("\n");
        builder.append("-----------------------------------------------------------------------------");
        builder.append("\n");

        return builder.toString();
    }

    public static String getFormattedLocalDataAndTime()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:ss");
        return now.format(formatter);
    }

}
