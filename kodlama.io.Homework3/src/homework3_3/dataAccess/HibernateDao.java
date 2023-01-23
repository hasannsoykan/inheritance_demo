package homework3_3.dataAccess;

import homework3_3.entity.Category;
import homework3_3.entity.Course;
import homework3_3.entity.Instructor;

public class HibernateDao implements CourseDao, CategoryDao, InstructorDao {
    @Override
    public void add(Category category) {
        System.out.println(category.getName() + " hibernate ile eklenmiştir.");
    }

    @Override
    public void add(Course course) {
        System.out.println(course.getName() + " kursu " + course.getPrice()+ " TL fiyatlı hibernate ile eklenmiştir.");
    }

    @Override
    public void add(Instructor instructor) {
        System.out.println(instructor.getFirstName() + " " + instructor.getLastName() + " isimli eğitmen hibernate ile eklenmiştir.");
    }
}
