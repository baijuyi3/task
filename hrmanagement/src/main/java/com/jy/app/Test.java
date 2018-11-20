package com.jy.app;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/29.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        Format sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String xxx=sf.format(date);
        Calendar c=Calendar.getInstance();

        String mo=" 09:00:00";
        String d=sf.format(date);
        Date date1=sf1.parse((d+mo));
        System.out.println(date1);
        System.out.println();

//        System.out.println("date:"+date);
//        System.out.println("date:"+sf.format(date));
//        System.out.println("c:"+c);
//        System.out.println("c:"+sf.format(c.getTime()));
//        c.add(Calendar.MONTH,-1);
//        System.out.println("c:"+sf.format(c.getTime()));
//        int a=c.get(Calendar.DATE);
//        System.out.println(a);
//        c.setTime(date);
    }
}
