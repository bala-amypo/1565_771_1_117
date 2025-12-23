package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PolicyRule;
import java.util.List;
import java.util.Optional;

public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule r);
    List<PolicyRule> findByActiveTrue();
    Optional<PolicyRule> findByRuleCode(String code);
    List<PolicyRule> findAll();
}
