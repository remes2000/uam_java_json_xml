package pl.nieruchalski;

import java.util.Scanner;

public class Citizen {
    public static Citizen readFromStandardInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj miasto: ");
        String city = scanner.nextLine();
        System.out.println("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.println("Podaj PESEL: ");
        String peselNumber = scanner.nextLine();
        return new Citizen(name, lastName, city, peselNumber);
    }

    private String name;
    private String lastName;
    private String city;
    private String peselNumber;

    public Citizen(String name, String lastName, String city, String peselNumber) throws InvalidPeselException {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
        if(!PESELValidator.isValid(peselNumber)) {
            throw new InvalidPeselException();
        }
        this.peselNumber = peselNumber;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName + '\n' + this.city + '\n' + this.peselNumber;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }
}
