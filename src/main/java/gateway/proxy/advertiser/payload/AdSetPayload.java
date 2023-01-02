package gateway.proxy.advertiser.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdSetPayload {
    private Long id;
    private String name;
    private List<KeywordPayload> keywords;
    private CampaignPayload campaign;
}

