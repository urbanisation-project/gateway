package gateway.controller;

import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class PlaylistController {
    private final VideoService videoService;

    public PlaylistController(VideoService videoService) {
        this.videoService = videoService;
    }

    // can t create playlist
    @PostMapping("/playlists/save")
    public ResponseEntity<PlaylistPayload> save(@RequestBody PlaylistPayload playlist){
        try {
            return new ResponseEntity(videoService.savePlaylist(playlist), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de créer la playlist", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t create update
    @PostMapping("/playlists/update")
    public ResponseEntity<PlaylistPayload> update(@RequestBody PlaylistPayload playlist){
        try {
            return new ResponseEntity(videoService.update(playlist), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de modifier la playlist", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t create delete
    @DeleteMapping("/playlists/delete")
    public ResponseEntity<Boolean> delete(@RequestBody PlaylistPayload playlist){
        try {
            return new ResponseEntity(videoService.delete(playlist), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de supprimer la playlist", HttpStatus.UNAUTHORIZED);
        }
    }
    // can t create remove video
    @DeleteMapping("/videos/remove")
    public ResponseEntity<Boolean> remove(@RequestBody VideoPayload video){
        try {
            return new ResponseEntity(videoService.removeVideoFromPlaylist(video), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de supprimer la video", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t create find playlist videos, aucun video
    @GetMapping("/playlists/{playlistId}/videos")
    public ResponseEntity<List<VideoPayload>> getPlaylistVideos(@PathVariable Long playlistId){
        try {
            return new ResponseEntity(videoService.getPlaylistVideos(playlistId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible de trouver les videos de cette playlist", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t create add video to playlist / deja kayn autre error
    @PostMapping("playlists/{playlistId}/add-video")
    public ResponseEntity<PlaylistPayload> addVideoToPlaylist(@PathVariable Long playlistId,@RequestBody VideoDTO video){
        try {
            return new ResponseEntity(videoService.addVideoToPlaylist(playlistId, video), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible d'ajouter la video", HttpStatus.UNAUTHORIZED);
        }
    }
}
