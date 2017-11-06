package enshud.s4.compiler.Helper.Output;

import static enshud.s4.compiler.Helper.FileRead.output;
import static enshud.s4.compiler.Helper.Output.Variables.getArrayIndex;
import static enshud.s4.compiler.Helper.Output.Variables.incArrayIndex;

public class IO {
    private int id;

    public void setWriteBuf(boolean allArray) {
        Write write = new Write();
        int id = getId();
        if (id == 45) {
            write.addLine("POP", "GR2");
            write.addLine("POP", "GR1");
            write.addLine("CALL", "WRTSTR");
        } else if (id == 4) {
            write.addLine("POP", "GR2");
            write.addLine("CALL", "WRTCH");
        } else {
            write.addLine("POP", "GR2");
            write.addLine("CALL", "WRTINT");
        }
        if (allArray){
            write.addLine("ADDA", "GR2, =1");
            write.addLine("JUMP", "ARRAY" + getArrayIndex());
            write.addLabel("ENDARRAY" + getArrayIndex());
            incArrayIndex();
        }
        output.addFile(write.getBuf());
    }

    public void pushString(int length, int index) {
        Write write = new Write();
        write.addLine("LD", "GR1, =" + length);
        write.addLine("PUSH", "0, GR1");
        write.addLine("LAD", "GR2, STR" + index);
        write.addLine("PUSH", "0, GR2");
        output.addFile(write.getBuf());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void endWrite() {
        Write write = new Write();
        write.addLine("CALL", "WRTLN");
        output.addFile(write.getBuf());
        write.buf = null;
    }
}
