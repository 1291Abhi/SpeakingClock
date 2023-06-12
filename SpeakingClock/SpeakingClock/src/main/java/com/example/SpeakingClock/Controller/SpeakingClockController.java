package com.example.SpeakingClock.Controller;

import com.example.SpeakingClock.Service.SpeakingClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clock")
public class SpeakingClockController {
    @Autowired
    SpeakingClockService clockService;
    @GetMapping("/time_convertor")
    public ResponseEntity timeConvertor(@RequestParam String time){
        String timeInWords=clockService.convertTimeToString(time);
        return new ResponseEntity(timeInWords, HttpStatus.OK);
    }

}
