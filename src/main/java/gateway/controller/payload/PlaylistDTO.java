package gateway.controller.payload;

import gateway.proxy.user.payload.PlaylistPayload;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaylistDTO {
    private PlaylistPayload playlist;
    private List<VideoPayload> videos;
}
