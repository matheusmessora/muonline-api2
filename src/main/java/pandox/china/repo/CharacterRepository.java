package pandox.china.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pandox.china.model.Character;

import java.util.List;

public interface CharacterRepository extends PagingAndSortingRepository<Character, String> {


    List<Character> findByAccountIdOrderByResetsDesc(String accountId);


    List<Character> findByAccountIdNotInOrderByResetsDescCLevelDesc(Pageable pageable, String... login);







}
