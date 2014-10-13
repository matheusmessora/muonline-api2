package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.ProfileDTO;
import pandox.china.dto.TokenDTO;
import pandox.china.exception.NoContentException;
import pandox.china.model.MembInfo;
import pandox.china.model.custom.Profile;
import pandox.china.repo.AccountRepository;
import pandox.china.repo.ProfileRepository;
import pandox.china.service.auth.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Service
public class ProfileService {


    @Autowired
    private ProfileRepository repository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthenticationService auth;


    public Profile getFromRequest(HttpServletRequest request) {
        TokenDTO token = auth.userLogged(request);
        Profile entity = repository.findByMembInfo_MembGuid(token.getId());

        if (entity == null) {
            entity = new Profile();
            entity.setMembInfo(accountRepository.findOne(token.getId()));
            entity.setSignupDate(new Date());
            entity = save(entity);
        }

        return entity;
    }

    public ProfileDTO getFromMembInfo(Integer membGuid) {
        Profile entity = repository.findByMembInfo_MembGuid(membGuid);
        if (entity == null) {
            entity = saveNew(membGuid);
        }

        return new ProfileDTO(entity);
    }

    public ProfileDTO getFromLogin(String login) {
        MembInfo membInfo = accountRepository.findByMembId(login);
        if (membInfo == null) {
            throw new NoContentException();
        }
        Profile entity = repository.findByMembInfo_MembGuid(membInfo.getMembGuid());
        if (entity == null) {
            entity = saveNew(membInfo.getMembGuid());
        }

        return new ProfileDTO(entity);
    }

    private Profile saveNew(Integer membGuid) {
        Profile entity = new Profile();
        entity.setMembInfo(accountRepository.findOne(membGuid));
        entity.setSignupDate(new Date());
        entity = save(entity);
        return repository.findOne(entity.getId());
    }


    protected Profile save(Profile notManagedEntity) {
        notManagedEntity.setLevel(1);
        notManagedEntity.setExp(0);
        return repository.save(notManagedEntity);
    }


}
