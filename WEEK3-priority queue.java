import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
 class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>((s1, s2) -> {
            if (s1.getCGPA() != s2.getCGPA())
                return Double.compare(s2.getCGPA(), s1.getCGPA());

            if (!s1.getName().equals(s2.getName()))
                return s1.getName().compareTo(s2.getName());

            return s1.getID() - s2.getID();
        });

        for (String event : events) {
            String[] arr = event.split(" ");

            if (arr[0].equals("ENTER")) {
                String name = arr[1];
                double cgpa = Double.parseDouble(arr[2]);
                int id = Integer.parseInt(arr[3]);

                pq.add(new Student(id, name, cgpa));
            } else {
                if (!pq.isEmpty())
                    pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty())
            result.add(pq.poll());

        return result;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}


OUTPUT:
Input (stdin)
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Expected Output
Dan
Ashley
Shafaet
Maria