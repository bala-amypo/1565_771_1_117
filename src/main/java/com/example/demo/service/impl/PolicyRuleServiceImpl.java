


@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {
    List<PolicyRule> rules = new ArrayList<>();
    long id=1;
    public PolicyRule createRule(PolicyRule rule){
        rule.setId((long) id++);
        rules.add(rule);
        return rule;
    }
    public PolicyRule updateRule(Long id,PolicyRule rule){
        for(PolicyRule r: rules){
            if(r.getId().equals(id)){
                r.setRuleCode(rule.getRuleCode());
                r.setDescripton(rule.getDescription());
                r.setSeverity(rule.getSeverity());
                r.setConditionsJson(rule.getConditionsJson());
                r.setActive(rule.getActive());
                return r;
            }
        }
        return null;
    }\
    public List<PolicyRule> getActiveRules(){
        List<PolicyRule> activeRules = new ArrayList<>();
        for(PolicyRule r :rules){
            if(Boolean.True.equals(r.getActive())){
                activeRules.add(r);
            }
        }
        return activeRules;
    }
    public List<PolicyRule> getAllRules(){
        return rules;
    }
    public PolicyRule getRuleBycode()

}