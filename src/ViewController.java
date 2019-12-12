import javax.swing.JFrame;
import java.util.HashMap;

public class ViewController {
	HashMap<String, JFrame> viewList = new HashMap<String, JFrame>();

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

	public void chooseView(String viewName) {
		JFrame view = this.findView(viewName);
		view.setVisible(true);
	}
	

}
