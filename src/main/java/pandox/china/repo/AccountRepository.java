package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.MembInfo;

public interface AccountRepository extends CrudRepository<MembInfo, Integer> {

    MembInfo findByMembId(String login);

    MembInfo findByMembIdAndMembPwd(String login, String password);


}
