package test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by vladimir on 23.07.2018.
 */
@EnableWebMvc
@RestController
public class Controller
{
    private static ArrayList<Data> list = new ArrayList<>();


    @GetMapping("/put")
    @RequestMapping(value = "/put")
    public void put(@RequestParam(name="name") String name,
                    @RequestParam(name="number") String integer,
                    @RequestParam(name="date") String date) {
        try{
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("MM/dd/yyyy");
            cal.setTime(format.parse(date));
            list.add(new Data(name, Integer.parseInt(integer),cal));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping("/get")
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Data> getFoosAsJsonFromREST() {
        Collections.sort(list, new ComparatorForDate() {
        });
        if (list.isEmpty()){
            return null;
            }
        else return list;
    }
}
