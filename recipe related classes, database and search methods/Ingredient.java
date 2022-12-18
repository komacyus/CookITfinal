package com.example.recipeclasses;

import java.io.IOException;

public class Ingredient {
    private String name;
    /** 
     * 0 for unit 
     * 1 for kilo
     * 2 for volume
     * 3 for glass
     * 4 for spoon
     */

    private int inputType;
    private int consumeType;
    private int conversion;
    private String inputTypeString;
    private String consumeTypeString;
    private String url;
    private String priceFromWebsite;
    private String amountForPriceFromWebsite;
    private PriceScraper ps;
    private double PricePerInputTypeUnit;
    private double PricePerConsumeTypeUnit;
    

    public Ingredient(String name, int inputType, int consumeType, int conversion, String url) throws IOException {
        this.name = name;
        this.inputType = inputType;
        this.consumeType = consumeType;
        this.conversion = conversion;


        this.url = url;
        ps = new PriceScraper(url);
        priceFromWebsite = ps.getPriceFromURL();
        amountForPriceFromWebsite = ps.getAmountFromURL();


        setTypeNameStrings();

        setPricePerInputTypeUnit();
        setPricePerConsumeTypeUnit();


    }

    public void setPricePerInputTypeUnit(){


        String priceWithoutTLSign = priceFromWebsite.substring(1);
        String commaReplacedDotPrice = priceWithoutTLSign.replace(',','.');
        Double doubleCommaReplacedDotPrice = Double.parseDouble(commaReplacedDotPrice);
        String StringAmountForPriceFromWebsite =  amountForPriceFromWebsite;
        Double doubleAmountForPriceFromWebsite = Double.parseDouble(StringAmountForPriceFromWebsite);

        this.PricePerInputTypeUnit = doubleCommaReplacedDotPrice/doubleAmountForPriceFromWebsite;
        this.PricePerInputTypeUnit = round(PricePerInputTypeUnit , 2);
    }

    public void setPricePerConsumeTypeUnit(){
        if(inputType==consumeType){
            PricePerConsumeTypeUnit = getPricePerInputTypeUnit();
        }

        else {
            String priceWithoutTLSign = priceFromWebsite.substring(1);
            String commaReplacedDotPrice = priceWithoutTLSign.replace(',', '.');
            String trimmedAmountFromWebsiteString = amountForPriceFromWebsite.replaceAll("\\D", "");
            double amountFromWebsiteDouble = Double.parseDouble(trimmedAmountFromWebsiteString);
            double amountFromWebsiteAsConsumeType = amountFromWebsiteDouble * conversion;


            this.PricePerConsumeTypeUnit = Double.parseDouble(commaReplacedDotPrice) / amountFromWebsiteAsConsumeType;
            this.PricePerConsumeTypeUnit = round(PricePerConsumeTypeUnit, 2);
        }
    }

    public void setTypeNameStrings(){

        if(inputType==0){this.inputTypeString = "unit";}
        else if(inputType==1){this.inputTypeString = "kg";}
        else if(inputType==2){this.inputTypeString = "glass";}
        else{this.inputTypeString="spoon";}

        if(consumeType==0){this.consumeTypeString="unit";}
        else if(consumeType==1){this.consumeTypeString="kg";}
        else if(consumeType==2){this.consumeTypeString="glass";}
        else{this.consumeTypeString="spoon";}

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public double getPricePerConsumeTypeUnit() {
        return PricePerConsumeTypeUnit;
    }

    public double getPricePerInputTypeUnit() {
        return PricePerInputTypeUnit;
    }

    public String getPriceFromWebsite() {
        return priceFromWebsite;
    }

    public int getConsumeType() {
        return consumeType;
    }

    public void setAmountForPriceFromWebsite(String amountForPriceFromWebsite) {
        this.amountForPriceFromWebsite = amountForPriceFromWebsite;
    }

    public void setConsumeType(int consumeType) {
        this.consumeType = consumeType;
    }

    public void setConsumeTypeString(String consumeTypeString) {
        this.consumeTypeString = consumeTypeString;
    }

    public void setInputTypeString(String inputTypeString) {
        this.inputTypeString = inputTypeString;
    }



    public String toString() {
        return name + " " + inputType + " " + conversion;
    }

    public int getConversion() {
        return conversion;
    }

    public void setConversion(int conversion) {
        this.conversion = conversion;
    }

    public int getInputType() {
        return inputType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    public void setInputType(int inputType) {
        this.inputType = inputType;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}