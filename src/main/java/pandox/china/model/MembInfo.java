package pandox.china.model;

import pandox.china.dto.AccountDTO;

import javax.persistence.*;
import java.util.Arrays;

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

    public void setMembGuid(int membGuid) {
        this.membGuid = membGuid;
    }

    @Basic
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

        if (goblinCoin != membInfo.goblinCoin) return false;
        if (goldChannelTime != membInfo.goldChannelTime) return false;
        if (membGuid != membInfo.membGuid) return false;
        if (scfExtWarehouse != membInfo.scfExtWarehouse) return false;
        if (scfIsVip != membInfo.scfIsVip) return false;
        if (scfLuckyCoins != membInfo.scfLuckyCoins) return false;
        if (scfVipDays != membInfo.scfVipDays) return false;
        if (scfVipMoney != membInfo.scfVipMoney) return false;
        if (scfWareVipCount != membInfo.scfWareVipCount) return false;
        if (wCoin != membInfo.wCoin) return false;
        if (wCoinP != membInfo.wCoinP) return false;
        if (activationId != null ? !activationId.equals(membInfo.activationId) : membInfo.activationId != null)
            return false;
        if (addrDeta != null ? !addrDeta.equals(membInfo.addrDeta) : membInfo.addrDeta != null) return false;
        if (addrInfo != null ? !addrInfo.equals(membInfo.addrInfo) : membInfo.addrInfo != null) return false;
        if (applDays != null ? !applDays.equals(membInfo.applDays) : membInfo.applDays != null) return false;
        if (blocCode != null ? !blocCode.equals(membInfo.blocCode) : membInfo.blocCode != null) return false;
        if (confirmed != null ? !confirmed.equals(membInfo.confirmed) : membInfo.confirmed != null) return false;
        if (country != null ? !country.equals(membInfo.country) : membInfo.country != null) return false;
        if (ctl1Code != null ? !ctl1Code.equals(membInfo.ctl1Code) : membInfo.ctl1Code != null) return false;
        if (fpasAnsw != null ? !fpasAnsw.equals(membInfo.fpasAnsw) : membInfo.fpasAnsw != null) return false;
        if (fpasQues != null ? !fpasQues.equals(membInfo.fpasQues) : membInfo.fpasQues != null) return false;
        if (gender != null ? !gender.equals(membInfo.gender) : membInfo.gender != null) return false;
        if (jobCode != null ? !jobCode.equals(membInfo.jobCode) : membInfo.jobCode != null) return false;
        if (mailAddr != null ? !mailAddr.equals(membInfo.mailAddr) : membInfo.mailAddr != null) return false;
        if (mailChek != null ? !mailChek.equals(membInfo.mailChek) : membInfo.mailChek != null) return false;
        if (membId != null ? !membId.equals(membInfo.membId) : membInfo.membId != null) return false;
        if (membName != null ? !membName.equals(membInfo.membName) : membInfo.membName != null) return false;
        if (membPwd != null ? !membPwd.equals(membInfo.membPwd) : membInfo.membPwd != null) return false;
        if (modiDays != null ? !modiDays.equals(membInfo.modiDays) : membInfo.modiDays != null) return false;
        if (!Arrays.equals(muItemShopGiftList, membInfo.muItemShopGiftList)) return false;
        if (!Arrays.equals(muItemShopGiftMsg, membInfo.muItemShopGiftMsg)) return false;
        if (!Arrays.equals(muItemShopList, membInfo.muItemShopList)) return false;
        if (outDays != null ? !outDays.equals(membInfo.outDays) : membInfo.outDays != null) return false;
        if (phonNumb != null ? !phonNumb.equals(membInfo.phonNumb) : membInfo.phonNumb != null) return false;
        if (postCode != null ? !postCode.equals(membInfo.postCode) : membInfo.postCode != null) return false;
        if (secretAnswer != null ? !secretAnswer.equals(membInfo.secretAnswer) : membInfo.secretAnswer != null)
            return false;
        if (secretQuestion != null ? !secretQuestion.equals(membInfo.secretQuestion) : membInfo.secretQuestion != null)
            return false;
        if (smsPoints != null ? !smsPoints.equals(membInfo.smsPoints) : membInfo.smsPoints != null) return false;
        if (snoNumb != null ? !snoNumb.equals(membInfo.snoNumb) : membInfo.snoNumb != null) return false;
        if (telNumb != null ? !telNumb.equals(membInfo.telNumb) : membInfo.telNumb != null) return false;
        if (trueDays != null ? !trueDays.equals(membInfo.trueDays) : membInfo.trueDays != null) return false;
        if (vipFree != null ? !vipFree.equals(membInfo.vipFree) : membInfo.vipFree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = membGuid;
        result = 31 * result + (membId != null ? membId.hashCode() : 0);
        result = 31 * result + (membPwd != null ? membPwd.hashCode() : 0);
        result = 31 * result + (membName != null ? membName.hashCode() : 0);
        result = 31 * result + (snoNumb != null ? snoNumb.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (addrInfo != null ? addrInfo.hashCode() : 0);
        result = 31 * result + (addrDeta != null ? addrDeta.hashCode() : 0);
        result = 31 * result + (telNumb != null ? telNumb.hashCode() : 0);
        result = 31 * result + (phonNumb != null ? phonNumb.hashCode() : 0);
        result = 31 * result + (mailAddr != null ? mailAddr.hashCode() : 0);
        result = 31 * result + (fpasQues != null ? fpasQues.hashCode() : 0);
        result = 31 * result + (fpasAnsw != null ? fpasAnsw.hashCode() : 0);
        result = 31 * result + (jobCode != null ? jobCode.hashCode() : 0);
        result = 31 * result + (applDays != null ? applDays.hashCode() : 0);
        result = 31 * result + (modiDays != null ? modiDays.hashCode() : 0);
        result = 31 * result + (outDays != null ? outDays.hashCode() : 0);
        result = 31 * result + (trueDays != null ? trueDays.hashCode() : 0);
        result = 31 * result + (mailChek != null ? mailChek.hashCode() : 0);
        result = 31 * result + (blocCode != null ? blocCode.hashCode() : 0);
        result = 31 * result + (ctl1Code != null ? ctl1Code.hashCode() : 0);
        result = 31 * result + (vipFree != null ? vipFree.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (secretQuestion != null ? secretQuestion.hashCode() : 0);
        result = 31 * result + (secretAnswer != null ? secretAnswer.hashCode() : 0);
        result = 31 * result + (int) scfIsVip;
        result = 31 * result + scfVipMoney;
        result = 31 * result + scfVipDays;
        result = 31 * result + scfWareVipCount;
        result = 31 * result + scfLuckyCoins;
        result = 31 * result + (smsPoints != null ? smsPoints.hashCode() : 0);
        result = 31 * result + (confirmed != null ? confirmed.hashCode() : 0);
        result = 31 * result + (activationId != null ? activationId.hashCode() : 0);
        result = 31 * result + (int) scfExtWarehouse;
        result = 31 * result + wCoin;
        result = 31 * result + wCoinP;
        result = 31 * result + goblinCoin;
        result = 31 * result + (muItemShopList != null ? Arrays.hashCode(muItemShopList) : 0);
        result = 31 * result + (muItemShopGiftList != null ? Arrays.hashCode(muItemShopGiftList) : 0);
        result = 31 * result + (muItemShopGiftMsg != null ? Arrays.hashCode(muItemShopGiftMsg) : 0);
        result = 31 * result + goldChannelTime;
        return result;
    }
}
