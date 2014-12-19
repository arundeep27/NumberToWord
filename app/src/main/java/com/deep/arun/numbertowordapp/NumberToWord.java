package com.deep.arun.numbertowordapp;

/**
 * Created by Arun on 12/12/2014.
 */
public class NumberToWord {
    private static final String[] bigNames = {""," Thousand"," Million"," Billion"," Trillion", " Quadrillion"," Quintillion"," Sextillion"," Septillion"," Octillion"," Nonillion" };

    private static final String[] tensNames = {""," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};

    private static final String[] numNames = {""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten",
            " Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen" };



    public static String convert(String number) {

        //remove all the leading zeroes
        number = number.replaceFirst("^0+(?!$)", "");

        //if number is 0
        if(number.length()== 1){
            if (Integer.parseInt(number) == 0){
                return "zero";
            }
        }

        String prefix = "";
        String current = "";
        int place = 0;
        int n = 0;

        do {
            if(number.length()>3) {
                n = Integer.parseInt(number.substring(number.length() - 3, number.length()));
                number = number.substring(0,number.length()-3);
            }
            else{
                n = Integer.parseInt(number.substring(0,number.length()));
                number = number.substring(number.length());
                String s = convertLessThanOneThousand(n);
                current = s + bigNames[place] + current;
                break;
            }
            if(n>0){
                String s = convertLessThanOneThousand(n);
                current = s + bigNames[place] + current;
            }
            place++;

        } while (number.length()> 0);

        return (prefix + current).trim();
    }
    private static String convertLessThanOneThousand(int number) {
        String current;
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

}
