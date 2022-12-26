package gateway.controller;

import gateway.proxy.user.payload.VideoPayload;
import gateway.service.SearchService;
import gateway.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/researches")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/youtube/{query}")
    public List<VideoPayload> researchVideoYoutube(@PathVariable String query){
        return searchService.researchVideoYoutube(query);
    }
    @GetMapping("/dailymotion/{query}")
    public List<VideoPayload> researchVideoDailyMotion(@PathVariable String query){
        return searchService.researchVideoDailyMotion(query);
    }
}
