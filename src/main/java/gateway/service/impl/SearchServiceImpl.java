package gateway.service.impl;

import gateway.proxy.user.UserProxy;
import gateway.proxy.user.payload.VideoAdResponse;
import gateway.proxy.user.payload.VideoDTO;
import gateway.proxy.user.payload.VideoPayload;
import gateway.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {
    public static final String DAILYMOTION = "dailymotion";
    public static final String YOUTUBE = "youtube";
    private UserProxy searchProxy;
    Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);


    public SearchServiceImpl(UserProxy searchProxy) {
        this.searchProxy = searchProxy;
    }

    @Override
    public List<VideoDTO> researchVideoYoutube(String query) throws Exception {
        return searchProxy.researchVideoYoutube(query);
    }

    @Override
    public List<VideoDTO> researchVideoDailyMotion(String query) throws Exception {
        return searchProxy.researchVideoDailyMotion(query);
    }

    @Override
    public VideosResponse researchVideo(Map<String, Boolean> videoQuery,String query) {
        VideosResponse videosResponse= new VideosResponse();
        videosResponse.setVideos(new HashMap<>());

        try {
            if(videoQuery.get(DAILYMOTION)){
                videosResponse.getVideos().put(DAILYMOTION,researchVideoDailyMotion(query));
            }
        }catch (Exception e){
            videosResponse.getVideos().put(DAILYMOTION, Arrays.asList());
            logger.error("message : {} \n stacktace: {}" ,e.getMessage(),e.getStackTrace());
        }

        try {
            if(videoQuery.get(YOUTUBE)){
                videosResponse.getVideos().put(YOUTUBE,researchVideoYoutube(query));
            }
        }catch (Exception e){
            videosResponse.getVideos().put(YOUTUBE,Arrays.asList());
            logger.error("message : {} \n stacktace: {}" ,e.getMessage(),e.getStackTrace());
        }

        if(!videoQuery.get(DAILYMOTION) && !videoQuery.get(YOUTUBE)){
            try {
                videosResponse.getVideos().put(DAILYMOTION,researchVideoDailyMotion(query));
            }catch (Exception e){
                videosResponse.getVideos().put(YOUTUBE,Arrays.asList());
                logger.error("message : {} \n stacktace: {}" ,e.getMessage(),e.getStackTrace());
            }

            try{
                videosResponse.getVideos().put(YOUTUBE,researchVideoYoutube(query));
            }catch (Exception e){
                videosResponse.getVideos().put(YOUTUBE,Arrays.asList());
                logger.error("message : {} \n stacktace: {}" ,e.getMessage(),e.getStackTrace());
            }
        }
        return videosResponse;
    }
}
