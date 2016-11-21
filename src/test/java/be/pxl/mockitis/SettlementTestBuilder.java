package be.pxl.mockitis;

import java.util.List;

/**
 * Created by stefanie on 21/11/2016.
 */
public class SettlementTestBuilder {
    private List<Settler> settlers;

    public SettlementTestBuilder() {
    }

    public SettlementTestBuilder withSettlers(List<Settler> settlers) {
        this.settlers = settlers;
        return this;
    }

    public Settlement build() {
        return new Settlement(settlers);
    }
}
