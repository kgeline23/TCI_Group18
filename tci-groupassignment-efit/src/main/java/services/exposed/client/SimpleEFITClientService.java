package services.exposed.client;

import model.*;
import services.exposed.ExamNotFoundException;
import services.exposed.client.EFITClientInterface;
import services.exposed.invigilator.Alert;
import services.external.UserToken;
import services.internal.InvalidTokenException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleEFITClientService implements EFITClientInterface {
    //TODO
    ExamToken token;
    Student student;
    String examName;
    Long startDate;

    /**
     * creates signupforexam method
     * @param student
     * @param examName
     * @param examDateAsEpochTime
     * @throws IllegalArgumentException
     * @throws SignupNotAllowedException
     * @throws ExamNotFoundException
     * @throws ExamAmountException
     * @should throw illegalargument exception if student or examname is null or examdateasepochtime is smaller than current time
     */
    @Override
    public void signUpForExam(Student student, String examName, Long examDateAsEpochTime) throws IllegalArgumentException, SignupNotAllowedException, ExamNotFoundException, ExamAmountException {
        ExamID examID = new ExamID(examName,examDateAsEpochTime);
        long time = System.currentTimeMillis();
        if(examID==null){
            throw new ExamNotFoundException();
        }
        if(time>examDateAsEpochTime){
            throw new SignupNotAllowedException();
        }
        this.student=student;
        this.examName=examName;
        this.startDate=examDateAsEpochTime;
    }

    @Override
    public Set<ExamID> getRegisteredExams(Student student) {
        return null;
    }

    @Override
    public ExamToken loginForExam(UserToken token, ExamID exam, String examClasscode) throws InvalidTokenException, IllegalArgumentException, ExamNotFoundException {
        if(exam==null){
            throw new ExamNotFoundException();
        }
        return null;
    }

    @Override
    public Object getExamMaterial(ExamToken examToken) {
        return null;
    }

    @Override
    public long sendKeepAlive(ExamToken examToken) throws InvalidTokenException {
        return 0;
    }

    @Override
    public void sendScreenShot(ExamToken examToken, Object screenshot) throws InvalidTokenException {

    }

    @Override
    public void sendListOfRunningProcesses(ExamToken examToken, List<String> runningProcesses) throws InvalidTokenException {

    }

    @Override
    public Alert sendProcessInfo(ExamToken examToken, String propertyKey, String propertyValue) throws InvalidTokenException {
        return null;
    }

    @Override
    public Alert uploadExamWork(ExamToken examToken, Object examWork) throws InvalidTokenException, IllegalArgumentException {
        return null;
    }

    @Override
    public Alert logoutForExam(ExamToken examToken) {
        return null;
    }
}
