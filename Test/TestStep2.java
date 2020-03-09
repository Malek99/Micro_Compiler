import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

// This class is used to test the correctness of my solution against Dr. Fahed's solution 
public class TestStep2 {
	// This function expects two parameters, the first is the directory path where
	// there are 21 .micro files of the form test<i>.micro. And the other parameter
	// is the path of the provided correct outputs of running the parser on 
	// test<i>.micro files, output files are in the form of test<i>.out
	public static void test(String directoryPathOfMicroFiles, String directoryPathOfOutputFiles) throws Exception {
		for (int i = 1; i <= 21; i++) {
			
			String microFileName = directoryPathOfMicroFiles + "test" + i + ".micro";
			String outFileName = directoryPathOfOutputFiles + "test" + i + ".out";
			
			MicroLexer lexer = null;
			try {
				CharStream input = CharStreams.fromFileName(microFileName);
				lexer = new MicroLexer(input);
			} 
			catch (IOException e) {
				System.out.println("can't open " + microFileName);
				System.exit(0);
			}
			
			MicroParser parser = new MicroParser(new CommonTokenStream(lexer));
			parser.program();
			
			String out = null;
			try {
				Scanner s = new Scanner(new File(outFileName));
				out = s.nextLine();
				s.close();
			}
			catch (IOException e) {
				System.out.println("can't open "+outFileName);
			}
			
			System.out.println("Test " + i +":\n" + "Your answer: \t" + (parser.getNumberOfSyntaxErrors() == 0? "Accepted" : "Not Accepted")
					+"\n" + "Correct answer: " + out + "\n");
		}
	}
}
