package pandox.china.model;

import pandox.china.dto.AccountDTO;

import javax.persistence.*;

@Entity
@Table(name = "MEMB_INFO", schema = "dbo", catalog = "MuOnline")
public class MembInfo {

    private int membGuid;
    private String membId;
    private String membPwd;
    private String membName;
    private String snoNumb;
    private String postCode;
    private String addrInfo;
    private String addrDeta;
    private String telNumb;
    private String phonNumb;
    private String mailAddr;
    private String fpasQues;
    private String fpasAnsw;
    private String jobCode;
    private String applDays;
    private String modiDays;
    private String outDays;
    private String trueDays;
    private String mailChek;
    private String blocCode;
    private String ctl1Code;
    private Byte vipFree;
    private String country;
    private String gender;
    private Integer secretQuestion;
    private String secretAnswer;
    private short scfIsVip;
    private int scfVipMoney;
    private int scfVipDays;
    private int scfWareVipCount;
    private int scfLuckyCoins;
    private String smsPoints;
    private Integer confirmed;
    private String activationId;
    private byte scfExtWarehouse;
    private int wCoin;
    private int wCoinP;
    private int goblinCoin;
    private byte[] muItemShopList;
    private byte[] muItemShopGiftList;
    private byte[] muItemShopGiftMsg;
    private int goldChannelTime;
    private MembStat membStat;


    public void chargeMoney(Integer value) {
        this.scfVipMoney -= value;
    }

    public void decreaseVIP(){
        this.scfVipDays -= 1;
    }

    public MembInfo() {
    }

    public MembInfo(AccountDTO dto) {
        super();
        setMembId(dto.getLogin());
        setMembPwd(dto.getPassword());
        setMailAddr(dto.getEmail());
        setMembName(dto.getName());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memb_guid")
    public int getMembGuid() {
        return membGuid;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "membInfo", cascade = CascadeType.ALL)
    public MembStat getMembStat() {
        return this.membStat;
    }

    public void setMembStat(MembStat membStat) {
        this.membStat = membStat;
    }

    public void setMembGuid(int membGuid) {
        this.membGuid = membGuid;
    }

    @Column(name = "memb___id", unique = true)
    public String getMembId() {
        return membId;
    }

    public void setMembId(String membId) {
        this.membId = membId;
    }

    @Basic
    @Column(name = "memb__pwd")
    public String getMembPwd() {
        return membPwd;
    }

    public void setMembPwd(String membPwd) {
        this.membPwd = membPwd;
    }

    @Basic
    @Column(name = "memb_name")
    public String getMembName() {
        return membName;
    }

    public void setMembName(String membName) {
        this.membName = membName;
    }

    @Basic
    @Column(name = "sno__numb")
    public String getSnoNumb() {
        return snoNumb;
    }

    public void setSnoNumb(String snoNumb) {
        this.snoNumb = snoNumb;
    }

    @Basic
    @Column(name = "post_code")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "addr_info")
    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    @Basic
    @Column(name = "addr_deta")
    public String getAddrDeta() {
        return addrDeta;
    }

    public void setAddrDeta(String addrDeta) {
        this.addrDeta = addrDeta;
    }

    @Basic
    @Column(name = "tel__numb")
    public String getTelNumb() {
        return telNumb;
    }

    public void setTelNumb(String telNumb) {
        this.telNumb = telNumb;
    }

    @Basic
    @Column(name = "phon_numb")
    public String getPhonNumb() {
        return phonNumb;
    }

    public void setPhonNumb(String phonNumb) {
        this.phonNumb = phonNumb;
    }

    @Basic
    @Column(name = "mail_addr")
    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    @Basic
    @Column(name = "fpas_ques")
    public String getFpasQues() {
        return fpasQues;
    }

    public void setFpasQues(String fpasQues) {
        this.fpasQues = fpasQues;
    }

    @Basic
    @Column(name = "fpas_answ")
    public String getFpasAnsw() {
        return fpasAnsw;
    }

    public void setFpasAnsw(String fpasAnsw) {
        this.fpasAnsw = fpasAnsw;
    }

    @Basic
    @Column(name = "job__code")
    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    @Basic
    @Column(name = "appl_days")
    public String getApplDays() {
        return applDays;
    }

    public void setApplDays(String applDays) {
        this.applDays = applDays;
    }

    @Basic
    @Column(name = "modi_days")
    public String getModiDays() {
        return modiDays;
    }

    public void setModiDays(String modiDays) {
        this.modiDays = modiDays;
    }

    @Basic
    @Column(name = "out__days")
    public String getOutDays() {
        return outDays;
    }

    public void setOutDays(String outDays) {
        this.outDays = outDays;
    }

    @Basic
    @Column(name = "true_days")
    public String getTrueDays() {
        return trueDays;
    }

    public void setTrueDays(String trueDays) {
        this.trueDays = trueDays;
    }

    @Basic
    @Column(name = "mail_chek")
    public String getMailChek() {
        return mailChek;
    }

    public void setMailChek(String mailChek) {
        this.mailChek = mailChek;
    }

    @Basic
    @Column(name = "bloc_code")
    public String getBlocCode() {
        return blocCode;
    }

    public void setBlocCode(String blocCode) {
        this.blocCode = blocCode;
    }

    @Basic
    @Column(name = "ctl1_code")
    public String getCtl1Code() {
        return ctl1Code;
    }

    public void setCtl1Code(String ctl1Code) {
        this.ctl1Code = ctl1Code;
    }

    @Basic
    @Column(name = "vip_free")
    public Byte getVipFree() {
        return vipFree;
    }

    public void setVipFree(Byte vipFree) {
        this.vipFree = vipFree;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "SecretQuestion")
    public Integer getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(Integer secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    @Basic
    @Column(name = "SecretAnswer")
    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    @Basic
    @Column(name = "SCFIsVip")
    public short getScfIsVip() {
        return scfIsVip;
    }

    public void setScfIsVip(short scfIsVip) {
        this.scfIsVip = scfIsVip;
    }

    @Basic
    @Column(name = "SCFVipMoney")
    public int getScfVipMoney() {
        return scfVipMoney;
    }

    public void setScfVipMoney(int scfVipMoney) {
        this.scfVipMoney = scfVipMoney;
    }

    @Basic
    @Column(name = "SCFVipDays")
    public int getScfVipDays() {
        return scfVipDays;
    }

    public void setScfVipDays(int scfVipDays) {
        this.scfVipDays = scfVipDays;
    }

    @Basic
    @Column(name = "SCFWareVipCount")
    public int getScfWareVipCount() {
        return scfWareVipCount;
    }

    public void setScfWareVipCount(int scfWareVipCount) {
        this.scfWareVipCount = scfWareVipCount;
    }

    @Basic
    @Column(name = "SCFLuckyCoins")
    public int getScfLuckyCoins() {
        return scfLuckyCoins;
    }

    public void setScfLuckyCoins(int scfLuckyCoins) {
        this.scfLuckyCoins = scfLuckyCoins;
    }

    @Basic
    @Column(name = "SMSPoints")
    public String getSmsPoints() {
        return smsPoints;
    }

    public void setSmsPoints(String smsPoints) {
        this.smsPoints = smsPoints;
    }

    @Basic
    @Column(name = "confirmed")
    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "activation_id")
    public String getActivationId() {
        return activationId;
    }

    public void setActivationId(String activationId) {
        this.activationId = activationId;
    }

    @Basic
    @Column(name = "SCFExtWarehouse")
    public byte getScfExtWarehouse() {
        return scfExtWarehouse;
    }

    public void setScfExtWarehouse(byte scfExtWarehouse) {
        this.scfExtWarehouse = scfExtWarehouse;
    }

    @Basic
    @Column(name = "WCoin")
    public int getwCoin() {
        return wCoin;
    }

    public void setwCoin(int wCoin) {
        this.wCoin = wCoin;
    }

    @Basic
    @Column(name = "WCoinP")
    public int getwCoinP() {
        return wCoinP;
    }

    public void setwCoinP(int wCoinP) {
        this.wCoinP = wCoinP;
    }

    @Basic
    @Column(name = "GoblinCoin")
    public int getGoblinCoin() {
        return goblinCoin;
    }

    public void setGoblinCoin(int goblinCoin) {
        this.goblinCoin = goblinCoin;
    }

    @Basic
    @Column(name = "MuItemShopList")
    public byte[] getMuItemShopList() {
        return muItemShopList;
    }

    public void setMuItemShopList(byte[] muItemShopList) {
        this.muItemShopList = muItemShopList;
    }

    @Basic
    @Column(name = "MuItemShopGiftList")
    public byte[] getMuItemShopGiftList() {
        return muItemShopGiftList;
    }

    public void setMuItemShopGiftList(byte[] muItemShopGiftList) {
        this.muItemShopGiftList = muItemShopGiftList;
    }

    @Basic
    @Column(name = "MuItemShopGiftMsg")
    public byte[] getMuItemShopGiftMsg() {
        return muItemShopGiftMsg;
    }

    public void setMuItemShopGiftMsg(byte[] muItemShopGiftMsg) {
        this.muItemShopGiftMsg = muItemShopGiftMsg;
    }

    @Basic
    @Column(name = "GoldChannelTime")
    public int getGoldChannelTime() {
        return goldChannelTime;
    }

    public void setGoldChannelTime(int goldChannelTime) {
        this.goldChannelTime = goldChannelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembInfo membInfo = (MembInfo) o;

        if (membGuid != membInfo.membGuid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return membGuid;
    }

}
