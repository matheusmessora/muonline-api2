package pandox.china.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import pandox.china.model.MembInfo;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class AccountDTO {

    private Integer id;

    @NotNull(message = "Login deve conter de 4 a 10 caracteres")
    @Length(min = 4, max = 10, message = "Login deve conter de 4 a 10 caracteres")
    private String login;

    @JsonIgnore
    @NotNull(message = "Senha deve ter de 4 a 10 caracteres")
    @Length(min = 4, max = 10, message = "Senha deve conter de 4 a 10 caracteres")
    private String password;

    @NotNull(message = "Nome deve ter de 3 a 30 caracteres")
    @Length(min = 3, max = 30, message = "Login deve conter de 4 a 10 caracteres")
    private String name;

    @Email(message = "Informe um e-mail válido")
    private String email;

    private Integer credits;

    private String mailVerified;


    private Set<GrantedAuthority> roles = new HashSet<>();

    public AccountDTO() {
    }

    public AccountDTO(String login, String password, String name, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public AccountDTO(MembInfo entity) {
        this.id = entity.getMembGuid();
        this.login = entity.getMembId();
        this.password = entity.getMembPwd();
        this.name = entity.getMembName();
        this.email = entity.getMailAddr();
        this.credits = entity.getScfVipMoney();
        this.mailVerified = entity.getMailChek();

    }

    public String getMailVerified() {
        return mailVerified;
    }

    public void setMailVerified(String mailVerified) {
        this.mailVerified = mailVerified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addRole(GrantedAuthority role) {
        roles.add(role);
    }

    public Set<GrantedAuthority> getRoles() {
        return roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountDTO{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", credits=").append(credits);
        sb.append(", id=").append(id);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
