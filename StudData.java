/* Practical 10
Implement Java program to implement a base class consisting of the data
members such as name of the student, roll number and subject. The
derived class consists of the data members subject code, internal
assessment and university examination marks. The program should have
the facilities. i) Build a master table ii) List a table iii) Insert a new entry
iv) Delete old entry v) Edit an entry vi) Search for a record. Use virtual
functions.
*/

import java.util.*;
class Student {
protected String name;
protected int rollNumber;
protected String subject;
public Student(String name, int rollNumber, String subject) {
this.name = name;
this.rollNumber = rollNumber;
this.subject = subject;
}
public void displayInfo() {
System.out.println("Name :" + name);
System.out.println("Roll Number:" + rollNumber);
System.out.println("Subjects:" + subject);
}
}
class SubjectDetails extends Student {
public static int internal;
String subjectCode;
private int internalAsses;
int universityMarks;
public SubjectDetails(String name, int rollNumber, String subject, String subjectCode, int
internalAsses,
int universityMarks) {
super(name, rollNumber, subject);
this.subjectCode = subjectCode;
this.internalAsses = internalAsses;
this.universityMarks = universityMarks;
}
@Override
public void displayInfo() {
super.displayInfo();
System.out.println("Subject Code:" + subjectCode);
System.out.println("Internal Assesment Marks:" + internalAsses);
System.out.println("University Examination Marks:" + universityMarks);
}
}
public class StudData{
static final int MAX_STUDENTS = 100;
static Student[] Menu = new Student[MAX_STUDENTS];
static int numStudents = 0;
static Scanner sc = new Scanner(System.in);
public static void main(String args[]) {
while (true) {
System.out.println("1.Insert a new Entry.");
System.out.println("2.Delete an Old Entry.");
System.out.println("3.Edit an Entry.");
System.out.println("4.Search for a record.");
System.out.println("5.Exit.");
System.out.println("Enter your Choice: ");
int ch = sc.nextInt();
switch (ch) {
case 1:
insertEntry();
break;
case 2:
deleteEntry();
break;
case 3:
editEntry();
break;
case 4:
searchRecord();
break;
case 5:
System.out.println("Exiting...");
System.exit(0);
break;
default:
System.out.println("Invalid Choice!");
}
}
}
static void insertEntry() {
if (numStudents >= MAX_STUDENTS) {
System.out.println("Menu is full!");
return;
}
System.out.println("Enter the Name:");
String name = sc.next();
System.out.println("Enter Roll Number:");
int rollNumber = sc.nextInt();
System.out.println("Enter Subjects:");
String subject = sc.next();
System.out.println("Enter Subject Codes:");
String subjectCode = sc.next();
System.out.println("Enter internal Assesment Marks:");
int internal = sc.nextInt();
System.out.println("Enter University Examination Marks:");
int universityMarks = sc.nextInt();
SubjectDetails newEntry = new SubjectDetails(name, rollNumber, subject, subjectCode, internal,
universityMarks);
Menu[numStudents++] = newEntry;
System.out.println("New Entry inserted successfully!");
}
static void deleteEntry() {
if (numStudents == 0) {
System.out.println("Menu is Empty!");
} else {
System.out.println("Enter the roll number of the entry to delete:");
int rollNumber = sc.nextInt();
for (int i = 0; i < numStudents; i++) {
if (Menu[i].rollNumber == rollNumber) {
for (int j = i; j < numStudents - 1; j++) {
Menu[j] = Menu[j + 1];
}
numStudents--;
System.out.println("Entry deleted Successfully!");
return;
}
}
System.out.println("Entry Not found!");
}
}
static void editEntry() {
if (numStudents == 0) {
System.out.println("Menu is Empty!");
} else {
System.out.println("Enter the roll number of entry to edit:");
int rollNumber = sc.nextInt();
for (int i = 0; i < numStudents; i++) {
if (Menu[i].rollNumber == rollNumber) {
System.out.println("Enter New Details:");
System.out.println("Name: ");
Menu[i].name = sc.next();
System.out.println("Subject: ");
Menu[i].subject = sc.next();
System.out.println("Subject Code: ");
((SubjectDetails) Menu[i]).subjectCode = sc.next();
System.out.println("Internal assessment Marks: ");
((SubjectDetails) Menu[i]).internal = sc.nextInt();
System.out.println("University Examination marks: ");
((SubjectDetails) Menu[i]).universityMarks = sc.nextInt();
System.out.println("Entry Edited Successfully!");
return;
}
}
System.out.println("Entry Not found!");
}
}
static void searchRecord() {
if (numStudents == 0) {
System.out.println("Menu is Empty!");
} else {
System.out.println("Enter the roll number to search: ");
int rollNumber = sc.nextInt();
for (int i = 0; i < numStudents; i++) {
if (Menu[i].rollNumber == rollNumber) {
Menu[i].displayInfo();
return;
}
}
System.out.println("Entry Not Found!");
}
}
}
