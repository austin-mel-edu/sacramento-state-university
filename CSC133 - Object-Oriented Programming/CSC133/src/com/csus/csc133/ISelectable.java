package com.csus.csc133;

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;

public interface ISelectable {
	public void setSelected(boolean y);
	
	public boolean isSelected();
	
	public void draw(Graphics g, int relX, int relY);
	
	public boolean contains(int pointerX, int pointerY, int relX, int relY);
}