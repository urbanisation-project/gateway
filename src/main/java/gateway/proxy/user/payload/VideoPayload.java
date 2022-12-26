package gateway.proxy.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoPayload {
    private Long id;
    private String link;
    private String miniature;
    private String description;
    private String title;
    private PlaylistPayload playlist;
}
