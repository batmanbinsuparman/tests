package io.redtrack.app.other;

import java.util.Random;
import java.lang.String;


public class Randomizzer {

    public static char[] S;
    public static int length;
    public static String characters;

    public static char[] text;
    public static Random rng;



    public static String randText(){
        text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);



        // S =text;
      // return generateString(Random, String);
    }




    }





