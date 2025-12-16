









@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody UserAccount user){
        retrun ResponseEntity.status(201).body(userAccountService.createUser(user));
    }
    @postMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserAccount user){
        UserAccount existingUser = userAccountService.findByUsername(user.getUsername());
        if(existingUser != null && existingUser.getPassword().euqls)
    }
}