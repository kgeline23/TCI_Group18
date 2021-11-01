package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * contains the student, the exam he/she took, classcode used and all screenshots, logging, uploaded examwork of a student which took an exam.
 *
 * methods need to be provided which enable adding screenshots, running processes on the student's computer, and several properties which
 * are sent by the EFIT client.
 *
 */
public class StudentExam {
    // TODO: the appropiate methods

    private Student student;
    private ExamSetup exam;;
    private List<Image> imageList;
    private List<String> logging;

    /**
     * creates StudentExam object with parameters student and exam
     * @param student
     * @param exam
     * @throws IllegalArgumentException when parameter is null
     * @should throw illegalargumetn exception if student or exam are null
     * @should show that logically similar examids are equal
     * @should show that logically not-similar examIds are not equal
     */
    public StudentExam(Student student, ExamSetup exam) throws IllegalArgumentException {
        if(student==null||exam==null){
            throw new IllegalArgumentException();
        }
        this.student = student;
        this.exam = exam;
        this.logging = new ArrayList<>();
        this.imageList = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }

    public ExamSetup getExam() {
        return exam;
    }

    public void addImages(){
        imageList.add(student.getPhoto());
    }
    public void getExam(ExamSetup exam){
        exam.getExamID();
    }
    public void getClassCode(ExamSetup exam){
        exam.getExamClasscodes();
    }

    public String getExamWork(Student student, ExamSetup exam){
        return exam.getEndTime()+
        exam.getExamMaterials()+
        student.getStudentnumber()+
        student.getName();
    }
}
