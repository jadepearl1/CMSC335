/* Project1.java
 * Jade Pearl
 * CMSC 335 Project 1
 * 10/31/2023
 * Purpose: The Project1 class holds the main method where the program prompts the user to pick a selection
 * from the menu. Each selection has a shape that will be created: Circle, square, triangle, rectangle, sphere,
 * cube, cone, cylinder, and torus. Once the user will make a selection, it will ask for the needed information
 * e.g. radius for a circle and return area if it is a 2D shape or volume if it is a 3D object. all calculations
 * are carried out with method calls to the other classes. The user will have the opportunity to continue entering
 * shapes or exit the program whenever they complete making a shape. The main method ensures running continuously
 * until the user exits the program and validates input in case the user enters a wrong number or character. Upon
 * leaving, the program outputs a thank you message and the current date and time.*/

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project1 {
    public static void main(String[] args) {
        //create Scanner object and objects that handle the date.
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd 'at' hh:mm a");
        Date date = new Date();
        
        System.out.println("********* Welcome to the Java OO Shapes Program **********");

        //use a while loop to run through the choices and print the menu
        while (true) {
            System.out.println("Select from the menu below:");
            System.out.println("1. Construct a Circle");
            System.out.println("2. Construct a Rectangle");
            System.out.println("3. Construct a Square");
            System.out.println("4. Construct a Triangle");
            System.out.println("5. Construct a Sphere");
            System.out.println("6. Construct a Cube");
            System.out.println("7. Construct a Cone");
            System.out.println("8. Construct a Cylinder");
            System.out.println("9. Construct a Torus");
            System.out.println("10. Exit the program");

            //helps the loop validate what the user enters as their choice.
            int choice = -1;
            //the user will enter a choice from the menu
            while (choice < 1 || choice > 10) {
                choice = input.nextInt();
                if(choice < 1 || choice > 10) {
                    System.out.println("Please enter a valid choice from the menu.");
                }
            }
            //break from the program if the user enters a 10.
            if (choice == 10) {
                System.out.println("Thanks for using the program. Today is " + dateFormat.format(date) + ".");
                break;
            }
            //use a switch statement and cases to use the menu selections 1-9
            switch (choice) {
                case 1:
                    // Construct a Circle object
                    System.out.println("You have selected a Circle");
                    System.out.println("What is the radius? ");
                    double radius = input.nextDouble();
                    Circle circle = new Circle(radius);
                    //rounds the area to 2 decimal places
                    System.out.printf("The area of the Circle is %.2f.\n", circle.getArea());
                    break;
                case 2:
                    // Construct a Rectangle
                    System.out.println("You have selected a Rectangle");
                    System.out.println("What is the length? ");
                    double length = input.nextDouble();
                    System.out.println("What is the width? ");
                    double width = input.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    System.out.printf("The area of the Rectangle is %.2f.\n", rectangle.getArea());
                    break;
                case 3:
                    // Construct a Square
                    System.out.println("You have selected a Square");
                    System.out.println("What is the length of all sides? ");
                    double sideLength = input.nextDouble();
                    Square square = new Square(sideLength);
                    System.out.printf("The area of the Square is %.2f.\n", square.getArea());
                    break;
                case 4:
                    // Construct a Triangle
                    System.out.println("You have selected a Triangle");
                    System.out.println("What is the base? ");
                    double base = input.nextDouble();
                    System.out.println("What is the height? ");
                    double height = input.nextDouble();
                    Triangle triangle = new Triangle(base, height);
                    System.out.printf("The area of the Triangle is %.2f.\n", triangle.getArea());
                    break;
                case 5:
                    // Construct a Sphere; first of the 3D shapes
                    System.out.println("You have selected a Sphere");
                    System.out.println("What is the radius? ");
                    double sphereRadius = input.nextDouble();
                    Sphere sphere = new Sphere(sphereRadius);
                    System.out.printf("The volume of the Sphere is %.2f.\n", sphere.getVolume());
                    break;
                case 6:
                    // Construct a Cube
                    System.out.println("You have selected a Cube");
                    System.out.println("What is the length of all sides? ");
                    double cubeLength = input.nextDouble();
                    Cube cube = new Cube(cubeLength);
                    System.out.printf("The volume of the Cube is %.2f.\n", cube.getVolume());
                    break;
                case 7:
                    // Construct a Cone
                    System.out.println("You have selected a Cone");
                    System.out.println("What is the radius? ");
                    double coneRadius = input.nextDouble();
                    System.out.println("What is the height? ");
                    double coneHeight = input.nextDouble();
                    Cone cone = new Cone(coneRadius, coneHeight);
                    System.out.printf("The volume of the Cone is %.2f.\n", cone.getVolume());
                    break;
                case 8:
                    // Construct a Cylinder
                    System.out.println("You have selected a Cylinder");
                    System.out.println("What is the radius? ");
                    double cylinderRadius = input.nextDouble();
                    System.out.println("What is the height? ");
                    double cylinderHeight = input.nextDouble();
                    Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                    System.out.printf("The volume of the Cylinder is %.2f.\n", cylinder.getVolume());
                    break;
                case 9:
                    // Construct a Donut!! (Torus)
                    System.out.println("You have selected a Torus");
                    System.out.println("What is the major radius? ");
                    double major = input.nextDouble();
                    System.out.println("What is the minor radius? ");
                    double minor = input.nextDouble();
                    Torus torus = new Torus(major, minor);
                    System.out.printf("The volume of the Torus is %.2f.\n", torus.getVolume());
                    break;
                default:
                    break;
            }

            //create a string that allows the user to continue using the app
            String cont;
            do {
                System.out.print("Would you like to continue? (Y or N): ");
                cont = input.next();
                //input validation if the user does not enter y or n
                if (!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N")) {
                    System.out.println("Sorry, I do not understand. Enter Y or N.");
                }
            } while (!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N"));
            //kick out if the user chooses not to continue. Print out the date
            if (cont.equalsIgnoreCase("N")) {
                System.out.println("Thanks for using the program. Today is " + dateFormat.format(date) + ".");
                break;
            }
        }
        //close while loop once broken from the program and close the scanner
        input.close();
    }
}
