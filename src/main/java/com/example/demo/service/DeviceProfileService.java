public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile updateTrustStatus(Long id, boolean trusted);

    List<DeviceProfile> getDevicesByUser(Long userId);

    Optional<DeviceProfile> findByDeviceId(String deviceId); // ✅ REQUIRED
}
