import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Mode extends JPanel {

	/**
	 * Create the panel.
	 */
	public Mode() {
		
		JButton btnArthimeticMode = new JButton("Arithimetic Mode");
		btnArthimeticMode.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JButton btnVariableMode = new JButton("Variable Mode");
		btnVariableMode.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(135)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVariableMode, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnArthimeticMode, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addComponent(btnArthimeticMode, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnVariableMode, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
