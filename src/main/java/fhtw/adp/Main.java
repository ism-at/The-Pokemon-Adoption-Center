package fhtw.adp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingletonAdoptionCenter singletonAdoptionCenter = SingletonAdoptionCenter.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pokemon Adoption Center ^_^");

        while (true) {
            System.out.println("\n1. Register User\n2. Adopt a Pokemon\n3. Show Available Pokemons\n4. Exit");
            System.out.print("Choose an option: ");
            int choose = scanner.nextInt();
            scanner.nextLine(); // Fixes input skipping issue

            switch (choose) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    ObserverUserNotification user = new ObserverUserNotification(userName);
                    singletonAdoptionCenter.registerUser(user);
                    System.out.println("User " + userName + " registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter Pokemon name: ");
                    String pokemonName = scanner.nextLine();
                    System.out.print("Enter Pokemon type (Electric, Fire, Ghost, Normal, Water): ");
                    String pokemonType = scanner.nextLine();

                    try {
                        PokemonAbstract newPokemon = FactoryCreatePokemon.createPokemon(pokemonType, pokemonName);
                        singletonAdoptionCenter.addPokemon(newPokemon);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid type. Please try again.");
                    }
                    break;

                case 3:
                    singletonAdoptionCenter.showAvailablePokemons();
                    break;

                case 4:
                    System.out.println("Thank you for using Pokemon Adoption Center! See You Again :)");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


/*
public class Main {

    public static void main(String[] args) {

        SingletonAdoptionCenter singletonAdoptionCenter = SingletonAdoptionCenter.getInstance();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcomm to Pokemon Adoption Center ^_^");
        System.out.println("Please enter your name :");
        String userName = scanner.nextLine();

        ObserverUserNotification user = new ObserverUserNotification(userName);

        singletonAdoptionCenter.registerUser(user);

        while (true){
            System.out.println("\n1. Adopt a Pokemon\n2. Show Available Pokemons\n3. Exit");
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose){
                case 1:
                    System.out.println("Enter pokemon name:");
                    String pokemonName = scanner.nextLine();
                    System.out.println("Enter pokemon type (Electric, Fire, Ghost, Normal, Water):");
                    String pokemonType = scanner.nextLine();

                try {
                        PokemonAbstract newPokemon = FactoryCreatePokemon.createPokemon(pokemonType, pokemonName);
                        singletonAdoptionCenter.addPokemon(newPokemon);
                        System.out.println(pokemonName + "[" + pokemonType + "]" + "The Pokemon has been added to the adoption center");
                    } catch (IllegalArgumentException e){
                        System.out.println("Invalid type. Please try again.");
                    }
                    break;

                case 2:
                    singletonAdoptionCenter.showAvailablePokemons();
                    break;

                case 3:
                    System.out.println("Thank you for using Pokemon Adoption Center! See You Again :)");
                    return;

                default:
                    System.out.println("Invalid, Please try again.");
            }
        }
    }
}
 */