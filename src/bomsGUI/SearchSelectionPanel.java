package bomsGUI;

import javax.swing.*;

public class SearchSelectionPanel extends JPanel {
	
	private BomsView view;

	public SearchSelectionPanel(BomsView view) {
			this.view = view;
	}
	
	public void showSearchResults(Object[] searchResults){
//		JList<String> list = new JList<String>(lol);
//		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		list.setLayoutOrientation(JList.VERTICAL);
//		list.setVisible(true);
//		list.setVisibleRowCount(-1);
//		JScrollPane listScroller = new JScrollPane(list);
//		listScroller.setPreferredSize(new Dimension(250, 80));
//		listScroller.setVisible(true);
		
		        this.add(new JScrollPane(new JList(searchResults)));
		        this.setSize(100,100);
		        this.setVisible(true);
	}
	
}
