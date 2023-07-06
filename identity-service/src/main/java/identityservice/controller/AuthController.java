package identityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import identityservice.model.AuthRequest;
import identityservice.model.JwtToken;
import identityservice.model.UserCredential;
import identityservice.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public ResponseEntity<UserCredential> addNewUser(@RequestBody UserCredential user) {
		UserCredential userCredential = service.saveUser(user);
		if(userCredential == null) {
			return new ResponseEntity<UserCredential>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserCredential>(userCredential, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtToken> getToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authenticate.isAuthenticated()) {
			JwtToken token = new JwtToken();
			token.setToken(service.generateToken(authRequest.getUsername()));
			return new ResponseEntity<JwtToken>(token, HttpStatus.OK);
		} else {
			return new ResponseEntity<JwtToken>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
