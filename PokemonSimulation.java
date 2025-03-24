import java.util.Scanner;

public class PokemonSimulation 
{
    private static PokemonImages images = new PokemonImages();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Pokemon Simulator!");
        System.out.println();
        System.out.println("(Developed by cautious)");
        System.out.println();
        System.out.println("Let's set up the first trainer!");
        System.out.print("What will Trainer One's name be? ");
        String trainerOneName = scanner.nextLine();

        Trainer trainerOne = new Trainer(trainerOneName);
        System.out.println();
        System.out.println("Hello " + trainerOne.toString() + "!");

        System.out.println();
        System.out.println("Let's give " + trainerOne.toString() + " their first Pokemon!");
        System.out.print("What Pokemon will " + trainerOne.toString() + " have? ");
        String firstPokemon = scanner.nextLine();

        Pokemon pokemonOne = new Pokemon(firstPokemon, 100, images.getPokemonImage(firstPokemon));

        System.out.println();
        System.out.println(trainerOne.toString() + " has been given a " + pokemonOne.getName());

        System.out.println();
        System.out.println(pokemonOne.toString());

        while (pokemonOne.canLearnMoreMoves()) {
            System.out.print("What move should " + pokemonOne.getName() + " have? ");
            String moveName = scanner.nextLine().trim();  // Read entire move name properly
            Move move = new Move(moveName, 25);
        
            if (pokemonOne.learnMove(move)) {
                System.out.println(pokemonOne.getName() + " learned " + moveName + "!");
            } else {
                System.out.println(pokemonOne.getName() + " cannot learn any more moves.");
            }
        }        

        scanner.close();
    }
}
