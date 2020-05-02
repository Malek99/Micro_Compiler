import java.io.IOException;
import java.util.LinkedList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
	
	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Error: expected one argument, the .micro file");
			System.exit(0);
		}

		MicroLexer lexer = null;
		try {
			CharStream input = CharStreams.fromFileName(args[0]);
			lexer = new MicroLexer(input);
		} catch (IOException e) {
			System.out.println("can't open " + args[0]);
			System.exit(0);
		}

		MicroParser parser = new MicroParser(new CommonTokenStream(lexer));
		ParseTree parseTree = parser.program();

		if (parser.getNumberOfSyntaxErrors() != 0) {
			System.exit(0);
		}

		ScopeTree scopes = new SymbolTablesVisitor().visit(parseTree);
		

		IRCode irCode = new IRVisitor(scopes).visit(parseTree);

		
		LinkedList<TinyStatement> TinyCode = new TinyCodeGenerator(scopes).generate(irCode);
		
		for (TinyStatement tinyStatement : TinyCode) {
			System.out.println(tinyStatement.toString());
		}
		
		
	}

}