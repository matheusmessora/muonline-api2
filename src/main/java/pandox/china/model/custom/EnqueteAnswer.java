package pandox.china.model.custom;

import javax.persistence.*;

@Entity
@Table(name = "X_Enquete_Answers", schema = "dbo", catalog = "MuOnline")
public class EnqueteAnswer {
    private int id;
    private Integer answer;
    private Profile profile;
    private Enquete enquete;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "answer")
    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @ManyToOne
    @JoinColumn(name = "id_profile", referencedColumnName = "id", nullable = false)
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @ManyToOne
    @JoinColumn(name = "id_enquete", referencedColumnName = "id", nullable = false)
    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnqueteAnswer that = (EnqueteAnswer) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
