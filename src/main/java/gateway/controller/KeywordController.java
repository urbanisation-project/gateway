package gateway.controller;

import gateway.proxy.advertiser.payload.AdPayload;
import gateway.service.AdvertiserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/keywords")
public class KeywordController {
    private AdvertiserService advertiserService;

    public KeywordController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }
    @PostMapping ("/ads")
    public List<AdPayload> getAdsByKeywords(@RequestBody List<String> keywords){
        return advertiserService.getAdsByKeywords(keywords);
    }
}
