package frameText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import human.vo.User;
import user.service.UserDAO;

public class OOEFrame extends JFrame {
	private JButton oddButton;
	private JButton evenButton;
	private final static int ODD = 0;
	private final static int EVEN = 1;
	private int user;
	private int computer;
	private boolean stringCon = false;
	private int cnt = 0;
	private boolean end = false;
	int betting;
	User userClass;

	Random random = new Random();

	class oddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			user = ODD;
			//System.out.println("À¯Àú : " + user);
			oddButton.setVisible(false);
			evenButton.setVisible(false);
			stringCon = true;
		}
	}

	class evenListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			user = EVEN;
			//System.out.println("À¯Àú : " + user);
			oddButton.setVisible(false);
			evenButton.setVisible(false);
			stringCon = true;
		}
	}

	public OOEFrame(User userClass ,int betting) {
		this.betting = betting;
		this.userClass = userClass;
		setTitle("È¦ Â¦");
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// MyPanel myPanel = new MyPanel();
		// add(myPanel);
		// myPanel.setBackground(Color.PINK);

		MyPanel p = new MyPanel();
		p.setLayout(new GridLayout());

		oddButton = new JButton("È¦");
		oddButton.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 100));
		oddButton.addActionListener(new oddListener());
		p.add(oddButton);
		evenButton = new JButton("Â¦");
		evenButton.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 100));
		evenButton.addActionListener(new evenListener());
		p.add(evenButton);

		add(p);

		setVisible(true);
		// ¹öÆ° 2°³ ¼±ÅÃ ÇØ¼­ È¦Â¦ º¸¿©ÁÖ°í ¹ºÁö º¸¿©ÁÖ°í ³¡
	}

	class MyPanel extends JPanel {
		int randnum = random.nextInt(2) + 20;

		public MyPanel() {
			class MyThread extends Thread {
				public void run() {
					while (true) {
//						if(money = -1)
//						{
//							dispose(); //µ·ÀÌ ¾ø°Å³ª °¡Áø°Å º¸´Ù ¸¹ÀÌ ¹èÆÃÇÒ ¶§ Ã¢ ´ÝÈû 
//						}
						try {
							repaint();
							Thread.sleep(200);
							if (stringCon == true)
								cnt++;

							if (cnt == randnum) {
								computer = cnt % 2;
								if (user == computer) {
									//System.out.println("µ· ¶¡");
									int money = (int)(betting*1.95)+userClass.getMoney();
									userClass.setMoney(money);
									UserDAO dao = new UserDAO();
									dao.InsertMoney(userClass);
								} else {
									//System.out.println("µ· ¸ø ¶¡");
								}
								//System.out.println("À¯Àú : " + user + " ÄÄÇ»ÅÍ : " + computer);
								end = true;
							}
							else if(end==true)
							{
								
								repaint();
								Thread.sleep(1000);
								dispose();
							}

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
			Thread t = new MyThread();
			t.start();
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			if (stringCon == true) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 600, 600);
				if (cnt % 2 == 0) {
					g.setColor(Color.WHITE);
					Font font2 = new Font("Serif", Font.BOLD, 100);
					g.setFont(font2);
					g.drawString("È¦ ", 100, 150);
				}
				if (cnt % 2 == 1) {
					g.setColor(Color.WHITE);
					Font font2 = new Font("Serif", Font.BOLD, 100);
					g.setFont(font2);
					g.drawString("Â¦ ", 400, 150);
				}
				// update(g);

			}
			
			//ÇöÀç ÀÜ¾× ¾Ë·ÁÁÖ±â
			if (end == true) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 600, 600);

				g.setColor(Color.WHITE);
				Font font2 = new Font("Serif", Font.BOLD, 40);
				g.setFont(font2);
				if (user == computer) {
					g.drawString("¹èÆÃ ¼º°ø", 185, 100);
					
				}else {
					g.drawString("¹èÆÃ ½ÇÆÐ", 185, 100);
				}
				g.drawString("ÇöÀçÀÜ¾× : ", 100, 200);
				String a = userClass.getMoney()+" ";
				g.drawString(a, 350, 200);

			} // (end == true)
		}// paint end
	}
}
