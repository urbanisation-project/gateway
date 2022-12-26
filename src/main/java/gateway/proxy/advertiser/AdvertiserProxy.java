package gateway.proxy.advertiser;

import gateway.proxy.advertiser.payload.*;
import gateway.proxy.common.Credentials;

import java.util.List;

public interface AdvertiserProxy {
    AdvertiserPayload authenticate(Credentials credentials);

    Integer getAdVisitorsCount(Long adId);

    List<CampaignPayload> getAdvertiserCampaigns(Long advertiserId);

    List<AdSetPayload> getCampaignAdSets(Long campaignId);

    List<AdPayload> getAdSetAds(Long adSetId);

    AdvertiserPayload saveAdvertiser(AdvertiserPayload advertiser);

    CampaignPayload saveCampaign(CampaignPayload campaign);

    AdSetPayload saveAdSet(AdSetPayload saveAdSet);

    AdPayload saveAd(AdPayload ad);

    List<KeywordPayload> getKeywordsByNames(List<String> keywords);

    List<AdPayload> getAdsByKeywords(List<KeywordPayload> keywordList);


    void updateAdVisitorsCount(Long adId);
}
