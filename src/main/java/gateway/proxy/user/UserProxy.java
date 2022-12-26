package gateway.proxy.user;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface UserProxy {
    PlaylistPayload savePlaylist(PlaylistPayload playlist);

    PlaylistPayload addVideoToPlaylist(VideoPayload video);

    PlaylistPayload removeVideoFromPlaylist(VideoPayload video);

    PlaylistPayload delete(PlaylistPayload playlist);

    PlaylistPayload update(PlaylistPayload playlist);

    List<VideoPayload> researchVideoYoutube(String query);

    List<VideoPayload> researchVideoDailyMotion(String query);

    UserPayload authenticate(Credentials credentials);

    UserPayload saveUser(UserPayload user);

    List<PlaylistPayload> getUserPlaylists(Long userId);

    List<VideoPayload> getPlaylistVideos(Long playlistId);
}
