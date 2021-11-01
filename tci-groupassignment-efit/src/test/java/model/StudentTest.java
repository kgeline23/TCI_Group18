package model;


import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StudentTest {
    private String name = "Spas";
    private long studentnumber = 123456;


    /**
     * @verifies create student with valid parameters
     * @see Student#Student(String, long)
     */
    @Test
    public void Student_shouldCreateStudentWithValidParameters() throws Exception {
        // act
        Student student= new Student(name,studentnumber);

        // assert
        assertThat(student.getName()).isEqualTo(name);
        assertThat(student.getStudentnumber()).isEqualTo(studentnumber);
    }
    /**
     * @verifies show that logically similar courses are equal
     * @see Student#Student(String, long)
     */
    @Test
    public void Student_shouldShowThatLogicallySimilarCoursesAreEqual() throws Exception {
        // Arrange

        // Act
        Student A = new Student(name,studentnumber);
        Student B = new Student(name,studentnumber);

        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }

    /**
     * @verifies show that logically not-similar courses are not equal
     * @see Student#Student(String, long)
     */
    @Test
    public void Student_shouldShowThatLogicallyNotsimilarCoursesAreNotEqual() throws Exception {
        // Act
        Student A = new Student(name,studentnumber);
        Student B = new Student("Bob",studentnumber);

        // Assert
        assertThat(A).isNotEqualTo(B);
    }

    /**
     * @verifies throw illegalargument exception if any of the input parameters is null
     * @see Student#Student(String, long)
     */
    @Test
    public void Student_shouldThrowIllegalargumentExceptionIfAnyOfTheInputParametersIsNull() throws IllegalArgumentException {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Student(null,studentnumber);
            new Student(name,-2);
        });
    }

}
