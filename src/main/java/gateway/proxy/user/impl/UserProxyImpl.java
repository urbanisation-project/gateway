package gateway.proxy.user.impl;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserProxyImpl implements UserProxy {
    private RestTemplate restTemplate;
    @Value("${user.url}")
    private String url;

    public UserProxyImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PlaylistPayload savePlaylist(PlaylistPayload playlist) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                playlist,
                PlaylistPayload.class
        ).getBody();
    }

    @Override
    public PlaylistPayload addVideoToPlaylist(Long playlistId, VideoDTO video) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/"+playlistId+"/add-video")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                video,
                PlaylistPayload.class
        ).getBody();
    }

    @Override
    public boolean removeVideoFromPlaylist(VideoPayload video) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/videos/remove")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                video,
                boolean.class
        ).getBody();
    }

    @Override
    public boolean delete(PlaylistPayload playlist) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/delete")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                playlist,
                boolean.class
        ).getBody();
    }

    @Override
    public PlaylistPayload update(PlaylistPayload playlist) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/update")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                playlist,
                PlaylistPayload.class
        ).getBody();
    }

    @Override
    public List<VideoDTO> researchVideoYoutube(String query) throws Exception{
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/researches/youtube/" + query)
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoDTO[].class
        ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<VideoDTO> researchVideoDailyMotion(String query) throws Exception {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/researches/dailymotion/" + query)
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoDTO[].class
        ).getBody())).collect(Collectors.toList());
    }

    @Override
    public UserPayload authenticate(Credentials credentials) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/authentication/")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                credentials,
                UserPayload.class
        ).getBody();
    }

    @Override
    public UserPayload saveUser(UserPayload user) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/users/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                user,
                UserPayload.class
        ).getBody();
    }

    @Override
    public List<PlaylistPayload> getUserPlaylists(Long userId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/users/" + userId+"/playlists")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                PlaylistPayload[].class
        ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<VideoPayload> getPlaylistVideos(Long playlistId) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/" + playlistId+"/videos")
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoPayload[].class
        ).getBody())).collect(Collectors.toList());
    }
}
