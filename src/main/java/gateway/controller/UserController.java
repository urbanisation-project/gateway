package gateway.controller;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/save")
    public UserPayload save(@RequestBody UserPayload user){
        return userService.saveUser(user);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<UserPayload> authenticate(@RequestBody Credentials credentials){
        try {
            return new ResponseEntity( userService.authenticate(credentials),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("message",HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/{userId}/playlists")
    public List<PlaylistPayload> getUserPlaylists(@PathVariable Long userId){
        return userService.getUserPlaylists(userId);
    }
}
