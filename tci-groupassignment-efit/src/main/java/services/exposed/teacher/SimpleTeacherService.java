package services.exposed.teacher;

import model.ExamID;
import model.StudentExam;
import services.exposed.ExamNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SimpleTeacherService implements TeacherInterface {
    // TODO

    /**
     *this method creates an examsetup
     * @param examname
     * @param begindate
     * @return
     * @throws DuplicateExamException
     * @throws IllegalArgumentException
     * @should throw IllegalArgumentException when examname is null
     */
    @Override
    public ExamID createExamSetup(String examname, long begindate) throws DuplicateExamException,IllegalArgumentException {
        ExamID examID = new ExamID(examname,begindate);
        return examID;
    }

    @Override
    public Set<ExamID> getOpenExams() {
        return null;
    }

    @Override
    public Set<ExamID> getOpenExams(Date dateOnOrAfter, Date dateOnOrBefore) {
        return null;
    }

    @Override
    public void addExamMaterial(ExamID exam, Object examMaterial) throws ExamNotFoundException, ExamStartedException {

    }

    @Override
    public List<Object> getExamMaterials(ExamID exam) {
        return null;
    }

    @Override
    public boolean removeExamMaterial(ExamID exam, Object examMaterial) throws ExamNotFoundException, ExamStartedException {
        return false;
    }

    @Override
    public Set<StudentExam> getExamResults(ExamID exam) throws ExamNotFoundException, ExamNotEndedException {
        return null;
    }

    @Override
    public boolean finalizeExam(ExamID examID) throws ExamNotFoundException {
        return false;
    }
}
