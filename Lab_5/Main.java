import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        int n = sc.nextInt();
        sc.nextLine();

        Roster roster = new Roster("test");

        // read and add each record to the roster
        for (int i = 0; i < n; i++) {
            String studentId = sc.next();
            String courseCode = sc.next();
            String assessmentTitle = sc.next();
            String grade = sc.next();

            roster = roster.add(studentId, courseCode, assessmentTitle, grade);
        }

        while (sc.hasNext()) {
            String studentId = sc.next();
            String courseCode = sc.next();
            String assessmentTitle = sc.next();

            // get grade and print out
            String result = roster.getGrade(studentId, courseCode, assessmentTitle);
            output.append(result).append('\n');
        }

        System.out.print(output);
        sc.close();
    }
}
