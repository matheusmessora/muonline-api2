package pandox.china.service;

import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pandox.china.dto.CreditDTO;
import pandox.china.dto.ErroDTO;
import pandox.china.exception.BadRequestException;
import pandox.china.model.custom.Credit;
import pandox.china.model.custom.Profile;
import pandox.china.repo.CreditRepository;

import java.math.BigDecimal;
import java.util.Date;


@Service
public class CreditService {

    private static Logger log = Logger.getLogger(CreditService.class);

    @Autowired
    private CreditRepository repository;


    public CreditDTO persist(Profile profile, Integer id) {

        Checkout checkout = new Checkout();

        Item item = getItem(id);
        String hash = String.valueOf(new Date().getTime());
        String reference = profile.getId() + "|" + item.getId() + "|" + item.getAmount() + "|" + hash.substring(0, 12);

        checkout.addItem(item);
        checkout.setShippingType(ShippingType.NOT_SPECIFIED);
        checkout.setCurrency(Currency.BRL);
        checkout.setReference(reference);
        checkout.setRedirectURL("http://www.worldofmu.com.br/shop/sucesso");

        Credit credit = new Credit(reference, new Date(), 0, profile);
        repository.save(credit);

        try {

            boolean onlyCheckoutCode = false;
            String response = checkout.register(PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);

            log.info("pagseguro. credit=" + credit.getId() + "status=0");
            return new CreditDTO(response);
        } catch (PagSeguroServiceException e) {
            credit.setStatus(-1);
            repository.save(credit);

            log.error("pagseguro.FALHA. credit=" + credit.getId() + "status=-1", e);
            throw new BadRequestException(new ErroDTO("id", e.getLocalizedMessage()));
        }
    }


    private static Item getItem(Integer id){
//        if(id.equals(1)){
//            return new Item("1", "1.500 WCoin", 1, new BigDecimal("15.00"));
//        }
//        if(id.equals(2)){
//            return new Item("2", "2.000 WCoin", 1, new BigDecimal("20.00"));
//        }
//        if(id.equals(3)){
//            return new Item("3", "3.000 WCoin", 1, new BigDecimal("30.00"));
//        }
//        if(id.equals(4)){
//            return new Item("4", "5.000 WCoin", 1, new BigDecimal("50.00"));
//        }
        if(id.equals(100)){
            return new Item("100", "3.000 WCoin - Promoção 2X WCoin", 1, new BigDecimal("15.00"));
        }
        if(id.equals(200)){
            return new Item("200", "4.000 WCoin - Promoção 2X WCoin", 1, new BigDecimal("20.00"));
        }
        if(id.equals(300)){
            return new Item("300", "6.000 WCoin - Promoção 2X WCoin", 1, new BigDecimal("30.00"));
        }
        if(id.equals(400)){
            return new Item("400", "10.000 WCoin - Promoção 2X WCoin", 1, new BigDecimal("50.00"));
        }

        throw new BadRequestException(new ErroDTO("id", "Falha ao buscar ITEM id=" + id));
    }
}
