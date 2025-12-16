












public interface PolicyRuleService{
    PolicyRule createRule(PolicyRule rule);
    PolicyRule updateRule(Long id,PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
    PolicyRule getRuleByCode(String ruleCode);
}