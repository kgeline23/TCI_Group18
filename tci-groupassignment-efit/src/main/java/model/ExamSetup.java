package model;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * An examsetup is related to a specific course. it is identified by the course it is related to, and the startdate.
 * <p>
 * The number of classcodes to be generated can be set.
 * unique classcodes are needed for each needed classroom during the exam. the classcode consists of the name of the exam, followed by a '-', followed by a random string of 6 characters.
 * it is assumed the randomness creates unique codes.
 * two extra classcodes are always generated for extra safety (this means extra classcodes are always added).
 * the name of the extra classcodes are the name of the exam, followed by '-extra-', followed by a random string of 4 characters.
 * a list of all examcodes can be generated.
 * <p>
 * an examname can be given during creation of an exam. when no name is provided, the examname is taken from the course the exam is for.
 * it can always be changed afterwards. an empty examname is not allowed, when this is entered, the name of the course is used instead.
 * it is not allowed to change the name, after the exam has started.
 * *
 * the begintime of the exam (when it is being set), cannot be after the endtime of the exam. otherwise an IllegalDateException is thrown.
 * the reverse is true for the endtime.
 * instead of an endtime, a begintime + duration in seconds can be given, the endtime is then calculated.
 * <p>
 * the examID of the examSetup can be returned.
 * <p>
 * Exam materials can be added to the exam setup after creation. after the exam has started, no materials can be added.
 */
public class ExamSetup {
    private Course course;
    private ExamID examID;
    private long startDate;
    private int nrClassCodes;
    private List<String> examClasscodes;
    private String examName;
    private String examMaterials;
    private long beginTime;
    private long endTime;
    long secs;



    /*
     *An examsetup is related to a specific course. it is identified by the course it is related to, and the startdate.
     */

    /**
     * Creates an object with a given course and examID
     * @throws IllegalArgumentException if either parameter is null this exception is thrown
     * @param course
     * @param examID
     * @should throw IllegalArgument ExceptionIfOneOfTheParametersIsNull()
     */
    public ExamSetup(Course course, ExamID examID) throws IllegalArgumentException {
        if(course==null||examID==null){
            throw new IllegalArgumentException();
        }
        this.course = course;
        this.examID = examID;
    }

    public Course getCourse() {
        return course;
    }

    /******************************************************
     *
     *   GETTERS/SETTERS CODE IS GENERATED BY INTELLIJ,
     *   AND UNTOUCHED BY PEOPLE.
     *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
     *
     ********************************************************/

    public long getStartDate() {
        return startDate;
    }
    public void setStartDate(long startDate) {
        this.startDate = examID.getTimeOfExamInEpochFormat();
    }

    public int getNrClassCodes() {
        return nrClassCodes;
    }

   /*
    * The number of classcodes to be generated can be set.
    */
    public void setNrClassCodes(int nrClassCodes) {
        this.nrClassCodes = nrClassCodes;
    }

    public List<String> getExamClasscodes() {
        return examClasscodes;
    }

    /**
     * unique classcodes are needed for each needed classroom during the exam. the classcode consists of the name of the exam, followed by a '-', followed by a random string of 6 characters.
     * it is assumed the randomness creates unique codes.
     * two extra classcodes are always generated for extra safety (this means extra classcodes are always added).
     * the name of the extra classcodes are the name of the exam, followed by '-extra-', followed by a random string of 4 characters.
     * a list of all examcodes can be generated.
     * @throws IllegalArgumentException when nrClassCodes is null
     * @param examClasscodes
     * @should throw illegalargumentexception if examclasscodes is null
     * @should examname should get examname from examid
     * @should classcode should be added to the classroomlist
     */
    public void setExamClasscodes(List<String> examClasscodes) throws IllegalArgumentException {
        List<String> classroomList = getExamClasscodes();
        for (int i = 0; i < getNrClassCodes(); i++) {
            String examName = examID.getExamName();
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            String classcode = examName + "-" + number;
            classroomList.add(classcode);
            setExamClasscodes(classroomList);
        }
        for (int i = 0; i < 2; i++) {
            String examName = examID.getExamName();
            Random rnd = new Random();
            int number = rnd.nextInt(9999);
            String classcode = examName + "-extra-" + number;
            classroomList.add(classcode);
            setExamClasscodes(classroomList);
        }
        this.examClasscodes = examClasscodes;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName){
        if (examName == null) {
            examName = course.getName();
        }
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        if (timeStampMillis < getStartDate()) {
            this.examName = examName;
        }
    }

    /******************************************************
     *
     *   GETTERS/SETTERS CODE IS GENERATED BY INTELLIJ,
     *   AND UNTOUCHED BY PEOPLE.
     *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
     *
     ********************************************************/
    public long getBeginTime() {
        return beginTime;
    }

    /**
     * the begintime of the exam (when it is being set), cannot be after the endtime of the exam. otherwise an IllegalDateException is thrown.
     * the reverse is true for the endtime.
     * instead of an endtime, a begintime + duration in seconds can be given, the endtime is then calculated.
     * @param beginTime
     * @throws Exception when beginetime is null
     * @should BegintimeShouldBeSmallerThanEndTime
     */
    public void setBeginTime(long beginTime) throws IllegalArgumentException{
        if(beginTime>getEndTime()){
            throw new IllegalArgumentException();
        }
        this.beginTime = beginTime;
    }
    public long getEndTime() {
        return endTime;
    }

    /**
     * the begintime of the exam (when it is being set), cannot be after the endtime of the exam. otherwise an IllegalDateException is thrown.
     * the reverse is true for the endtime.
     * instead of an endtime, a begintime + duration in seconds can be given, the endtime is then calculated.
     * @param beginTime
     * @param seconds
     * @throws Exception when begintime is null or seconds is smaller or equal to zero
     * @should throw illegaldateexception when begintime is null or seconds is smaller or equal to zero
     * @should sendendtime should create endtime from parameters begintime and seconds
     */
    public void setEndTime(long beginTime,long seconds) throws Exception{
        secs = beginTime;
        endTime = secs + seconds;
        if(endTime<beginTime){
            throw new Exception();
        }
    }

    /*
     * the examID of the examSetup can be returned.
     */
    public ExamID getExamID() {
        return examID;
    }

    public long getSecs() {
        return secs;
    }

    public String getExamMaterials() {
        return examMaterials;
    }

    /**
     * Exam materials can be added to the exam setup after creation. after the exam has started, no materials can be added.
     * @param examMaterials
     * @throws IllegalArgumentException when exammaterials is null
     * @should throw illegaldateexception when exammaterials is null
     * @should timeStampMillis is smaller than getStartDate
     */
    public void setExamMaterials(String examMaterials) throws IllegalArgumentException {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        if (timeStampMillis < getStartDate()) {
            this.examMaterials = examMaterials;
        }
    }
}
