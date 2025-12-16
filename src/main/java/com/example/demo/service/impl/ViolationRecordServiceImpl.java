




@Service
public class ViolationRecordServiceImpl implements ViolationRecordService{
    List<ViolationRecord> violations = new ArrayList<>();
    long id=1;
    public ViolationRecord logViolation(ViolationRecord violation){
        violation.setId((long) id++);
        violations.add(violation);;
        return violation;
    }
    public List<ViolationRecord> getViolationsByUser(Long userId){
        List<ViolationRecord> result =new ArrayList<>();
        for (ViolationRecord v : violations){
            if(v.getUserId().equals(userId)){
                result.add(v);
            }
        }
        return result;
    }
    public ViolationRecord markResolved(Long id){
        for (ViolationRecord v : violations){
            if(v.getId().equals(id)){
                v.setResolved(true);
                return v;
            }
        }
        return null;
    }
    public List<ViolationRecord> getUnresolvedViolations(){
        List<ViolationRecord> result= new ArrayList<>();
        for(ViolationRecord v : violations){
            if(!v.getUnresolved()){
                result.add(v);
            }
        }
        return result;
    }
    public List<ViolationRecord> getAllViolations(){
        return violations
    }
}