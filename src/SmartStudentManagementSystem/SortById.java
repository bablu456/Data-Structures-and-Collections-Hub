package SmartStudentManagementSystem;

import java.util.Comparator;

/**
 * SortById - Comparator class for sorting students by ID
 * यह class students को ID के आधार पर sort करने के लिए है
 * 
 * ASCENDING ORDER में sort करेगा - छोटी ID पहले, बड़ी ID बाद में
 */
public class SortById implements Comparator<Student> {

    /**
     * compare method - दो students को ID के आधार पर compare करता है
     * 
     * ASCENDING ORDER में sort होगा - lowest ID पहले
     * 
     * @param s1 - पहला student
     * @param s2 - दूसरा student
     * @return negative if s1 < s2, 0 if equal, positive if s1 > s2
     */
    @Override
    public int compare(Student s1, Student s2) {
        // Integer.compare() का use करके ID compare करते हैं
        // s1.getId() - s2.getId() से ASCENDING order मिलता है
        return Integer.compare(s1.getId(), s2.getId());

        // Alternative way (same result):
        // return s1.getId() - s2.getId();
    }
}
