package pandox.china.model.custom;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "X_Item", schema = "dbo", catalog = "MuOnline")
public class Item {

    public Item(){}

    public Item(Integer id) {
        this.id = id;
    }

    @Id
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer status;

    @Column
    private Integer value;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private Set<ItemProfile> itemProfile;

    public Set<ItemProfile> getItemProfile() {
        return itemProfile;
    }

    public void setItemProfile(Set<ItemProfile> itemProfile) {
        this.itemProfile = itemProfile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", status=").append(status);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
