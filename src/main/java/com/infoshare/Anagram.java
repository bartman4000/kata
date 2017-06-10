package com.infoshare;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bartman3000 on 10.06.17.
 */
public class Anagram {


    public Boolean check(String str1, String str2)
    {
        String [] arr1 = str1.split("");
        String [] arr2 = str2.split("");
        Arrays.sort(arr1);
        Arrays.sort(arr2);


        if(Arrays.equals(arr1, arr2))
        {
            return true;
        }
        return false;
    }

    public Boolean check(String[] args)
    {
        String[] args2 = args;
        for(int i = 0; i < args.length; i++)
        {
            for (int j = 1; j < args2.length; j++) {

                if(!args[i].equals(args2[j]))
                {
                    String s1 = args[i];
                    String s2 = args2[j];
                    System.out.println(s1 + "-"+ s2);

                    if(this.check(s1,s2))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}





