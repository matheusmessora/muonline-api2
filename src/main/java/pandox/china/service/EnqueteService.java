package pandox.china.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.EnqueteDTO;
import pandox.china.dto.ErroDTO;
import pandox.china.exception.BadRequestException;
import pandox.china.model.custom.Enquete;
import pandox.china.model.custom.EnqueteAnswer;
import pandox.china.model.custom.Profile;
import pandox.china.repo.EnqueteAnswerRepository;
import pandox.china.repo.EnqueteRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class EnqueteService {

    @Autowired
    private EnqueteRepository enqueteRepository;

    @Autowired
    private EnqueteAnswerRepository answerRepository;

    public void doAnswer(Integer enqueteId, Integer answerValue, Integer profileId) {
        if (isValidAnswer(answerValue)) {
            if (profileAlreadyAnswered(profileId, enqueteId)) {
                throw new BadRequestException(new ErroDTO("answer", "Você já respondeu a pergunta"));
            }

            EnqueteAnswer entity = new EnqueteAnswer();
            entity.setAnswer(answerValue);
            entity.setEnquete(new Enquete(enqueteId));
            entity.setProfile(new Profile(profileId));

            answerRepository.save(entity);
        } else {
            throw new BadRequestException(new ErroDTO("answer", "Informe uma resposta válida"));
        }

    }

    private boolean profileAlreadyAnswered(Integer profileId, Integer enqueteId) {
        Enquete enquete = enqueteRepository.findOne(enqueteId);
        if (enquete == null) {
            throw new BadRequestException(new ErroDTO("question", "Pergunta inválida"));
        }
        for (EnqueteAnswer answer : enquete.getEnqueteAnswerses()) {
            if (answer.getProfile().getId().equals(profileId))
                return true;

        }
        return false;
    }

    private boolean isValidAnswer(Integer answer) {
        return 1 <= answer && answer <= 4;
    }

    public List<EnqueteDTO> getAll(String status, Profile profile, boolean answerable) {
        List<Enquete> entities = new ArrayList<>();
        if (isValidStatus(status)) {
            entities = enqueteRepository.findByStatus(status);
        } else {
            Iterable<Enquete> all = enqueteRepository.findAll();
            for (Enquete enquete : all) {
                entities.add(enquete);
            }
        }


        List<EnqueteDTO> dtos = new ArrayList<>();
        for (Enquete enquete : entities) {
            if (answerable) {
                boolean alreadyAnwered = false;
                for (EnqueteAnswer answer : profile.getEnqueteAnswerses()) {
                    if (answer.getEnquete().getId().equals(enquete.getId())) {
                        alreadyAnwered = true;
                    }
                }
                if (!alreadyAnwered) {
                    EnqueteDTO enqueteDTO = new EnqueteDTO(enquete);
                    enqueteDTO.setCanAnswer(true);
                    dtos.add(enqueteDTO);
                }

            } else {
                dtos.add(new EnqueteDTO(enquete));
            }
        }

        return dtos;
    }


    private boolean isValidStatus(String status) {
        return !StringUtils.isBlank(status) && (status.equals("1") || status.equals("0"));
    }
}
