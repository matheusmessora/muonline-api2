package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.MembStat;

import java.util.List;

public interface MembStatRepository extends CrudRepository<MembStat, String> {

    List<MembStat> findByConnectStat(Integer connectStatus);
}
