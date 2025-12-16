









@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@)
}