package pandox.china.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.ServerDTO;
import pandox.china.repo.AccountRepository;
import pandox.china.repo.CharacterRepository;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public ServerDTO get() {

        Long qtdAccount = accountRepository.count();
        Long qtdChars = characterRepository.count();
        Long qtdOnline = 0L;

        boolean serverUp = isServerUp();

        return new ServerDTO(qtdAccount, qtdChars, qtdOnline, serverUp);
    }

    private boolean isServerUp() {

        Socket s = null;
        try {
            s = new Socket();
            s.connect(new InetSocketAddress("54.207.81.210", 44405), 2000);


            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    return false;
                }
            }
        }
    }
}
