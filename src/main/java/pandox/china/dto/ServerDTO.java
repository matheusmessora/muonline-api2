package pandox.china.dto;

public class ServerDTO {


    private Long qtdAccount;
    private Long qtdChars;
    private Integer qtdOnline;

    private boolean serverUp;

    public ServerDTO(Long qtdAccount, Long qtdChars, Integer qtdOnline, boolean serverUp) {
        this.qtdAccount = qtdAccount;
        this.qtdChars = qtdChars;
        this.qtdOnline = qtdOnline;
        this.serverUp = serverUp;
    }

    public Long getQtdAccount() {
        return qtdAccount;
    }

    public void setQtdAccount(Long qtdAccount) {
        this.qtdAccount = qtdAccount;
    }

    public Long getQtdChars() {
        return qtdChars;
    }

    public void setQtdChars(Long qtdChars) {
        this.qtdChars = qtdChars;
    }

    public Integer getQtdOnline() {
        return qtdOnline;
    }

    public void setQtdOnline(Integer qtdOnline) {
        this.qtdOnline = qtdOnline;
    }

    public boolean isServerUp() {
        return serverUp;
    }

    public void setServerUp(boolean serverUp) {
        this.serverUp = serverUp;
    }
}
