package com.gamefromscratch;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.gamefromscratch.MainHere;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("IntelliJ");
		new Lwjgl3Application(new MainHere(), config);
	}
}
