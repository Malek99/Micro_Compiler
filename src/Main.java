import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class Main {

	public static void main(String[] args) throws Exception {
		// read input MICRO code

		if(args.length == 0)
		{
			System.out.println("You should specify the input .micro file");
			System.exit(0);
		}
		
		CharStream input = null;
		try {
			input = CharStreams.fromFileName(args[0]);

		} catch (IOException e) {
			System.out.println("can't open " + args[0]);
			System.exit(0);
		}

		MicroLexer lexer = new MicroLexer(input);

		

		List<? extends Token> tokens = lexer.getAllTokens();
		System.out.println("Number of tokens: " + tokens.size());

		for (int i = 0; i < tokens.size(); i++) {
			Token t = tokens.get(i);
			System.out.println(/*"Token Type: " +*/ lexer.getVocabulary().getSymbolicName(t.getType()) + "\n"
					+ /*"Value: " +*/ t.getText()+"\n");
		}

	}

}