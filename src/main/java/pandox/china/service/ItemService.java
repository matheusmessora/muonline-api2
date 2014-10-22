package pandox.china.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pandox.china.dto.ErroDTO;
import pandox.china.dto.ItemDTO;
import pandox.china.exception.BadRequestException;
import pandox.china.model.MembInfo;
import pandox.china.model.custom.Item;
import pandox.china.model.custom.ItemProfile;
import pandox.china.model.custom.Profile;
import pandox.china.repo.AccountRepository;
import pandox.china.repo.ItemProfileRepository;
import pandox.china.repo.ItemRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class ItemService {

    private static Logger log = Logger.getLogger(ItemService.class);
    @Autowired
    private ItemRepository repository;

    @Autowired
    private ItemProfileRepository itemProfileRepository;

    @Autowired
    private AccountRepository accountRepository;


    public List<ItemDTO> getAll() {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        Iterable<Item> all = repository.findAll();

        for (Item item : all) {
            itemDTOs.add(new ItemDTO(item));
        }

        return itemDTOs;
    }

    private void canBuy(Profile profile, Item item){
        if(item == null) {
            log.info("compraITEM.WARN. profile=" + profile.getId() + ", login=" + profile.getMembInfo().getMembId() + ", item=" + item.getId() + ", msg=Item inexistente");
            throw new BadRequestException(new ErroDTO("item", "Selecione um item correto."));
        }

        Integer money = profile.getMembInfo().getScfVipMoney();
        if(money < item.getValue()) {
            log.info("compraITEM.WARN. profile=" + profile.getId() + ", login=" + profile.getMembInfo().getMembId() + ", item=" + item.getId() + ", msg=Saldo negativo");
            throw new BadRequestException(new ErroDTO("item", "Você não possui créditos"));
        }

    }


    @Transactional
    public ItemProfile buy(Profile profile, Integer itemId) {
        Item item = repository.findOne(itemId);
        canBuy(profile, item);

        ItemProfile itemProfile = new ItemProfile();
        itemProfile.setProfile(profile);
        itemProfile.setItem(item);
        itemProfile.setCreationDate(new Date());
        itemProfile.setValue(item.getValue());

        itemProfileRepository.save(itemProfile);

        MembInfo membInfo = accountRepository.findOne(profile.getMembInfo().getMembGuid());
        membInfo.chargeMoney(item.getValue());

        if(isVIPItem(item)){
            membInfo.setScfIsVip((short) 1);
            membInfo.setScfVipDays(getVipDays(item));
            accountRepository.save(membInfo);

            itemProfile.setProcessDate(new Date());
            itemProfileRepository.save(itemProfile);
            log.info("compraITEM.SUCESSO.VIP. profile=" + profile.getId() + ", login=" + profile.getMembInfo().getMembId() + ", item=" + item.getId());
        } else {
            accountRepository.save(membInfo);
            log.info("compraITEM.SUCESSO. profile=" + profile.getId() + ", login=" + profile.getMembInfo().getMembId() + ", item=" + item.getId());
        }



        return itemProfile;
    }

    private Integer getVipDays(Item item){
        if(item.getId().equals(1)){
            return 15;
        }
        if(item.getId().equals(2)){
            return 30;
        }
        if(item.getId().equals(3)){
            return 60;
        }
        log.error("vipDAYS.ERRO. item=" + item.getId());
        return 15;
    }

    private boolean isVIPItem(Item item) {
        List<Integer> idsVIP = Arrays.asList(1, 2, 3);
        return idsVIP.contains(item.getId());
    }

    @Scheduled(cron="*/5 * * * * *")
    public void processVIP() {
        log.info("PROCESSANDO VIP");
        List<MembInfo> membInfos = accountRepository.findByScfIsVip((short) 1);
        log.info("VIP. qtdVIPs=" + membInfos.size());
        for (MembInfo membInfo : membInfos) {
            membInfo.decreaseVIP();

            if(membInfo.getScfVipDays() <= 0){
                log.info("VIP.REMOVIDO. login=" + membInfo.getMembId() + ", credits=" + membInfo.getScfVipMoney());
                membInfo.setScfIsVip((short) 0);
            }
        }
        log.info("VIP.SUCESSO");
        accountRepository.save(membInfos);
    }
}
