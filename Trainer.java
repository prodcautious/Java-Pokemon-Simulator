import java.util.ArrayList;

public class Trainer {
    private static final int MAX_POKEMON = 2;


    private String trainerName;
    private ArrayList<Pokemon> pokemonCollection;

    // Constructor
    public Trainer(String name) {
        trainerName = name;
        this.pokemonCollection = new ArrayList<>();
    }

    public boolean addPokemon(Pokemon pokemon) {
        if (pokemonCollection.size() < MAX_POKEMON) {
            pokemonCollection.add(pokemon);
            return true;
        }
        return false;
    }

    public boolean hasLost() {
        for (Pokemon pokemon : pokemonCollection) {
            if (!pokemon.hasFainted()) {
                return false;
            }
        }
        return true;
    }

    public Pokemon getNextPokemon() {
        for (Pokemon pokemon : pokemonCollection) {
            if (!pokemon.hasFainted()) {
                return pokemon;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return trainerName;
    }
}