





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
                
            }
        }
    }
}