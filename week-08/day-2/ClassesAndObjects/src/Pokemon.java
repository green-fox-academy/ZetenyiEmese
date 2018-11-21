public class Pokemon {
    private String name;
    private String type;
    private String effectiveAgainst;

    public Pokemon(String name, String type, String effectiveAgainst) {
        this.name = name;
        this.type = type;
        this.effectiveAgainst = effectiveAgainst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffectiveAgainst() {
        return effectiveAgainst;
    }

    public void setEffectiveAgainst(String effectiveAgainst) {
        this.effectiveAgainst = effectiveAgainst;
    }

    public boolean isEffectiveAgainst(Pokemon anotherPokemon) {
        return this.effectiveAgainst.equals(anotherPokemon.type);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", effectiveAgainst='" + effectiveAgainst + '\'' +
                '}';
    }
}