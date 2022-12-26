package gateway.service;

import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface VideoService {
    PlaylistPayload savePlaylist(PlaylistPayload playlist);

    PlaylistPayload addVideoToPlaylist(VideoPayload video);

    PlaylistPayload removeVideoFromPlaylist(VideoPayload video);

    PlaylistPayload delete(PlaylistPayload playlist);

    PlaylistPayload update(PlaylistPayload playlist);

    List<VideoPayload> getPlaylistVideos(Long playlistId);
}
