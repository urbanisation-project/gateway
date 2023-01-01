package gateway.service;

import gateway.proxy.user.payload.VideoAdResponse;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.impl.VideosResponse;

import java.util.List;
import java.util.Map;

public interface SearchService {
    List<VideoDTO> researchVideoYoutube(String query) throws Exception;

    List<VideoDTO> researchVideoDailyMotion(String query) throws Exception;

    VideosResponse researchVideo(Map<String, Boolean> videoQuery, String query);
}
