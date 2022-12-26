package gateway.proxy.advertiser.payload;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiserPayload {
    private Long id;
    private String username;
    private String email;
    private String password;
}
