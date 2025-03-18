package fhtw.adp;

import java.util.ArrayList;
import java.util.List;

public class SingletonAdoptionCenter {
    private static SingletonAdoptionCenter instance;
    private List<PokemonAbstract> pokemons = new ArrayList<>();
    private List<ObserverUserNotification> users = new ArrayList<>();
    private SingletonAdoptionCenter(){}

    public static SingletonAdoptionCenter getInstance() {
        if(instance == null){
            instance = new SingletonAdoptionCenter();
        }
        return instance;
    }

    public void addPokemon(PokemonAbstract pokemon){
        pokemons.add(pokemon);
        notifyUsers(pokemon);
    }

    public void registerUser(ObserverUserNotification user){
        users.add(user);
    }

    private void notifyUsers(PokemonAbstract pokemon) {
        for (ObserverUserNotification user : users){
            user.update(pokemon);
        }
    }

    public void showAvailablePokemons(){
        if(pokemons.isEmpty()){
            System.out.println("There's no Pokemons available right now for adoption :(");
        }
        else {
            for (PokemonAbstract pokemon : pokemons){
                System.out.println(pokemon.getName() + " - " + pokemon.getType());
            }
        }
    }

}
