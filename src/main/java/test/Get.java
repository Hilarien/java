package test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by vladimir on 25.07.2018.
 */

@Service
public class Get {

    @Async
    public Future<List<Data>> get(List<Data> list) {
        Collections.sort(list, new ComparatorForDate());
        if (list.isEmpty()){
            return null;
        }
        else return new AsyncResult<List<Data>>(list);
    }
}
