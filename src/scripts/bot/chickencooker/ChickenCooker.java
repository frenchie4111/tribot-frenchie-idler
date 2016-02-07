package scripts.bot.chickencooker;

import org.tribot.api.types.generic.Condition;
import scripts.lib.action.Action;
import scripts.lib.action.If;
import scripts.lib.action.While;
import scripts.lib.action.inventory.DropAll;
import scripts.lib.condition.And;
import scripts.lib.condition.InventoryContains;
import scripts.lib.condition.InventoryFull;
import scripts.lib.condition.Not;

/**
 * Created by mike on 2/6/2016.
 */
public class ChickenCooker extends While {
    public ChickenCooker( Condition stop_condition ) {
        super(
                stop_condition,
                new Action[]{
                        new If(
                                new And(
                                        new InventoryFull(),
                                        new Not(
                                                new InventoryContains( "Raw chicken" )
                                        )
                                ),
                                new DropAll()
                        ),
                        new CollectRawChicken(),
                        new CookChicken()
                }
        );
    }
}
