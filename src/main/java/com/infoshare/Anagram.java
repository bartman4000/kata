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





