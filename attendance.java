import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class attendance {
    private static final String STUDENTS_FILE = "students.txt";
    private static final String ATTENDANCE_FILE = "attendance.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createFilesIfNotExist();
        
        while (true) {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View All Students");
            System.out.println("5. View Attendance Records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addStudent(scanner); break;
                case 2: removeStudent(scanner); break;
                case 3: markAttendance(scanner); break;
                case 4: viewAllStudents(); break;
                case 5: viewAttendanceRecords(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void createFilesIfNotExist() {
        try {
            new File(STUDENTS_FILE).createNewFile();
            new File(ATTENDANCE_FILE).createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating files");
        }
    }
    
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        String rollNo = scanner.nextLine();
        
        if (studentExists(rollNo)) {
            System.out.println("Student already exists!");
            return;
        }
        
        try (PrintWriter out = new PrintWriter(new FileWriter(STUDENTS_FILE, true))) {
            out.println(rollNo + "," + name);
            System.out.println("Student added!");
        } catch (IOException e) {
            System.out.println("Error saving student");
        }
    }
    
    private static void removeStudent(Scanner scanner) {
        System.out.print("Enter roll number to remove: ");
        String rollNo = scanner.nextLine();
        
        try {
            File inputFile = new File(STUDENTS_FILE);
            File tempFile = new File("temp.txt");
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String line;
            boolean found = false;
            
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(rollNo + ",")) {
                    writer.write(line + "\n");
                } else {
                    found = true;
                }
            }
            
            writer.close();
            reader.close();
            
            if (found) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("Student removed!");
            } else {
                tempFile.delete();
                System.out.println("Student not found!");
            }
        } catch (IOException e) {
            System.out.println("Error removing student");
        }
    }
    
    private static void markAttendance(Scanner scanner) {
        System.out.print("Enter roll number: ");
        String rollNo = scanner.nextLine();
        
        if (!studentExists(rollNo)) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.print("Enter date (YYYY-MM-DD) or press enter for today: ");
        String date = scanner.nextLine();
        if (date.isEmpty()) date = LocalDate.now().toString();
        
        System.out.print("Status (P for Present/A for Absent): ");
        String status = scanner.nextLine().equalsIgnoreCase("P") ? "Present" : "Absent";
        
        try (PrintWriter out = new PrintWriter(new FileWriter(ATTENDANCE_FILE, true))) {
            out.println(rollNo + "," + date + "," + status);
            System.out.println("Attendance marked!");
        } catch (IOException e) {
            System.out.println("Error saving attendance");
        }
    }
    
    private static void viewAllStudents() {
        try (Scanner fileScanner = new Scanner(new File(STUDENTS_FILE))) {
            System.out.println("\nAll Students:");
            System.out.println("Roll No\tName");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 2) {
                        System.out.println(parts[0] + "\t" + parts[1]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No students found");
        }
    }
    
    private static void viewAttendanceRecords() {
        try (Scanner fileScanner = new Scanner(new File(ATTENDANCE_FILE))) {
            System.out.println("\nAttendance Records:");
            System.out.println("Roll No\tDate\t\tStatus");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length >= 3) {
                        System.out.println(parts[0] + "\t" + parts[1] + "\t" + parts[2]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No attendance records found");
        }
    }
    
    private static boolean studentExists(String rollNo) {
        try (Scanner fileScanner = new Scanner(new File(STUDENTS_FILE))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!line.isEmpty() && line.startsWith(rollNo + ",")) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }
}