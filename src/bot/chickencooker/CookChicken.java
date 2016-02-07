package bot.chickencooker;

import scripts.lib.action.*;
import scripts.lib.action.cooking.Cook;
import scripts.lib.condition.InventoryContains;

/**
 * Created by mike on 1/19/2016.
 */
public class CookChicken extends While {
    public CookChicken() {
        super(
                new InventoryContains( "Raw chicken" ),
                new Action[] {
                        new AlwaysTrue(
                                new LinearGroup(
                                        new Action[] {
                                                new Walk( new int[]{3226, 3290 } ),
                                                new Cook( "Raw chicken", "Cooking pot" )
                                        }
                                )
                        )
                }
        );
    }
}
