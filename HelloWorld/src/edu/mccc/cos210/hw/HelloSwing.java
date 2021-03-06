package edu.mccc.cos210.hw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloSwing {

	private void init(String hw) {
		try {
			EventQueue.invokeAndWait(() -> initSwing(hw));
		} catch (InvocationTargetException | InterruptedException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	private void initSwing(String hw) {
		JFrame jf = new JFrame(hw);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel() {
			private static final long serialVersionUID = 1L;
			private final String HW = hw;
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(1024, 768);
			}
			@Override
			public Color getBackground() {
				return new Color(120, 200, 240);
			}
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setPaint(new Color(255, 0, 128));
				g2d.setFont(g2d.getFont().deriveFont(80.0f));
				FontMetrics fm = g2d.getFontMetrics();
				StringBuilder sb = new StringBuilder();
				sb.append(HW);
				sb.append(' ');
				sb.append(Character.toChars(0x1f47d));
				String text = sb.toString();
				int stringWidth = fm.stringWidth(text);
				g2d.drawString(
						text,
						getWidth() / 2 - stringWidth / 2,
						getHeight() / 2
				);
				
				//g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
				//g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
				g2d.dispose();
			}
		};
		jf.add(jp);
		jf.pack();
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		final String HW = "Hello, World!";
		HelloSwing hs = new HelloSwing();
		hs.init(HW);
		hs.doIt(HW);
	}
	
	private void doIt(String hw) {
		System.out.println(hw);
	}

}
