package com.example.SpeakingClock.Service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
public class SpeakingClockService {
    private String hourToString(int hh){
        String hour[]= {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three"
        };
        return hour[hh];
    }

    public String convertTimeToString(String time) {

       int hh,mm;
       try{
            LocalTime localTime=LocalTime.parse(time);
            hh=localTime.getHour();
            mm=localTime.getMinute();
        }catch(Exception e){
            return "Invalid Input";
        }
        if (hh == 12 && mm == 0) {
            return "It's Midday";
        } else if (hh == 0 && mm == 0) {
            return "It's Midnight";
        }
       String hour=hourToString(hh);
       String min=minToString(mm);
       return "It's"+" "+hour+" "+min;
    }

    private String minToString(int mm) {
        String tensDigit[]={"","ten","twenty","thirty","forty","fifty"};
        if(mm==0)
            return "";
        if(mm<=23)
            return hourToString(mm);
        else{
            if(mm%10==0){
                return tensDigit[mm/10];
            }
            else{
                String tensdigit=tensDigit[mm/10];
                mm=mm%10;
                String onceDigit=hourToString(mm);
                return tensdigit+" "+onceDigit;
            }
        }
    }
}
