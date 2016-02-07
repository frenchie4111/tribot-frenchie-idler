package scripts;

import org.tribot.api2007.util.ThreadSettings;
import scripts.bot.chickencooker.ChickenCooker;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;
import scripts.lib.Properties;
import scripts.lib.TribotPrintStream;
import scripts.lib.action.Action;
import scripts.lib.action.LinearGroup;
import scripts.lib.action.Login;
import scripts.lib.action.camera.SetCameraAngle;
import scripts.lib.condition.True;

import java.awt.*;

@ScriptManifest(
        authors = { "frenchie4111" },
        name = "Frenchie Idler",
        category = "Tools"
)
public class FrenchieIdle extends Script implements Painting {
    Action script = new LinearGroup(
            new Action[] {
                    new Login(),
                    new SetCameraAngle( 90, 100 ),
                    new ChickenCooker( new True() )
            }
    );

    @Override
    public void run() {
        ThreadSettings.get().setClickingAPIUseDynamic( true );
        System.setOut( new TribotPrintStream( this ) );

        script.start();
    }

    @Override
    public void onPaint( Graphics g ) {
        g.drawString( Properties.getProperties().getCurrentState(), 300, 300 );
    }
}
