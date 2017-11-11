package enshud.s4.compiler.Helper.Output;

public class Argument {
    private String name;
    private boolean isArray;

    public Argument(String name, boolean isArray){
        this.name = name;
        this.isArray = isArray;
    }

    public String getName() {
        return name;
    }

    public boolean isArray() {
        return isArray;
    }
}
