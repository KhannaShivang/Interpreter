package com.interpreter.jail;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class Jail {
    static boolean errorOccured = false;
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jail [script]");
            System.exit(64);     
        }
        else if (args.length == 1) {
            runFile(args[0]);    
        }
        else {
            runPrompt();
        }
    }

    //TO run a file present at path
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
        // Indicate an error in the exit code.
        if (errorOccured) System.exit(65);
    }

    //To reun the code from command Line
    private static void runPrompt() throws IOException {
        System.out.println("!!!!!Welcome TO jail");
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) 
                break;
            run(line);
            errorOccured = false;
        }
    }
    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        // print the tokens.
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
     static void error(int line, String message) {
        report(line, "", message);
    }
    private static void report(int line, String where,String message) {
        System.err.println(
        "[line " + line + "] Error" + where + ": " + message);
        errorOccured = true;
    }

}

