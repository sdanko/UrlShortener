package com.urlshortener.url;

import com.urlshortener.core.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController extends BaseController{
    @RequestMapping(method = RequestMethod.GET, value="/statistics")
    public String index(Map<String, Object> model){
        model.put("accountId", getAccountId());
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value="/help")
    public String help(){
        return "help";
    }
}
