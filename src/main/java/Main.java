import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------------------------------------------------\n");
        System.out.println("Welcome to DeepDungeon v3.1! ");
        System.out.println("What is your name stranger?");

        String name = scan.nextLine();

        GameCharacter player = new Player(name, 121, 0.8);
        GameCharacter npc = Npc.createRandomNpc();

        int rounds = 0;
        Weapon currentWeapon;

        player.addWeapon(new Weapon("stick from the ground",2));
        player.addWeapon(new Weapon("rock found in a bush", 1));

        System.out.println("\nYour name: " + player.getName());
        System.out.println("Your HP: " + player.getHealth());
        System.out.println("Your finesse: " + player.getFinesse());

        boolean chosen = false;

        while (player.getHealth() > 0 && npc.getHealth() > 0 && !chosen) {
            System.out.println("\nYou will need a weapon in order to survive.");
            System.out.println("Finesse will determine the effectiveness of attacks.");
            System.out.println("\nYou see three weapons laying on the ground in front of you... Which one is your preferred weapon of choice?");
            System.out.println("1: Sword");
            System.out.println("2: Axe");
            System.out.println("3: Bow");

            try {

            int weapon = scan.nextInt();

                if (weapon == 1) {
                    player.addWeapon(new Weapon("sword", 18));
                    currentWeapon = player.getInventory().get(2);
                    player.setWeapon(currentWeapon.getName());
                    player.setDamage(currentWeapon.getDamage());
                    chosen = true;
                    System.out.println("\nSomething moves in the shadows... How many rounds can you survive?");
                }

                if (weapon == 2) {
                    player.addWeapon(new Weapon("axe", 16));
                    currentWeapon = player.getInventory().get(2);
                    player.setWeapon(currentWeapon.getName());
                    player.setDamage(currentWeapon.getDamage());
                    chosen = true;
                    System.out.println("\nSomething moves in the shadows... How many rounds can you survive?");
                }
                if (weapon == 3) {
                    player.addWeapon(new Weapon("bow", 19));
                    currentWeapon = player.getInventory().get(2);
                    player.setWeapon(currentWeapon.getName());
                    player.setDamage(currentWeapon.getDamage());
                    chosen = true;
                    System.out.println("\nSomething moves in the shadows... How many rounds can you survive?");
                } else {
                    System.out.println("Please choose a weapon.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Choose a number between 1 and 3!");
                scan.next();
            } catch (Exception e) {
                scan.next();
            }
        }

        npc = Npc.createRandomNpc();

        System.out.println("\nA " + npc.getName() + " emerges from the darkness.");
        System.out.println("HP: " + npc.getHealth() + "");
        System.out.println("Finesse: " + npc.getFinesse() + "");

        boolean finished = false;
        boolean healthPotion = false;
        rounds++;

        while (player.getHealth() > 0 && npc.getHealth() > 0) {
            System.out.println("\nROUND: " + rounds);
            System.out.println("What do you want to do?");
            System.out.println("1: Attack");
            System.out.println("2: Run");
            System.out.println("3: Quit");

            try {

                int choice = scan.nextInt();

                if (choice == 1) {
                    System.out.println("\nINVENTORY:");
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        System.out.printf("%d - %s\n", i+1, player.getInventory().get(i).getName() + " (" + player.getInventory().get(i).getDamage() + " dmg)");
                    }
                    System.out.println("\nWhich weapon would you like to attack with?");
                    currentWeapon = player.getInventory().get(scan.nextInt()-1);

                    player.setWeapon(currentWeapon.getName());
                    player.setDamage(currentWeapon.getDamage());

                    if (npc.getHealth() > 0) {
                        finished = false;
                        System.out.println("You attack the " + npc.getName() + " with a " + player.getWeapon() + " for " + player.getDamage() + " HP. The " + npc.getName() + " has " + (npc.takeDamage(player.damage)) + " HP left.");

                        if (npc.getHealth() > 0) {
                            System.out.println("The " + npc.getName() + " attacks you for " + npc.getDamage() + " HP. You have " + (player.takeDamage(npc.damage)) + " HP left.");
                        }
                        if (player.getHealth() == 0) {
                            System.out.println("\nGAME OVER! You made it to round " + rounds + ". Better luck next time " + player.getName() + "!");
                            System.out.println("------------------------------------------------------------------------------------\n");
                        }
                    }

                    while (player.getHealth() > 0 && npc.getHealth() == 0 && !finished) {
                        System.out.println("\nGood job! You've successfully defeated the " + npc.getName() + "! You had " + player.getHealth() + " HP left.");
                        System.out.println("The " + npc.getName() + " dropped a magical weapon which has been added to your inventory.");
                        player.addWeapon(Weapon.createRandomDrop());
                        System.out.println("------------------------------------------------------------------------------------\n");
                        System.out.println("What do you want to do now? You have " + player.getHealth() + " HP left.");
                        System.out.println("1: Keep fighting");
                        System.out.println("2: Drink health potion and keep fighting (x 1)");
                        System.out.println("3: Quit");

                        try {
                            int replay = scan.nextInt();

                            if (replay == 1) {
                                rounds++;
                                npc.setHealth(70);
                                finished = true;
                                npc = Npc.createRandomNpc();
                                System.out.println("\nA " + npc.getName() + " now emerges from the darkness.");
                                System.out.println("HP: " + npc.getHealth() + "");
                            }

                            if (replay == 2) {
                                if (!healthPotion) {
                                    rounds++;
                                    healthPotion = true;
                                    npc.setHealth(70);
                                    double oldHealth = player.getHealth();
                                    player.heal(20);
                                    double newHealth = player.getHealth();
                                    System.out.println("\nThe health potion added " + (newHealth - oldHealth) + " HP to your health!");
                                    finished = true;
                                    npc = Npc.createRandomNpc();
                                    System.out.println("\nA " + npc.getName() + " now emerges from the darkness.");
                                    System.out.println("HP: " + npc.getHealth() + "");
                                } else {
                                    System.out.println("\nYOU'VE ALREADY USED YOUR POTION. Choose another option.");
                                }
                            }

                            else if (replay == 3) {
                                System.out.println("\nHave a nice day!");
                                System.out.println("Quitting program...");
                                System.out.println("------------------------------------------------------------------------------------\n");
                                scan.close();
                                System.exit(0);
                            } else {
                                System.out.println("Choose a viable option");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Choose a number between 1 and 3!");
                            scan.next();
                        } catch (Exception e) {
                            scan.next();
                        }
                    }

                } else if (choice == 2) {
                    System.out.println("\nYou've escaped successfully! You might not be so lucky next time around...");
                    System.out.println("------------------------------------------------------------------------------------\n");
                    scan.close();
                    System.exit(0);
                } else if (choice == 3) {
                    System.out.println("\nHave a nice day!");
                    System.out.println("Quitting program...");
                    System.out.println("------------------------------------------------------------------------------------\n");
                    scan.close();
                    System.exit(0);
                } else
                    System.out.println("Choose a viable option");
            } catch (InputMismatchException e) {
                System.out.println("Choose a number between 1 and 3!");
                scan.next();
            } catch (Exception e) {
                scan.next();
            }
        }
    }
}


