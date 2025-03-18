package fhtw.adp;

import fhtw.adp.factories.*;

// If I need more types --> https://bulbapedia.bulbagarden.net/wiki/List_of_Pok%C3%A9mon_by_name
public class FactoryCreatePokemon {

    public static PokemonAbstract createPokemon(String type, String name){
        switch (type.toLowerCase()){
            case "electric":
                return new Electric(name);

            case "water":
                return new Water(name);

            case "normal":
                return new Normal(name);

            case "fire":
                return new Fire(name);

            case "ghost":
                return new Ghost(name);

            default:
                throw new IllegalArgumentException("Unknown type, please chose the type from the list");
        }
    }
}
