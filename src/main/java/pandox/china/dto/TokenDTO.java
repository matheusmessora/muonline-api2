package pandox.china.dto;

public class TokenDTO {

    private String token;
    private Integer id;

    public TokenDTO() {
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public TokenDTO(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
