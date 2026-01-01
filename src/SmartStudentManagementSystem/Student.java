package SmartStudentManagementSystem;

import java.io.Serializable;

/**
 * Student class represents a student entity with all necessary properties.
 * This class implements Serializable for file handling (saving/loading students to/from file)
 * This class implements Comparable for default sorting by name
 * 
 * Collections में store करने और file में save करने के लिए बनाया गया है
 */
public class Student implements Serializable, Comparable<Student> {
    
    // Serial version UID for serialization compatibility
    // Serialization के लिए जरूरी है ताकि version conflicts न हों
    private static final long serialVersionUID = 1L;
    
    // Instance variables - हर student की properties
    private int id;           // Unique student ID
    private String name;      // Student का नाम
    private int age;          // उम्र
    private double marks;     // प्राप्त अंक (obtained marks)
    private String course;    // कोर्स का नाम (e.g., Java, Python, DSA)
    
    /**
     * Default Constructor - empty student बनाने के लिए
     */
    public Student() {
        // Empty constructor for flexibility
    }
    
    /**
     * Parameterized Constructor - सभी values के साथ student बनाने के लिए
     * 
     * @param id - Unique ID for student
     * @param name - Student का नाम
     * @param age - Age of student
     * @param marks - Marks obtained
     * @param course - Course enrolled
     */
    public Student(int id, String name, int age, double marks, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.course = course;
    }
    
    // ==================== GETTERS AND SETTERS ====================
    // हर field के लिए getter और setter methods
    
    /**
     * Get student ID
     * @return student की ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Set student ID
     * @param id - नयी ID set करने के लिए
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get student name
     * @return student का नाम
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set student name
     * @param name - नया नाम set करने के लिए
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get student age
     * @return student की उम्र
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Set student age
     * @param age - नयी age set करने के लिए
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Get student marks
     * @return student के marks
     */
    public double getMarks() {
        return marks;
    }
    
    /**
     * Set student marks
     * @param marks - नए marks set करने के लिए
     */
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    /**
     * Get student course
     * @return student का course
     */
    public String getCourse() {
        return course;
    }
    
    /**
     * Set student course
     * @param course - नया course set करने के लिए
     */
    public void setCourse(String course) {
        this.course = course;
    }
    
    // ==================== COMPARABLE INTERFACE IMPLEMENTATION ====================
    
    /**
     * compareTo method - Comparable interface का हिस्सा
     * Default sorting by NAME (alphabetically)
     * यह method students को नाम के आधार पर sort करता है
     * 
     * @param other - दूसरा student जिससे compare करना है
     * @return negative if this < other, 0 if equal, positive if this > other
     */
    @Override
    public int compareTo(Student other) {
        // Compare students by name (case-insensitive)
        // नाम के आधार पर alphabetically sort होगा (A to Z)
        return this.name.compareToIgnoreCase(other.name);
    }
    
    // ==================== OBJECT CLASS METHODS OVERRIDE ====================
    
    /**
     * toString method - student की सारी information को readable format में return करता है
     * यह console पर student को print करने के लिए use होता है
     * 
     * @return String representation of Student
     */
    @Override
    public String toString() {
        return String.format("ID: %-5d | Name: %-20s | Age: %-3d | Marks: %-6.2f | Course: %-15s",
                            id, name, age, marks, course);
    }
    
    /**
     * equals method - दो students को compare करने के लिए
     * ID के base पर equality check करते हैं क्योंकि ID unique होती है
     * 
     * @param obj - Object to compare with
     * @return true if students have same ID, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // Check if same object reference
        if (this == obj) return true;
        
        // Check if obj is null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Type cast and compare IDs
        Student student = (Student) obj;
        
        // दो students equal हैं अगर उनकी ID same है
        return id == student.id;
    }
    
    /**
     * hashCode method - HashMap और HashSet में use के लिए
     * ID को base बनाकर hash code generate करते हैं
     * 
     * @return hash code based on student ID
     */
    @Override
    public int hashCode() {
        // Hash code based on student ID
        // ID unique है इसलिए यह hash code भी unique होगा
        return Integer.hashCode(id);
    }
}
