package gateway.proxy.user.impl;

import gateway.proxy.common.Credentials;
import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.UserPayload;
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
    public PlaylistPayload addVideoToPlaylist(VideoPayload video) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/videos/save")
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                video,
                PlaylistPayload.class
        ).getBody();
    }

    @Override
    public PlaylistPayload removeVideoFromPlaylist(VideoPayload video) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/videos"+video.getId()+"/remove")
                .build()
                .toUri();
        return restTemplate.postForEntity( // a revoir
                uri,
                video,
                PlaylistPayload.class
        ).getBody();
    }

    @Override
    public PlaylistPayload delete(PlaylistPayload playlist) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/playlists/delete") // a revoir
                .build()
                .toUri();
        return restTemplate.postForEntity(
                uri,
                playlist,
                PlaylistPayload.class
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
    public List<VideoPayload> researchVideoYoutube(String query) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/researches/youtube" + query) //a revoir
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoPayload[].class
        ).getBody())).collect(Collectors.toList());
    }

    @Override
    public List<VideoPayload> researchVideoDailyMotion(String query) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .path("/v1/api/researches/dailymotion" + query) // idem pour youtube
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoPayload[].class
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
                .path("chnger/" + userId) // a implementer
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
                .path("chnger/" + playlistId) // a implementer
                .build()
                .toUri();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForEntity(
                uri,
                VideoPayload[].class
        ).getBody())).collect(Collectors.toList());
    }
}
