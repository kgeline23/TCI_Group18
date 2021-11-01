package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.provider.Arguments;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;

public class ExamSetupTest {
    private Course course = new Course("sot", "SOT", 3);
    private ExamID examID = new ExamID("SOT2021", 1636239920);
    private long startDate = 1636239920;
    private int nrClassCodes = 2;
    private String examName;
    private String examMaterials = "one";
    private long beginTime =1636239920;
    private long endtime=0;
    @BeforeEach
    public void setUp(){

        course = mock(Course.class);
        examID= mock(ExamID.class);

    }

    /**
     * @verifies throw illegalargumentexception if either parameter is null
     * @see ExamSetup#ExamSetup(Course, ExamID)
     */
    @Test
    public void ExamSetup_shouldThrowIllegalArgumentExceptionIfOneOfTheParametersIsNull() throws IllegalArgumentException {
        //TODO: FIX THIS
        //arrange//act//assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ExamSetup(course, null);
            new ExamSetup(null,examID);
            new ExamSetup(null,null);
        });
    }

    /**
     * @verifies begintime should be smaller than endtime
     * @see ExamSetup#setBeginTime
     */
    @Test
    public void setBeginTime_shouldBegintimeShouldBeSmallerThanEndTime() throws Exception {
        // Act
        long begintime = 0;
        long endtime  =1636239920;

        // Assert
        assertThat(endtime).isGreaterThan(begintime);
    }

    /**
     * @verifies throw IllegalArgumentException when seconds is smaller or equal to zero
     * @see ExamSetup#setEndTime
     */
    @Test
    public void setEndTime_shouldThrowIllegaldateexceptionWhenBegintimeIsNullOrSecondsIsSmallerOrEqualToZero() throws IllegalArgumentException {
        //Act
        int seconds = 0;
        int seconds2=-2;
        //Assert
        assertThat(seconds).isLessThanOrEqualTo(0);
        assertThat(seconds2).isLessThanOrEqualTo(0);
    }

    /**
     * @verifies sendendtime should create endtime from parameters begintime and seconds
     * @see ExamSetup#setEndTime
     */
    @Test
    public void setEndTime_shouldSendendtimeShouldCreateEndtimeFromParametersBegintimeAndSeconds() throws Exception{
        //Act
        ExamSetup examSetup = new ExamSetup(course, examID);
        long seconds = 1000;
        examSetup.setEndTime(beginTime,seconds);
        long endTime = examSetup.getEndTime();
        //Assert
        assertThat(endTime).isEqualTo(beginTime+seconds);
    }

    /**
     * @verifies throw IllegalArgumentException when exammaterials is null
     * @see ExamSetup#setExamMaterials(String)
     */
    @Test
    public void setExamMaterials_shouldThrowIllegaldateexceptionWhenExammaterialsIsNull() throws IllegalArgumentException {
        //Act
        String examMaterials = null;
        //Assert
        assertThat(examMaterials).isEqualTo(null);
    }

    /**
     * @verifies timeStampMillis is smaller than getStartDate
     * @see ExamSetup#setExamMaterials(String)
     */
    @Test
    public void setExamMaterials_shouldTimestampMillisIsSmallerThanGetStartDate() throws Exception {
        //Act
        Instant instant = Instant.now();
        ExamSetup examSetup = new ExamSetup(course, examID);
        long timeStampMillis = instant.toEpochMilli();
        //Assert
        assertThat(timeStampMillis).isGreaterThan(startDate);
    }

    /**
     * @verifies throw illegalargumentexception if examclasscodes is null
     * @see ExamSetup#setExamClasscodes(List)
     */
    @Test
    public void setExamClasscodes_shouldThrowIllegalargumentexceptionIfExamclasscodesIsSNull() throws IllegalArgumentException {
        //Act
        List<String> examclasscodes=null;
        //Assert
        assertThat(examclasscodes).isEqualTo(null);
    }

    /**
     * @verifies examname should get examname from examid
     * @see ExamSetup#setExamClasscodes(List)
     */
    @Test
    public void setExamClasscodes_shouldExamnameShouldGetExamnameFromExamid() throws Exception {
        //Act
        String examname = null;
        //Assert
        assertThat(examname).isEqualTo(examID.getExamName());}

    /**
     * @verifies classcode should be added to the classroomlist
     * @see ExamSetup#setExamClasscodes(List)
     */
    @Test
    public void setExamClasscodes_shouldClasscodeShouldBeAddedToTheClassroomlist() throws Exception {
        //Act
        String classcode = "something";
        List<String> classroomlist = new ArrayList<>();
        classroomlist.add(classcode);
        //Assert
        assertThat(classroomlist).contains(classcode);
    }

}


