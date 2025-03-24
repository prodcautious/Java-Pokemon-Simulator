import java.util.ArrayList;

public class Pokemon {
    private String pokemonName;
    private int pokemonHealth;
    private ArrayList<Move> moves;
    private String image; // New instance variable to store ASCII images

    // Private constants
    private static final int MAX_HEALTH = 100;
    private static final int MAX_MOVES = 4;

    private static PokemonImages pokemonImages = new PokemonImages();

    public Pokemon(String name, int health, String image) {
        pokemonName = name;
        moves = new ArrayList<>();
        this.image = image;

        if (health > MAX_HEALTH) {
            pokemonHealth = MAX_HEALTH;
        } else {
            pokemonHealth = health;
        }
    }

    public String getName() {
        return pokemonName;
    }

    public int getHealth() {
        return pokemonHealth;
    }

    public boolean canLearnMoreMoves() {
        return moves.size() < MAX_MOVES;
    }

    public boolean learnMove(Move move) {
        if (canLearnMoreMoves()) {
            moves.add(move);
            return true;
        }
        return false;
    }
    
    public void faint() {
        pokemonHealth = 0;
        System.out.println(pokemonName + " has fainted.");
    }
    
    public void takeDamage(int damage) {
        pokemonHealth -= damage;
        if (pokemonHealth < 0) {
            pokemonHealth = 0;
        }
    }

    public void forgetMove(Move move) {
        moves.remove(move);
    }

    public void printMoves() {
        System.out.println(pokemonName + "'s Moves:");
        for (Move move : moves) {
            System.out.println("- " + move);
        }
    }

    public boolean hasFainted() {
        return pokemonHealth <= 0;
    }

    // Method to set the image
    public void setImage(String image) {
        this.image = image;
    }

    // Method to get the image
    public String getImage() {
        return image;
    }

    // Returns an ArrayList of all the Moves this Pokemon knows
    public ArrayList<Move> getMoves() {
        return new ArrayList<>(moves);
    }

    // Returns true if the Pokemon knows this move
    public boolean knowsMove(Move move) {
        return moves.contains(move);
    }

    // Perform an attack using a Move object
    public boolean attack(Pokemon opponent, Move move) {
        if (knowsMove(move)) {
            opponent.takeDamage(move.getDamage());
            System.out.println(pokemonName + " used " + move.getName() + " on " + opponent.getName() + "!");
            return true;
        }
        return false;
    }

    // Includes ASCII image if available
    public String toString() {
        String result = "";
        if (image != null) {
            result += image + "\n";
        }
        result += pokemonName + " (Health: " + pokemonHealth + " / " + MAX_HEALTH + ")";
        return result;
    }
}