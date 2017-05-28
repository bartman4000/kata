package com.infoshare.string_calculator_kata;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 - Create a simple String calculator with a method int Add(string numbers)
 - The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
 - Start with the simplest test case of an empty string and move to 1 and two numbers
 - Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
 - Remember to refactor after each passing test
 - Allow the Add method to handle an unknown amount of numbers
 - Allow the Add method to handle new lines between numbers (instead of commas).
 - the following input is ok:  “1\n2,3”  (will equal 6)
 - the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
 Support different delimiters
 - to change a delimiter, the beginning of the string will contain a separate line that looks like this:   “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
 - the first line is optional. all existing scenarios should still be supported
 - Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message

 - Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
 - Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
 - Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
 - Make sure you can also handle multiple delimiters with length longer than one char
 */
public class Kata {

    public int Add(String string)
    {
        if(string.isEmpty())
        {
            return 0;
        }

        /*
        take group of numbers and delimeters from given string
         */
        String pattern = "^(//(.+)\n)?(.*)$";
        List<String> delimeters = new ArrayList<>();
        String numbersGroup = "";

        Pattern p = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher m = p.matcher(string);
        if (m.find( ))
        {
            numbersGroup = m.group(3);
            delimeters = this.prepareDelimeters(m);
        }

        /*
        get numbers by diving group of numbers with delimeters
         */
        String[] stringNumbers = new String[]{};
        if(!delimeters.isEmpty())
        {
            String regex = "";
            for(String del : delimeters)
            {
                del = del.replace("*","\\*");//in case when the delimeter is asterisk
                regex = regex + del+"|";
            }
            stringNumbers = numbersGroup.split(regex);
        }
        else
        {
            stringNumbers = numbersGroup.split(",|\n");
        }

        /*
        make actual adding numbers
         */
        List<Integer> negativeNumbers = new ArrayList<>();
        Integer sum = 0;

        for (String stringNumber : stringNumbers)
        {
            if(stringNumber.isEmpty())
            {
                continue;
            }

            int number = Integer.parseInt(stringNumber);
            if(number<0)
            {
                negativeNumbers.add(number);
            }
            if(number > 1000)
            {
                number = 0;
            }

            sum = sum + number;
        }

        if(negativeNumbers.size() > 0)
        {
            throw new IllegalStateException("negatives not allowed " + negativeNumbers.toString());
        }

        return sum;
    }


    public List<String> prepareDelimeters(Matcher m)
    {
        List<String> delimeters = new ArrayList<>();
        String delimeterGroup = m.group(2);

        if(delimeterGroup != null)
        {
            if(delimeterGroup.contains("["))
            {
                String pattern2 = "\\[([^\\[\\]]+)\\]";
                Pattern p2 = Pattern.compile(pattern2, Pattern.DOTALL);
                Matcher m2 = p2.matcher(delimeterGroup);

                while (m2.find())
                {
                    delimeters.add(m2.group(1));
                }
            }
            else
            {
                delimeters.add(delimeterGroup);
            }
        }
        return delimeters;
    }

}
