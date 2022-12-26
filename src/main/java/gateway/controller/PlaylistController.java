package gateway.controller;

import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PlaylistController {
    private VideoService videoService;

    public PlaylistController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/playlists/save")
    public PlaylistPayload save(@RequestBody PlaylistPayload playlist){
        return videoService.savePlaylist(playlist);
    }
    @PostMapping("/playlists/update")
    public PlaylistPayload update(@RequestBody PlaylistPayload playlist){
        return videoService.update(playlist);
    }
    public PlaylistPayload delete(@RequestBody PlaylistPayload playlist){
        return videoService.delete(playlist);
    }
    @DeleteMapping("/playlists/delete")
    @PostMapping("/videos/save")
    public PlaylistPayload save(@RequestBody VideoPayload video){
        return videoService.addVideoToPlaylist(video);
    }
    @DeleteMapping("/videos/remove")
    public PlaylistPayload remove(@RequestBody VideoPayload video){
        return videoService.removeVideoFromPlaylist(video);
    }
    @GetMapping("/playlists/{playlistId}/videos")
    public List<VideoPayload> getPlaylistVideos(@PathVariable Long playlistId){
        return videoService.getPlaylistVideos(playlistId);
    }
}
