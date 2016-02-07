package scripts.bot.noobleveler;

import org.tribot.api2007.Skills;
import scripts.lib.action.*;
import scripts.lib.action.bank.*;
import scripts.lib.action.combat.ChangeStance;
import scripts.lib.condition.*;

/**
 * Created by mike on 1/6/2016.
 */
public class NoobLeveler extends LinearGroup {
    public static int TARGET_LEVEL = 10;

    public static int[] GOBLIN_LOCATION = { 3248, 3240 };
    public static String GOBLIN_NAME = "Goblin";

    public static int[] COW_LOCATION = { 3256, 3284 };
    public static String COW_NAME = "Cow";

    public static int[] CHICKEN_LOCATION = { 3230, 3296 };
    public static String CHICKEN_NAME = "Chicken";

    public NoobLeveler() {
        super( new Action[] {
                new Wait( 200, 1000 ),
                new CloseBeginnerUI(),
                new Wait( 200, 1000 ),
                // If we don't have training gear, go check the bank
                new If( new Not(
                        new HaveTrainingGear()
                ), new LinearGroup(
                        new Action[] {
                                new WalkToBank(),
                                new Wait( 200, 1000 ),
                                new OpenBank(),
                                new Wait( 200, 1000 ),
                                new BankAll(),
                                new Wait( 200, 1000 ),
                                new Unfailable( new Withdraw( 1, "Training sword" ) ),
                                new Wait( 200, 1000 ),
                                new Unfailable( new Withdraw( 1, "Training shield" ) ),
                                new Wait( 200, 1000 ),
                                new CloseBank(),
                                new Wait( 200, 1000 ),
                                }
                ) ),
                new Wait( 200, 1000 ),
                // Otherwise Go get it from the trainer
                new If(
                        new Not(
                                new HaveTrainingGear()
                        ), new GetTrainingGear()
                ),
                new Wait( 200, 1000 ),
                new EquipTrainingGear(),
                new Wait( 200, 1000 ),
                new If(
                        new Not(
                                new LevelRequirementCondition( Skills.SKILLS.STRENGTH, TARGET_LEVEL )
                        ), new LinearGroup( new Action[] {
                        new ChangeStance( "Lunge" ),
                        new Wait( 200, 1000 ),
                        new EarlyFighter(
                                new Not(
                                        new LevelRequirementCondition( Skills.SKILLS.STRENGTH, TARGET_LEVEL )
                                ),
                                CHICKEN_NAME, CHICKEN_LOCATION
                        )
                } )
                ),
                new Wait( 200, 1000 ),
                new If(
                        new Not(
                                new LevelRequirementCondition( Skills.SKILLS.ATTACK, TARGET_LEVEL )
                        ), new LinearGroup( new Action[] {
                        new ChangeStance( "Stab" ),
                        new Wait( 200, 1000 ),
                        new EarlyFighter(
                                new Not(
                                        new LevelRequirementCondition( Skills.SKILLS.ATTACK, TARGET_LEVEL )
                                ),
                                GOBLIN_NAME, GOBLIN_LOCATION
                        )
                } )
                ),
                new Wait( 200, 1000 ),
                new If(
                        new Not(
                                new LevelRequirementCondition( Skills.SKILLS.DEFENCE, TARGET_LEVEL )
                        ), new LinearGroup( new Action[] {
                        new ChangeStance( "Block" ),
                        new Wait( 200, 1000 ),
                        new EarlyFighter(
                                new Not(
                                        new LevelRequirementCondition( Skills.SKILLS.DEFENCE, TARGET_LEVEL )
                                ),
                                COW_NAME, COW_LOCATION
                        )
                } )
                )
        } );
    }
}
