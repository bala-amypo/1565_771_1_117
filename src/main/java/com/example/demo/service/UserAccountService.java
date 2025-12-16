







public interface UserAccountService{
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id),String stat;
}