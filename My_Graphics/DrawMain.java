package My_Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class DrawMain extends JFrame {

	public static void main(String[] args) {
		DrawMain dm = new DrawMain();
		dm.setLookAndFeel();
		dm.initUI();
	}

	/**
	 * Ϊ���������Ƥ��
	 */
	public void setLookAndFeel() {

		try {

			UIManager

					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void initUI() {
		this.setTitle("��ͼ����");
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		/*
		 * ����������λ��
		 * 
		 * @param NorthJPanel ��ͼ���Ϸ�����ѡ������,��ʽ����
		 * 
		 * @param InNorthJPanel ��ѡ������������һ��ָ����С�����,��ʽ����
		 */
		JPanel NorthJPanel = new JPanel();
		NorthJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 0));
		NorthJPanel.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), new Color(0, 255, 0)));
		NorthJPanel.setBackground(new Color(240, 240, 240));
		this.add(NorthJPanel, BorderLayout.NORTH);
		JPanel InNorthJPanel = new JPanel();
		InNorthJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 0));
		InNorthJPanel.setPreferredSize(new Dimension(900, 150));
		InNorthJPanel.setBackground(new Color(240, 240, 240));
		NorthJPanel.add(InNorthJPanel);

		/*
		 * ��״����
		 * 
		 * @param ShapeJPanel ��״��������,���沼��
		 * 
		 * @param InShapeJPanel ��״�����з�����״ѡ������,����ShapeJPanel��,��ʽ����
		 * 
		 * @param InShapeLabel ��״�����б�ʶ����ı�ǩ,����ShapeJPanel��
		 */
		JPanel ShapeJPanel = null;
		ShapeJPanel = createJPanel(InNorthJPanel);
		ShapeJPanel.setPreferredSize(new Dimension(300, 150));
		JPanel InShapeJPanel = new JPanel();
		InShapeJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		InShapeJPanel.setBackground(null);// ���ñ���ɫ͸��
		InShapeJPanel.setOpaque(false);
		InShapeJPanel.setPreferredSize(new Dimension(300, 110));
		ShapeJPanel.add(InShapeJPanel, BorderLayout.NORTH);
		JLabel InShapeLabel = null;
		InShapeLabel = createJLabel("��״", ShapeJPanel);

		/*
		 * ��ɫ����
		 * 
		 * @param ColorJPanel ��ɫ�������,���沼��
		 * 
		 * @param InColorJPanel ��ɫ�����з�����ɫѡ�����壬����ColorJPanel�У���ʽ����
		 * 
		 * @param InColorLabel ��ɫ�����б�ʶ����ı�ǩ������ColorJPanel��
		 */
		JPanel ColorJPanel = null;
		ColorJPanel = createJPanel(InNorthJPanel);
		JPanel IncolorJPanel = new JPanel();
		IncolorJPanel.setPreferredSize(new Dimension(200, 110));
		IncolorJPanel.setBackground(null);// ���ñ���ɫ͸��
		IncolorJPanel.setOpaque(false);
		IncolorJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		ColorJPanel.add(IncolorJPanel, BorderLayout.NORTH);
		JLabel InColorLabel = null;
		InColorLabel = createJLabel("��ɫ", ColorJPanel);

		/*
		 * ��ϸ��������
		 * 
		 * @param StrokeJPanel ��ϸ����������壬���沼��
		 * 
		 * @param InStrokeJPanel ��ϸ���������з��ô�ϸѡ�����壬����StrokeJPanel�У���ʽ����
		 * 
		 * @param InStrokeLabel ��ϸ��������ı�ǩ������StrokeJPanel��
		 */
		JPanel StrokeJPanel = null;
		StrokeJPanel = createJPanel(InNorthJPanel);
		StrokeJPanel.setPreferredSize(new Dimension(50, 150));
		JPanel InStrokeJPanel = new JPanel();
		InStrokeJPanel.setPreferredSize(new Dimension(50, 110));
		InStrokeJPanel.setBackground(null);
		InStrokeJPanel.setOpaque(false);
		InStrokeJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		StrokeJPanel.add(InStrokeJPanel, BorderLayout.NORTH);
		JLabel InStrokeLabel = null;
		InStrokeLabel = createJLabel("��ϸ", StrokeJPanel);

		/*
		 * ��ͼ��
		 */
		JPanel paint = new JPanel();
		paint.setBackground(Color.white);
		this.add(paint, BorderLayout.CENTER);

		/*
		 * ���ð�ť
		 */
		String[] typeArray = { "Line", "Oval", "Rect", "RoundRect", "fill3DRect", "fillArc", "Image", "Text", "Pencil",
				"iso_Tri", "Polygon","��ǹ", "Erase" };
		Color[] colorArray = { Color.red, Color.black, Color.green, Color.BLUE, new Color(255, 255, 255) };
		String[] widthArray = { "1", "3", "5" };
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(100, 30));

		DrawListener dl = new DrawListener(this, text, list);

		for (int i = 0; i < typeArray.length; i++) {
			JButton button = new JButton(typeArray[i]);
			InShapeJPanel.add(button);
			button.addActionListener(dl);
			if(i>=12)
			{
				JButton button1 = new JButton(typeArray[i]);
				InNorthJPanel.add(button);
				button1.addActionListener(dl);
			}
		}
		for (int i = 0; i < colorArray.length; i++) {
			JButton button = new JButton();
			button.setBackground(colorArray[i]);
			button.setPreferredSize(new Dimension(30, 30));
			IncolorJPanel.add(button);
			button.addActionListener(dl);
				
		}
		/*
		 * �����ɫ�Զ��尴ť
		 * δ���
		 */
		JButton changeButton=new JButton();
		changeButton.setBackground(Color.WHITE);
		changeButton.setPreferredSize(new Dimension(30,30));
		IncolorJPanel.add(changeButton);
		changeButton.addActionListener(dl);
		
		
		
		for (int i = 0; i < widthArray.length; i++) {
			JButton button = new JButton(widthArray[i]);
			InStrokeJPanel.add(button);
			button.addActionListener(dl);
		}
		InNorthJPanel.add(text);
		this.setVisible(true);

		paint.addMouseListener(dl);
		paint.addMouseMotionListener(dl);
	}

	private List<Shape> list = new ArrayList<Shape>();

	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < list.size(); i++) {
			Shape shape = list.get(i);
			shape.draw(g);
		}
	}

	private JPanel createJPanel(JPanel InNorthJPanel) {
		JPanel jp = new JPanel();
		jp.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), new Color(0, 255, 0)));
		jp.setPreferredSize(new Dimension(200, 150));
		jp.setBackground(new Color(240, 240, 240));
		InNorthJPanel.add(jp);
		return jp;
	}

	private JLabel createJLabel(String s, JPanel jp) {
		JLabel jl = new JLabel(s);
		jl.setHorizontalAlignment(JLabel.CENTER);// ���ö����ʽ����
		jl.setFont(new Font("����", Font.BOLD, 20));// �������� ��ʽ ��С
		jp.add(jl, BorderLayout.SOUTH);
		return jl;
	}

}
