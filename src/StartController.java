import javax.swing.JFrame;

public class StartController extends ViewController {
	public StartController(JFrame view) {
		super(view);
	}

	private StartFrame startFrame;
	
	
	public StartFrame getStartFrame() {
		return startFrame;
	}


	public void setStartFrame(StartFrame startFrame) {
		this.startFrame = startFrame;
	}


	public void changeView() {
		
	}
	
}
