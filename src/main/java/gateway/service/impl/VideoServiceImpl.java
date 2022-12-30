package gateway.service.impl;

import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    private UserProxy userProxy;

    public VideoServiceImpl(UserProxy userProxy) {
        this.userProxy = userProxy;
    }

    @Override
    public PlaylistPayload savePlaylist(PlaylistPayload playlist) {
        return userProxy.savePlaylist(playlist);
    }

    @Override
    public PlaylistPayload addVideoToPlaylist(Long playlistId, VideoDTO video) {
        return userProxy.addVideoToPlaylist(playlistId,video);
    }

    @Override
    public boolean removeVideoFromPlaylist(VideoPayload video) {
        return userProxy.removeVideoFromPlaylist(video);
    }

    @Override
    public boolean delete(PlaylistPayload playlist) {
        return userProxy.delete(playlist);
    }

    @Override
    public PlaylistPayload update(PlaylistPayload playlist) {
        return userProxy.update(playlist);
    }

    @Override
    public List<VideoPayload> getPlaylistVideos(Long playlistId) {
        return userProxy.getPlaylistVideos(playlistId);
    }
}
