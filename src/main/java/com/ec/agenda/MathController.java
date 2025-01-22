package com.ec.agenda;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    //return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    private Double convertToDouble(String strnumber) {
        if(strnumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strnumber.replaceAll(",", ".");
        if(isNumeric(number))return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strnumber){
        if( strnumber == null )return false;
        String number = strnumber.replaceAll(",",".");
        return number.matches("([\\d|.]+)");
    }
}
