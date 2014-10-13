package pandox.china.dto;

import pandox.china.dto.enums.HeroType;
import pandox.china.model.Character;

public class HeroDTO {


    private String login;
    private String name;
    private Integer level;
    private Integer reset;

    private String type;
    private HeroType heroType;

    public HeroDTO(Character character) {
        setLogin(character.getAccountId());
        setName(character.getName());
        setLevel(character.getcLevel());
        setReset(character.getResets());
        setType(character.getClazz().toString());
        setHeroType(HeroType.valueOf(character.getClazz().intValue()));
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeroDTO{");
        sb.append("login='").append(login).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", level=").append(level);
        sb.append(", reset=").append(reset);
        sb.append(", type='").append(type).append('\'');
        sb.append(", heroType=").append(heroType);
        sb.append('}');
        return sb.toString();
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

}
