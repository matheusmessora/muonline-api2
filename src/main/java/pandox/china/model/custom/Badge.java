package pandox.china.model.custom;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "X_Badge", schema = "dbo", catalog = "MuOnline")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String description;

    @Basic
    @Column
    private Integer gainExp;

    @OneToMany
    private Set<BadgeProfile> badgeProfiles;

    public Set<BadgeProfile> getBadgeProfiles() {
        return badgeProfiles;
    }

    public void setBadgeProfiles(Set<BadgeProfile> badgeProfiles) {
        this.badgeProfiles = badgeProfiles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGainExp() {
        return gainExp;
    }

    public void setGainExp(Integer gainExp) {
        this.gainExp = gainExp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Badge badge = (Badge) o;

        if (id != null ? !id.equals(badge.id) : badge.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
