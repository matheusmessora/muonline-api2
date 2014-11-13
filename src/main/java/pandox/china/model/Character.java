package pandox.china.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Character", schema = "dbo", catalog = "MuOnline")
public class Character {


    private String accountId;
    private String name;
    private Integer cLevel;
    private Integer levelUpPoint;
    private Byte clazz;
    private Integer experience;
    private Integer strength;
    private Integer dexterity;
    private Integer vitality;
    private Integer energy;
    private byte[] inventory;
    private byte[] magicList;
    private Integer money;
    private Float life;
    private Float maxLife;
    private Float mana;
    private Float maxMana;
    private Short mapNumber;
    private Short mapPosX;
    private Short mapPosY;
    private Byte mapDir;
    private Integer pkCount;
    private Integer pkLevel;
    private Integer pkTime;
    private Timestamp mDate;
    private Timestamp lDate;
    private Integer ctlCode;
    private Byte dbVersion;
    private byte[] quest;
    private Integer leadership;
    private Short chatLimitTime;
    private Integer fruitPoint;
    private Integer zsCount;
    private Integer zy;
    private Integer fqbz;
    private Integer fqCount;
    private String fqName;
    private int resets;
    private int muId;
    private Integer scfpcPoints;
    private int scfMarried;
    private String scfMarryHusbandWife;
    private int scfMasterLevel;
    private int scfMasterPoints;
    private byte[] scfMasterSkills;
    private byte[] scfCustomQuest;
    private short scfGensFamily;
    private int scfGensContribution;
    private int scfGensRank;
    private Timestamp scfGensDateLeave;
    private byte scfGensRecvReward;
    private int grandResets;
    private byte[] scfMasterSkill;
    private byte scfExtInventory;
    private byte scfUpdatedPShop;
    private int scfSealItem;
    private int scfSealTime;
    private int scfScrollItem;
    private int scfScrollTime;

    @Basic
    @Column(name = "AccountID")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Id
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cLevel")
    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    @Basic
    @Column(name = "LevelUpPoint")
    public Integer getLevelUpPoint() {
        return levelUpPoint;
    }

    public void setLevelUpPoint(Integer levelUpPoint) {
        this.levelUpPoint = levelUpPoint;
    }

    @Basic
    @Column(name = "Class")
    public Byte getClazz() {
        return clazz;
    }

    public void setClazz(Byte clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "Experience")
    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "Strength")
    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Basic
    @Column(name = "Dexterity")
    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    @Basic
    @Column(name = "Vitality")
    public Integer getVitality() {
        return vitality;
    }

    public void setVitality(Integer vitality) {
        this.vitality = vitality;
    }

    @Basic
    @Column(name = "Energy")
    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    @Basic
    @Column(name = "Inventory")
    public byte[] getInventory() {
        return inventory;
    }

    public void setInventory(byte[] inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "MagicList")
    public byte[] getMagicList() {
        return magicList;
    }

    public void setMagicList(byte[] magicList) {
        this.magicList = magicList;
    }

    @Basic
    @Column(name = "Money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "Life")
    public Float getLife() {
        return life;
    }

    public void setLife(Float life) {
        this.life = life;
    }

    @Basic
    @Column(name = "MaxLife")
    public Float getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Float maxLife) {
        this.maxLife = maxLife;
    }

    @Basic
    @Column(name = "Mana")
    public Float getMana() {
        return mana;
    }

    public void setMana(Float mana) {
        this.mana = mana;
    }

    @Basic
    @Column(name = "MaxMana")
    public Float getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(Float maxMana) {
        this.maxMana = maxMana;
    }

    @Basic
    @Column(name = "MapNumber")
    public Short getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(Short mapNumber) {
        this.mapNumber = mapNumber;
    }

    @Basic
    @Column(name = "MapPosX")
    public Short getMapPosX() {
        return mapPosX;
    }

    public void setMapPosX(Short mapPosX) {
        this.mapPosX = mapPosX;
    }

    @Basic
    @Column(name = "MapPosY")
    public Short getMapPosY() {
        return mapPosY;
    }

    public void setMapPosY(Short mapPosY) {
        this.mapPosY = mapPosY;
    }

    @Basic
    @Column(name = "MapDir")
    public Byte getMapDir() {
        return mapDir;
    }

    public void setMapDir(Byte mapDir) {
        this.mapDir = mapDir;
    }

    @Basic
    @Column(name = "PkCount")
    public Integer getPkCount() {
        return pkCount;
    }

    public void setPkCount(Integer pkCount) {
        this.pkCount = pkCount;
    }

    @Basic
    @Column(name = "PkLevel")
    public Integer getPkLevel() {
        return pkLevel;
    }

    public void setPkLevel(Integer pkLevel) {
        this.pkLevel = pkLevel;
    }

    @Basic
    @Column(name = "PkTime")
    public Integer getPkTime() {
        return pkTime;
    }

    public void setPkTime(Integer pkTime) {
        this.pkTime = pkTime;
    }

    @Basic
    @Column(name = "MDate")
    public Timestamp getmDate() {
        return mDate;
    }

    public void setmDate(Timestamp mDate) {
        this.mDate = mDate;
    }

    @Basic
    @Column(name = "LDate")
    public Timestamp getlDate() {
        return lDate;
    }

    public void setlDate(Timestamp lDate) {
        this.lDate = lDate;
    }

    @Basic
    @Column(name = "CtlCode")
    public Integer getCtlCode() {
        return ctlCode;
    }

    public void setCtlCode(Integer ctlCode) {
        this.ctlCode = ctlCode;
    }

    @Basic
    @Column(name = "DbVersion")
    public Byte getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(Byte dbVersion) {
        this.dbVersion = dbVersion;
    }

    @Basic
    @Column(name = "Quest")
    public byte[] getQuest() {
        return quest;
    }

    public void setQuest(byte[] quest) {
        this.quest = quest;
    }

    @Basic
    @Column(name = "Leadership")
    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    @Basic
    @Column(name = "ChatLimitTime")
    public Short getChatLimitTime() {
        return chatLimitTime;
    }

    public void setChatLimitTime(Short chatLimitTime) {
        this.chatLimitTime = chatLimitTime;
    }

    @Basic
    @Column(name = "FruitPoint")
    public Integer getFruitPoint() {
        return fruitPoint;
    }

    public void setFruitPoint(Integer fruitPoint) {
        this.fruitPoint = fruitPoint;
    }

    @Basic
    @Column(name = "zs_count")
    public Integer getZsCount() {
        return zsCount;
    }

    public void setZsCount(Integer zsCount) {
        this.zsCount = zsCount;
    }

    @Basic
    @Column(name = "ZY")
    public Integer getZy() {
        return zy;
    }

    public void setZy(Integer zy) {
        this.zy = zy;
    }

    @Basic
    @Column(name = "FQBZ")
    public Integer getFqbz() {
        return fqbz;
    }

    public void setFqbz(Integer fqbz) {
        this.fqbz = fqbz;
    }

    @Basic
    @Column(name = "FQCount")
    public Integer getFqCount() {
        return fqCount;
    }

    public void setFqCount(Integer fqCount) {
        this.fqCount = fqCount;
    }

    @Basic
    @Column(name = "FQName")
    public String getFqName() {
        return fqName;
    }

    public void setFqName(String fqName) {
        this.fqName = fqName;
    }

    @Basic
    @Column(name = "Resets")
    public int getResets() {
        return resets;
    }

    public void setResets(int resets) {
        this.resets = resets;
    }

    @Basic
    @Column(name = "mu_id")
    public int getMuId() {
        return muId;
    }

    public void setMuId(int muId) {
        this.muId = muId;
    }

    @Basic
    @Column(name = "SCFPCPoints")
    public Integer getScfpcPoints() {
        return scfpcPoints;
    }

    public void setScfpcPoints(Integer scfpcPoints) {
        this.scfpcPoints = scfpcPoints;
    }

    @Basic
    @Column(name = "SCFMarried")
    public int getScfMarried() {
        return scfMarried;
    }

    public void setScfMarried(int scfMarried) {
        this.scfMarried = scfMarried;
    }

    @Basic
    @Column(name = "SCFMarryHusbandWife")
    public String getScfMarryHusbandWife() {
        return scfMarryHusbandWife;
    }

    public void setScfMarryHusbandWife(String scfMarryHusbandWife) {
        this.scfMarryHusbandWife = scfMarryHusbandWife;
    }

    @Basic
    @Column(name = "SCFMasterLevel")
    public int getScfMasterLevel() {
        return scfMasterLevel;
    }

    public void setScfMasterLevel(int scfMasterLevel) {
        this.scfMasterLevel = scfMasterLevel;
    }

    @Basic
    @Column(name = "SCFMasterPoints")
    public int getScfMasterPoints() {
        return scfMasterPoints;
    }

    public void setScfMasterPoints(int scfMasterPoints) {
        this.scfMasterPoints = scfMasterPoints;
    }

    @Basic
    @Column(name = "SCFMasterSkills")
    public byte[] getScfMasterSkills() {
        return scfMasterSkills;
    }

    public void setScfMasterSkills(byte[] scfMasterSkills) {
        this.scfMasterSkills = scfMasterSkills;
    }

    @Basic
    @Column(name = "SCFCustomQuest")
    public byte[] getScfCustomQuest() {
        return scfCustomQuest;
    }

    public void setScfCustomQuest(byte[] scfCustomQuest) {
        this.scfCustomQuest = scfCustomQuest;
    }

    @Basic
    @Column(name = "SCFGensFamily")
    public short getScfGensFamily() {
        return scfGensFamily;
    }

    public void setScfGensFamily(short scfGensFamily) {
        this.scfGensFamily = scfGensFamily;
    }

    @Basic
    @Column(name = "SCFGensContribution")
    public int getScfGensContribution() {
        return scfGensContribution;
    }

    public void setScfGensContribution(int scfGensContribution) {
        this.scfGensContribution = scfGensContribution;
    }

    @Basic
    @Column(name = "SCFGensRank")
    public int getScfGensRank() {
        return scfGensRank;
    }

    public void setScfGensRank(int scfGensRank) {
        this.scfGensRank = scfGensRank;
    }

    @Basic
    @Column(name = "SCFGensDateLeave")
    public Timestamp getScfGensDateLeave() {
        return scfGensDateLeave;
    }

    public void setScfGensDateLeave(Timestamp scfGensDateLeave) {
        this.scfGensDateLeave = scfGensDateLeave;
    }

    @Basic
    @Column(name = "SCFGensRecvReward")
    public byte getScfGensRecvReward() {
        return scfGensRecvReward;
    }

    public void setScfGensRecvReward(byte scfGensRecvReward) {
        this.scfGensRecvReward = scfGensRecvReward;
    }

    @Basic
    @Column(name = "Grand_Resets")
    public int getGrandResets() {
        return grandResets;
    }

    public void setGrandResets(int grandResets) {
        this.grandResets = grandResets;
    }

    @Basic
    @Column(name = "SCFMasterSkill")
    public byte[] getScfMasterSkill() {
        return scfMasterSkill;
    }

    public void setScfMasterSkill(byte[] scfMasterSkill) {
        this.scfMasterSkill = scfMasterSkill;
    }

    @Basic
    @Column(name = "SCFExtInventory")
    public byte getScfExtInventory() {
        return scfExtInventory;
    }

    public void setScfExtInventory(byte scfExtInventory) {
        this.scfExtInventory = scfExtInventory;
    }

    @Basic
    @Column(name = "SCFUpdatedPShop")
    public byte getScfUpdatedPShop() {
        return scfUpdatedPShop;
    }

    public void setScfUpdatedPShop(byte scfUpdatedPShop) {
        this.scfUpdatedPShop = scfUpdatedPShop;
    }

    @Basic
    @Column(name = "SCFSealItem")
    public int getScfSealItem() {
        return scfSealItem;
    }

    public void setScfSealItem(int scfSealItem) {
        this.scfSealItem = scfSealItem;
    }

    @Basic
    @Column(name = "SCFSealTime")
    public int getScfSealTime() {
        return scfSealTime;
    }

    public void setScfSealTime(int scfSealTime) {
        this.scfSealTime = scfSealTime;
    }

    @Basic
    @Column(name = "SCFScrollItem")
    public int getScfScrollItem() {
        return scfScrollItem;
    }

    public void setScfScrollItem(int scfScrollItem) {
        this.scfScrollItem = scfScrollItem;
    }

    @Basic
    @Column(name = "SCFScrollTime")
    public int getScfScrollTime() {
        return scfScrollTime;
    }

    public void setScfScrollTime(int scfScrollTime) {
        this.scfScrollTime = scfScrollTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (name != null ? !name.equals(character.name) : character.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
