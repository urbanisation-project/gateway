package gateway.service;

import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface VideoService {
    PlaylistPayload savePlaylist(PlaylistPayload playlist);

    PlaylistPayload addVideoToPlaylist(Long playlistId, VideoDTO video);

    boolean removeVideoFromPlaylist(VideoPayload video);

    boolean delete(PlaylistPayload playlist);

    PlaylistPayload update(PlaylistPayload playlist);

    List<VideoPayload> getPlaylistVideos(Long playlistId);
}
