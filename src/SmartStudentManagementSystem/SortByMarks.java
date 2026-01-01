package SmartStudentManagementSystem;

import java.util.Comparator;

/**
 * SortByMarks - Comparator class for sorting students by marks
 * यह class students को marks के आधार पर sort करने के लिए है
 * 
 * Comparator का use करके हम custom sorting कर सकते हैं
 * Comparable से अलग है - वहाँ default sorting होती है (name से)
 * यहाँ हम अपनी मर्ज़ी से किसी भी field से sort कर सकते हैं
 */
public class SortByMarks implements Comparator<Student> {
    
    /**
     * compare method - दो students को marks के आधार पर compare करता है
     * 
     * DESCENDING ORDER में sort करेगा - highest marks पहले, lowest बाद में
     * यानी जिसके ज़्यादा marks हैं वो पहले आएगा
     * 
     * @param s1 - पहला student
     * @param s2 - दूसरा student
     * @return negative if s1 > s2, 0 if equal, positive if s1 < s2
     *         (descending order के लिए उल्टा comparison)
     */
    @Override
    public int compare(Student s1, Student s2) {
        // Double.compare() का use करके marks compare करते हैं
        // s2.getMarks() - s1.getMarks() इसलिए करते हैं ताकि DESCENDING order मिले
        // अगर ascending चाहिए तो s1 - s2 करेंगे
        return Double.compare(s2.getMarks(), s1.getMarks());
        
        // Alternative way (same result):
        // if (s1.getMarks() > s2.getMarks()) return -1;  // s1 should come first
        // if (s1.getMarks() < s2.getMarks()) return 1;   // s2 should come first
        // return 0;  // both are equal
    }
}
