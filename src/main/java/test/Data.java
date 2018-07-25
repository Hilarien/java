package test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;

/**
 * Created by vladimir on 23.07.2018.
 */
public class Data {
    private String message;
    private Integer number;
    @JsonFormat(pattern="MM/dd/yyyy")
    private Calendar date;

    public Data(String message, Integer number, Calendar date) {
        this.message = message;
        this.number = number;
        this.date = date;
        this.date.add(Calendar.DATE,1);
    }

    public  void setString (String message) {
        this.message = message;
    }

    public  void setInteger (Integer number) {
        this.number = number;
    }

    public String getString () {
        return message;
    }

    public Integer getInt () {
        return number;
    }

    public Calendar getDate () {
        return date;
    }

}
