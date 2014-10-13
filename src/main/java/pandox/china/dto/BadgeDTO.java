package pandox.china.dto;

import pandox.china.model.custom.Badge;

public class BadgeDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer gainExp;


    public BadgeDTO() {
    }

    public BadgeDTO(Badge badge) {
        this.id = badge.getId();
        this.name = badge.getName();
        this.description = badge.getDescription();
        this.gainExp = badge.getGainExp();
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
}
