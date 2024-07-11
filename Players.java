/* Practical 7
Write a program in Java to create a player class. Inherit the classes
Cricket_player, Football_player and Hockey_player from player class. The
objective of this assignment is to learn the concepts of inheritance in Java.
*/
import java.util.Scanner;

class Player {
    private String name;
    private int age;
   
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }
   
    public String getName() {
        return name;
    }
   
    public int getAge() {
        return age;
    }
   
    public void play() {
        System.out.println(name + " is playing.");
    }
}

class CricketPlayer extends Player {
    private String team;
   
    public CricketPlayer(String name, int age, String team) {
        super(name, age);
        this.team = team;
    }
   
    public String getTeam() {
        return team;
    }
   

    public void play() {
        System.out.println(getName() + " is playing cricket for " + team + ".");
    }
}

class FootballPlayer extends Player {
    private String club;
   
    public FootballPlayer(String name, int age, String club) {
        super(name, age);
        this.club = club;
    }
   
    public String getClub() {
        return club;
    }
   
 
    public void play() {
        System.out.println(getName() + " is playing football for " + club + ".");
    }
}


class HockeyPlayer extends Player {
    private String team;
   
    public HockeyPlayer(String name, int age, String team) {
        super(name, age);
        this.team = team;
    }
   
    public String getTeam() {
        return team;
    }
   
    @Override
    public void play() {
        System.out.println(getName() + " is playing hockey for " + team + ".");
    }
}


public class Players {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Enter cricket player's name:");
        String cricketName = scanner.nextLine();
        System.out.println("Enter cricket player's age:");
        int cricketAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter cricket player's team:");
        String cricketTeam = scanner.nextLine();
       
        System.out.println("Enter football player's name:");
        String footballName = scanner.nextLine();
        System.out.println("Enter football player's age:");
        int footballAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter football player's club:");
        String footballClub = scanner.nextLine();
       
        System.out.println("Enter hockey player's name:");
        String hockeyName = scanner.nextLine();
        System.out.println("Enter hockey player's age:");
        int hockeyAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter hockey player's team:");
        String hockeyTeam = scanner.nextLine();
       
        CricketPlayer cricketPlayer = new CricketPlayer(cricketName, cricketAge, cricketTeam);
        FootballPlayer footballPlayer = new FootballPlayer(footballName, footballAge, footballClub);
        HockeyPlayer hockeyPlayer = new HockeyPlayer(hockeyName, hockeyAge, hockeyTeam);
       
        cricketPlayer.play();
        footballPlayer.play();
        hockeyPlayer.play();
       
        scanner.close();
    }
}

