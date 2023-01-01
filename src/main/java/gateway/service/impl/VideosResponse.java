package gateway.service.impl;

import gateway.proxy.advertiser.payload.AdPayload;
import gateway.proxy.user.payload.VideoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class VideosResponse {
    private Map<String, List<VideoDTO>> videos;
    private List<AdPayload> ads;
    private String query;
}
