package model;


import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

public class StudentExamTest {
    Course course = new Course("sot","SOT",3);
    ExamID examID = new ExamID("ANDR1",1636239920);
    Student student = mock(Student.class);
    ExamSetup examSetup = new ExamSetup(course,examID);

    @BeforeEach
    public void setUp() {
    }

    /**
     * @verifies throw illegalargumetn exception if student or exam are null
     * @see StudentExam#StudentExam(Student, ExamSetup)
     */
    @Test
    public void StudentExam_shouldThrowIllegalargumetnExceptionIfStudentOrExamAreNull() throws IllegalArgumentException {
        //Act
        StudentExam studentExam = new StudentExam(student,examSetup);
        //Assert
        assertThat(student).isEqualTo(studentExam.getStudent());
    }

    /**
     * @verifies show that logically similar examids are equal
     * @see StudentExam#StudentExam(Student, ExamSetup)
     */
    @Test
    public void StudentExam_shouldShowThatLogicallySimilarExamidsAreEqual() throws Exception {
        StudentExam studentExam = new StudentExam(student,examSetup);
        StudentExam studentExam2 = new StudentExam(student,examSetup);

        //Assert
        Assertions.assertThat(studentExam.getStudent()).isEqualTo(studentExam2.getStudent());
        Assertions.assertThat(studentExam.getExam()).isEqualTo(studentExam2.getExam());
    }

    /**
     * @verifies show that logically not-similar examIds are not equal
     * @see StudentExam#StudentExam(Student, ExamSetup)
     */
    @Test
    public void StudentExam_shouldShowThatLogicallyNotsimilarExamIdsAreNotEqual() throws Exception {
        StudentExam studentExam = new StudentExam(student,examSetup);
        StudentExam studentExam2 = new StudentExam(student,examSetup);

        //Assert
        Assertions.assertThat(studentExam).isNotEqualTo(studentExam2);
    }
}
