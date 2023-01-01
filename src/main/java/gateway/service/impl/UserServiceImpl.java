package gateway.service.impl;

import gateway.controller.payload.PlaylistDTO;
import gateway.proxy.common.Credentials;
import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.service.UserService;
import gateway.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserProxy userProxy;
    private final VideoService videoService;
    public UserServiceImpl(UserProxy userProxy, VideoService videoService) {
        this.userProxy = userProxy;
        this.videoService = videoService;
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

    @Override
    public List<PlaylistDTO> getUserPlaylistsDTO(Long userId) {
        List<PlaylistPayload> playlistPayloadList = getUserPlaylists(userId);
        return playlistPayloadList.stream().map(playlistPayload -> {
            return new PlaylistDTO(playlistPayload,
                    videoService.getPlaylistVideos(playlistPayload.getId()));
        }).collect(Collectors.toList());
    }
}
