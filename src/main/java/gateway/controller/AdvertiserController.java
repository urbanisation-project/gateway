package gateway.controller;

import gateway.proxy.advertiser.payload.AdPayload;
import gateway.proxy.advertiser.payload.AdSetPayload;
import gateway.proxy.advertiser.payload.AdvertiserPayload;
import gateway.proxy.advertiser.payload.CampaignPayload;
import gateway.proxy.common.Credentials;
import gateway.service.AdvertiserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/advertisers")
public class AdvertiserController {
    private AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @PostMapping("/save")
    public ResponseEntity<AdvertiserPayload> save(@RequestBody AdvertiserPayload advertiser) {
        try {
            return new ResponseEntity(advertiserService.saveAdvertiser(advertiser), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible d'effectuer l'inscription !", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AdvertiserPayload> authenticate(@RequestBody Credentials credentials) {
        try {
            return new ResponseEntity(advertiserService.authenticate(credentials), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Mail/password invalide !", HttpStatus.UNAUTHORIZED);
        }
    }

    // CAn t save campagne
    @PostMapping("/campaigns/save")
    public ResponseEntity<CampaignPayload> save(@RequestBody CampaignPayload campaign) {
        try {
            return new ResponseEntity(advertiserService.saveCampaign(campaign), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible d'enregistrer la campagne !", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t save adset
    @PostMapping("/campaigns/ad-sets/save")
    public ResponseEntity<AdSetPayload> save(@RequestBody AdSetPayload adSet) {
        try {
            return new ResponseEntity(advertiserService.saveAdSet(adSet), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible d'enregistrer la Adset !", HttpStatus.UNAUTHORIZED);
        }
    }

    // can t save ad
    @PostMapping("/campaigns/ad-sets/ads/save")
    public ResponseEntity<AdPayload> save(@RequestBody AdPayload ad) {
        try {
            return new ResponseEntity(advertiserService.saveAd(ad), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Impossible d'enregistrer la Ad !", HttpStatus.UNAUTHORIZED);
        }
    }

    // internal server error
    @GetMapping("/campaigns/ads/{adId}/visitors/count")
    public ResponseEntity<Integer> getAdVisitorsCount(@PathVariable Long adId) {
        try {
            return new ResponseEntity(advertiserService.getAdVisitorsCount(adId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("", HttpStatus.UNAUTHORIZED);
        }
    }

    // TODO: correct methode to return status
    @GetMapping("/campaigns/ads/{adId}/visitors/count/update")
    public void updateAdVisitorsCount(@PathVariable Long adId) {
        advertiserService.updateAdVisitorsCount(adId);
    }

    // aucune compagne | internat server error
    @GetMapping("/{advertiserId}/campaigns")
    public ResponseEntity<List<CampaignPayload>> getAdvertiserCampaigns(@PathVariable Long advertiserId) {
        try {
            return new ResponseEntity(advertiserService.getAdvertiserCampaigns(advertiserId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Aucune campagne trouvée !", HttpStatus.UNAUTHORIZED);
        }
    }

    // internal server error
    @GetMapping("/campaigns/{campaignId}/ad-sets")
    public ResponseEntity<List<AdSetPayload>> getCampaignAdSets(@PathVariable Long campaignId) {
        try {
            return new ResponseEntity(advertiserService.getCampaignAdSets(campaignId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Erreur interne serveur !", HttpStatus.UNAUTHORIZED);
        }
    }

    // internal server error
    @GetMapping("/ad-sets/{adSetId}/ads")
    public ResponseEntity<List<AdPayload>> getAdSetAds(@PathVariable Long adSetId) {
        try {
            return new ResponseEntity(advertiserService.getAdSetAds(adSetId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Erreur interne serveur !", HttpStatus.UNAUTHORIZED);
        }
    }
}
