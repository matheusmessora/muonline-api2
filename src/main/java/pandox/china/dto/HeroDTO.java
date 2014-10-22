package pandox.china.dto;

import pandox.china.dto.enums.HeroType;
import pandox.china.model.Character;

public class HeroDTO {


    private String login;
    private String name;
    private Integer level;
    private Integer reset;

    private String img;
    private HeroType heroType;
    private String longHeroType;

    public HeroDTO(Character character) {
        setLogin(character.getAccountId());
        setName(character.getName());
        setLevel(character.getcLevel());
        setReset(character.getResets());
        setImg(HeroType.valueOf(character.getClazz().intValue()).getImg());
        setHeroType(HeroType.valueOf(character.getClazz().intValue()));
        longHeroType = HeroType.valueOf(character.getClazz().intValue()).getDesc();
    }

    public String getLongHeroType() {
        return longHeroType;
    }

    public void setLongHeroType(String longHeroType) {
        this.longHeroType = longHeroType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getReset() {
        return reset;
    }

    public void setReset(Integer reset) {
        this.reset = reset;
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

}
