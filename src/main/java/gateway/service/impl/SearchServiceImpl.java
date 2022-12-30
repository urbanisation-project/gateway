package gateway.service.impl;

import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchServiceImpl implements SearchService {
    private UserProxy searchProxy;

    public SearchServiceImpl(UserProxy searchProxy) {
        this.searchProxy = searchProxy;
    }

    @Override
    public List<VideoDTO> researchVideoYoutube(String query) {
        return searchProxy.researchVideoYoutube(query);
    }

    @Override
    public List<VideoDTO> researchVideoDailyMotion(String query) {
        return searchProxy.researchVideoDailyMotion(query);
    }
}
