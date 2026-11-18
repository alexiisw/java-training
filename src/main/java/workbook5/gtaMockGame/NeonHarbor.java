package workbook5.gtaMockGame;

import java.util.Scanner;

    public class NeonHarbor {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Player player = new Player("Jax Mercer");

            boolean playing = true;

            System.out.println("================================");
            System.out.println("      NEON HARBOR CITY");
            System.out.println("       CRIME STORIES");
            System.out.println("================================");
            System.out.println("Welcome, " + player.getName() + "!");

            while (playing && player.getHealth() > 0) {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Explore the city");
                System.out.println("2. Steal a Mustang");
                System.out.println("3. Drive your vehicle");
                System.out.println("4. Rob a store");
                System.out.println("5. Check status");
                System.out.println("6. Escape the police");
                System.out.println("7. Equip gun");
                System.out.println("8. Equip bat");
                System.out.println("0. Quit");
                System.out.print("Choose: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("You explore downtown Neon Harbor.");
                        System.out.println("Neon lights shine across the streets.");
                        break;

                    case "2":
                        player.stealVehicle(new Mustang("Shadow Mustang"));
                        break;

                    case "3":
                        player.drive();
                        break;

                    case "4":
                        System.out.println("You rob Michael's jewelery store!");
                        player.earnMoney(20000);
                        player.addWantedLevel(2);
                        System.out.println("You got $20,000!");
                        break;

                    case "5":
                        player.showStatus();
                        break;

                    case "6":
                        if (player.getWantedLevel() == 0) {
                            System.out.println("No police are chasing you.");
                        } else {
                            Police police = new Police("Officer Vale");
                            police.chase(player);
                        }
                        break;
                    case "7":
                        player.equip(new Gun("Pistol", 0, 800));
                        break;
                    case "0":
                        playing = false;
                        System.out.println("Thanks for playing!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            if (player.getHealth() == 0) {
                System.out.println("GAME OVER! Jax was caught!");
            }

            scanner.close();
        }
    }

    // ABSTRACTION: A general blueprint for vehicles
    abstract class Vehicle {
        private String name;

        public Vehicle(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void drive();
    }

    // INTERFACE: A vehicle that can be stolen
    interface Stealable {
        void steal();
    }

    // INHERITANCE: Mustang is a Vehicle
    class Mustang extends Vehicle implements Stealable {

        public Mustang(String name) {
            super(name);
        }

        @Override
        public void drive() {
            System.out.println(getName() + " roars through the city!");
        }

        @Override
        public void steal() {
            System.out.println("You stole the " + getName() + "!");
        }
    }

    // PARENT CLASS: Shared character information
    class Character {
        private String name;
        private int health = 100;

        public Character(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        // ENCAPSULATION: Health cannot fall below zero
        public void takeDamage(int damage) {
            if (damage > 0) {
                health = Math.max(0, health - damage);
            }
        }
    }

// DIFFERENT APPROACH -->
// Interface: weaponAction()
//interface WeaponAttack {
//    void weaponAttack();
//}

    // Class: Weapon
    abstract class Weapon implements Stealable {
        private String name;
        private double damage;
        private double cost;

        // CONSTRUCTOR
        public Weapon(String name, double damage, double cost) {
            this.name = name;
            this.damage = damage;
            this.cost = cost;
        }

        // GETTERS
        public String getName() {
            return name;
        }
        public double getDamage() {
            return damage;
        }
        public double getCost() {
            return cost;
        }

        abstract void equipWeapon();
        abstract void unequipWeapon();

        abstract void weaponAttack();

        @Override
        public void steal() {
            System.out.println("You stole the " + name + "!");
        }
    }

    // SubClass: Bat
    class Bat extends Weapon {

        private boolean isSpiked;

        // CONSTRUCTOR
        public Bat(String name, double damage, double cost, boolean isSpiked) {
            super(name, damage, cost);
            this.isSpiked = isSpiked;
        }

        // GETTERS
        public boolean isSpiked() {
            return isSpiked;
        }

        @Override
        void weaponAttack() {
            System.out.println("You swung the bat!");
        }

        @Override
        void equipWeapon() {
            System.out.println("You equipped the bat.");
        }

        @Override
        void unequipWeapon() {
            System.out.println("You unequipped the bat.");
        }
    }

    // SubClass: Gun
    class Gun extends Weapon {

        private double range;
        private int currentAmmoAmount;
        private int maxAmmoAmount;
        private double fireRate;

        // CONSTRUCTOR
        public Gun(String name,  double damage, double cost) {
            super(name, damage, cost);
//        this.range = range;
//        this.currentAmmoAmount = currentAmmoAmount;
//        this.maxAmmoAmount = maxAmmoAmount;
//        this.fireRate = fireRate;
        }

        // GETTERS
        public double getRange() {
            return range;
        }
        public int getCurrentAmmoAmount() {
            return currentAmmoAmount;
        }
        public int getMaxAmmoAmount() {
            return maxAmmoAmount;
        }
        public double getFireRate() {
            return fireRate;
        }

        public void reloadGun() {}

        @Override
        void weaponAttack() {
            System.out.println("You fired the gun!");
        }

        @Override
        void equipWeapon() {
            System.out.println("You equipped the gun.");
        }

        @Override
        void unequipWeapon() {
            System.out.println("You unequipped the gun.");
        }
    }

    // INHERITANCE: Player is a Character
    class Player extends Character {
        private int money = 500;
        private int wantedLevel = 0;

        // COMPOSITION: Player has a Weapon
        private Weapon weapon; // abstract reference

        // COMPOSITION: Player has a Vehicle
        private Vehicle vehicle;

        public Player(String name) {
            super(name);
        }

        public void stealVehicle(Mustang mustang) {
            mustang.steal();
            vehicle = mustang;
            addWantedLevel(1);
        }

        public void drive() {
            if (vehicle == null) {
                System.out.println("You need a vehicle first!");
            } else {
                vehicle.drive();
            }
        }

        public void equip(Gun gun) {
//        if (weapon == null) {
//            System.out.println("You need a weapon first!");
//        } else {
//            weapon = gun;
//            weapon.equipWeapon();
//        }
            weapon = gun;
            weapon.equipWeapon();
        }

        public void unequip(Gun gun) {
//        if (weapon == null) {
//            System.out.println("You need a weapon first!");
//        } else {
//            weapon = gun;
//            weapon.unequipWeapon();
//        }
            weapon = gun;
            weapon.unequipWeapon();
        }

        public void earnMoney(int amount) {
            if (amount > 0) {
                money += amount;
            }
        }

        public void addWantedLevel(int amount) {
            if (amount > 0) {
                wantedLevel = Math.min(5, wantedLevel + amount);
            }
        }

        public int getWantedLevel() {
            return wantedLevel;
        }

        public void escapePolice() {
            wantedLevel = Math.max(0, wantedLevel - 1);
        }

        public void showStatus() {
            System.out.println("\n===== PLAYER STATUS =====");
            System.out.println("Name: " + getName());
            System.out.println("Health: " + getHealth());
            System.out.println("Money: $" + money);
            System.out.println("Wanted Level: " + wantedLevel);
            System.out.println("Vehicle: " +
                    (vehicle == null ? "None" : vehicle.getName()));
        }
    }

    // INHERITANCE: Police is a Character
    class Police extends Character {

        public Police(String name) {
            super(name);
        }

        public void chase(Player player) {
            System.out.println(getName() + " is chasing you!");

            if (player.getWantedLevel() >= 3) {
                System.out.println("Police catch up and you take 30 damage!");
                player.takeDamage(30);
            } else {
                System.out.println("You escape through a side street!");
                player.escapePolice();
            }
        }
    }
