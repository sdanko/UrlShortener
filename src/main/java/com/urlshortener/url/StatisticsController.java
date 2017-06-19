package com.urlshortener.url;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    @GetMapping(value="/admin/statistics")
    public String index(){
        return "index";
    }
}
