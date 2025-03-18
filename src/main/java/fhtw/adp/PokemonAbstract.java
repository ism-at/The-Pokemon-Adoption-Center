package fhtw.adp;

public abstract class PokemonAbstract {
    protected String name;
    protected String type;

    public PokemonAbstract(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
