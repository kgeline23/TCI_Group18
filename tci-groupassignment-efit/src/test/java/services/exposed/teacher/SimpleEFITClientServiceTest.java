package services.exposed.client;


import model.Course;
import model.ExamID;
import model.ExamSetup;
import model.Student;
import org.junit.jupiter.api.Test;
import services.exposed.teacher.SimpleTeacherService;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;

public class SimpleEFITClientServiceTest {
    Course course = new Course("sot","SOT",3);
    ExamID examID = new ExamID("ANDR1",1636239920);
    Student student = mock(Student.class);
    ExamSetup examSetup = new ExamSetup(course,examID);

    /**
     * @verifies throw illegalargument exception if student or examname is null or examdateasepochtime is smaller than current time
     * @see SimpleEFITClientService#signUpForExam(model.Student, String, Long)
     */
    @Test
    public void signUpForExam_shouldThrowIllegalargumentExceptionIfStudentOrExamnameIsNullOrExamdateasepochtimeIsSmallerThanCurrentTime() throws IllegalArgumentException {
        //Act
        long startdate = 1636239920;
        String examname = null;

        //assert
        SimpleEFITClientService simpleEFITClientService = new SimpleEFITClientService();
        String name = null;

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            simpleEFITClientService.signUpForExam(student, examname, startdate);
        });
    }
}
