public class Ingredient {
    private String name;
    /**
     * 0 for unit
     * 1 for kilo
     * 2 for volume
     * 3 for glass
     */
    private int[] inputTypes = new int[2];
    private int conversion;


    public Ingredient(String name, int inputType, int conversion) {
        this.name = name;
        if (inputType > 9) {
            inputTypes[0] = inputType % 10;
            inputType = inputType / 10;
            inputTypes[1] = inputType % 10;
        }
        else {
            inputTypes[0] = inputType;
        }
        this.conversion = conversion;
    }

    /**
     * @return 0 if the ingredient can not be counted with glass
     */
    public double getAsGlass(int a) {
        if ((inputTypes[0] == 3 || inputTypes[1] == 3) && inputTypes.length > 1) {
            return a * conversion;
        }
        else {
            return 0;
        }
    }

    /**
     * @return 0 if the ingredient can not be counted with kilos
     */
    public double getAsKilo(int a) {
        if ((inputTypes[0] == 1 || inputTypes[1] == 1) && inputTypes.length > 1) {
            return a / conversion * 1.0;
        }
        else {
            return 0;
        }
    }
    
    /**
     * @return 0 if the ingredient can not be counted with volume
     */
    public double getAsVolume(int a) {
        if ((inputTypes[0] == 2 || inputTypes[1] == 2) && inputTypes.length > 1) {
            return a / conversion * 1.0;
        }
        else {
            return 0;
        }
    }

    /**
     * @return 0 if the ingredient can not be counted with units
     */
    public int getAsUnit(int a) {
        if ((inputTypes[0] == 0 || inputTypes[1] == 0) && inputTypes.length > 1) {
            return a * conversion;
        }
        else {
            return 0;
        }
    }
    
    public String toString() {
        return name + " " + inputTypes + " " + conversion;
    }

    public int getConversion() {
        return conversion;
    }

    public void setConversion(int conversion) {
        this.conversion = conversion;
    }

    public int[] getInputTypes() {
        return inputTypes;
    }


    public void setInputType(int inputTypes[]) {
        this.inputTypes = inputTypes;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
