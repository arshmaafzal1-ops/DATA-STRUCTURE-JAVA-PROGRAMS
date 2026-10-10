// SCENARIO: Class ke students ke marks array me store hain.
// Topper, average, aur kisi marks ki search karni hai.
public class ArrayDemo {
    public static void main(String[] args) {
        String[] names = {"Aman", "Riya", "Karan", "Sneha", "Zoya"};
        int[] marks = {72, 91, 65, 88, 79};

        int max = 0, total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
            if (marks[i] > marks[max]) max = i;
        }
        System.out.println("Topper: " + names[max] + " (" + marks[max] + ")");
        System.out.println("Average: " + (double) total / marks.length);

        int target = 65; // linear search
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == target) {
                System.out.println(target + " marks mile: " + names[i] + " (index " + i + ")");
            }
        }
    }
}
