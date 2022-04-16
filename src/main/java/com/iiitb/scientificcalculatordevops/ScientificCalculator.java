package com.iiitb.scientificcalculatordevops;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

@RestController
public class ScientificCalculator {
    private static final Logger logger = LogManager.getLogger("ScientificCalculator");

    @RequestMapping(value = "/power",method = RequestMethod.POST)
    public double power(@RequestBody Map<String,Object> payload){
        double res;
        double input1 = Double.parseDouble((String) payload.get("input1"));
        double input2 = Double.parseDouble((String) payload.get("input2"));
        logger.info();
        res = Math.pow(input1,input2);
        logger.info("[POWER] - [data] :" + input1 + "^"+input2 + " - [RESULT] : " + res);
        return res  ;
    }


    @RequestMapping(value = "/sqrt",method = RequestMethod.POST)
    public double sqrt(@RequestBody Map<String,Object> payload){
        double res;
        double input1 = Double.parseDouble((String) payload.get("input1"));
        res = Math.sqrt(input1);
        logger.info("[SQRT] - [data] :" + input1  + " - [RESULT] : " + res);
        return res  ;
    }

    @RequestMapping(value = "/fact",method = RequestMethod.POST)
    public double fact(@RequestBody Map<String,Object> payload){
        double res= 1;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        for(double i=1;i<=input1;i++)
            res = res*i;
        logger.info("[FACTORIAL] - [data] :" + input1  + " - [RESULT] : " + res);

        return res;
    }

    @RequestMapping(value = "/log",method = RequestMethod.POST)
    public double log(@RequestBody Map<String,Object> payload){
        double res;
        double input1 = Double.parseDouble((String) payload.get("input1"));

        res = Math.log10(input1);
        logger.info("[LOG10] - [data] :" + input1  + " - [RESULT] : " + res);

        return res  ;
    }

}
