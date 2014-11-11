package pandox.china.dto;

public class CreditDTO {

    public CreditDTO(String response){
        id = response;
    }

    public CreditDTO() {
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

