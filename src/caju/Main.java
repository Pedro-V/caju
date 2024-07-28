package caju;
import caju.lexer.*;
import caju.node.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
    String arquivo = "";
		try {
			arquivo = args[0];
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.err.println("Usage: caju <input>.caju");
      System.exit(1);
    }

    Lexer lexer = null;
    try {
      lexer = new Lexer(new PushbackReader(new FileReader(arquivo), 2048)); 
    } catch (IOException ex) {
			System.err.println(ex.getMessage());
      System.exit(1);
    }

    try {
      Token token;
      while(!((token = lexer.next()) instanceof EOF)) {
        System.out.println(token.getClass());
        System.out.println(" ( "+token.toString()+")");
      }
    } catch (Exception ex) {
      System.err.println(ex.getMessage());
      System.exit(1);
    }
	}
}
