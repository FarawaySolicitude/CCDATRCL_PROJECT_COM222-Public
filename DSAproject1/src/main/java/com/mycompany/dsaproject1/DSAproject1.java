/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dsaproject1;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Section {
    String name;

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Node {
    String sectionName;
    Student student;
    Node next;

    public Node(String sectionName, Student student) {
        this.sectionName = sectionName;
        this.student = student;
    }
}

public class DSAproject1 {
    private static Node head = null;
    private static ArrayList<Section> sections = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Create Section");
            System.out.println("2. Add Student to Section");
            System.out.println("3. Display All Students in Section");
            System.out.println("4. Find Student in Section");
            System.out.println("5. Update Student Info in Section");
            System.out.println("6. Remove Student from Section");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Section Name: ");
                    String sectionName = scanner.nextLine();
                    createSection(sectionName);
                    break;
                case 2:
                    System.out.print("Enter Section Name: ");
                    sectionName = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    addStudentToSection(sectionName, new Student(studentName, studentAge));
                    break;
                case 3:
                    System.out.print("Enter Section Name: ");
                    sectionName = scanner.nextLine();
                    displayAllStudentsInSection(sectionName);
                    break;
                case 4:
                    System.out.print("Enter Section Name: ");
                    sectionName = scanner.nextLine();
                    System.out.print("Enter Student Name to Find: ");
                    studentName = scanner.nextLine();
                    findStudentInSection(sectionName, studentName);
                    break;
                case 5:
                    System.out.print("Enter Section Name: ");
                    sectionName = scanner.nextLine();
                    System.out.print("Enter Student Name to Update: ");
                    studentName = scanner.nextLine();
                    updateStudentInSection(sectionName, studentName, scanner);
                    break;
                case 6:
                    System.out.print("Enter Section Name: ");
                    sectionName = scanner.nextLine();
                    System.out.print("Enter Student Name to Remove: ");
                    studentName = scanner.nextLine();
                    removeStudentFromSection(sectionName, studentName);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createSection(String sectionName) {
        sections.add(new Section(sectionName));
        System.out.println("Section '" + sectionName + "' created.");
    }

    private static void addStudentToSection(String sectionName, Student student) {
        for (Section section : sections) {
            if (section.getName().equals(sectionName)) {
                if (head == null) {
                    head = new Node(sectionName, student);
                } else {
                    Node current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = new Node(sectionName, student);
                }
                System.out.println("Student '" + student.getName() + "' added to section '" + sectionName + "'.");
                return;
            }
        }
        System.out.println("Section '" + sectionName + "' not found.");
    }

    private static void displayAllStudentsInSection(String sectionName) {
        System.out.println("Students in Section '" + sectionName + "':");
        Node current = head;
        while (current != null) {
            if (current.sectionName.equals(sectionName) && current.student != null) {
                System.out.println("Name: " + current.student.getName() + " - Age: " + current.student.getAge());
            }
            current = current.next;
        }
    }

    private static void findStudentInSection(String sectionName, String studentName) {
        Node current = head;
        while (current != null) {
            if (current.sectionName.equals(sectionName) && current.student != null && current.student.getName().equals(studentName)) {
                System.out.println("Student '" + studentName + "' found in section '" + sectionName + "'.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student '" + studentName + "' not found in section '" + sectionName + "'.");
    }

    private static void updateStudentInSection(String sectionName, String studentName, Scanner scanner) {
        Node current = head;
        while (current != null) {
            if (current.sectionName.equals(sectionName) && current.student != null && current.student.getName().equals(studentName)) {
                System.out.print("Enter New Student Name: ");
                String newStudentName = scanner.nextLine();
                System.out.print("Enter New Student Age: ");
                int newStudentAge = scanner.nextInt();
                current.student.name = newStudentName;
                current.student.age = newStudentAge;
                System.out.println("Student info updated in section '" + sectionName + "'.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student '" + studentName + "' not found in section '" + sectionName + "'.");
    }

    private static void removeStudentFromSection(String sectionName, String studentName) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.sectionName.equals(sectionName) && current.student != null && current.student.getName().equals(studentName)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    current.student = null;
                }
                System.out.println("Student '" + studentName + "' removed from section '" + sectionName + "'.");
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Student '" + studentName + "' not found in section '" + sectionName + "'.");
    }
}
