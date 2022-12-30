package gateway.proxy.user.payload;

import gateway.proxy.advertiser.payload.AdPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoAdResponse {
    private String query;
    private List<VideoDTO> videos;
    private List<AdPayload> ads;
}
