package pandox.china.service;

import pandox.china.dto.HeroDTO;

import java.util.List;

public interface HeroService {


    List<HeroDTO> getAllByLogin(String login);
}
