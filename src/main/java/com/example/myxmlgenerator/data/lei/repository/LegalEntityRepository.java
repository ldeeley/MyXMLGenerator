package com.example.myxmlgenerator.data.lei.repository;

import com.example.myxmlgenerator.data.lei.model.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalEntityRepository extends JpaRepository<LegalEntity, String> {
    List<String> findByLegalCountry(String country);
    List<LegalEntity> findByHQCountry(String country);
}
