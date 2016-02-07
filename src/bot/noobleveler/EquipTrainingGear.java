package bot.noobleveler;

import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.Wait;
import scripts.lib.action.inventory.Equip;

/**
 * Created by mike on 1/10/2016.
 */
public class EquipTrainingGear extends LinearGroup {
    public EquipTrainingGear() {
        super( new Action[] {
                new Equip( "Training sword" ),
                new Wait( 200, 1000 ),
                new Equip( "Training shield" ),
                new Wait( 200, 1000 )
        } );
    }
}
