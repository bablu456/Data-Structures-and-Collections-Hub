package SmartStudentManagementSystem;

import java.io.*;
import java.util.*;

/**
 * StudentManagementSystem - Main class जो पूरा system manage करता है
 * 
 * यह class सभी collections को use करता है:
 * - ArrayList<Student> : सभी students को store करने के लिए
 * - HashSet<Integer> : duplicate IDs detect करने के लिए
 * - HashMap<Integer, Student> : ID से student को fast search करने के लिए
 * - TreeSet<Student> : toppers को sorted order में रखने के लिए
 */
public class StudentManagementSystem {

    // ==================== COLLECTIONS DECLARATION ====================

    /**
     * ArrayList<Student> - Main storage for all students
     * यहाँ सभी students store होंगे
     * ArrayList क्यों? - dynamic size, order maintain करता है, duplicates allow
     * करता है
     */
    private ArrayList<Student> studentList;

    /**
     * HashSet<Integer> - To detect duplicate IDs
     * Duplicate student IDs को detect करने के लिए
     * HashSet क्यों? - O(1) time में check कर सकते हैं कि ID already exist करती है
     * या नहीं
     */
    private HashSet<Integer> studentIds;

    /**
     * HashMap<Integer, Student> - For fast ID-based search
     * ID से student को जल्दी search करने के लिए (O(1) time complexity)
     * HashMap क्यों? - key-value pair में store होता है, fast retrieval
     */
    private HashMap<Integer, Student> studentMap;

    /**
     * TreeSet<Student> - For storing toppers in sorted order
     * Toppers (marks > 80) को sorted order में store करने के लिए
     * TreeSet क्यों? - automatically sorted रहता है, duplicates allow नहीं करता
     */
    private TreeSet<Student> toppers;

    /**
     * Scanner - Console से input लेने के लिए
     */
    private Scanner scanner;

    /**
     * File path - जहाँ students का data save होगा
     */
    private static final String FILE_PATH = "students.dat";

    // ==================== CONSTRUCTOR ====================

    /**
     * Constructor - सभी collections को initialize करता है
     */
    public StudentManagementSystem() {
        // ArrayList को initialize करते हैं - सभी students यहाँ होंगे
        studentList = new ArrayList<>();

        // HashSet को initialize करते हैं - duplicate IDs track करने के लिए
        studentIds = new HashSet<>();

        // HashMap को initialize करते हैं - fast search के लिए
        studentMap = new HashMap<>();

        // TreeSet को initialize करते हैं - toppers को sorted रखने के लिए
        // SortByMarks comparator use कर रहे हैं ताकि marks के base पर sort हो
        toppers = new TreeSet<>(new SortByMarks());

        // Scanner object बनाते हैं user input के लिए
        scanner = new Scanner(System.in);
    }

    // ==================== MAIN MENU ====================

    /**
     * displayMenu - Console पर menu display करता है
     */
    public void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     SMART STUDENT MANAGEMENT SYSTEM - COLLECTIONS          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1.  Add Student (नया student जोड़ें)");
        System.out.println("2.  Remove Student (student हटाएं)");
        System.out.println("3.  Update Student (student की info update करें)");
        System.out.println("4.  Search Student by ID (ID से student खोजें)");
        System.out.println("5.  View All Students (सभी students देखें)");
        System.out.println("6.  Sort Students (students को sort करें)");
        System.out.println("7.  Filter Students (students को filter करें)");
        System.out.println("8.  Save Data to File (data को file में save करें)");
        System.out.println("9.  Load Data from File (data को file से load करें)");
        System.out.println("10. Exit (प्रोग्राम बंद करें)");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.print("Enter your choice (अपनी पसंद enter करें): ");
    }

    /**
     * run - Main method जो while loop में menu चलाता है
     */
    public void run() {
        boolean running = true;

        // Infinite loop - जब तक user exit नहीं करता
        while (running) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Switch case से user की choice handle करते हैं
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        searchStudent();
                        break;
                    case 5:
                        viewAllStudents();
                        break;
                    case 6:
                        sortStudents();
                        break;
                    case 7:
                        filterStudents();
                        break;
                    case 8:
                        saveToFile();
                        break;
                    case 9:
                        loadFromFile();
                        break;
                    case 10:
                        System.out.println("\n✓ Thank you for using Student Management System!");
                        System.out.println("✓ धन्यवाद! Program बंद हो रहा है...");
                        running = false; // Loop से बाहर निकलने के लिए
                        break;
                    default:
                        System.out.println("✗ Invalid choice! कृपया 1-10 के बीच का number enter करें।");
                }
            } catch (InputMismatchException e) {
                System.out.println("✗ Invalid input! कृपया valid number enter करें।");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("✗ Error occurred: " + e.getMessage());
            }
        }

        // Scanner को close करते हैं resource leak से बचने के लिए
        scanner.close();
    }

    // ==================== 1. ADD STUDENT ====================

    /**
     * addStudent - नया student add करता है
     * यह method सभी collections में student को add करता है
     */
    private void addStudent() {
        System.out.println("\n--- Add New Student (नया Student जोड़ें) ---");

        try {
            // ID input लेते हैं
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // HashSet से check करते हैं कि यह ID पहले से exist तो नहीं करती
            if (studentIds.contains(id)) {
                System.out.println("✗ Error: Student with ID " + id + " already exists!");
                System.out.println("✗ यह ID पहले से मौजूद है। कृपया दूसरी ID use करें।");
                return; // Method से बाहर निकल जाते हैं
            }

            // बाकी details input लेते हैं
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            System.out.print("Enter Marks (0-100): ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            // नया Student object बनाते हैं
            Student student = new Student(id, name, age, marks, course);

            // सभी collections में add करते हैं

            // 1. ArrayList में add करते हैं
            studentList.add(student);

            // 2. HashSet में ID add करते हैं (duplicate detection के लिए)
            studentIds.add(id);

            // 3. HashMap में ID-Student pair add करते हैं (fast search के लिए)
            studentMap.put(id, student);

            // 4. अगर marks > 80 हैं तो TreeSet में add करते हैं (toppers में)
            if (marks > 80) {
                toppers.add(student);
            }

            System.out.println("✓ Student added successfully!");
            System.out.println("✓ Student सफलतापूर्वक add हो गया!");

        } catch (InputMismatchException e) {
            System.out.println("✗ Invalid input! कृपया सही format में data enter करें।");
            scanner.nextLine(); // Clear buffer
        }
    }

    // ==================== 2. REMOVE STUDENT (with Iterator) ====================

    /**
     * removeStudent - Student को ID के base पर remove करता है
     * यहाँ Iterator का use करते हैं safe removal के लिए
     */
    private void removeStudent() {
        System.out.println("\n--- Remove Student (Student हटाएं) ---");

        if (studentList.isEmpty()) {
            System.out.println("✗ No students found! पहले कुछ students add करें।");
            return;
        }

        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check करते हैं कि यह ID exist करती है या नहीं
        if (!studentIds.contains(id)) {
            System.out.println("✗ Student with ID " + id + " not found!");
            return;
        }

        // Iterator use करके safely remove करते हैं
        // Iterator क्यों? - loop के दौरान collection modify करना safe है
        Iterator<Student> iterator = studentList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            // अगर ID match करती है तो remove करते हैं
            if (student.getId() == id) {
                // ArrayList से iterator के through remove करते हैं
                iterator.remove();

                // HashSet से ID remove करते हैं
                studentIds.remove(id);

                // HashMap से entry remove करते हैं
                studentMap.remove(id);

                // TreeSet से भी remove करते हैं (if present)
                toppers.remove(student);

                System.out.println("✓ Student removed successfully!");
                System.out.println("✓ Student सफलतापूर्वक remove हो गया!");
                return;
            }
        }
    }

    // ==================== 3. UPDATE STUDENT ====================

    /**
     * updateStudent - Student की information को update करता है
     */
    private void updateStudent() {
        System.out.println("\n--- Update Student (Student Update करें) ---");

        if (studentList.isEmpty()) {
            System.out.println("✗ No students found!");
            return;
        }

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // HashMap से student को fetch करते हैं (O(1) time में)
        Student student = studentMap.get(id);

        if (student == null) {
            System.out.println("✗ Student with ID " + id + " not found!");
            return;
        }

        // Current details दिखाते हैं
        System.out.println("\nCurrent Details:");
        System.out.println(student);

        // Update menu
        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Marks");
        System.out.println("4. Course");
        System.out.println("5. Update All");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // पुरानी marks को store करते हैं (toppers update के लिए)
        double oldMarks = student.getMarks();

        // Switch case से field update करते हैं
        switch (choice) {
            case 1:
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter new Age: ");
                student.setAge(scanner.nextInt());
                break;
            case 3:
                System.out.print("Enter new Marks: ");
                student.setMarks(scanner.nextDouble());
                break;
            case 4:
                System.out.print("Enter new Course: ");
                student.setCourse(scanner.nextLine());
                break;
            case 5:
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Age: ");
                student.setAge(scanner.nextInt());
                System.out.print("Enter new Marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Enter new Course: ");
                student.setCourse(scanner.nextLine());
                break;
            default:
                System.out.println("✗ Invalid choice!");
                return;
        }

        // Toppers TreeSet को update करते हैं
        // पहले पुराने marks वाले student को remove करते हैं
        if (oldMarks > 80) {
            toppers.remove(student);
        }
        // अगर नए marks > 80 हैं तो add करते हैं
        if (student.getMarks() > 80) {
            toppers.add(student);
        }

        System.out.println("✓ Student updated successfully!");
        System.out.println("✓ Student की details update हो गई हैं!");
    }

    // ==================== 4. SEARCH STUDENT BY ID ====================

    /**
     * searchStudent - ID के base पर student को search करता है
     * HashMap का use करके O(1) time में search होता है
     */
    private void searchStudent() {
        System.out.println("\n--- Search Student by ID (ID से खोजें) ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // HashMap से directly student fetch करते हैं
        // यह बहुत fast है - O(1) time complexity
        Student student = studentMap.get(id);

        if (student == null) {
            System.out.println("✗ Student with ID " + id + " not found!");
            System.out.println("✗ इस ID का कोई student नहीं मिला।");
        } else {
            System.out.println("\n✓ Student Found:");
            System.out.println("─────────────────────────────────────────────────────────────");
            System.out.println(student);
            System.out.println("─────────────────────────────────────────────────────────────");
        }
    }

    // ==================== 5. VIEW ALL STUDENTS ====================

    /**
     * viewAllStudents - सभी students को display करता है
     */
    private void viewAllStudents() {
        System.out.println("\n--- All Students (सभी Students) ---");

        if (studentList.isEmpty()) {
            System.out.println("✗ No students found! पहले students add करें।");
            return;
        }

        System.out.println("Total Students: " + studentList.size());
        System.out.println("─────────────────────────────────────────────────────────────────────────────");

        // Enhanced for loop से सभी students को print करते हैं
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("─────────────────────────────────────────────────────────────────────────────");
    }

    // ==================== 6. SORT STUDENTS ====================

    /**
     * sortStudents - Different comparators use करके students को sort करता है
     */
    private void sortStudents() {
        System.out.println("\n--- Sort Students (Students को Sort करें) ---");

        if (studentList.isEmpty()) {
            System.out.println("✗ No students found!");
            return;
        }

        System.out.println("Sort by:");
        System.out.println("1. Name (नाम से - Alphabetically)");
        System.out.println("2. Age (उम्र से - Youngest first)");
        System.out.println("3. Marks (अंकों से - Highest first)");
        System.out.println("4. ID (ID से - Lowest first)");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Switch case से appropriate comparator choose करते हैं
        switch (choice) {
            case 1:
                // Collections.sort() with Comparable (default - by name)
                // Student class में compareTo() method है जो name से sort करता है
                Collections.sort(studentList);
                System.out.println("✓ Sorted by Name (Alphabetically)");
                break;

            case 2:
                // Collections.sort() with SortByAge Comparator
                Collections.sort(studentList, new SortByAge());
                System.out.println("✓ Sorted by Age (Youngest first)");
                break;

            case 3:
                // Collections.sort() with SortByMarks Comparator
                Collections.sort(studentList, new SortByMarks());
                System.out.println("✓ Sorted by Marks (Highest first)");
                break;

            case 4:
                // Collections.sort() with SortById Comparator
                Collections.sort(studentList, new SortById());
                System.out.println("✓ Sorted by ID (Lowest first)");
                break;

            default:
                System.out.println("✗ Invalid choice!");
                return;
        }

        // Sorted list को display करते हैं
        System.out.println("\n─────────────────────────────────────────────────────────────────────────────");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("─────────────────────────────────────────────────────────────────────────────");
    }

    // ==================== 7. FILTER STUDENTS ====================

    /**
     * filterStudents - Different criteria के base पर students को filter करता है
     */
    private void filterStudents() {
        System.out.println("\n--- Filter Students (Students को Filter करें) ---");

        if (studentList.isEmpty()) {
            System.out.println("✗ No students found!");
            return;
        }

        System.out.println("Filter by:");
        System.out.println("1. Marks > 80 (Toppers)");
        System.out.println("2. Specific Course");
        System.out.println("3. Age Range");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Filtered students को store करने के लिए list
        ArrayList<Student> filtered = new ArrayList<>();

        switch (choice) {
            case 1:
                // TreeSet से toppers को directly get कर सकते हैं
                // यह automatically sorted है (marks के base पर)
                System.out.println("\n--- TOPPERS (Marks > 80) ---");
                if (toppers.isEmpty()) {
                    System.out.println("✗ No toppers found! (कोई topper नहीं है)");
                } else {
                    System.out.println("Total Toppers: " + toppers.size());
                    System.out.println("─────────────────────────────────────────────────────────────────────────────");
                    for (Student student : toppers) {
                        System.out.println(student);
                    }
                    System.out.println("─────────────────────────────────────────────────────────────────────────────");
                }
                return;

            case 2:
                // Course के base पर filter करते हैं
                System.out.print("Enter Course name: ");
                String course = scanner.nextLine();

                for (Student student : studentList) {
                    // equalsIgnoreCase() से case-insensitive comparison
                    if (student.getCourse().equalsIgnoreCase(course)) {
                        filtered.add(student);
                    }
                }

                System.out.println("\n--- Students in " + course + " course ---");
                break;

            case 3:
                // Age range के base पर filter करते हैं
                System.out.print("Enter minimum age: ");
                int minAge = scanner.nextInt();
                System.out.print("Enter maximum age: ");
                int maxAge = scanner.nextInt();

                for (Student student : studentList) {
                    if (student.getAge() >= minAge && student.getAge() <= maxAge) {
                        filtered.add(student);
                    }
                }

                System.out.println("\n--- Students with age between " + minAge + " and " + maxAge + " ---");
                break;

            default:
                System.out.println("✗ Invalid choice!");
                return;
        }

        // Filtered results को display करते हैं
        if (filtered.isEmpty()) {
            System.out.println("✗ No students match the filter criteria!");
        } else {
            System.out.println("Total students found: " + filtered.size());
            System.out.println("─────────────────────────────────────────────────────────────────────────────");
            for (Student student : filtered) {
                System.out.println(student);
            }
            System.out.println("─────────────────────────────────────────────────────────────────────────────");
        }
    }

    // ==================== 8. SAVE TO FILE (Serialization) ====================

    /**
     * saveToFile - सभी students को file में save करता है
     * Java Serialization का use करते हैं
     */
    private void saveToFile() {
        System.out.println("\n--- Save Data to File (Data को File में Save करें) ---");

        // try-with-resources statement - automatically close हो जाएगी
        // यह best practice है क्योंकि resource leak नहीं होता
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))) {

            // पूरी ArrayList को file में write करते हैं
            oos.writeObject(studentList);

            System.out.println("✓ Data saved successfully to " + FILE_PATH);
            System.out.println("✓ कुल " + studentList.size() + " students को file में save किया गया!");

        } catch (IOException e) {
            System.out.println("✗ Error saving file: " + e.getMessage());
            System.out.println("✗ File save करने में error आई!");
        }
    }

    // ==================== 9. LOAD FROM FILE (Deserialization) ====================

    /**
     * loadFromFile - File से students को load करता है
     * Java Deserialization का use करते हैं
     */
    @SuppressWarnings("unchecked") // Type safety warning को suppress करते हैं
    private void loadFromFile() {
        System.out.println("\n--- Load Data from File (File से Data Load करें) ---");

        // पहले check करते हैं कि file exist करती है या नहीं
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("✗ File not found! पहले data save करें।");
            return;
        }

        // try-with-resources statement
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_PATH))) {

            // File से ArrayList को read करते हैं
            ArrayList<Student> loadedList = (ArrayList<Student>) ois.readObject();

            // सभी collections को clear करते हैं
            studentList.clear();
            studentIds.clear();
            studentMap.clear();
            toppers.clear();

            // Loaded students को सभी collections में add करते हैं
            for (Student student : loadedList) {
                studentList.add(student);
                studentIds.add(student.getId());
                studentMap.put(student.getId(), student);

                // Toppers में add करते हैं अगर marks > 80
                if (student.getMarks() > 80) {
                    toppers.add(student);
                }
            }

            System.out.println("✓ Data loaded successfully from " + FILE_PATH);
            System.out.println("✓ कुल " + studentList.size() + " students file से load किए गए!");

        } catch (IOException e) {
            System.out.println("✗ Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Class not found error: " + e.getMessage());
        }
    }

    // ==================== MAIN METHOD ====================

    /**
     * main method - Program का entry point
     * यहाँ से program start होता है
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                      WELCOME TO                            ║");
        System.out.println("║     SMART STUDENT MANAGEMENT SYSTEM - COLLECTIONS          ║");
        System.out.println("║                                                            ║");
        System.out.println("║              स्वागत है आपका!                              ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        // StudentManagementSystem का object बनाते हैं
        StudentManagementSystem sms = new StudentManagementSystem();

        // Program को run करते हैं
        sms.run();
    }
}
