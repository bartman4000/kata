package com.infoshare;

/**
 * Created by bartman3000 on 10.06.17.
 */
public class Anagram {


    public Boolean check(String str1, String str2)
    {
        if(str1.equals(new StringBuffer(str2).reverse().toString()))
        {
            return true;

        }return false;
    }


}





