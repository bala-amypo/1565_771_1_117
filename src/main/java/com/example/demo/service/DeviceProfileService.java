













public interface DeviceProfileService{
    DeviceProfile registerDevice(DeviceProfile device);
    DeviceProfile updateTrustStatus(Long id,boolean trust);
    List<DeviceProfile> getDeviceByUser(Long userId);
    DeviceProfile findByDeviceId(String deviceId);
}