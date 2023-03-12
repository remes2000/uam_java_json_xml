package pl.nieruchalski;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import static java.text.MessageFormat.format;

public class CensusOfCitizens {
    private LinkedHashMap<String, Citizen> citizens = new LinkedHashMap();
    private PrintWriter outputFileWriter;

    public static void main(String[] args) {
        String outputFileName = "census.txt";
        if(args.length >= 1) {
            outputFileName = args[0];
        }
        try {
            CensusOfCitizens censusOfCitizens = new CensusOfCitizens(outputFileName);
            censusOfCitizens.run();
        } catch (FileNotFoundException e) {
            System.err.println(format("Wystąpił błąd podczas próby otwarcia pliku {0}", outputFileName));
        }
    }

    public CensusOfCitizens(String outputFileName) throws FileNotFoundException{
        this.outputFileWriter = new PrintWriter(outputFileName);
    }

    private void run() {
        System.out.println("---=== Census of Citizens ===---");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                Citizen citizen = Citizen.readFromStandardInput();
                this.addCitizen(citizen);
            } catch (InvalidPeselException exception) {
                System.out.println("Podano nieprawidłowy numer PESEL");
            }
            System.out.println("Czy chcesz dodać kolejnego mieszkańca? [Y/n]");
        } while("Y".equals(scanner.next()));
        this.flushToFile();
        this.exit();
    }

    private void addCitizen(Citizen citizen) {
        this.citizens.put(citizen.getPeselNumber(), citizen);
    }

    private void flushToFile() {
        for(String peselNumber : this.citizens.keySet()) {
            this.outputFileWriter.println(this.citizens.get(peselNumber));
        }
    }

    private void exit() {
        this.outputFileWriter.close();
        System.out.println("Bye");
    }
}
