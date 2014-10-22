package pandox.china.dto;

import pandox.china.model.custom.BadgeProfile;
import pandox.china.model.custom.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfileDTO {

    private Integer id;
    private Date signupDate;
    private int level;
    private int exp;
    private int qtdBadges;

    private boolean vip;
    private int vipDays;

    private String login;


    private List<ProfileBadgeDTO> badges = new ArrayList<>();

    public ProfileDTO() {
    }

    public ProfileDTO(Profile entity) {
        this.id = entity.getId();
        this.signupDate = entity.getSignupDate();
        this.level = entity.getLevel();
        this.exp = entity.getExp();
        this.login = entity.getMembInfo().getMembId();

        if (!entity.getBadgeProfiles().isEmpty()) {
            for (BadgeProfile badgeProfile : entity.getBadgeProfiles()) {
                badges.add(new ProfileBadgeDTO(badgeProfile.getBadge().getId()));
            }
        }

        this.setQtdBadges(entity.getBadgeProfiles().size());

        this.vip = entity.getMembInfo().getScfIsVip() == (short) 1;
        this.vipDays = entity.getMembInfo().getScfVipDays();
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean isVIP) {
        this.vip = isVIP;
    }

    public int getVipDays() {
        return vipDays;
    }

    public void setVipDays(int vipDays) {
        this.vipDays = vipDays;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<ProfileBadgeDTO> getBadges() {
        return badges;
    }

    public void setBadges(List<ProfileBadgeDTO> badges) {
        this.badges = badges;
    }

    public int getQtdBadges() {
        return qtdBadges;
    }

    public void setQtdBadges(int qtdBadges) {
        this.qtdBadges = qtdBadges;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileDTO that = (ProfileDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
