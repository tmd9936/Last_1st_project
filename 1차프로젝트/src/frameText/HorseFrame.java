package frameText;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import human.vo.User;
import user.service.UserDAO;
import vo.Horse;

public class HorseFrame extends JFrame {
	Random random = new Random();
	int[] ar = new int[5];
	Move move = new Move();
	Scanner sc = new Scanner(System.in);

	ArrayList<Horse> horseArr = new ArrayList<>();
	double betPersent[] = { 8.0, 7.0, 6.5, 6.0, 3.0, 2.7, 2.4, 2.1, 1.95, 1.87, 1.79, // 10
			1.71, 1.65, 1.574, 1.478, 1.372, 1.31, 1.265, 1.23, 1.12, 1.05 };
	double[] betArr = new double[5];
	User user;
	int selectHorse, bettingMoney;
	boolean inMoney = false;

	public HorseFrame(User user) {
		this.user = user;
		setTitle("�渶 ����");
		setSize(1800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel myPanel = new MyPanel();
		add(myPanel);
		// myPanel.setBackground(Color.PINK);

		setVisible(true);
	}

	class MyPanel extends JPanel {
		boolean end = false;

		public MyPanel() {
			super();
			int ct = horseInit();
			class MyThread extends Thread {
				public void run() {
					while (true) {
						if (ct == -1)
							dispose();
						try {
							horseUpdate();
							repaint();
							Thread.sleep(10);
							if (end == true) {
								Thread.sleep(2000);
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

		// TODO �����ϴ� �Լ� �����
		public int betting() {
			int betting = -1;
			while (true) {
				System.out.println("�ɾ�:::");
				try {
					betting = sc.nextInt();

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�߸� �Է� �ϼ̽��ϴ�");
					continue;
				} finally {
					sc.nextLine();

				}
				if (user.getMoney() - betting < 0) {
					System.out.println("Don't have money.");
					return -1;
				} else {
					user.setMoney(user.getMoney() - betting);

				}

				return betting;
			}
		}

		public int horseInit() {

			/*
			 * if (a > 0 && a < 6) return;
			 */
			horseArr.add(
					new Horse("horse2.png", 100, "1", random.nextInt(10), random.nextInt(10) + 5, random.nextInt(10)));
			horseArr.add(
					new Horse("horse2.png", 200, "2", random.nextInt(10), random.nextInt(10) + 5, random.nextInt(10)));
			horseArr.add(
					new Horse("horse2.png", 300, "3", random.nextInt(10), random.nextInt(10) + 5, random.nextInt(10)));
			horseArr.add(
					new Horse("horse2.png", 400, "4", random.nextInt(10), random.nextInt(10) + 5, random.nextInt(10)));
			horseArr.add(
					new Horse("horse2.png", 500, "5", random.nextInt(10), random.nextInt(10) + 5, random.nextInt(10)));
			int ar = 0;
			for (int i = 0; i < horseArr.size(); i++) {
				ar = horseArr.get(i).getSpeed() + horseArr.get(i).getCondition() + move.condition_patch()
						+ horseArr.get(i).getHealth() + move.health_patch();
				horseArr.get(i).setAr(ar);
				System.out.print(" condition : "+ horseArr.get(i).getCondition() + " health : " + horseArr.get(i).getHealth());
				System.out.println(" dividend rate : " + betPersent[(horseArr.get(i).getCondition() + horseArr.get(i).getHealth())]);

			}
			for (int i = 0; i < 5; i++) {
				betArr[i] = betPersent[(horseArr.get(i).getCondition() + horseArr.get(i).getHealth())];
			}
			// TODO �����ϴ� �Լ� �ֱ�
			while (true) {
				System.out.println("������� ���� �Ͻðڽ��ϱ�");
				try {
					selectHorse = sc.nextInt();

				} catch (Exception e) {
					System.out.println("�߸� �Է��Ͽ����ϴ�");
					continue;
				} finally {
					sc.nextLine();

				}
				bettingMoney = betting();

				return bettingMoney;
			}
		}

		public void horseUpdate() {
			for (int i = 0; i < horseArr.size(); i++) {
				horseArr.get(i).update();
			}
			for (Horse horse : horseArr) {
				horse.setCnt(horse.getCnt() + 1);
			}
		}

		///////////////////// �׸��� �Լ� ����////////////////////////////////
		// �׷��ִ� ��ü
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(new ImageIcon("background2.png").getImage(), 0, 0, null);

			drawHorseWheel(g); // �� ������ üũ
			checkFinish(g);

			for (int i = 0; i < horseArr.size(); i++) {
				horseArr.get(i).draw(g);
			}
		}

		public void drawHorseWheel(Graphics g) {
			// ���� ������ üũ�� �׸���
			for (int i = 0; i < horseArr.size(); i++) {
				g.setColor(Color.RED);
				Font font2 = new Font("Serif", Font.BOLD, 20);
				g.setFont(font2);
				g.drawString(i + 1 + "���� : " + horseArr.get(i).getNumOfWheels() + "����", 0, 500 + i * 30);
			}
		}

		public void checkFinish(Graphics g) {

			// ���� �������� üũ�ϸ鼭 ���� �� ���� �ֳ� Ȯ��
			int wheels = 10; // ���� ������
			for (int i = 0; i < horseArr.size(); i++) {
				if (horseArr.get(i).getNumOfWheels() == wheels) {
					end = true;

					g.setColor(Color.BLACK);
					Font font2 = new Font("Serif", Font.BOLD, 50);
					g.setFont(font2);
					g.drawString(i + 1 + "������ �¸�!!", 600, 250);
					if (selectHorse == i + 1 && inMoney == false) {
						System.out.println("���� ����");
						int money = (int) (betArr[i] * bettingMoney) + user.getMoney();
						user.setMoney(money);
						UserDAO dao = new UserDAO();
						dao.InsertMoney(user);
						inMoney = true;

					}

					g.drawString("���� �ܾ� : " + user.getMoney(), 500, 400);

					// TODO �̰����� ���ֱ� ���� ����
					// System.out.println("���� �ܾ� : "+user.getMoney());
					return;
				}

			}
		}
		///////////////////// �׸��� �Լ� ����//////////////////////

	}
}
