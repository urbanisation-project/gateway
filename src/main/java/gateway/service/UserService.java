package gateway.service;

import gateway.controller.payload.PlaylistDTO;
import gateway.proxy.common.Credentials;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface UserService {
    UserPayload authenticate(Credentials credentials);

    UserPayload saveUser(UserPayload user);

    List<PlaylistPayload> getUserPlaylists(Long userId);

    List<PlaylistDTO> getUserPlaylistsDTO(Long userId);
}
