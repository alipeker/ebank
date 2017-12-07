package UserPages;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class user_stockmarket {
	public user_stockmarket(final JEditorPane editorPane,final JEditorPane editorPane2,final JEditorPane foreign,JFrame frame) throws IOException{

		editorPane.setPage("file:///D:/javaworks/ebank/webpages/second.html");
		editorPane.setEditable(false);
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_editorPane.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane.gridx = 2;
		gbc_editorPane.gridy = 1;
		frame.getContentPane().add(editorPane, gbc_editorPane);

		editorPane2.setPage("file:///D:/javaworks/ebank/webpages/first.html");
		editorPane2.setEditable(false);
		GridBagConstraints gbc_editorPane2 = new GridBagConstraints();
		gbc_editorPane2.anchor = GridBagConstraints.NORTHWEST;
		gbc_editorPane2.insets = new Insets(0, 0, 5, 5);
		gbc_editorPane2.gridx = 3;
		gbc_editorPane2.gridy = 1;
		frame.getContentPane().add(editorPane2, gbc_editorPane2);

		foreign.setPage("file:///D:/javaworks/ebank/webpages/third.html");
		foreign.setEditable(false);
		GridBagConstraints gbc_foreign = new GridBagConstraints();
		gbc_foreign.insets = new Insets(0, 0, 5, 5);
		gbc_foreign.fill = GridBagConstraints.BOTH;
		gbc_foreign.gridx = 6;
		gbc_foreign.gridy = 1;
		frame.getContentPane().add(foreign, gbc_foreign);
	}
}
