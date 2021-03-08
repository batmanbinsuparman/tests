package io.redtrack.app.other;

import io.redtrack.app.messages.Mess;
import io.redtrack.app.variable.Variables;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;

public class ManipWithString {

    public static Variables vars;

    public static final Logger logger = Logger.getLogger(CheckingParam.class.getCanonicalName());

    public static void getSometoDouble() {
        try {
            logger.info("Converting String to double");
            vars.valOfClicks = (Double.parseDouble(vars.CheckCost));
            logger.info("String to double successful converted");
            logger.info("Current 'double' value is: " + vars.valOfClicks);
        }
        catch(Exception e){
            logger.error("Exception "+e.getMessage());
        }
    }

    public static void validArrayLength(){
        vars.asd = vars.newchar.length - 1;
    }

    public static void stringToDouble() {
        try {
            if (vars.CheckCost.contains("-") && vars.CheckCost.contains("$")) {
                vars.newchar = new char[50];
                vars.newchar = vars.CheckCost.toCharArray();
                vars.copyOfRange = new char[50];
                logger.info("Array contains minus value. Current array has " + vars.newchar.length + " elements");
                for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                    System.arraycopy(vars.newchar, 2, vars.copyOfRange, 0, vars.i - 1);
                }
                validArrayLength();
                logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                vars.copyOfRange2 = new String();
                vars.copyOfRange2 = vars.copyOfRange.toString();
                String stringCopyofRange = String.valueOf(vars.copyOfRange);
                vars.checkCost = (Double.parseDouble(stringCopyofRange));
            } else {
                if (vars.CheckCost.contains("-") && vars.CheckCost.contains("%")) {
                    vars.newchar = new char[50];
                    vars.newchar = vars.CheckCost.toCharArray();
                    vars.copyOfRange = new char[50];
                    logger.info("Current array has " + vars.newchar.length + " elements");
                    for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                        System.arraycopy(vars.newchar, 0, vars.copyOfRange, 0, vars.i);
                    }
                    validArrayLength();
                    logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                    vars.copyOfRange2 = new String();
                    vars.copyOfRange2 = vars.copyOfRange.toString();
                    String stringCopyofRange = String.valueOf(vars.copyOfRange);
                    logger.info("Converting 'String' to 'double'");
                    vars.checkCost = (Double.parseDouble(stringCopyofRange));
                    logger.info("'String' to 'double' successful converted");
                    logger.info("Current 'double' value is: " + vars.checkCost);
                    if (vars.CheckCost.contains("-") && vars.CheckCost.contains("%")) {
                        vars.checkCost = -vars.checkCost;
                    }
                } else {
                    if (vars.CheckCost.contains("-")) {
                        vars.newchar = new char[50];
                        vars.newchar = vars.CheckCost.toCharArray();
                        vars.copyOfRange = new char[50];
                        logger.info("Array contains minus value. Current array has " + vars.newchar.length + " elements");
                        for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                            System.arraycopy(vars.newchar, 2, vars.copyOfRange, 0, vars.i - 1);
                        }
                        validArrayLength();
                        logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                        vars.copyOfRange2 = new String();
                        vars.copyOfRange2 = vars.copyOfRange.toString();
                        String stringCopyofRange = String.valueOf(vars.copyOfRange);
                        vars.checkCost = (Double.parseDouble(stringCopyofRange));
                    } else {
                        if (vars.CheckCost.contains("%")) {
                            vars.newchar = new char[50];
                            vars.newchar = vars.CheckCost.toCharArray();
                            vars.copyOfRange = new char[50];
                            logger.info("Current array has " + vars.newchar.length + " elements");
                            for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                                System.arraycopy(vars.newchar, 0, vars.copyOfRange, 0, vars.i);
                            }
                            validArrayLength();
                            logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                            vars.copyOfRange2 = new String();
                            vars.copyOfRange2 = vars.copyOfRange.toString();
                            String stringCopyofRange = String.valueOf(vars.copyOfRange);
                            logger.info("Converting 'String' to 'double'");
                            vars.checkCost = (Double.parseDouble(stringCopyofRange));
                            logger.info("'String' to 'double' successful converted");
                            logger.info("Current 'double' value is: " + vars.checkCost);
                        } else {
                            if (!vars.CheckCost.contains("-") && !vars.CheckCost.contains("$")) {
                                vars.newchar = new char[50];
                                vars.newchar = vars.CheckCost.toCharArray();
                                vars.copyOfRange = new char[50];
                                logger.info("Current array has " + vars.newchar.length + " elements");
                                for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                                    System.arraycopy(vars.newchar, 0, vars.copyOfRange, 0, vars.i + 1);
                                }
                                validArrayLength();
                                logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                                vars.copyOfRange2 = new String();
                                vars.copyOfRange2 = vars.copyOfRange.toString();
                                String stringCopyofRange = String.valueOf(vars.copyOfRange);
                                logger.info("Converting 'String' to 'double'");
                                vars.checkCost = (Double.parseDouble(stringCopyofRange));
                                logger.info("'String' to 'double' successful converted");
                                logger.info("Current 'double' value is: " + vars.checkCost);
                            } else {
                                if (!vars.CheckCost.contains("-")) {
                                    vars.newchar = new char[50];
                                    vars.newchar = vars.CheckCost.toCharArray();
                                    vars.copyOfRange = new char[50];
                                    for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                                        System.arraycopy(vars.newchar, 1, vars.copyOfRange, 0, vars.i);
                                    }
                                    vars.copyOfRange2 = new String();
                                    vars.copyOfRange2 = vars.copyOfRange.toString();
                                    String stringCopyofRange = String.valueOf(vars.copyOfRange);
                                    vars.checkCost = (Double.parseDouble(stringCopyofRange));
                                } else {
                                    if (vars.CheckCost.contains("$")) {
                                        vars.newchar = new char[50];
                                        vars.newchar = vars.CheckCost.toCharArray();
                                        vars.copyOfRange = new char[50];
                                        logger.info("Current array has " + vars.newchar.length + " elements");
                                        for (vars.i = 1; vars.i != vars.newchar.length; vars.i++) {
                                            System.arraycopy(vars.newchar, 1, vars.copyOfRange, 0, vars.i);
                                        }
                                        validArrayLength();
                                        logger.info("New length is: " + vars.asd + ". Created array for " + vars.asd + " elements");
                                        vars.copyOfRange2 = new String();
                                        vars.copyOfRange2 = vars.copyOfRange.toString();
                                        String stringCopyofRange = String.valueOf(vars.copyOfRange);
                                        logger.info("Converting 'String' to 'double'");
                                        vars.checkCost = (Double.parseDouble(stringCopyofRange));
                                        logger.info("'String' to 'double' successful converted");
                                        logger.info("Current 'double' value is: " + vars.checkCost);
                                    } else {

                                        //logger.error("stringToDouble isn't working. Need hotfix");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
            logger.fatal("Something went wrong "+e.getMessage());
        }
    }


    public static void doubleToString() {
        try {
            if (vars.CheckCost.contains("-") && vars.CheckCost.contains("%")) {
                logger.info("checking value before correcting " + vars.checkCost);
                vars.check3 = -vars.checkCost;
                logger.info("Converting 'double' to 'String' with minus value");
                vars.valOfCPC = String.valueOf(vars.check3);
                logger.info("'Double' to 'String' with minus value successful converted");
            } else {
                if (vars.CheckCost.contains("-")) {
                    logger.info("checking value before correcting " + vars.checkCost);
                    vars.check3 = -vars.checkCost;
                    logger.info("Converting 'double' to 'String' with minus value");
                    vars.valOfCPC = String.valueOf(vars.check3);
                    logger.info("'Double' to 'String' with minus value successful converted");
                } else {
                    if (!vars.CheckCost.contains("-")) {
                        logger.info("Converting 'double' to 'String'");
                        vars.valOfCPC = String.valueOf(vars.checkCost);
                        logger.info("'Double' to 'String' successful converted " + vars.valOfCPC);
                    } else {
                        logger.error("doubleToString isn't working. Need hotfix");
                    }
                }
            }
        }
        catch(Exception e){
            logger.fatal("Something went wrong "+e.getMessage());
        }
    }


    public static void checkingDecimal() {
        try {
            if (vars.checkCost < 0.001) {
                logger.info("Correcting decimal... Current value is: " + vars.checkCost);
                DecimalFormat formatter = new DecimalFormat("0.0000");
                vars.valOfCPC = formatter.format(vars.checkCost);
                Mess.newdDateInfo();
                logger.info("Correcting decimal finished... Corrected value is: " + vars.valOfCPC);
            } else {
                doubleToString();
            }
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }


}