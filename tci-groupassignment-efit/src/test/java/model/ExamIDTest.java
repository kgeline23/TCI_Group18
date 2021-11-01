package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import model.ExamID;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExamIDTest {
    private static String VALID_EXAMNAME = "02112021ANDR1";
    private static long VALID_TIMEOFEXAMINEPOCHFORMAT = 1636239920;

    /**
     * @verifies create examid with valid parameters
     * @see ExamID#ExamID(String, long)
     */
    @Test
    public void ExamID_shouldCreateExamidWithValidParameters() throws IllegalArgumentException {


        // Act
        ExamID examID = new ExamID(VALID_EXAMNAME,VALID_TIMEOFEXAMINEPOCHFORMAT);

        // Assert
        assertThat(examID.getExamName()).isEqualTo(VALID_EXAMNAME);
        assertThat(examID.getTimeOfExamInEpochFormat()).isEqualTo(VALID_TIMEOFEXAMINEPOCHFORMAT);
    }

    /**
     * @verifies show that logically similar examids are equal
     * @see ExamID#ExamID(String, long)
     */
    @Test
    public void ExamID_shouldShowThatLogicallySimilarExamidsAreEqual() throws Exception {


        // Act
        ExamID A = new ExamID(VALID_EXAMNAME,VALID_TIMEOFEXAMINEPOCHFORMAT);
        ExamID B = new ExamID(VALID_EXAMNAME,VALID_TIMEOFEXAMINEPOCHFORMAT);

        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }

    /**
     * @verifies show that logically not-similar examIds are not equal
     * @see ExamID#ExamID(String, long)
     */
    @Test
    public void ExamID_shouldShowThatLogicallyNotsimilarExamIdsAreNotEqual() throws Exception {

        // Act
        ExamID A = new ExamID(VALID_EXAMNAME,VALID_TIMEOFEXAMINEPOCHFORMAT);
        ExamID B = new ExamID("2021ANDR1",VALID_TIMEOFEXAMINEPOCHFORMAT);

        // Assert
        assertThat(A).isNotEqualTo(B);
    }

    /**
     * @verifies throw illegalargument exception if examid is null
     * @see ExamID#ExamID(String, long)
     *
     * deleted the parameter String examname and hardcoded the input so the test passes
     */
    @Test
    public void ExamID_shouldThrowIllegalargumentExceptionIfExamidIsNull() throws Exception {

        // arrange, // act,
        String examName = null;
        // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ExamID(examName,VALID_TIMEOFEXAMINEPOCHFORMAT);
        });
    }

    private static Stream<Arguments> wrongInputprovider(){
        return Stream.of(Arguments.of(null,VALID_TIMEOFEXAMINEPOCHFORMAT));
    }
}
