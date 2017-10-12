package enshud.s2.parser.Helper.Syntax.Elements;

/**
 * Created by Cain96 on 2017/09/30.
 */
public class Elements {
    public int id, lineNumber;
    public String string;

    protected void getElements(String line) {
        if (line != null) {
            String[] elements = line.split("\t");
            try {
                string = elements[0];
                id = Integer.parseInt(elements[2]);
                lineNumber = Integer.parseInt(elements[3]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
