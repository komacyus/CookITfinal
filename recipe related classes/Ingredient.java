package com.example.mycookit.Classes;

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
    private int conversion;
    private String url;
    

    public Ingredient(String name, int inputType, int conversion, String url) {
        this.name = name;
        this.inputType = inputType;
        this.conversion = conversion;
        this.url = url;
    }

    /*
    public double getAsGlass() {
        
    }

    public double getAsKilo() {

    }

    public double getAsVolume() {

    }

    public int getAsUnit() {

    }
    
    public int getAsTableSpoon(){
    
    }
    
    public int getAsTeaSpoon(){
    
    }
    
    
    */

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

    public void setUrl(int url) {
        this.url = url;
    }

    public int getUrl() {
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