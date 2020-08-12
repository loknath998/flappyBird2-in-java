import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics;
// import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

class Menu extends JPanel 
{
	
	ImageIcon ic1;
	Image resetImage;
	JLabel label1,label2;
	PDemo p;
	Menu(PDemo p)
	{
		this.p = p;
		setLayout(null);
		setOpaque(false);
		// setBackground(new Color(20,20,20));
		
		ic1 = new ImageIcon("reset.png");
		
		label1 = new JLabel(ic1);
		label1.setSize(60,60);
		label1.setLocation(0,0);
		add(label1);
		
		label1.addMouseListener(new MouseListener()
		{
			public void mouseExited(MouseEvent e)
			{}
			public void mouseEntered(MouseEvent e)
			{}
			public void mouseReleased(MouseEvent e)
			{}
			public void mousePressed(MouseEvent e)
			{}
			public void mouseClicked(MouseEvent e)
			{
				show1();
			}
		});
		
		label1.setFocusable(false);
		Font f = new Font("courier",Font.BOLD,16);
		label2 = new JLabel("Reset");
		label2.setFont(f);
		label2.setBounds(60,10,60,40);
		add(label2);
	}
	void show1()
	{
		System.out.println("mouse clicked");
		// p.start_game = false;
		p.reset();
	}
	
}

class PDemo extends JPanel implements ActionListener , KeyListener
{
	int pheight,pwidth;
	int score,target;
	Font f;
	JButton reset;
	JLabel label;
	ImageIcon ic1,ic1t1,ic1t2,ic1t3,ic2,ic3,ic4,ic5,ic6,ic7,ic8,ic9;
	Image tree,tree1,tree2,tree3,bird,back,cloud1,cloud2,sun,block300,block400,block500;
	int xball, yball, gap1 ,gap2;
	int xblock1,yblock1;
	int xblock2,yblock2;
	int t1,t2,t3,t4,t5,suny;
	int time;
	Timer timer;
	int size_of_ball;
	int height_of_block1, height_of_block1b ;
	int height_of_block2, height_of_block2b ;
	boolean start_game;
	PDemo(int pwidth,int pheight)
	{
		
		this.pheight = pheight;
		this.pwidth = pwidth;
		xball = 100;
		yball = 100;
		t1 = 100;
		t2 = 500;
		t3 = 800;
		t4 = 0;
		t5 = t4+1570;
		suny = 220;
		height_of_block1 = 500;
		height_of_block1b = 300;
		height_of_block2 = 500;
		height_of_block2b = 400;
		xblock1 = pwidth + 100;
		xblock2 = pwidth + 400;
		yblock1 = 0 ;
		yblock2 = 0 ;
		gap1 = 100;
		score = 0;
		target =20;
		size_of_ball = 30;
		// ic1 = new ImageIcon("tree.png");
		ic1t1 = new ImageIcon("t1.png");
		ic1t2 = new ImageIcon("t2.png");
		ic1t3 = new ImageIcon("t3.png");
		ic2 = new ImageIcon("background.png");
		ic3 = new ImageIcon("b1.png");
		ic4 = new ImageIcon("c1.png");
		ic5 = new ImageIcon("c2.png");
		ic6 = new ImageIcon("sun1.png");
		ic7 = new ImageIcon("b300.png");
		ic8 = new ImageIcon("b400.png");
		ic9 = new ImageIcon("b500.png");
		
		// tree = ic1.getImage();
		tree1 = ic1t1.getImage();
		tree2 = ic1t2.getImage();
		tree3 = ic1t3.getImage();
		back = ic2.getImage();
		bird = ic3.getImage();
		cloud1 = ic4.getImage();
		cloud2 = ic5.getImage();
		sun = ic6.getImage();
		
		block300 = ic7.getImage();
		block400 = ic8.getImage();
		block500 = ic9.getImage();
		
		setBackground(new Color(149,221,255));
		
		// setBackground(Color.red);
		f = new Font("STENCIL",Font.BOLD,40);
		setFont(f);
		
		time = 20;
		timer = new Timer(time,this);
		timer.start();
		
		start_game = true;
		addKeyListener(this);
		setFocusable(true);
		setLayout(null);
		
		Menu m = new Menu(this);
		m.setBounds(850,150,110,60);
		add(m);
		
	}
	
	public void reset()
	{
		xball = 100;
		yball = 100;
		t1 = 100;
		t2 = 500;
		t3 = 800;
		t4 = 0;
		t5 = t4+1570;
		suny = 220;
		xblock1 = pwidth + 100;
		xblock2 = pwidth + 400;
		yblock1 = 0 ;
		yblock2 = 0 ;
		// gap1 = 100;
		start_game= true;
		score = 0;
		target =20;
		time = 20;
		timer.stop();
		timer = new Timer(time,this);
		timer.start();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);
			
		g.drawImage(sun, 600,suny,this);	
		g.drawImage(cloud1,t2+100,70,this);
		g.drawImage(cloud2,t3+50,40,this);
		g.drawImage(cloud2,t1,20,this);
		g.drawImage(tree1,t1,170,this);
		g.drawImage(tree2,t2,120,this);
		g.drawImage(tree3,t3,180,this);
		g.drawImage(back,t4,-100,this);
		g.drawImage(back,t5,-100,this);
		
		// g.fillRect(xblock1,yblock1,30, height_of_block1);
		g.drawImage(block500,xblock1,yblock1,this);
		// g.fillRect(xblock1,yblock1 - height_of_block1b - gap1,30, height_of_block1b);
		g.drawImage(block300,xblock1,yblock1- height_of_block1b-gap1,this);
		
		// g.fillRect(xblock2,yblock2,30, height_of_block2);
		g.drawImage(block500,xblock2,yblock2,this);
		// g.fillRect(xblock2,yblock2 - height_of_block2b - gap2 ,30, height_of_block2b);
		g.drawImage(block400,xblock2,yblock2 - height_of_block2b - gap2,this);
		
		g.setColor(Color.red);
		// g.fillOval(xball,yball,size_of_ball,size_of_ball);
		g.drawImage(bird,xball,yball,this);
		// g.setColor(new Color(0,191,255));
		g.setColor(new Color(144, 12, 63));
		g.drawString("your score: "+score,500,100);
		g.setColor(new Color(220,20,60));
		
		
			if
			(
				
				
					(xball >= xblock1 - size_of_ball && xball <= xblock1 +size_of_ball -5 )
						&&
					(
						( yball >= yblock1 && yball <= yblock1+height_of_block1)
							|| 
						( yball >= yblock1 - height_of_block1b - gap1 && yball <= yblock1 - gap1  )
					)
			)
			{
				// start_game = false;
				timer.stop();
				g.drawString("OOPs.. you loose !!!",240,250);
			}
			if( 
				(xball >= xblock2 - size_of_ball && xball <= xblock2 + size_of_ball -5) 
				&&
				(
					(yball >= yblock2 && yball <= yblock2 +height_of_block2) 
					||
					(yball >= yblock2 - height_of_block2b - gap2  && yball <=yblock2 - gap2 )
				)
			)
			{
				timer.stop();
				g.drawString("OOPs.. you loose !!!",240,250);
				// start_game = false;
			}
			
		
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(start_game)
		{
			if(score >= target)
			{
				timer.stop();
				time-=1;
				target += 20;
				timer = new Timer(time,this );
				timer.start();
			}
			t4 -= 2;
			t5 -= 2;
			t1 -= 1;
			suny -=1;
			
			if(t1 < -300)
				t1 = pwidth;
			t2 -= 1;
			if(t2 < -300)
				t2 = pwidth;
			t3 -= 1;
			if(t3 < -300)
				t3 = pwidth;
			if(t4 < -1600 )
				t4 = t5 +1570;
			if(t5 < -1600)
				t5 = t4 + 1570;
			if(suny < -200)
				suny = pheight-100;
			
			if(yball < pheight +100)
			yball+=5;
		
			xblock1 -= 5;
			xblock2 -= 5;
			
			if(xblock1 == pwidth )
			{
				int r1 = (int)Math.round(Math.random()*400 + 200);
				int r2 = (int )Math.round(Math.random()*250 + 90);
				yblock1 =r1;
				gap1 = r2;
				
				
			}
			if(xblock2 == pwidth)
			{
				int r1 = (int )Math.round(Math.random()*400 + 100);
				int r2 = (int )Math.round(Math.random()*250 + 90);
				yblock2 = r1;
				gap2 = r2;
			}
			if(xblock1 < 0 )
			{
				score++;
				xblock1 = pwidth+10; 
			}
			if(xblock2 < 0)
			{
				score++;
				xblock2 = xblock1 + (int )Math.round(Math.random()*300+ 400);
			
			}
			
			// if
			// (
				
				
					// (xball >= xblock1 - size_of_ball && xball <= xblock1 +size_of_ball )
						// &&
					// (
						// ( yball >= yblock1 && yball <= yblock1+height_of_block1)
							// || 
						// ( yball >= yblock1 - height_of_block1b - gap1 && yball <= yblock1 - gap1  )
					// )
			// )
				// start_game = false;
			// if( 
				// (xball >= xblock2 - size_of_ball && xball <= xblock2 + size_of_ball) 
				// &&
				// (
					// (yball >= yblock2 && yball <= yblock2 +height_of_block2) 
					// ||
					// (yball >= yblock2 - height_of_block2b - gap2  && yball <=yblock2 - gap2 )
				// )
			// )
			// start_game = false;
			
		repaint();
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		
	}
	public void keyPressed(KeyEvent e)
	{
	
		if(e.getKeyCode()== KeyEvent.VK_P)
		{
			start_game = !start_game;
			// System.out.println("P "+ yball);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			// System.out.println("space "+ yball);
			if(yball >=40)
			yball-=80;
		}
			// repaint();
	
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	
}

class FDemo extends JFrame
{
	PDemo p;
	FDemo()
	{
		setLayout(null);
		int width = 1000;
		int height = 700;

		// setLayout(new FlowLayout());
		p = new PDemo(width,height);
		p.setSize(width,height);
		p.setLocation(0,0);

		add(p);
	}
}

class FlappyBird
{
	public static void main(String arfd[] )
	{
		FDemo f = new FDemo();
		f.setVisible(true);
		f.setSize(1000,700);
		f.setLocation(300,0);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}