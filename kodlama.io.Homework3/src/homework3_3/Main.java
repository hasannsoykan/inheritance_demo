package homework3_3;

import homework3_3.business.CategoryManager;
import homework3_3.business.CourseManager;
import homework3_3.business.InstructorManager;
import homework3_3.core.logging.DatabaseLogger;
import homework3_3.core.logging.FileLogger;
import homework3_3.core.logging.Logger;
import homework3_3.core.logging.MailLogger;
import homework3_3.dataAccess.HibernateDao;
import homework3_3.dataAccess.JdbcDao;
import homework3_3.entity.Category;
import homework3_3.entity.Course;
import homework3_3.entity.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Programlama");
        Category category2 = new Category(2, "Yazılım");
        List<Category> categories = new ArrayList<>();

        CategoryManager categoryManager = new CategoryManager(new HibernateDao(), categories, new DatabaseLogger());
        categoryManager.add(category1);
        categoryManager.add(category2);


        Course course1 = new Course(1, "Java", 30);
        Course course2 = new Course(2, "C#", 15);
        Course course3 = new Course(3, "JavaScript", 40);

        List<Course> courses = new ArrayList<>();

        CourseManager courseManager = new CourseManager(new JdbcDao(), courses, new DatabaseLogger());
        courseManager.add(course1);
        courseManager.add(course2);
        courseManager.add(course3);

        Instructor instructor = new Instructor("Engin", "Demiroğ");
        InstructorManager instructorManager = new InstructorManager(new HibernateDao(), new DatabaseLogger());
        instructorManager.add(instructor);
    }
}