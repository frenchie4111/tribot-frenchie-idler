package bot.noobleveler;

import scripts.lib.action.*;
import scripts.lib.action.npc.TalkToNPC;
import scripts.lib.action.ui.Continue;
import scripts.lib.condition.And;
import scripts.lib.condition.IsInDialogue;
import scripts.lib.condition.Not;
import scripts.lib.condition.Retry;

/**
 * Created by mike on 1/10/2016.
 */
public class GetTrainingGear extends LinearGroup {
    public GetTrainingGear() {
        super( new Action[] {
                new Walk( new int[] {3218, 3237 } ),
                new Wait( 200, 1000 ),
                new While(
                    new And( new Not( new IsInDialogue() ), new Retry( 5 ) ),
                    new Action[]{
                            new TalkToNPC( "Melee combat tutor" )
                    }
                ),
                new Wait( 200, 1000 ),
                new While( new IsInDialogue(), new Action[]{
                        new Continue(),
                        new Wait( 200, 1000 )
                } )
        } );
    }
}
