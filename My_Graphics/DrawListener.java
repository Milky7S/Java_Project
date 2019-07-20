package My_Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DrawListener extends MouseAdapter implements ActionListener {

	private Color color = Color.black;// ������ɫ���ԣ��洢�û�ѡ�����ɫ
	private int width = 1;// ������ϸ���ԣ��洢�û�ѡ��Ĵ�ϸ
	private String type = "Line";// ����ͼ�����ԣ��洢�û�ѡ���ͼ��
	private int x1, y1, x2, y2, x3 = 0, y3 = 0, x4 = 0, y4 = 0, x5, y5;// ��������ֵ���ԣ��洢��갴�º��ͷŵ�����ֵ
	private Graphics2D g;// �������������ԣ�����ǻ������ģ�����Ҫ������ϻ�ͼ�Σ�Graphics������ϻ�ȡ
	private DrawMain dm;// ������ͼ�������������
	private JTextField text;// ��ȡ�ı�������
	private double H = 100;// ���������εĸ߶�
	private int num = 0;
	private List<Shape> list;
	private ImageIcon i = new ImageIcon("C:\\Users\\long452a\\Desktop\\a1.jpg");

	/**
	 * ���췽��
	 * 
	 * @param dm��ͼ����Ĵ����������
	 */
	public DrawListener(DrawMain dm, JTextField text, List<Shape> list) {
		this.dm = dm;
		this.text = text;
		this.list = list;
	}

	/**
	 * �����ťʱִ�е��¼�������
	 * 
	 * @param e�����д洢���¼�Դ�������Ϣ�Ͷ�����Ϣ
	 */
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		if (text.equals("")) {
			JButton button = (JButton) e.getSource();
			color = button.getBackground();
		} else if (text.equals("1") || text.equals("3") || text.equals("5")) {
			width = Integer.parseInt(text);
		} else {
			type = text;
		}
		// System.out.println(color + ">>" + width + ">>" + type);
	}

	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a
	 * component.
	 */
	public void mouseClicked(MouseEvent e) {
		x4 = x2;
		y4 = y2;
	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		x1 = e.getX() + 7;
		y1 = e.getY() + 183;
		if (y1 < 183)
			y1 = 183;
		g = (Graphics2D) dm.getGraphics();// �Ӵ����ϻ�ȡ���ʶ���
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// ���û��ʿ����
		g.setColor(color);// ���û�����ɫ
		g.setStroke(new BasicStroke(width));// ���û���������ϸ

	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX() + 7;
		y2 = e.getY() + 183;
		if (y2 < 183)
			y2 = 183;
		if (type.equals("iso_Tri")) {
			if (x1 == x2) {
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1, x1 + (int) H, (y2 + y1) / 2);
				g.drawLine(x2, y2, x1 + (int) H, (y2 + y1) / 2);
				list.add(new Shape(x1, y1, x2, y2, width, color, type, i, dm, text));
				list.add(new Shape(x1, y1, x1 + (int) H, (y2 + y1) / 2, width, color, type, i, dm, text));
				list.add(new Shape(x2, y2, x1 + (int) H, (y2 + y1) / 2, width, color, type, i, dm, text));
			} else if (y1 == y2) {
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1, (x1 + x2) / 2, y1 + (int) H);
				g.drawLine(x2, y2, (x1 + x2) / 2, y1 + (int) H);
				list.add(new Shape(x1, y1, x2, y2, width, color, type, i, dm, text));
				list.add(new Shape(x1, y1, x1 + (x1 + x2) / 2, y1 + (int) H, width, color, type, i, dm, text));
				list.add(new Shape(x2, y2, x1 + (x1 + x2) / 2, y1 + (int) H, width, color, type, i, dm, text));
			} else {
				double a = Math.atan((double) (x2 - x1) / (double) (y2 - y1));
				double x3 = (double) (x1 + x2) / 2 + H * Math.cos(a);
				double y3 = (double) (y1 + y2) / 2 - H * Math.sin(a);
				g.drawLine(x1, y1, x2, y2);
				g.drawLine(x1, y1, (int) x3, (int) y3);
				g.drawLine(x2, y2, (int) x3, (int) y3);
				list.add(new Shape(x1, y1, x2, y2, width, color, type, i, dm, text));
				list.add(new Shape(x1, y1, x1 + (int) x3, (int) y3, width, color, type, i, dm, text));
				list.add(new Shape(x2, y2, (int) x3, (int) y3, width, color, type, i, dm, text));
			}
		} else if (type.equals("Polygon")) {
			if (num == 0) {
				g.drawLine(x1, y1, x2, y2);
				list.add(new Shape(x1, y1, x2, y2, width, color, type, i, dm, text));
				x5 = x2;
				y5 = y2;
			}
			num++;
			if (num == 1) {
				x3 = x1;
				y3 = y1;
			}
			if (x2 == x4 && y2 == y4) {
				g.drawLine(x1, y1, x3, y3);
				list.add(new Shape(x1, y1, x3, y3, width, color, type, i, dm, text));
				num = 0;
			} else {
				g.drawLine(x2, y2, x5, y5);
				list.add(new Shape(x2, y2, x5, y5, width, color, type, i, dm, text));
				x5 = x2;
				y5 = y2;
			}
		} else {
			Shape s = new Shape(x1, y1, x2, y2, width, color, type, i, dm, text);
			s.draw(g);
			list.add(s);
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (type.equals("Pencil")) {
			x2 = e.getX() + 7;
			y2 = e.getY() + 183;
			if (y2 < 183)
				y2 = 183;
			Shape s = new Shape(x1, y1, x2, y2, width, color, type, i, dm, text);
			s.draw(g);
			list.add(s);
			x1 = x2;
			y1 = y2;
		} else if (type.equals("Erase")) {
			x2 = e.getX() + 7;
			y2 = e.getY() + 183;
			if (y2 < 183)
				y2 = 183;
			Shape s = new Shape(x1, y1, x2, y2, width, Color.WHITE, type, i, dm, text);
			s.draw(g);
			list.add(s);
			x1 = x2;
			y1 = y2;
		} else if (type.equals("��ǹ")) // �ѵ�
		{
			Random rand = new Random();// ʵ����һ���������Ķ���
			int size = rand.nextInt(50);// �������Ҫ���ĵ���
			x2 = e.getX() + 7;
			y2 = e.getY() + 183;
			for (int j = 0; j < size; j++) {
				// ��0-7֮�����ȡ50��
				int x = rand.nextInt(10);
				int y = rand.nextInt(10);
				// ���ϸı䣨x1,y1��������ֵ��ʵ����(x1,y1)����Χ����
				Shape s = new Shape(x2 + x, y2 + y, x2 + x, y2 + y, width, color, type, i, dm, text);
				s.draw(g);
				list.add(s);
				x1 = x2;
				y1 = y2;
			}
		}
	}

}
