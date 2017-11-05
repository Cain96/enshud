package enshud.s4.compiler.Helper.Output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {
    private PrintWriter pw;

    public Output(String outputFileName) {
        try {
            File file = new File(outputFileName);
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        } catch (IOException e) {

        }
        /** 初期設定 **/
        writeFile("CASL", "START", "BEGIN");
        writeFile("BEGIN", "LAD", "GR6, 0");
        writeFile("LAD", "GR7, LIBBUF");
    }

    public void writeFile(String label, String order, String op) {
        pw.println(label + "\t" + order + "\t" + op);
    }

    public void writeFile(String order, String op) {
        pw.println("\t" + order + "\t" + op);
    }

    public void addFile(String string) {
        if (string != null) {
            pw.print(string);
        }
    }

    public void closeFile() {
        pw.close();
    }
}
