package be.pxl.mockitis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefanie on 21/11/2016.
 */
public class RaiderTestBuilder {
    private List<Raider> raiders = new ArrayList<>();
    private boolean hasLegendary;

    public RaiderTestBuilder() {
    }

    public RaiderTestBuilder withHasLegendary(Boolean hasLegendary) {
        this.hasLegendary = hasLegendary;
        return this;
    }

    public RaiderTestBuilder withRaiders(int amountOfRaiders) {
        for (int i = 0; i < amountOfRaiders; i++) {
            this.raiders.add(new Raider());
        }
        return this;
    }

    public Raiders build() {
        Raiders raiders = new Raiders(hasLegendary);
        this.raiders.forEach(raiders::addAttacker);
        return raiders;
    }

}
