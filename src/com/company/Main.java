package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    Gym gym = new Gym();

    public void addPerson(UUID personId, String personName, String address, String sex, UUID trainerId, String trainerName) {
        Trainer trainer = findTrainerById(trainerId);
        if (trainer == null){
            trainer = new Trainer(trainerId, trainerName);
            gym.getTrainer().add(trainer);
        }
        Person person = new Person(personId, personName, address, sex, trainer);
        gym.getPerson().add(person);
    }

    public void addTrainer(UUID id, String name) {
        Trainer trainer = new Trainer(id, name);
        gym.getTrainer().add(trainer);
        System.out.println(gym.getTrainer());
    }

    public void updatePersonName( UUID personId, String newName) {
        Person person = findPersonId(personId);
        if (person != null) {
            person.setName(newName);
        }
        System.out.println(gym.getPerson());
    }

    public Person findPersonId(UUID personId) {
        for (Person person : gym.getPerson()) {
            if (personId.equals(person.getId())) {
                return person;
            }
        }
        return null;
    }
    public Trainer findTrainerById(UUID trainerId) {
        for (Trainer trainer : gym.getTrainer()) {
            if (trainerId.equals(trainer.getId())) {
                return trainer;
            }
        }
        return null;
    }

    public void deletePerson(UUID personId){
        Person person = findPersonId(personId);
        if (person != null) {
            gym.getPerson().remove(person);

        }
    }

    public void updateTrainerName(UUID trainerId, String newName) {

        for(Trainer trainer: gym.getTrainer()){
            if(trainer.getId().equals(trainerId)){
                trainer.setName(newName);
                break;
            }
        }
        System.out.println(gym.getTrainer());
    }

    public List<Person> listAllPerson(){
        return gym.getPerson();
    }

    public List<Trainer> listAllTrainer(){
        return gym.getTrainer();
    }

    public static void main (String[]args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        try {
            boolean stop = false;
            while (!stop) {
                printMenu();
                System.out.println("Enter Your Choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the Person Name: ");
                        String personName = scanner.next();
                        System.out.println("Enter the Person Address: ");
                        String address = scanner.next();
                        System.out.println("Enter the Person Sex: ");
                        String sex = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter the Trainer Name: ");
                        String trainerName = scanner.next();
                        main.addPerson(UUID.randomUUID(), personName, address, sex, UUID.randomUUID(), trainerName);
                        System.out.println("Person  " + personName + " has been added..");
                        break;


                    case 2:
                        System.out.println("Enter the Trainer Name: ");
                        String name = scanner.next();
                        main.addTrainer(UUID.randomUUID(), name);
                        System.out.println("Trainer   " + name + " has been added..");
                        break;
                    case 3:
                        System.out.println("Enter the Trainer Id: ");
                        String trainerId = scanner.next();
                        System.out.println("Enter the Trainer New Name: ");
                        String newName = scanner.next();
                        main.updatePersonName(UUID.fromString(trainerId), newName);
                        break;

                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:

                        break;

                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;

                    default:
                        System.out.println("Thank you for using Gym Management OOPS Application");
                        stop = true;
                        break;
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            scanner.close();
        }
    }


    private static void printMenu() {
        System.out.println("1) Add Person To GYM [+]\n" +
                "2) Add Trainer [+]\n" +
                "3) Update Person Name in GYM [+]\n" +
                "4) update Student By RoomId And StudentId [+]\n" +
                "5) update Room Number Of Student [+]\n" +
                "6) add room [+]\n" +
                "7) update Room Number [-]\n" +
                "8) update Student By Room Id And Student Id [+]\n" +
                "9) Enter the room id to find Room By Id [+]");
        System.out.println("10) exit");
    }
}

