package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.MembStat;

public interface MembStatRepository extends CrudRepository<MembStat, String> {

    MembStat findByMembId(String login);

}
