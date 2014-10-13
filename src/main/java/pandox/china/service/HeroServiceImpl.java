package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.HeroDTO;
import pandox.china.model.Character;
import pandox.china.repo.CharacterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<HeroDTO> getAllByLogin(String login) {
        List<HeroDTO> dtos = new ArrayList<>();
        List<Character> characters = characterRepository.findByAccountIdOrderByResetsDesc(login);

        for (Character character : characters) {
            dtos.add(new HeroDTO(character));
        }

        return dtos;
    }

}
