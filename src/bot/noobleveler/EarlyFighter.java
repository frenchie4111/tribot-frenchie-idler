package bot.noobleveler;

import org.tribot.api.types.generic.Condition;
import scripts.lib.action.Action;
import scripts.lib.action.If;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.combat.AttackAtLocation;
import scripts.lib.condition.Not;

/**
 * Created by mike on 1/7/2016.
 */
public class EarlyFighter extends AttackAtLocation {

    public EarlyFighter( Condition condition, String name, int[] location ) {
        super(
                condition,
                name,
                location,
                new LinearGroup( new Action[] {
                        new CloseBeginnerUI(),
                        new If(
                                new Not(
                                        new HaveTrainingGear()
                                ), new GetTrainingGear()
                        ),
                        new EquipTrainingGear(),
                } )
        );
    }
}