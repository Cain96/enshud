package enshud.s2.parser.Helper.Syntax.Core;

import enshud.s2.parser.Helper.Syntax.Elements.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Cain96 on 2017/03/05.
 */
public class Core extends Elements {

    protected BufferedReader idCheck(BufferedReader br, int targetID) {
        String line = null;

        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getElements(line);
        if (id != targetID) {
            System.err.println("Syntax error: line " + lineNumber);
            System.exit(-1);
        }

        return br;
    }

    protected BufferedReader idCheck(BufferedReader br, Integer[] targetIdArray) {
        String line = null;

        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getElements(line);
        if (!Arrays.asList(targetIdArray).contains(id)) {
            System.err.println("Syntax error: line " + lineNumber);
            System.exit(-1);
        }

        return br;
    }

    protected boolean hasOption(BufferedReader br, int targetId) {
        hasOptionHelper(br);
        return targetId == id;
    }

    protected boolean hasOption(BufferedReader br, Integer[] targetIdArray) {
        hasOptionHelper(br);
        return Arrays.asList(targetIdArray).contains(id);
    }

    private void hasOptionHelper(BufferedReader br) {
        String line = null;
        try {
            br.mark(1024);
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getElements(line);
        try {
            br.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
