package pandox.china.dto;

import pandox.china.model.custom.Enquete;
import pandox.china.model.custom.EnqueteAnswer;

public class EnqueteDTO {

    private Integer id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String status;
    private Integer qtdAnswer1;
    private Integer qtdAnswer2;
    private Integer qtdAnswer3;
    private Integer qtdAnswer4;
    private Integer qtdVotes;
    private boolean canAnswer;

    public EnqueteDTO() {
    }

    public EnqueteDTO(Enquete enquete) {
        this.id = enquete.getId();
        this.question = enquete.getQuestion();
        this.answer1 = enquete.getAnswer1();
        this.answer2 = enquete.getAnswer2();
        this.answer3 = enquete.getAnswer3();
        this.answer4 = enquete.getAnswer4();
        this.status = enquete.getStatus();

        sumAnswers(enquete);

        this.canAnswer = false;
    }

    private void sumAnswers(Enquete enquete) {
        qtdAnswer1 = 0;
        qtdAnswer2 = 0;
        qtdAnswer3 = 0;
        qtdAnswer4 = 0;

        for (EnqueteAnswer enqueteAnswer : enquete.getEnqueteAnswerses()) {
            switch (enqueteAnswer.getAnswer()) {
                case 1:
                    qtdAnswer1++;
                    break;
                case 2:
                    qtdAnswer2++;
                    break;
                case 3:
                    qtdAnswer3++;
                    break;
                case 4:
                    qtdAnswer4++;
                    break;
            }
        }

        qtdVotes = qtdAnswer1 + qtdAnswer2 + qtdAnswer3 + qtdAnswer4;
    }

    public boolean isCanAnswer() {
        return canAnswer;
    }

    public void setCanAnswer(boolean canAnswer) {
        this.canAnswer = canAnswer;
    }

    public Integer getQtdAnswer1() {
        return qtdAnswer1;
    }

    public void setQtdAnswer1(Integer qtdAnswer1) {
        this.qtdAnswer1 = qtdAnswer1;
    }

    public Integer getQtdAnswer2() {
        return qtdAnswer2;
    }

    public void setQtdAnswer2(Integer qtdAnswer2) {
        this.qtdAnswer2 = qtdAnswer2;
    }

    public Integer getQtdAnswer3() {
        return qtdAnswer3;
    }

    public void setQtdAnswer3(Integer qtdAnswer3) {
        this.qtdAnswer3 = qtdAnswer3;
    }

    public Integer getQtdAnswer4() {
        return qtdAnswer4;
    }

    public void setQtdAnswer4(Integer qtdAnswer4) {
        this.qtdAnswer4 = qtdAnswer4;
    }

    public Integer getQtdVotes() {
        return qtdVotes;
    }

    public void setQtdVotes(Integer qtdVotes) {
        this.qtdVotes = qtdVotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
