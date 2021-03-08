package io.redtrack.app.messages;

import java.util.Date;
import io.redtrack.app.variable.Variables;

public class Mess {

    public static Date date;
    public static String
    a0 = "Initialization",
    a1 = "initialization",
    a25 = "initialized",
    a3 = "Open",
    a4 = "open",
    a5 = "Opening",
    a6 = "opening",
    a7 = "Opened",
    a8 = "opened",
    a9 = "Save",
    a10 = "save",
    a11 = "Saving",
    a12 = "saving",
    a13 = "Saved",
    a14 = "saved",
    a15 = "Close",
    a16 = "close",
    a17 = "Closing",
    a18 = "closing",
    a19 = "Closed",
    a20 = "closed",
    a21 = "Back",
    a22 = "back",
    a23 = "Found",
    a24 = "found",
    a26 = "Create",
    a27 = "create",
    a28 = "created",
    a29 = "choosing",
    a30 = "creating",


    b0 = "Success",
    b1 = "success",
    b2 = "Failed",
    b3 = "failed",
    b4 = "passed",

    c0 = "Page",
    c1 = "page",
    c2 = "Pages",
    c3 = "pages",
    c4 = "Dashboard",
    c5 = "Campaigns",
    c6 = "Campaign",
    c7 = "Offers",
    c8 = "Offer",
    c9 = "Networks",
    c10 = "Network",
    c11 = "Traffic Sources",
    c12 = "Traffic Source",
    c13 = "Domains",
    c14 = "Domain",
    c15 = "Logs",
    c16 = "Clicks",
    c17 = "Click",
    c18 = "click",
    c19 = "Conversions",
    c20 = "Conversion",
    c21 = "conversion",
    c22 = "Postbacks",
    c23 = "Postback",
    c24 = "postback",
    c25 = "driver",
    c26 = "Driver",
    c27 = "Test",
    c28 = "test",
    c29 = "Login",
    c30 = " +NEW ",

    add1 = "s",
    add2 = "[",
    add3 = "]",
    add4 = ":",
    add5 = "not",
    add6 = " ",
    add7 = "full",
    add8 = "'",
    add9 = ",",
    add10 = ".",
    add11 = "is",
    add12 = "-> ",
    add13 = "of",
    add14 = "new",


    i1 = "INFO",
    i2 = "ERROR";

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";

    public static void ansi_reset(){
        System.out.print(ANSI_RESET);
    }

    public static void error(){
        date = new Date();
        System.out.print(ANSI_RED+add2+i2+add3+add2+date+add3+add4+add6);
    }

    public static void newdDateInfo() {
        date = new Date();
        System.out.print(add2+i1+add3+add2+date+add3+add4+add6);
    }

    public static void initDriver(){
        System.out.println(a0+add6+c25);
    }

    public static void initDriverSuccess(){
        System.out.println(c26+add6+a25+add6+b1);
    }

    public static void openingPage(){
        System.out.println(a5+add6+c1+add6+Variables.urlProd);
    }

    public static void openedPage(){
        System.out.println(c0+add6+Variables.urlProd+add6+b1+add7+add6+a8);
    }

    public static void testTest(){
        System.out.print(c27+add6+add8);
    }

    public static  String passedPassed(){
        String aaa= "add8+add6+b4+add9+add6+a24+add4";
        System.out.print(add8+add6+b4+add9+add6+a24+add4);
        return aaa;

    }

    public static void nextLine(){
        System.out.println(add6);
    }

    public static void failedFailed(){
        System.out.print(add8+add6+b3+add9+add6+a24+add4);
    }

    public static void loginLogin(){
        System.out.print(c29);
    }

    public static void traffSource(){
        System.out.print(c11);
    }

    public static void passedOpenedPage(){
        System.out.print(a7+add6+c1+add6+add11+add4+add6);
    }
    public static void dotAdd(){
        System.out.print(add10+add6);
    }

    public static void createSomeObject(){
        System.out.print(c27+add6+add13+add6+a29+add6+add14+add6+add8);
    }

    public static void createSomeObject2(){
        System.out.print(c27+add6+add13+add6+a30+add6+add8);
   }


//This comment is fixing this class, crashing w/o it

}