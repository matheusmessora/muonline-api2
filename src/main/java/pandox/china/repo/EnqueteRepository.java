package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.custom.Enquete;

import java.util.List;

public interface EnqueteRepository extends CrudRepository<Enquete, Integer> {

    List<Enquete> findByStatus(String status);

}
