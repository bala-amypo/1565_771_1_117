




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
        List<ViolationRecord> result =
    }
}