package enshud.s4.compiler.Helper.Semantics;

import enshud.s4.compiler.Helper.Semantics.Variable.Declared;

public class Function {
    private Declared declared;
    private int index;
    private static int functionIndex = 0;

    public Function(Declared declared){
        this.declared = declared;
        this.index = functionIndex;
        functionIndex++;
    }

    public Declared getDeclared(){
        return declared;
    }

    public int getIndex(){
        return index;
    }
}
