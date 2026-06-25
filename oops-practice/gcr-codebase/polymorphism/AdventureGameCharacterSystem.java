// Superclass
class GameCharacter {
    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    void performAttack() {
        System.out.println(characterName + " attacks!");
    }
}

// Warrior Class
class Warrior extends GameCharacter {

    Warrior(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " attacks with a Sword!");
    }
}

// Mage Class
class Mage extends GameCharacter {

    Mage(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " casts a Fireball!");
    }
}

// Archer Class
class Archer extends GameCharacter {

    Archer(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " shoots an Arrow!");
    }
}

// Main Class
public class AdventureGameCharacterSystem {

    // Method for starting battle
    static void startBattle(GameCharacter[] characters) {

        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println(" Battle Started ");

        for (GameCharacter character : characters) {

            // Polymorphic method call
            character.performAttack();

            // Counting character types
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("\n Battle Summary ");
        System.out.println("Warriors Participated: " + warriorCount);
        System.out.println("Mages Participated: " + mageCount);
        System.out.println("Archers Participated: " + archerCount);
    }

    public static void main(String[] args) {

        GameCharacter[] characters = {
                new Warrior("Aragorn"),
                new Mage("Gandalf"),
                new Archer("Legolas"),
                new Warrior("Thor"),
                new Mage("Merlin"),
                new Archer("Robin")
        };

        startBattle(characters);
    }
}