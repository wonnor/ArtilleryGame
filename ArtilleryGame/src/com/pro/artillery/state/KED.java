package com.pro.artillery.state;

import java.awt.*;

public class KED implements KeyEventDispatcher
{

    public boolean dispatchKeyEvent(java.awt.event.KeyEvent event)
	{
		String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
		if (key.equals("pressed A"))
			Key.pressedA = true;
		if (key.equals("pressed D"))
			Key.pressedD = true;
		if (key.equals("pressed W"))
			Key.pressedW = true;
		if (key.equals("released A"))
			Key.pressedA = false;
		if (key.equals("released D"))
			Key.pressedD = false;
		if (key.equals("released W"))
			Key.pressedW = false;
		System.out.println(key);
		return true;
	}
    
}