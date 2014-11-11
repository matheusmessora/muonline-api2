package pandox.china.model.custom;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "X_Credit", schema = "dbo", catalog = "MuOnline")
public class Credit {

    public Credit(){}

    public Credit(Integer id) {
        this.id = id;
    }

    public Credit(String reference, Date dateCreation, Integer status, Profile profile) {
        this.reference = reference;
        this.dateCreation = dateCreation;
        this.status = status;
        this.profile = profile;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String reference;

    @Column
    private Date dateCreation;

    @Column
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "idProfile", referencedColumnName = "id", nullable = false)
    private Profile profile;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credit credit = (Credit) o;

        if (id != null ? !id.equals(credit.id) : credit.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Credit{");
        sb.append("id=").append(id);
        sb.append(", reference='").append(reference).append('\'');
        sb.append(", dateCreation=").append(dateCreation);
        sb.append(", status=").append(status);
        sb.append(", profile=").append(profile);
        sb.append('}');
        return sb.toString();
    }
}
