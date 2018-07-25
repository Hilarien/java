package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

/**
 * Created by vladimir on 23.07.2018.
 */
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@RestController
@ComponentScan
@EnableAsync
public class Controller
{
    private static ArrayList<Data> list = new ArrayList<>();

    @Autowired
    private Get get;
    @Autowired
    private Put put;

    @GetMapping("/put")
    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public void put(@RequestParam(name="name") String name,
                    @RequestParam(name="number") String integer,
                    @RequestParam(name="date") String date) {
      put.put(list, name, integer, date);
    }

    @GetMapping("/get")
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public List<Data>get() {
        get.get(list);
        return list;
    }
}
