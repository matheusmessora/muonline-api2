package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pandox.china.dto.HeroDTO;
import pandox.china.exception.NoContentException;
import pandox.china.model.Character;
import pandox.china.model.MembStat;
import pandox.china.repo.CharacterRepository;
import pandox.china.repo.MembStatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MembStatRepository membStatRepository;


    public List<HeroDTO> getAllByLogin(String login) {
        List<HeroDTO> dtos = new ArrayList<>();
        List<Character> characters = characterRepository.findByAccountIdOrderByResetsDesc(login);

        for (Character character : characters) {
            dtos.add(new HeroDTO(character));
        }

        return dtos;
    }

    public HeroDTO getByLoginAndName(String login, String name) {

        Character character = characterRepository.findOne(name);


        if(character != null) {
            if(character.getAccountId().equals(login)){
                return new HeroDTO(character);
            }
        }
        throw new NoContentException();
    }

    public List<HeroDTO> getAll(String heroType, Integer size, String order) {
        List<HeroDTO> dtos = new ArrayList<>();

        Pageable pageable = new PageRequest(0, size);
        List<Character> chars = characterRepository.findByAccountIdNotInOrderByResetsDescCLevelDesc(pageable, "mmmkiller", "enigma", "rafaela");

        for (Character character : chars) {
            HeroDTO heroDTO = new HeroDTO(character);
            MembStat membStat = membStatRepository.findOne(character.getAccountId());
            heroDTO.setOnlineHours(membStat.getHours());
            dtos.add(heroDTO);
        }
        return dtos;
    }
}
