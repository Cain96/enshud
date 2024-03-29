package enshud.s3.checker.Helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Cain96 on 2017/02/06.
 */
public class FileRead {

    public void fileRead(String inputFileName) {

        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(inputFileName);
            br = new BufferedReader(fr);
            SyntaxCheck syntaxCheck = new SyntaxCheck();

            String line;
            line = br.readLine();
            br = syntaxCheck.syntaxCheck(line, br);
            if (br != null) {
                br.close();
                fr.close();
                System.out.println("OK");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}
