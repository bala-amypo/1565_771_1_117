





@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {
    List<DeviceProfile> devices=new ArrayList<>();
    long id;

    public DeviceProfile registerDevice(DeviceProfile device){
        device.setId((long)id++);
        devices.add(device);
        return device;
    }
    public DeviceProfile updateTrustStatus(Long id, boolean trust){
        for(DeviceProfile d : devices){
            if(d.getId().equals(id)){
                d.setIsTrusted(trust);
                return d;
            }
        }
        return null;
    }
    public List<DeviceProfile> getDeviceByUser(Long userId){
        List<DeviceProfile> result = new ArrayList<>();
        for(DeviceProfile d : devices){
            if(d.getUserId().equals(userId)){
                result.add(d);
            }
        }
        return result;
    }
    public DeviceProfile findByDeviceId(String deviceId){
        for(DeviceProfile d: devices){
            if(d.getDeviceId().equlas)
        }
    }
}