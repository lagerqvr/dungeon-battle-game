import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------\n");
        System.out.println("Welcome to the dungeon!\n");
        System.out.println("What is your name stranger?");

        String name = scan.nextLine();

        GameCharacter player = new GameCharacter(name, 100);
        GameCharacter monster = new GameCharacter("Werewolf", 70);

        System.out.println("\nYour name: " + player.getName());
        System.out.println("Your HP: " + player.getHealth());

        System.out.println("\nA werewolf emerges from the darkness.");
        System.out.println("Werewolf HP: " + monster.getHealth() + "\n");

        while(player.getHealth() > 0) {
            System.out.println("What do you want to do?");
            System.out.println("1: Attack");
            System.out.println("2: Run");
            System.out.println("3: Quit");
            int choice = scan.nextInt();

            if(choice == 1) {
                if (monster.getHealth() > 0) {
                    System.out.println("You attack the Werewolf for 20 HP. Werewolf has " + (monster.takeDamage(20)) +  " HP left.");

                    if (monster.getHealth() > 0) {
                        System.out.println("The Werewolf attacks you for 10 HP. You have " + (player.takeDamage(17)) +  " HP left.");

                    }
                }
                if (monster.getHealth() == 0) {
                    System.out.println("\nGood job! You've won the fight! You had " + player.getHealth() + " HP left.");
                    System.out.println("------------------------------------------------------------------------------------\n");
                }
            }
            else if (choice == 2) {

                System.out.println("\nYou've escaped succesfully! You might not be so lucky next time around...");
                System.out.println("------------------------------------------------------------------------------------\n");
                scan.close();
                System.exit(0);
            }

            else if (choice == 3) {
                System.out.println("\nHave a nice day!");
                System.out.println("Quitting program...");
                System.out.println("------------------------------------------------------------------------------------\n");
                scan.close();
                System.exit(0);
            }
            else
                System.out.println("Choose a viable option");

        }


    }

}


