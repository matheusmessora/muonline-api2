package pandox.china.dto;

import pandox.china.dto.enums.HeroType;
import pandox.china.model.Character;

public class HeroDTO {


    private String login;
    private String name;
    private Integer level;
    private Integer reset;

    private Integer forca;
    private Integer agilidade;
    private Integer vitalidade;
    private Integer energia;

    private Integer life;
    private Integer mana;

    private String img;
    private HeroType heroType;
    private String longHeroType;
    private Integer onlineHours;

    private boolean gameMaster;

    public HeroDTO(Character character) {
        setLogin(character.getAccountId());
        setName(character.getName());
        setLevel(character.getcLevel());
        setReset(character.getResets());
        setImg(HeroType.valueOf(character.getClazz().intValue()).getImg());
        setHeroType(HeroType.valueOf(character.getClazz().intValue()));
        longHeroType = HeroType.valueOf(character.getClazz().intValue()).getDesc();
        gameMaster = character.getCtlCode().equals(32);
        forca = character.getStrength();
        agilidade = character.getDexterity();
        vitalidade = character.getVitality();
        energia = character.getEnergy();
        life = character.getMaxLife().intValue();
        mana = character.getMaxMana().intValue();
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getVitalidade() {
        return vitalidade;
    }

    public void setVitalidade(Integer vitalidade) {
        this.vitalidade = vitalidade;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public boolean isGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(boolean gameMaster) {
        this.gameMaster = gameMaster;
    }

    public Integer getOnlineHours() {
        return onlineHours;
    }

    public void setOnlineHours(Integer onlineHours) {
        this.onlineHours = onlineHours;
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
