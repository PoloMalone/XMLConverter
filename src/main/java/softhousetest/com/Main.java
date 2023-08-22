package softhousetest.com;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: mvn exec:java -Dexec.args=\"example.txt output.xml\"");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        StringBuilder inputText = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                inputText.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        ParserXML parsedXml = new ParserXML(outputFile);
        parsedXml.parseInput(inputText.toString());
    }
}
