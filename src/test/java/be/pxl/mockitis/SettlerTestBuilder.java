package be.pxl.mockitis;

/**
 * Created by stefanie on 21/11/2016.
 */
public class SettlerTestBuilder {
    private boolean assignedToDefense;

    public SettlerTestBuilder() {
    }

    public SettlerTestBuilder WithAssignedToDefense(boolean assignedToDefense) {
        this.assignedToDefense = assignedToDefense;
        return this;
    }

    public Settler build() {
        return new Settler(assignedToDefense);
    }

}
