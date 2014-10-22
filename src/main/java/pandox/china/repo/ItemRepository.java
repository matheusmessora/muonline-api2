package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.custom.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
