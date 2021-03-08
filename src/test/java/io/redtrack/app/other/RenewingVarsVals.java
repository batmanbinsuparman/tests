package io.redtrack.app.other;

import io.redtrack.app.messages.Mess;
import io.redtrack.app.variable.Variables;
import org.apache.log4j.Logger;

public class RenewingVarsVals {

    public static Variables vars;
    public static final Logger logger = Logger.getLogger(CheckingParam.class.getCanonicalName());

    public static void renewVal() {
        try {
            if (vars.val < 0.001) {
                logger.info("Re-newing Val");
                vars.val3 = vars.output;
                logger.info("Val is re-newed");
                logger.info("Result of new value is: " + vars.val3);
            } else {
                logger.info("Re-newing Val");
                vars.val3 = String.valueOf(vars.val2);
                logger.info("Val is re-newed");
                logger.info("Result of new value is: " + vars.val3);
            }
        }
        catch(Exception e){
            logger.info("Something went wrong "+e.getMessage());
        }
    }

    public static void renewVar() {
        try {
            if (vars.CheckCost.contains("-") && vars.CheckCost.contains("$")) {
                logger.info("Re-newing Var");
                vars.check4 = vars.checkCost;
                logger.info("Var is re-newed. Current Var is: " + vars.check4);

            } else {
                logger.info("Re-newing Var");
                vars.check2 = vars.checkCost;
                logger.info("Var is re-newed. Current Var is: " + vars.check2);
            }
        }
        catch (Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void renewVar2() {
        try {
            logger.info("Re-newing Var2");
            vars.check4 = vars.valOfClicks;
            logger.info("Var2 is re-newed. Current Var2 is: " + vars.check4);
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void renevVar4(){
        vars.valOfClicks = vars.checkCost;
    }

}