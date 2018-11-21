import java.util.ArrayList;
import java.util.List;

public class PokemonMain {
    public static void main(String[] args) {
        // Every pokemon has a name and a type.
        // Certain types are effective against others, e.g. water is effective against fire.
        // Ash has a few pokemon.
        // A wild pokemon appeared!
        // Which pokemon should Ash use?

        List<Pokemon> pokemonsOfAsh = initializePokemons();

        Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

        for (Pokemon pokemon : pokemonsOfAsh) {
            if (pokemon.isEffectiveAgainst(wildPokemon)) {
                System.out.println("I choose you, " + pokemon.getName());
            }
        }
    }

    private static List<Pokemon> initializePokemons() {
        List<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon("Balbasaur", "leaf", "water"));
        pokemons.add(new Pokemon("Pikatchu", "electric", "water"));
        pokemons.add(new Pokemon("Charizard", "fire", "leaf"));
        pokemons.add(new Pokemon("Balbasaur", "water", "fire"));
        pokemons.add(new Pokemon("Kingler", "water", "fire"));

        return pokemons;
    }
}