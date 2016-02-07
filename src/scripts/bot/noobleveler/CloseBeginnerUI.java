package scripts.bot.noobleveler;

import scripts.lib.action.Action;
import scripts.lib.action.If;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.Wait;
import scripts.lib.action.ui.ClickUIElement;
import scripts.lib.condition.IsInterfaceValid;

/**
 * Created by mike on 1/15/2016.
 */
public class CloseBeginnerUI extends If {
    public CloseBeginnerUI() {
        super(
                new IsInterfaceValid( 153 ), new LinearGroup( new Action[] {
                    new ClickUIElement( 153, 71 ),
                    new Wait( 100, 200 ),
                    new Wait( new IsInterfaceValid( 153 ), 1000 )
            } )
        );
    }
}
