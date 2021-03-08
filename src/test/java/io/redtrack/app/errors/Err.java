package io.redtrack.app.errors;
import io.redtrack.app.messages.Mess;
import io.redtrack.app.variable.Variables;


public class Err {

    public static String
        Err1 = "Something went wrong",
        Err2 = "failed";


    public static void errorN1(){
        //Mess.newdDateInfo();
        Mess.error();
        Mess.testTest();
        System.out.print(Mess.c29);
        Mess.failedFailed();
        //System.out.print(Err1+Mess.a6+Mess.a28+Mess.add6+Mess.add8+Mess.c29+Mess.add8+Mess.add6+Mess.b3+Mess.);
    }

    public static void errorN2(){
        Mess.error();
        Mess.testTest();
        System.out.print(Mess.c11);
        Mess.failedFailed();
    }

    public static void errorN3(){
        Mess.error();
        Mess.createSomeObject();
        System.out.print(Mess.c11);
        Mess.failedFailed();
    }

    public static void errorN4(){
        Mess.error();
        Mess.createSomeObject2();
        System.out.print(Variables.NCTS);
        Mess.failedFailed();
    }


}