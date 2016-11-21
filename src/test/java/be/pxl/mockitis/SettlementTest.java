package be.pxl.mockitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {

        //Raiders raiders = mock(Raiders.class);
        //when(raiders.getAmountOfRaiders()).thenReturn(1);

        Raiders raiders = new RaiderTestBuilder()
                .withHasLegendary(false)
                .withRaiders(1)
                .build();

//        Settler defender = mock(Settler.class);
//        Settler farmer = mock(Settler.class);
//        Settler clerk = mock(Settler.class);

        Settler defender = new SettlerTestBuilder()
                .WithAssignedToDefense(true)
                .build();
        Settler farmer = new SettlerTestBuilder()
                .WithAssignedToDefense(false)
                .build();
        Settler clerk = new SettlerTestBuilder()
                .WithAssignedToDefense(false)
                .build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
//        when(defender.isAssignedToDefense()).thenReturn(true);
//        when(farmer.isAssignedToDefense()).thenReturn(false);
//        when(clerk.isAssignedToDefense()).thenReturn(false);

        //   Settlement settlement = new Settlement(settlers);

        Settlement settlement = new SettlementTestBuilder()
                .withSettlers(settlers)
                .build();

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        //Raiders raiders = mock(Raiders.class);
        //when(raiders.getAmountOfRaiders()).thenReturn(2);

        Raiders raiders = new RaiderTestBuilder()
                .withHasLegendary(false)
                .withRaiders(2)
                .build();
//        Settler defender = mock(Settler.class);
//        Settler farmer = mock(Settler.class);
//        Settler clerk = mock(Settler.class);

        Settler defender = new SettlerTestBuilder()
                .WithAssignedToDefense(true)
                .build();
        Settler farmer = new SettlerTestBuilder()
                .WithAssignedToDefense(true)
                .build();
        Settler clerk = new SettlerTestBuilder()
                .WithAssignedToDefense(false)
                .build();

//        when(defender.isAssignedToDefense()).thenReturn(true);
//        when(farmer.isAssignedToDefense()).thenReturn(true);
//        when(clerk.isAssignedToDefense()).thenReturn(false);
//Settlement settlement = new Settlement(settlers);

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);

        Settlement settlement = new SettlementTestBuilder()
                .withSettlers(settlers)
                .build();

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        // Raiders raiders = mock(Raiders.class);
        // when(raiders.getAmountOfRaiders()).thenReturn(2);

        Raiders raiders = new RaiderTestBuilder()
                .withHasLegendary(false)
                .withRaiders(3)
                .build();

//        Settler defender = mock(Settler.class);
//        Settler farmer = mock(Settler.class);
//        Settler clerk = mock(Settler.class);

        Settler defender = new SettlerTestBuilder()
                .WithAssignedToDefense(true)
                .build();
        Settler farmer = new SettlerTestBuilder()
                .WithAssignedToDefense(false)
                .build();
        Settler clerk = new SettlerTestBuilder()
                .WithAssignedToDefense(false)
                .build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
//        when(defender.isAssignedToDefense()).thenReturn(true);
//        when(farmer.isAssignedToDefense()).thenReturn(false);
//        when(clerk.isAssignedToDefense()).thenReturn(false);

        //Settlement settlement = new Settlement(settlers);
        Settlement settlement = new SettlementTestBuilder()
                .withSettlers(settlers)
                .build();

        assertThat(settlement.defend(raiders)).isFalse();
    }
}
