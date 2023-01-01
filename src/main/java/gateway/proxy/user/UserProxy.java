package gateway.proxy.user;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface UserProxy {
    PlaylistPayload savePlaylist(PlaylistPayload playlist);

    PlaylistPayload addVideoToPlaylist(Long playlistId, VideoDTO video);

    boolean removeVideoFromPlaylist(VideoPayload video);

    boolean delete(PlaylistPayload playlist);

    PlaylistPayload update(PlaylistPayload playlist);

    List<VideoDTO> researchVideoYoutube(String query) throws Exception;

    List<VideoDTO> researchVideoDailyMotion(String query) throws Exception;

    UserPayload authenticate(Credentials credentials);

    UserPayload saveUser(UserPayload user);

    List<PlaylistPayload> getUserPlaylists(Long userId);

    List<VideoPayload> getPlaylistVideos(Long playlistId);
}
