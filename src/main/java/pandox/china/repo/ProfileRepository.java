package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.custom.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Profile findByMembInfo_MembGuid(Integer membGuid);


}
