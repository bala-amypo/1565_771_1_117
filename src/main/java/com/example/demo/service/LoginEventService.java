





public interface LoginEventService{
    LoginEvent recordLogin(LoginEvent event);
    List<LoginEvent> getEventByUser(Long userId);
    List<LoginEvent> getSuspiciousLogins(Long userId);
    List<LoginEvent> getAllEvents();
}