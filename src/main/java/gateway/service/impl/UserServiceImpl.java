package gateway.service.impl;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserProxy userProxy;

    public UserServiceImpl(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    @Override
    public UserPayload authenticate(Credentials credentials) {
        return userProxy.authenticate(credentials);
    }

    @Override
    public UserPayload saveUser(UserPayload user) {
        return userProxy.saveUser(user);
    }

    @Override
    public List<PlaylistPayload> getUserPlaylists(Long userId) {
        return userProxy.getUserPlaylists(userId);
    }
}
