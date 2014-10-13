package pandox.china.repo;

import org.springframework.data.repository.CrudRepository;
import pandox.china.model.Character;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character, String> {


    List<Character> findByAccountIdOrderByResetsDesc(String accountId);


}
