import org.junit.Test;

public class BrainParserTest {




@Test (expected = IOException)
public void EmptyFileTest() {

	BrainParser eFTestParser = new BrainParser("1");

}

@Test (expected = FileNotFoundException)
public void IncorrectFileNameTest() {

	BrainParser fNFTestParser = new BrainParser("2");

}

@Test
public void FileLengthTooBigTest(){
	BrainParser fLTBParser = new BrainParser("3");
	
	
}

@Test (expected = ParseException)
public void InvalidCommentCharactersTest(){
	BrainParser iCCTestParser = new BrainParser("4");
}

@Test (expected = ParseException)
public void InvalidInstructionCharactersTest(){
	BrainParser iICharTestParser = new BrainParser("5");
}

@Test (expected = ParseException)
public void TwoInstructionOneLineTest(){
	BrainParser tIOLTestParser = new BrainParser("6");
}

@Test (expected = ParseException)
public void EmptyLineTest(){
	BrainParser eLTestParser = new BrainParser("7");
}

@Test (expected = ParseException)
public void InstructionParamTooLargeTest(){
	BrainParser iPTLTestParser = new BrainParser("8");
}

@Test (expected = ParseException)
public void InstructionParamTooSmallTest(){
	BrainParser iPTSTestParser = new BrainParser("9");
}

@Test (expected = ParseException)
public void InvalidParameterNumberTest(){
	BrainParser iPNTestParser = new BrainParser("10");
}

@Test (expected = ParseException)
public void NoWhiteSpaceInstructionTest(){
	BrainParser nWSITestParser = new BrainParser("11");
}

@Test (expected = ParseException)
public void RandomLexicalErrorTest(){
	BrainParser rLETestParser = new BrainParser("12");
}

@Test
public void TestvalidFile() {
	BrainParser TVFTestParser = new BrainParser("13");
}

@Test
public void TestvalidFileWithComments() {
	BrainParser tVFWCTestParser = new BrainParser("14");
	
}


}
