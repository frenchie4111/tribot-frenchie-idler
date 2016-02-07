package bot.noobleveler;

import scripts.lib.condition.And;
import scripts.lib.condition.InventoryContainsCondition;
import scripts.lib.condition.IsEquiped;
import scripts.lib.condition.Or;

/**
 * Created by mike on 1/15/2016.
 */
public class HaveTrainingGear extends And {
    public HaveTrainingGear() {
        super(
                new Or(
                        new InventoryContainsCondition( "Training sword" ),
                        new IsEquiped( "Training sword" )
                ),
                new Or(
                        new InventoryContainsCondition( "Training shield" ),
                        new IsEquiped( "Training shield" )
                )
        );
    }
}
