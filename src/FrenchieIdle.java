import bot.chickencooker.ChickenCooker;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;
import scripts.lib.Properties;
import scripts.lib.TribotPrintStream;
import scripts.lib.action.AlwaysTrue;
import scripts.lib.condition.True;

import java.awt.*;

@ScriptManifest(
        authors = { "frenchie4111" },
        name = "Frenchie Idler",
        category = "Tools"
)
public class FrenchieIdle extends Script implements Painting {
    ChickenCooker cooker = new ChickenCooker( new True() );

    @Override
    public void run() {
        System.setOut( new TribotPrintStream( this ) );

        cooker.start();
    }

    @Override
    public void onPaint( Graphics g ) {
        g.drawString( Properties.getProperties().getCurrentState(), 300, 300 );
    }
}
