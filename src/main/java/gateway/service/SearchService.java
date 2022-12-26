package gateway.service;

import gateway.proxy.user.payload.VideoPayload;

import java.util.List;

public interface SearchService {
    List<VideoPayload> researchVideoYoutube(String query);

    List<VideoPayload> researchVideoDailyMotion(String query);
}
