package com.jinstec;

import org.junit.Test;

/**
 * @author jins
 * @date on 2018/6/11.
 */
public class DataTest {

    @Test
    public void dataTest(){
        String str = "1996,";
        String [] strs = str.split(",");
        for (String string:strs){
            System.out.println(string);
        }
    }
}
