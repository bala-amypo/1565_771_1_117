





@Service
public class LoginEventServiceImpl implements LoginEventService{
    List<LoginEvent> events =new ArrayList<>();
    long id=1;
    public void recordLogin(LoginEvent event){
        event.setId((long) id++);
        events.add(event);
    }
    public List<LoginEvent> getEventByUser(Long userId){
        List<LoginEvent> result =new ArrayList<>();
        for(LoginEvent e: events){
            if(e.getUserId().equals(userId)){
                result.add(e);
            }
        }
        return result;
    }
    public List<LoginEvent> getSuspiciousLogins(Long userId){
        List<LoginEvent> result = new ArrayList<>();
        for(LoginEvent e : events){
            if(e.getUserId().equals(userId) && "Falied".euqla(e.getLoginStatus())){
                result.add(e);
            }
        }
        return result;
    }
    public List<LoginEvent> getAllEvents(){
        return events;
    }
}
