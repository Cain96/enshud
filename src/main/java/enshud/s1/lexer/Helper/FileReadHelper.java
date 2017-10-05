package enshud.s1.lexer.Helper;

import enshud.s1.lexer.Token.Check;
import enshud.s1.lexer.Token.Separate;
import enshud.s1.lexer.Token.TokenList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Cain96 on 2016/12/21.
 */
public class FileReadHelper {

    public void fileRead(String inputFileName, String outputFileName) {

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(inputFileName);
            br = new BufferedReader(fr);

            File file = new File(outputFileName);
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            String line;
            int lineNumber = 1;
            TokenList tokenList = new TokenList();
            tokenList.setList();
            Separate separate = new Separate(new OutputHelper(tokenList, new Check()));
            while ((line = br.readLine()) != null) {
                separate.separateLine(line, lineNumber, pw);
                lineNumber++;
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
