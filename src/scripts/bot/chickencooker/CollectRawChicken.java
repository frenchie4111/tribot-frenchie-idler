package scripts.bot.chickencooker;

import scripts.lib.action.*;
import scripts.lib.action.combat.Loot;
import scripts.lib.condition.InventoryFull;
import scripts.lib.condition.Not;

/**
 * Created by mike on 1/19/2016.
 */
public class CollectRawChicken extends If {
    public static int[] CHICKEN_LOCATION = {3230, 3296};
    public static String CHICKEN_NAME = "Chicken";
    public static String RAW_CHICKEN_NAME = "Raw chicken";


    public CollectRawChicken() {
        super(
                new Not( new InventoryFull() ),
                new LinearGroup(
                        new Action[]{
                                new Walk( CHICKEN_LOCATION ),
                                new While(
                                        new Not( new InventoryFull() ),
                                        new Action[]{
                                                new OnFail(
                                                        new Loot( RAW_CHICKEN_NAME ),
                                                        new LinearGroup(
                                                                new Action[] {
                                                                        new Wait( 500, 1000 )
                                                                }
                                                        )
                                                )
                                        }
                                )
                        }
                )
        );
    }
}
