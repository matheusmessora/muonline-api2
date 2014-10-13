package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.BadgeDTO;
import pandox.china.model.custom.Badge;
import pandox.china.repo.BadgeRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class BadgeService {

    @Autowired
    private BadgeRepository repository;


    public List<BadgeDTO> getAll() {
        List<BadgeDTO> badgeDTOs = new ArrayList<>();
        Iterable<Badge> all = repository.findAll();

        for (Badge badge : all) {
            badgeDTOs.add(new BadgeDTO(badge));
        }

        return badgeDTOs;
    }


}
