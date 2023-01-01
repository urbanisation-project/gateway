package gateway.controller;

import gateway.proxy.user.payload.VideoAdResponse;
import gateway.service.AdvertiserService;
import gateway.service.SearchService;
import gateway.service.impl.VideosResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/researches")
public class SearchController {
    private SearchService searchService;
    private AdvertiserService advertiserService;

    public SearchController(SearchService searchService, AdvertiserService advertiserService) {
        this.searchService = searchService;
        this.advertiserService = advertiserService;
    }

    @GetMapping("/youtube/{query}")
    public VideoAdResponse researchVideoYoutube(@PathVariable String query) throws Exception {
        return new VideoAdResponse(
                query,
                searchService.researchVideoYoutube(query),
                advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                        .collect(Collectors.toList()))
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
    @GetMapping("/dailymotion/{query}")
    public VideoAdResponse researchVideoDailyMotion(@PathVariable String query) throws Exception {
        return new VideoAdResponse(
                query,
                searchService.researchVideoDailyMotion(query),
                advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                        .collect(Collectors.toList()))
                        .stream()
                        .distinct()
                        .collect(Collectors.toList()));
    }
    @PostMapping("/{query}")
    public VideosResponse researchVideo(@RequestBody Map<String,Boolean> videoQuery, @PathVariable String query){
        VideosResponse response = searchService.researchVideo(videoQuery, query);
        response.setAds(advertiserService.getAdsByKeywords(Arrays.stream(query.split(" "))
                        .collect(Collectors.toList()))
                .stream()
                .distinct()
                .collect(Collectors.toList()));
        response.setQuery(query);
        return response;
    }
}
