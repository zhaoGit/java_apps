package com.zhaos.mvc;
  
public class BeatController implements ControllerInterface {
	/*
	 * 持有Model的引用，当Controller解释GUI的动作之后需要告知Model做相应的动作进行处理
	 */
	BeatModelInterface model;
	
	/*
	 * Controller创建View是一种组合关系。当Controller从界面View接收某一动作，有时也需要告诉View调整其局部状态。例如Controller可以
	 * 将界面中的某些菜单或按钮置为无效有效状态。
	 */
	DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
  
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
