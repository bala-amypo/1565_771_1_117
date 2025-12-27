import com.example.demo.dto.JwtResponse;
// ... other imports

@PostMapping("/signin")
public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    // ... logic to generate token
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    // This is the line that was failing because the class was missing
    return ResponseEntity.ok(new JwtResponse(jwt));
}