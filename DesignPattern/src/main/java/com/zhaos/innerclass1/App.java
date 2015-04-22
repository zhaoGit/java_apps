package com.zhaos.innerclass1;

public class App {

	public static void main(String[] args) {
		String[] ids = new String[]{"Circle","Square","Square","Circle"};
        for(int i=0;i<ids.length;i++)
        {
               Shape shape = ShapeFactory.createShape("com.zhaos.innerclass." +ids[i]);
               shape.draw();
               shape.erase();
        }
	}

}
