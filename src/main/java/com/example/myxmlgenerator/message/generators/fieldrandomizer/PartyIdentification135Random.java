package com.example.myxmlgenerator.message.generators.fieldrandomizer;

import com.example.myxmlgenerator.data.lei.model.LegalEntity;
import com.example.myxmlgenerator.data.lei.repository.LegalEntityRepository;
import com.example.myxmlgenerator.util.StringUtils;
import com.prowidesoftware.swift.model.mx.dic.PartyIdentification135;
import com.prowidesoftware.swift.model.mx.dic.PostalAddress24;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class PartyIdentification135Random {

    public static PartyIdentification135 getPartyIdentification135(LegalEntityRepository legalEntityRepository, String countryCode){

        PartyIdentification135 partyIdentification = new PartyIdentification135();
        // get random Legal Entity from repo
        List<String> entities = legalEntityRepository.findByLegalCountry(countryCode);
        int recordCount = entities.size();
        int idx = (int)(Math.random() * recordCount);
        // log.info("Random Entity - " + idx);
        Optional<LegalEntity> entity = legalEntityRepository.findById(entities.get(idx));

        if (entity.isPresent()) {
            LegalEntity query = entity.get();

            partyIdentification.setNm(StringUtils.removeNonPrintableChars(StringUtils.StringStripper(query.getLegalName(),140)));
            PostalAddress24 postalAddress = new PostalAddress24();
            postalAddress.setCtry(StringUtils.removeNonPrintableChars(query.getLegalAddressCountry()));
            postalAddress.setTwnNm(StringUtils.removeNonPrintableChars(StringUtils.removeNonPrintableChars(StringUtils.StringStripper(query.getLegalAddressCity(),35))));
            postalAddress.setPstCd(query.getLegalAddressPostalCode());
            postalAddress.setStrtNm(StringUtils.removeNonPrintableChars(StringUtils.removeNonPrintableChars(StringUtils.StringStripper(query.getLegalAddressFirstAddressLine(),70))));

            partyIdentification.setPstlAdr(postalAddress);
        }
        else
            log.error("Error Generating Random BIC number");

        return partyIdentification;
    }
}
