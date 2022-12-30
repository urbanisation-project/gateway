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

    // creation de compte, impossible de créer le compte, cas ou le serveur user is down
    @PostMapping("/save")
    public ResponseEntity<UserPayload> save(@RequestBody UserPayload user){
        try {
            return new ResponseEntity( userService.saveUser(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de créer le compte !", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserPayload> authenticate(@RequestBody Credentials credentials){
        try {
            return new ResponseEntity( userService.authenticate(credentials),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Mail/password invalide !",HttpStatus.UNAUTHORIZED);
        }
    }
    // get playlist user, if nothing found
    @GetMapping("/{userId}/playlists")
    public ResponseEntity<List<PlaylistPayload>> getUserPlaylists(@PathVariable Long userId){
        try {
            return new ResponseEntity(userService.getUserPlaylists(userId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Aucune playlist trouvé !", HttpStatus.UNAUTHORIZED);
        }
    }
}
