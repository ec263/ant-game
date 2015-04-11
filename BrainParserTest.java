/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**Test class to test the brain parser deliverable
 *
 * @author Ben
 */
public class BrainParserTest {

    /**
     *
     */
    public BrainParserTest() {
    }

    /**This test tries to make a parser on a blank file, and should throw an exception
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = IOException.class)
    public void EmptyFileTest() throws IOException, FileNotFoundException, ParseException {

        BrainParser eFTestParser = new BrainParser("1");

    }

    /**This test tries to parse a file that is not found in the location folder, as the file does not exist
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = FileNotFoundException.class)
    public void IncorrectFileNameTest() throws IOException, FileNotFoundException, ParseException {

        BrainParser fNFTestParser = new BrainParser("2");

    }

    /**This attempts to parse a file that is over 10000 lines long, and should produce an error message 
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test
    public void FileLengthTooBigTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser fLTBParser = new BrainParser("3");

    }

    /** This test looks for comments in the code, and if it finds an invalid character in a comment should throw an exception
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = TokenMgrError.class)
    public void InvalidCommentCharactersTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser iCCTestParser = new BrainParser("4");
    }

    /**This tests for invalid characters in the instruction keywords and throws a token error accordingly
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = TokenMgrError.class)
    public void InvalidInstructionCharactersTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser iICharTestParser = new BrainParser("5");
    }

    /**This tests that there should always be 1 instruction on 1 line of the file
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = ParseException.class)
    public void TwoInstructionOneLineTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser tIOLTestParser = new BrainParser("6");
    }

    /**This tests that every line in the file has an instruction on
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = ParseException.class)
    public void EmptyLineTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser eLTestParser = new BrainParser("7");
    }

    /** This tests boundaries for certain parameters for instructions
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = ParseException.class)
    public void InstructionParamTooLargeTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser iPTLTestParser = new BrainParser("8");
    }

    /**This tests boundaries for certain parameters for instructions
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = TokenMgrError.class)
    public void InstructionParamTooSmallTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser iPTSTestParser = new BrainParser("9");
    }

    /** This tests that an instruction receives the correct number of parameters
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = ParseException.class)
    public void InvalidParameterNumberTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser iPNTestParser = new BrainParser("10");
    }

    /** This test checks for space between an instruction and it's parameters and that they are separate tokens
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = java.lang.StringIndexOutOfBoundsException.class)
    public void NoWhiteSpaceInstructionTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser nWSITestParser = new BrainParser("11");
    }

    /**This test covers random spelling and typing mistakes in the file
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test(expected = TokenMgrError.class)
    public void RandomLexicalErrorTest() throws IOException, FileNotFoundException, ParseException {
        BrainParser rLETestParser = new BrainParser("12");
    }

    /**This test accepts a valid file and checks that all the lines are converted into the corresponding instructions
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test
    public void TestvalidFile() throws IOException, FileNotFoundException, ParseException {
        BrainParser TVFTestParser = new BrainParser("13");
        ArrayList<Instruction> incList = new ArrayList<Instruction>(TVFTestParser.getInstructions());
        boolean aTrue = true;
        if (incList.get(0).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(1).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(2).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(3).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(4).getClass() != Sense.class) {
            aTrue = false;
        }
        if (incList.get(5).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(6).getClass() != PickUp.class) {
            aTrue = false;
        }
        if (incList.get(7).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(8).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(9).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(10).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(11).getClass() != Unmark.class) {
            aTrue = false;
        }
        if (incList.get(12).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(13).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(14).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(15).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(16).getClass() != Sense.class) {
            aTrue = false;
        }
        if (incList.get(17).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(18).getClass() != Drop.class) {
            aTrue = false;
        }
        if (incList.get(19).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(20).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(21).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(22).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(23).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(24).getClass() != Mark.class) {
            aTrue = false;
        }
        if (incList.get(25).getClass() != Move.class) {
            aTrue = false;
        }

        assertTrue(aTrue);

    }

    /**This test accepts a valid file and checks that all the lines are converted into the corresponding instructions, with valid comments too
     *
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @Test
    public void TestvalidFileWithComments() throws IOException, FileNotFoundException, ParseException {
        BrainParser tVFWCTestParser = new BrainParser("14");
        ArrayList<Instruction> incList = new ArrayList<Instruction>(tVFWCTestParser.getInstructions());
        boolean aTrue = true;
        if (incList.get(0).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(1).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(2).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(3).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(4).getClass() != Sense.class) {
            aTrue = false;
        }
        if (incList.get(5).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(6).getClass() != PickUp.class) {
            aTrue = false;
        }
        if (incList.get(7).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(8).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(9).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(10).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(11).getClass() != Unmark.class) {
            aTrue = false;
        }
        if (incList.get(12).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(13).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(14).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(15).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(16).getClass() != Sense.class) {
            aTrue = false;
        }
        if (incList.get(17).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(18).getClass() != Drop.class) {
            aTrue = false;
        }
        if (incList.get(19).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(20).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(21).getClass() != Flip.class) {
            aTrue = false;
        }
        if (incList.get(22).getClass() != Turn.class) {
            aTrue = false;
        }
        if (incList.get(23).getClass() != Move.class) {
            aTrue = false;
        }
        if (incList.get(24).getClass() != Mark.class) {
            aTrue = false;
        }
        if (incList.get(25).getClass() != Move.class) {
            aTrue = false;
        }

        assertTrue(aTrue);

    }

}
