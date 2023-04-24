package com.example.myxmlgenerator.data.bic.repository;

import com.example.myxmlgenerator.data.bic.model.BICRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BICRepository extends JpaRepository<BICRecord, String> {
    Set<BICRecord> findByBIC(String BICCode);
    Set<BICRecord> findByBranch(String BranchCode);
    List<BICRecord> findByCountryCode(String countryCode);
    List<BICRecord> findAllExcludeInvalid();
}
