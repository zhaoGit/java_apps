package com.zhaos.mvc;
  
public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		new BeatController(model);
    }
}
