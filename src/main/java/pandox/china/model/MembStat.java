package pandox.china.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MEMB_STAT", schema = "dbo", catalog = "MuOnline")
public class MembStat {
    private String membId;
    private Integer connectStat;
    private String serverName;
    private String ip;
    private Timestamp connectTm;
    private Timestamp disConnectTm;
    private Integer onlineHours;
    private Integer hours;
    private MembInfo membInfo;

    public void addHour(){
        setHours(getHours() +1);
    }

    @Id
    @Column(name = "memb___id", unique = true, nullable = false)
    public String getMembId() {
        return membId;
    }

    public void setMembId(String membId) {
        this.membId = membId;
    }


    @Basic
    @Column(name = "Hours")
    public Integer getHours() {
        if(hours == null){
            hours = 0;
        }
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @OneToOne
    @JoinColumn(name = "membInfo_memb___id", updatable = false, insertable = false)
    public MembInfo getMembInfo() {
        return membInfo;
    }

    public void setMembInfo(MembInfo membInfo) {
        this.membInfo = membInfo;
    }

    @Basic
    @Column(name = "ConnectStat")
    public Integer getConnectStat() {
        return connectStat;
    }

    public void setConnectStat(Integer connectStat) {
        this.connectStat = connectStat;
    }

    @Basic
    @Column(name = "ServerName")
    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "ConnectTM")
    public Timestamp getConnectTm() {
        return connectTm;
    }

    public void setConnectTm(Timestamp connectTm) {
        this.connectTm = connectTm;
    }

    @Basic
    @Column(name = "DisConnectTM")
    public Timestamp getDisConnectTm() {
        return disConnectTm;
    }

    public void setDisConnectTm(Timestamp disConnectTm) {
        this.disConnectTm = disConnectTm;
    }

    @Basic
    @Column(name = "OnlineHours")
    public Integer getOnlineHours() {
        return onlineHours;
    }

    public void setOnlineHours(Integer onlineHours) {
        this.onlineHours = onlineHours;
    }

}
