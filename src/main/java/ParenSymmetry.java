import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        String a;
        int sphinx = 0;
        int idx = 0;
        while (idx < s.length()) {

           a = String.valueOf(s.charAt(idx));

            if (a.equals("(")) {
                sphinx++;
            } else if (a.equals(")")) {
                sphinx--;
            } else if (sphinx < 0){

                return false;

            }

            idx++;
        }
        return sphinx==0;
        }



    private void checkFile(String filename) {
        // open file named filename
        File file = new File("filename");
        // for each line in the file
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        }
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}