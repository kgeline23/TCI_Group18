package services.exposed.teacher;


import model.ExamID;
import model.Student;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SimpleTeacherServiceTest {


    /**
     * @verifies throw IllegalArgumentException when examname is null
     * @see SimpleTeacherService#createExamSetup(String, long)
     */
    @Test
    public void createExamSetup_shouldThrowIllegalArgumentExceptionWhenExamnameIsNull() throws IllegalArgumentException {
        SimpleTeacherService teacherService = new SimpleTeacherService();
        String name = null;
        long startdate = 1636239920;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            teacherService.createExamSetup(name,startdate);
        });
    }
}
