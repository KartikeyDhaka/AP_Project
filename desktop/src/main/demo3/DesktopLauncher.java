package main.demo3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import main.demo3.GameView;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1353,671);
		config.setResizable(true);
		config.setTitle(GameView.TITLE);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new GameView(), config);
	}
}
