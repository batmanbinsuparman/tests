package io.redtrack.app.other;

import io.redtrack.app.messages.Mess;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import io.redtrack.app.other.ManipWithString;
import io.redtrack.app.variable.Variables;
import org.apache.log4j.Logger;

public class CalculatingValues {

    public static  ManipWithString manipulation;
    public static  Variables vars;
    public static final Logger logger = Logger.getLogger(CheckingParam.class.getCanonicalName());
    public static void valueOFcpc() {
        try {
            logger.info("Cost per Clicks is calculating by Cost dividing by Clicks");
            vars.val = vars.checkCost / vars.valOfClicks;
            if (vars.val < 0.001) {
                DecimalFormat formatter = new DecimalFormat("0.0000");
                vars.output = formatter.format(vars.val);
                logger.info("Calculated CPC is: " + vars.output);

            } else {
                vars.val2 = BigDecimal.valueOf(vars.val).setScale(4, RoundingMode.HALF_DOWN).doubleValue();
                logger.info("Calculated CPC is: " + vars.val2);
            }
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }


    public static void valOfProfit() {
        try {
            logger.info("Profit is calculating by **** minus *****");
            vars.val = vars.checkCost - vars.check2;
            vars.val2 = BigDecimal.valueOf(vars.val).setScale(4, RoundingMode.HALF_DOWN).doubleValue();
            logger.info("Calculated Profit is: " + vars.val2);
            if (vars.CheckCost.contains("-")) {
                vars.val2 = -vars.val2;
                logger.info("Value corrected with minus: " + vars.val2);
            } else {
                logger.info("Value doesn't contains minus: " + vars.val2);
            }
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void valOfConver() {
        try {
            logger.info("Conversions is calculating via val of Clicks dividing CR ");
            vars.val2 = vars.valOfClicks / vars.check4 * 100;
            vars.val2 = BigDecimal.valueOf(vars.val2).setScale(2, RoundingMode.HALF_UP).doubleValue();
            logger.info("Calculated Conversions is: " + vars.val2);
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void valOfCPT (){
        try {
            logger.info("Cost Per Transaction is calculating via Cost dividing Transactions ");
            vars.val2 = vars.checkCost / vars.valOfClicks;
            vars.val2 = BigDecimal.valueOf(vars.val2).setScale(4, RoundingMode.HALF_UP).doubleValue();
            logger.info("Calculated Cost Per Transaction is: " + vars.val2);
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void valOfCPA() {
        try {
            logger.info("Calculating CPA");
            vars.val = vars.check2 / vars.valOfClicks;
            vars.val2 = BigDecimal.valueOf(vars.val).setScale(4, RoundingMode.HALF_DOWN).doubleValue();
            logger.info("Calculated CPA is: " + vars.val2);
            if (vars.CheckCost.contains("-")) {
                vars.val2 = -vars.val2;
                logger.info("Value corrected with minus: " + vars.val2);
            } else {
                logger.info("Value doesn't contains minus: " + vars.val2);
            }
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

    public static void valOfTR() {
        try {
            vars.val = (vars.check4 / vars.valOfClicks) * 100; // Высчитывание процента
            vars.val2 = BigDecimal.valueOf(vars.val).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            if (vars.CheckCost.contains("-") && vars.CheckCost.contains("%")) {
                vars.val2 = -vars.val2;
                logger.info("Value corrected with minus: " + vars.val2);
            } else {
                logger.info("Value doesn't contains minus: " + vars.val2);
            }
        }
        catch(Exception e){
            logger.error("Something went wrong "+e.getMessage());
        }
    }

}
