# The Pokemon Adoption Center
## 1. Introduction

 Users can adopt Pokemon, view available Pokemon, and get notified when new Pokemon are added. The project implements three design patterns:

    1- Singleton
    2- Factory
    3- Observer

The goal is to implement three design patterns in one project.

## 2. Project Overview
   
### Features:

- Users can adopt Pokemon by specifying a name and type. 
- The adoption center ensures only one instance exists (Singleton Pattern).
- Pokemons are created dynamically based on type (Factory Pattern).
- Users receive notifications when a new Pokemon is added (Observer Pattern).

Pokemons types are:

    * Fire 
    * Electric 
    * Water 
    * Ghost 
    * Normal 

## 3. Implemented Design Patterns 

Singleton Pattern:

    Ensures only one instance of the adoption center exists.
    Prevents duplicate adoption centers.

Factory Pattern:

    Simplifies object creation by dynamically instantiating Pokemon based on type.
    Easy to extend (New Pokemon types can be added without modifying existing logic).

Observer Pattern:

    Notifies users in real-time when a new Pokémon is available.
    Ensures users receive updates without modifying logic.

## 4. Class Diagram (UML)

![UML Diagram](src/UML-class%20-diagram.jpeg)

## 5. Implementation Details

### Singleton Pattern Implementation

The adoption center is one central place for managing Pokemon, ensuring that only one instance exists.
Implemented using a private static instance, ensuring that all operations use the same shared instance.
The constructor is private, preventing external classes from creating multiple adoption centers.
Method getInstance() provides controlled access to the single instance.

    private static SingletonAdoptionCenter instance;
    
    private SingletonAdoptionCenter() {}
    
    public static SingletonAdoptionCenter getInstance() {
        if (instance == null) {
            instance = new SingletonAdoptionCenter();
        }
        return instance;
    }

### Factory Pattern Implementation

The Factory Pattern is used to encapsulate object creation and dynamically generate Pokemon based on user input.
Instead of creating Pokemon manually, the FactoryCreatePokemon class contains a static method (createPokemon) that returns the appropriate Pokemon subclass.
This avoids hardcoding object creation logic and makes it easier to extend (new Pokemon types can be added without modifying existing code).

    public static PokemonAbstract createPokemon(String type, String name){
        switch (type.toLowerCase()){
            case "electric": return new Electric(name);
            case "water": return new Water(name);
            case "normal": return new Normal(name);
            case "fire": return new Fire(name);
            case "ghost": return new Ghost(name);
            default:
                throw new IllegalArgumentException("Unknown type, please choose from the list.");
        }
    }

### Observer Pattern Implementation

The Observer Pattern is used to notify users when a new Pokemon is available.
Users subscribe to the adoption center using registerUser().
When a new Pokemon is added, the notifyUsers() method alerts user by calling the update() method.
This decouples the notification system from the main program logic, following the publish-subscribe model.

    public void registerUser(ObserverUserNotification user){
        users.add(user);
    }
    
    private void notifyUsers(PokemonAbstract pokemon) {
        for (ObserverUserNotification user : users){
            user.update(pokemon);
        }
    }


## 6. Reflection

#### Challenges Faced:

Choose the appropriate Design-Pattern for my project.

#### Lessons Learned:

Design Patterns Improve Code Structure and make clean:

- The Factory Pattern allows adding new Pokemon without modifying core logic.
- The Observer Pattern ensures real-time updates without coupling classes.
- The Singleton Pattern ensures that the adoption center remains a single source.

#### Possible Future Enhancements:

- GUI Integration, adding GUI will improve user interaction.
- Real Database, storing Pokemons in a DB instead of memory.