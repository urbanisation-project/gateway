package gateway.service.impl;

import gateway.proxy.advertiser.AdvertiserProxy;
import gateway.proxy.advertiser.payload.*;
import gateway.proxy.common.Credentials;
import gateway.service.AdvertiserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {
    private AdvertiserProxy advertiserProxy;

    public AdvertiserServiceImpl(AdvertiserProxy advertiserProxy) {
        this.advertiserProxy = advertiserProxy;
    }

    @Override
    public AdvertiserPayload authenticate(Credentials credentials) {
        return advertiserProxy.authenticate(credentials);
    }

    @Override
    public Integer getAdVisitorsCount(Long adId) {
        return advertiserProxy.getAdVisitorsCount(adId);
    }

    @Override
    public List<CampaignPayload> getAdvertiserCampaigns(Long advertiserId) {
        return advertiserProxy.getAdvertiserCampaigns(advertiserId);
    }

    @Override
    public List<AdSetPayload> getCampaignAdSets(Long campaignId) {
        return advertiserProxy.getCampaignAdSets(campaignId);
    }

    @Override
    public List<AdPayload> getAdSetAds(Long adSetId) {
        return advertiserProxy.getAdSetAds(adSetId);
    }

    @Override
    public AdvertiserPayload saveAdvertiser(AdvertiserPayload advertiser) {
        return advertiserProxy.saveAdvertiser(advertiser);
    }

    @Override
    public CampaignPayload saveCampaign(CampaignPayload campaign) {
        return advertiserProxy.saveCampaign(campaign);
    }

    @Override
    public AdSetPayload saveAdSet(AdSetPayload saveAdSet) {
        return advertiserProxy.saveAdSet(saveAdSet);
    }

    @Override
    public AdPayload saveAd(AdPayload ad) {
        return advertiserProxy.saveAd(ad);
    }

    @Override
    public List<AdPayload> getAdsByKeywords(List<String> keywords) {
        return advertiserProxy
                .getAdsByKeywords(
                        advertiserProxy
                                .getKeywordsByNames(keywords)
                );
    }

    @Override
    public void updateAdVisitorsCount(Long adId) {
        advertiserProxy.updateAdVisitorsCount(adId);
    }
}
