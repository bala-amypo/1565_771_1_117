







@Service
public class UserAccountServiceImpl implements UserAccountService{
    List<UserAccount> users = new ArrayList<>();
    long id=1;
    public List<UserAccount> getAllUsers()
    {
        return users;
    }
    public UserAccount createUser(UserAccount user){
        user.setId((long) id++);
        users.add(user);
        return user;
    }
    public UserAccount getUserById(Long id){
        for(UserAccount u: users){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }
    public UserAccount findByUsername(String username){
        for(UserAccount u: users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
    public UserAccount updateUser(Long id,UserAccount user){
        for()
    }
}