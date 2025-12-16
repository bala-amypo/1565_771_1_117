


















public interface ViolationRecordService{
    ViolationRecord logViolation(ViolationRecord violation);
    List<ViolationRecord> getViolationsByUser(Long userId);
    ViolationRecord markResolved(Long id);
    List<ViolationRecord> getUnResolvedViolations();
    List<ViolationRecord> getAllViolations();
}