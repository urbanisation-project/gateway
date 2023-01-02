package gateway.proxy.advertiser.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdPayload {
    private Long id;
    private String name;
    private String resource;
    private String description;
    private int visitorsCount;
    private AdSetPayload adSet;
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AdPayload other = (AdPayload) obj;
        return Objects.equals(id, other.id);
    }
}
