package pandox.china.model.custom;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "X_Enquete", schema = "dbo", catalog = "MuOnline")
public class Enquete {
    private Integer id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String status;

    private Collection<EnqueteAnswer> enqueteAnswerses;

    public Enquete() {
    }

    public Enquete(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "answer_1")
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    @Basic
    @Column(name = "answer_2")
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Basic
    @Column(name = "answer_3")
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @Basic
    @Column(name = "answer_4")
    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enquete")
    public Collection<EnqueteAnswer> getEnqueteAnswerses() {
        return enqueteAnswerses;
    }

    public void setEnqueteAnswerses(Collection<EnqueteAnswer> enqueteAnswerses) {
        this.enqueteAnswerses = enqueteAnswerses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enquete enquete = (Enquete) o;

        if (id != null ? !id.equals(enquete.id) : enquete.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
