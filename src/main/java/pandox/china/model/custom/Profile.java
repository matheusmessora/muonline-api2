package pandox.china.model.custom;

import pandox.china.model.MembInfo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "X_Profile", schema = "dbo", catalog = "MuOnline")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "signup_date")
    private Date signupDate;

    @OneToOne
    @JoinColumn(name = "memb_guid", referencedColumnName = "memb_guid", nullable = false)
    private MembInfo membInfo;

    @Basic
    @Column(name = "level")
    private int level;

    @Basic
    @Column(name = "exp")
    private int exp;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
    private Set<EnqueteAnswer> enqueteAnswerses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<BadgeProfile> badgeProfiles;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    private Set<Credit> creditProfile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    private Set<ItemProfile> itemProfile;

    public void addBadge(Badge badge) {
        getBadgeProfiles().add(new BadgeProfile(badge, this));
        setExp(getExp() + badge.getGainExp());
    }

    public Set<ItemProfile> getItemProfile() {
        return itemProfile;
    }

    public Set<Credit> getCreditProfile() {
        return creditProfile;
    }

    public void setCreditProfile(Set<Credit> creditProfile) {
        this.creditProfile = creditProfile;
    }

    public void setItemProfile(Set<ItemProfile> itemProfile) {
        this.itemProfile = itemProfile;
    }

    public Profile() {
    }

    public Profile(Integer profileId) {
        this.id = profileId;
    }

    public Set<BadgeProfile> getBadgeProfiles() {
        return badgeProfiles;
    }

    public void setBadgeProfiles(Set<BadgeProfile> badgeProfiles) {
        this.badgeProfiles = badgeProfiles;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public MembInfo getMembInfo() {
        return membInfo;
    }

    public void setMembInfo(MembInfo membInfo) {
        this.membInfo = membInfo;
    }

    public Set<EnqueteAnswer> getEnqueteAnswerses() {
        return enqueteAnswerses;
    }

    public void setEnqueteAnswerses(Set<EnqueteAnswer> enqueteAnswerses) {
        this.enqueteAnswerses = enqueteAnswerses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (id != profile.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
