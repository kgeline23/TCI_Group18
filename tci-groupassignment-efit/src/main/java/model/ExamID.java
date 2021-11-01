package model;

import java.util.Objects;

/**
 * a planned exam is an immutable object, meant for showing when an exam is planned.
 */
public class ExamID {
    private String examName;
    private long timeOfExamInEpochFormat;


    /**
     * Creates a model.ExamID object with given examName and timeOfExamInEpochFormat
     * @param examName
     * @param timeOfExamInEpochFormat
     * @throws IllegalArgumentException
     * @should create examid with valid parameters
     * @should show that logically similar examids are equal
     * @should show that logically not-similar examIds are not equal
     * @should throw illegalargumentexception if examid is null
     */
    public ExamID(String examName, long timeOfExamInEpochFormat) throws IllegalArgumentException {
        if(examName==null) {
            throw new IllegalArgumentException("Exam name should not be null");
        }

        this.examName = examName;
        this.timeOfExamInEpochFormat = timeOfExamInEpochFormat;
    }

    /******************************************************
     *
     *   GETTERS/SETTERS CODE IS GENERATED BY INTELLIJ,
     *   AND UNTOUCHED BY PEOPLE.
     *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
     *
     ********************************************************/
    public String getExamName() { return examName; }

    public long getTimeOfExamInEpochFormat() { return timeOfExamInEpochFormat;}


    /******************************************************
     *
     *   OTHER CODE GENERATED BY INTELLIJ,
     *   BUT BASED ON INPUT OF A PROGRAMMER.
     *   THE BEHAVIOUR OF THIS CODE HAS TO BE TESTED.
     *   (but not present to keep demo code short)
     *
     ********************************************************/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamID examID = (ExamID) o;
        return examName.equals(examID.examName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examName);
    }
}
