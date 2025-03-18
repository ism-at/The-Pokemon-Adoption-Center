package fhtw.adp;

public class ObserverUserNotification {

    private String name;

    public ObserverUserNotification(String name) {
        this.name = name;
    }

    public void update(PokemonAbstract pokemon){
        System.out.println("User " + name + " was notified: A new Pokemon is available :) " + pokemon.getName() + " [ "+ pokemon.getType() +" ]");
    }
}
