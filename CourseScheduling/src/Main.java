public class Main {

    public static void main(String[] args) {

        Scheduler.addCourse("Git",3);
        Scheduler.addCourse("Clean Code",2);
        Scheduler.addCourse("HTML",4);
        Scheduler.addCourse("CSS",4);
        Scheduler.addCourse("Javascript",10);
        Scheduler.addCourse("Java",5);
        Scheduler.addCourse("Typescript",5);
        Scheduler.addCourse("Object Oriented Programming",3);
        Scheduler.addCourse("Spring",15);
        Scheduler.addCourse("React",20);

        Scheduler.addCourseDependency("Java", "Object Oriented Programming");
        Scheduler.addCourseDependency("Java", "Spring");
        Scheduler.addCourseDependency("Clean Code", "React");
        Scheduler.addCourseDependency("Object Oriented Programming", "Spring");
        Scheduler.addCourseDependency("Clean Code", "Spring");
        Scheduler.addCourseDependency("HTML", "Spring");
        Scheduler.addCourseDependency("CSS", "Spring");
        Scheduler.addCourseDependency("HTML", "React");
        Scheduler.addCourseDependency("CSS", "Javascript");
        Scheduler.addCourseDependency("Clean Code", "Java");
        Scheduler.addCourseDependency("Javascript", "Typescript");
        Scheduler.addCourseDependency("CSS", "React");
        Scheduler.addCourseDependency("Javascript", "React");
        Scheduler.addCourseDependency("HTML", "Javascript");
        Scheduler.addCourseDependency("HTML", "Typescript");
        Scheduler.addCourseDependency("Clean Code", "Javascript");
        Scheduler.addCourseDependency("CSS", "Typescript");
        Scheduler.addCourseDependency("Typescript", "React");
        Scheduler.addCourseDependency("Clean Code", "Typescript");
        Scheduler.addCourseDependency("HTML", "CSS");

        Scheduler.start();

    }

}