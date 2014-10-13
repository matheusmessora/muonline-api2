package pandox.china.model.custom;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "X_Badge_Profile", schema = "dbo", catalog = "MuOnline")
public class BadgeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "badge_id", referencedColumnName = "id", nullable = false)
    private Badge badge;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
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

        BadgeProfile that = (BadgeProfile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BadgeProfile{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", badge=").append(badge);
        sb.append(", profile=").append(profile);
        sb.append('}');
        return sb.toString();
    }
}
