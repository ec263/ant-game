import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class BrainParser {

    String FileName;
    String toParse;
    BufferedReader r;
    String holder = "";
    int lineCount = 0;

    public BrainParser(String s) throws FileNotFoundException, IOException, ParseException {

        FileName = s;
        ParseFile(FileName);
    }

    public void ParseFile(String s) throws FileNotFoundException, IOException, ParseException {

        BufferedReader r = new BufferedReader(new FileReader("C:\\" + FileName + ".txt"));

        s = r.readLine();

        while (s != null) {

            holder = holder + s + "\n";
            lineCount += 1;
            s = r.readLine();

        }

        System.out.println(holder);

        if (lineCount <= 10000) {

            StringReader reader = new StringReader(holder);

            AntBrainParser parser = new AntBrainParser(reader);
            parser.Start();

        } else {
        
        System.out.println("The brain file is too long");
        }

    }

    public static void main(String[] args) throws ParseException, TokenMgrError, IOException {

        BrainParser s = new BrainParser("1");

    }

}
