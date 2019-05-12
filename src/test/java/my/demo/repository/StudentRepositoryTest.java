package my.demo.repository;

import lombok.extern.slf4j.Slf4j;
import my.demo.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Rollback(false)
    public void testStudent() {
        String title = "hello";
        String titleUpdated = "world";
        //test insert
        Student student = new Student();
        student.setTitle(title);
        Student stu = studentRepository.save(student);
        log.info(stu.toString());
        Assert.assertEquals(true,stu.getId()>0);

        //test select
        Optional<Student> findStudent = studentRepository.findById(student.getId());
        Assert.assertEquals(title,findStudent.get().getTitle());
        log.info("select test finish.");

        //test update
        student.setTitle(titleUpdated);
        studentRepository.save(student);
        Optional<Student> updatedStudent = studentRepository.findById(student.getId());
        Assert.assertEquals(updatedStudent.get().getTitle(),titleUpdated);
        log.info("update test finish.");

        //test delete
        studentRepository.delete(student);
        Optional<Student> deletedStudent = studentRepository.findById(student.getId());
        Assert.assertEquals(false,deletedStudent.isPresent());
        log.info("delete test finish.");

    }
}
