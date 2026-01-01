package SmartStudentManagementSystem;

import java.util.Comparator;

/**
 * SortByAge - Comparator class for sorting students by age
 * यह class students को age के आधार पर sort करने के लिए है
 * 
 * ASCENDING ORDER में sort करेगा - youngest पहले, oldest बाद में
 */
public class SortByAge implements Comparator<Student> {
    
    /**
     * compare method - दो students को age के आधार पर compare करता है
     * 
     * ASCENDING ORDER में sort होगा - छोटी age पहले आएगी
     * 
     * @param s1 - पहला student
     * @param s2 - दूसरा student
     * @return negative if s1 < s2, 0 if equal, positive if s1 > s2
     */
    @Override
    public int compare(Student s1, Student s2) {
        // Integer.compare() का use करके age compare करते हैं
        // s1.getAge() - s2.getAge() से ASCENDING order मिलता है
        return Integer.compare(s1.getAge(), s2.getAge());
        
        // Alternative way (same result):
        // return s1.getAge() - s2.getAge();
        
        // For DESCENDING order use:
        // return s2.getAge() - s1.getAge();
    }
}
