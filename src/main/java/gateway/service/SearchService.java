package gateway.service;

import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface SearchService {
    List<VideoDTO> researchVideoYoutube(String query);

    List<VideoDTO> researchVideoDailyMotion(String query);
}
