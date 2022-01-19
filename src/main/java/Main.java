import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------\n");
        System.out.println("Welcome to the dungeon!\n");
        System.out.println("What is your name stranger?");

        String name = scan.nextLine();

        GameCharacter player = new Player(name, 100);
        GameCharacter npc = new Npc(70);

        Weapon playerWeapon = new Weapon("knife", 17);
        Weapon npcWeapon = new Weapon("knife", 15);

        System.out.println("\nYour name: " + player.getName());
        System.out.println("Your HP: " + player.getHealth());

        System.out.println("\nA " + npc.getName() + " emerges from the darkness.");
        System.out.println(npc.getName() + " HP: " + npc.getHealth() + "\n");

        boolean finished = false;

        while(player.getHealth() > 0 && npc.getHealth() > 0) {
            System.out.println("What do you want to do?");
            System.out.println("1: Attack");
            System.out.println("2: Run");
            System.out.println("3: Quit");
            int choice = scan.nextInt();

            System.out.println("\n");

            if(choice == 1) {
                if (npc.getHealth() > 0) {
                    finished = false;
                    System.out.println("You attack the " + npc.getName() + " with a " + playerWeapon.getName() + " for " + playerWeapon.getDamage()  +  " HP. The " + npc.getName() + " has "+ (npc.takeDamage(playerWeapon.getDamage())) +  " HP left.");

                    if (npc.getHealth() > 0) {
                        System.out.println("The " + npc.getName() + " attacks you for " + npcWeapon.getDamage() + " HP. You have " + (player.takeDamage(npcWeapon.getDamage())) +  " HP left.");
                    } if (player.getHealth() == 0) {
                        System.out.println("\nGAME OVER! Better luck next time " + player.getName() + "!");
                        System.out.println("------------------------------------------------------------------------------------\n");
                    }
                }

                while (player.getHealth() > 0 && npc.getHealth() == 0 && !finished) {

                    System.out.println("\nGood job! You've won the fight! You had " + player.getHealth() + " HP left.");
                    System.out.println("------------------------------------------------------------------------------------\n");
                    System.out.println("What do you want to do now? You have " + player.getHealth() + " HP left.");
                    System.out.println("1: Keep fighting");
                    System.out.println("2: Drink health potion and keep fighting (+ 20 HP)");
                    System.out.println("3: Quit");

                    int replay = scan.nextInt();

                    if (replay == 1) {
                        npc.setHealth(70);
                        finished = true;
                        System.out.println("\nA " + npc.getName() + " now emerges from the darkness.");
                    }

                    if (replay == 2) {
                        npc.setHealth(70);
                        player.addHealth(20);
                        finished = true;
                        System.out.println("\nA " + npc.getName() + " emerges from the darkness.");
                    }

                    else if (replay == 3) {
                        System.out.println("\nHave a nice day!");
                        System.out.println("Quitting program...");
                        System.out.println("------------------------------------------------------------------------------------\n");
                        scan.close();
                        System.exit(0);
                    }

                    else {
                        System.out.println("Choose a viable option");
                    }
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


