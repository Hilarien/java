package test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Future;

/**
 * Created by vladimir on 25.07.2018.
 */

@Service
public class Put {

    @Async
    public Future<ArrayList<Data>> put(ArrayList<Data> list, String name, String integer, String date){
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("MM/dd/yyyy");
            cal.setTime(format.parse(date));
            list.add(new Data(name, Integer.parseInt(integer),cal));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return new AsyncResult<ArrayList<Data>>(list) ;
    }

}
