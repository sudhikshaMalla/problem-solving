import orderGenerators.TopologicalOrderGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {

    private static ArrayList<Course> courses = new ArrayList<>();
    private static Graph courseGraph;
    private static HashMap<Course, Integer> courseIndexMap = new HashMap<>();
    private static HashMap<String, Course> courseNameMap = new HashMap<>();
    private static ArrayList<Course> orderedCourses = new ArrayList<>();


    public static void start() {
        getOrderedCourses();
        printSchedule();
    }

    private static void mapCourses() {
        for (int i=0; i<courses.size(); i++) {
            courseIndexMap.put(courses.get(i),i);
        }
    }

    public static void addCourse(String courseName, int duration) {
        if(courseNameMap.containsKey(courseName))
            throw new RuntimeException("Course with name " + courseName + " already exists");
        Course course = new Course(courseName, duration);
        courses.add(course);
        courseNameMap.put(courseName, course);
    }

    public static void createGraph() {
        mapCourses();
        courseGraph = new Graph(courses.size(), new TopologicalOrderGenerator());
    }

    public static void addCourseDependency(String start, String end) {
        if(courseGraph == null) {
            createGraph();
        }
        if(!courseNameMap.containsKey(start))
            throw new RuntimeException("There is no course with name " + start);
        else if(!courseNameMap.containsKey(end))
            throw new RuntimeException("There is no course with name " + end);
        else
            courseGraph.addEdge(courseIndexMap.get(courseNameMap.get(start)),courseIndexMap.get(courseNameMap.get(end)));
    }

    private static void getOrderedCourses() {

        ArrayList<Integer> orderedIndices = courseGraph.getOrderedIndices();

        for (int i=0; i<orderedIndices.size(); i++) {
            orderedCourses.add(courses.get(orderedIndices.get(i)));
        }
    }

    private static void printSchedule() {

        int planDuration = 0;

        System.out.println("SCHEDULED PLAN :\n");

        for (int i=0; i<orderedCourses.size(); i++) {
            Course tempCourse = orderedCourses.get(i);
            planDuration += tempCourse.getDurationInDays();
            System.out.println(tempCourse.getName() + "\t-\t" + tempCourse.getDurationInDays() + " Days");
        }
        System.out.println("\nTotal Plan Duration : " + planDuration + " Days");


    }

}