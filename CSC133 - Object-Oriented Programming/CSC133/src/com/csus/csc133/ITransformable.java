package com.csus.csc133;

public interface ITransformable {
	public void rotate(float degrees);
	public void scale(float x, float y);
	public void translate(float dx, float dy);
}