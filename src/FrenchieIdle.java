import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;
import scripts.lib.Properties;

import java.awt.*;

@ScriptManifest(
        authors = { "frenchie4111" },
        name = "Frenchie Idler",
        category = "Tools"
)
public class FrenchieIdle extends Script implements Painting {


    @Override
    public void run() {

    }

    @Override
    public void onPaint( Graphics g ) {
        g.drawString( Properties.getProperties().getCurrentState(), 300, 300 );
    }
}
