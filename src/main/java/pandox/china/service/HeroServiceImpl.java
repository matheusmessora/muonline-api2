package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pandox.china.dto.HeroDTO;
import pandox.china.model.Character;
import pandox.china.repo.CharacterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroServiceImpl {

    @Autowired
    private CharacterRepository characterRepository;

    public List<HeroDTO> getAllByLogin(String login) {
        List<HeroDTO> dtos = new ArrayList<>();
        List<Character> characters = characterRepository.findByAccountIdOrderByResetsDesc(login);

        for (Character character : characters) {
            dtos.add(new HeroDTO(character));
        }

        return dtos;
    }

    public List<HeroDTO> getAll(String heroType, Integer size, String order) {
        List<HeroDTO> dtos = new ArrayList<>();

        Pageable pageable = new PageRequest(0, size);
        List<Character> chars = characterRepository.findByAccountIdNotInOrderByResetsDescCLevelDesc(pageable, "mmmkiller", "enigma", "rafaela");

        for (Character character : chars) {
            dtos.add(new HeroDTO(character));
        }
        return dtos;
    }
}
