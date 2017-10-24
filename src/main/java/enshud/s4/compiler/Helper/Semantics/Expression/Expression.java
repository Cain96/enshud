package enshud.s4.compiler.Helper.Semantics.Expression;

public class Expression {
    public boolean checkBool(int id) {
        final int BOOL = 3;
        if (id == BOOL) {
            return true;
        }
        return false;
    }
}
