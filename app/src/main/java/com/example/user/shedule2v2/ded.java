package com.example.user.shedule2v2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ded {

    static private int counttime(int hrs, int min){
        return hrs*60+min;
    }

    static public String kogdapara(int i, boolean tea){

        if (tea)
            return "Чай пить никогда не поздно";
        
        String resulstring = "";

        DateFormat dtHours = new SimpleDateFormat("HH");
        DateFormat dtMinutes = new SimpleDateFormat("mm");

        String resultString = "";
        String dtHSTring = dtHours.format(Calendar.getInstance().getTime());
        String dtMSTring = dtMinutes.format(Calendar.getInstance().getTime());

        int IntHrs=Integer.parseInt(dtHSTring);
        int IntMin=Integer.parseInt(dtMSTring);


        int resultInt = counttime(IntHrs, IntMin);
        int selectedpara = 0;
        switch (i){
            case 0: selectedpara = counttime(8, 30);
                break;
            case 1: selectedpara = counttime(10, 15);
                break;
            case 2: selectedpara = counttime(12, 0);
                break;
            case 3: selectedpara = counttime(13, 50);
                break;
            case 4: selectedpara = counttime(15, 40);
                break;
            case 5: selectedpara = counttime(17, 25);
                break;
            case 6: selectedpara = counttime(19, 10);
                break;
        }

        selectedpara -= resultInt;
        
        if (selectedpara <0)
            return "Пара уже началась";

        int resultHrs = selectedpara / 60;
        int resultMin = selectedpara % 60;

        int intminname = resultMin % 10;

        String minname = "";

        if (resultMin >= 10 && resultMin <= 20){
            minname=" минут";
        }else
        {
            switch (intminname){
                case 1:
                    minname = " минута";
                    break;
                case 2:
                    minname = " минуты";
                    break;
                case 3:
                    minname = " минуты";
                    break;
                case 4:
                    minname = " минуты";
                    break;
                default:
                    minname = " минут";
                    break;
            }

        }

        int inthname = resultHrs % 10;

        String hname = "";

        if (resultHrs >= 10 && resultHrs <= 20){
            hname=" часов ";
        }else
        {
            switch (inthname){
                case 1:
                    hname = " час ";
                    break;
                case 2:
                    hname = " часа ";
                    break;
                case 3:
                    hname = " часа ";
                    break;
                case 4:
                    hname = " часа ";
                    break;
                default:
                    hname = " часов ";
                    break;
            }

        }


        if (resultHrs == 0) {

            resultString = "До начала пары " + Integer.toString(resultMin) + minname;

        }else{
        
            resultString = "До начала пары "+Integer.toString(resultHrs)+ hname + Integer.toString(resultMin)+minname;
        }


        return resultString;


    }

    static public String kogdaded(){
        DateFormat dtHours = new SimpleDateFormat("HH");
        DateFormat dtMinutes = new SimpleDateFormat("mm");

        String resultString = "";
        String dtHSTring = dtHours.format(Calendar.getInstance().getTime());
        String dtMSTring = dtMinutes.format(Calendar.getInstance().getTime());

        int IntHrs=Integer.parseInt(dtHSTring);
        int IntMin=Integer.parseInt(dtMSTring);


        int resultInt = IntHrs*60+IntMin;

        boolean parabeg = false;

        if (resultInt <= counttime(8, 30)){
            parabeg = false;
            resultInt = counttime(8,30)-resultInt;
        }

        if (resultInt >= counttime(8, 30)){
            if (resultInt <= counttime(10, 5)){
                parabeg = true;
                resultInt = counttime(10,5)-resultInt;
            }
        }

        if (resultInt >= counttime(10, 5)){
            if (resultInt <= counttime(10, 15)){
                parabeg = false;
                resultInt = counttime(10,15)-resultInt;
            }
        }

        if (resultInt >= counttime(10, 15)){
            if (resultInt <= counttime(11, 50)){
                parabeg = true;
                resultInt = counttime(11,50)-resultInt;
            }
        }

        if (resultInt >= counttime(11, 50)){
            if (resultInt <= counttime(12, 0)){
                parabeg = false;
                resultInt = counttime(12,0)-resultInt;
            }
        }

        if (resultInt >= counttime(12, 0)){
            if (resultInt <= counttime(13, 35)){
                parabeg = true;
                resultInt = counttime(13,35)-resultInt;
            }
        }

        if (resultInt >= counttime(13, 35)){
            if (resultInt <= counttime(13, 50)){
                parabeg = false;
                resultInt = counttime(13,50)-resultInt;
            }
        }

        if (resultInt >= counttime(13, 50)){
            if (resultInt <= counttime(15, 25)){
                parabeg = true;
                resultInt = counttime(15,25)-resultInt;
            }
        }

        if (resultInt >= counttime(15, 25)){
            if (resultInt <= counttime(15, 40)){
                parabeg = false;
                resultInt = counttime(15,40)-resultInt;
            }
        }

        if (resultInt >= counttime(15, 50)){
            if (resultInt <= counttime(17, 15)){
                parabeg = true;
                resultInt = counttime(17,15)-resultInt;
            }
        }

        if (resultInt >= counttime(17, 15)){
            if (resultInt <= counttime(17, 25)){
                parabeg = false;
                resultInt = counttime(17,25)-resultInt;
            }
        }

        if (resultInt >= counttime(17, 25)){
            if (resultInt <= counttime(19, 0)){
                parabeg = true;
                resultInt = counttime(19,0)-resultInt;
            }
        }
        if (resultInt >= counttime(19, 0)){
            if (resultInt <= counttime(19, 10)){
                parabeg = false;
                resultInt = counttime(19,10)-resultInt;
            }
        }

        if (resultInt >= counttime(19, 10)){
            if (resultInt <= counttime(20, 45)){
                parabeg = true;
                resultInt = counttime(20,45)-resultInt;
            }
        }

        if (resultInt >= counttime(20, 45)){
            parabeg = false;
            resultInt = 9999999;
        }

        int resultHrs = resultInt / 60;
        int resultMin = resultInt % 60;

        int intminname = resultMin % 10;

        String minname = "";

        if (resultMin >= 10 && resultMin <= 20){
            minname=" минут";
        }else
        {
            switch (intminname){
                case 1:
                    minname = " минута";
                    break;
                case 2:
                    minname = " минуты";
                    break;
                case 3:
                    minname = " минуты";
                    break;
                case 4:
                    minname = " минуты";
                    break;
                default:
                    minname = " минут";
                    break;
            }

        }

        int inthname = resultHrs % 10;

        String hname = "";

        if (resultHrs >= 10 && resultHrs <= 20){
            hname=" часов ";
        }else
        {
            switch (inthname){
                case 1:
                    hname = " час ";
                    break;
                case 2:
                    hname = " часа ";
                    break;
                case 3:
                    hname = " часа ";
                    break;
                case 4:
                    hname = " часа ";
                    break;
                default:
                    hname = " часов ";
                    break;
            }

        }


        if (resultHrs == 0){

            if (parabeg)
                resultString = "До конца пары "+ Integer.toString(resultMin)+minname;
            else
                resultString = "До начала пары "+ Integer.toString(resultMin)+minname;


        }else{

            if (resultInt == 9999999){
                resultString = "Пары кончились, пора пить чай";
            }else{
                if (parabeg)
                    resultString = "До конца пары "+Integer.toString(resultHrs)+ hname + Integer.toString(resultMin)+minname;
                else
                    resultString = "До начала пары "+Integer.toString(resultHrs)+ hname + Integer.toString(resultMin)+minname;
            }

        }

        return resultString;
    }
}
