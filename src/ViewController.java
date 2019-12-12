
import javax.swing.JFrame;
import java.util.HashMap;

public class ViewController {
	HashMap<String, JFrame> viewList = new HashMap<String, JFrame>();
	JFrame activeView;
	
	public ViewController(JFrame view) {
		this.addView(view);
		activeView = view;
	}
	
	public JFrame getActiveView() {
		return activeView;
	}

	public void setActiveView(JFrame activeView) {
		this.activeView = activeView;
	}

	public HashMap<String, JFrame> getViewList() {
		return viewList;
	}

	public void setViewList(HashMap<String, JFrame> viewList) {
		this.viewList = viewList;
	}
	public void addView(JFrame view) {
		viewList.put(view.getName(), view);
	}
	public JFrame findView(String viewName) {
		return viewList.get(viewName);
	}

	public void chooseView(JFrame view) {
		view.setVisible(true);
		activeView = view;
	}
	
	

}
