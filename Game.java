import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Game {
	
	private static int[][] board = new int[8][8];
	private static JFrame frame;
	private static int turn = 1;
	
	public static void main(String[] args) {
		frame = new JFrame();
		JPanel panel = new BoardPanel();
		frame.add(BorderLayout.CENTER, panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game");
		panel.setPreferredSize(new Dimension(48*8, 48*9));
		panel.setBackground(Color.white);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		MouseInput mi = new MouseInput();
		panel.addMouseListener(mi);
		panel.addMouseMotionListener(mi);
	}
	
	public static boolean check() {
		boolean check = false;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (board[y][x] == 0) {
					continue;
				}
				if (x + 3 < 8) {
					if (board[y][x] == 1 && board[y][x + 1] == 1 && board[y][x + 2] == 1 && board[y][x + 3] == 1 || 
					    board[y][x] == 2 && board[y][x + 1] == 2 && board[y][x + 2] == 2 && board[y][x + 3] == 2) {
						check = true;
						board[y][x] = -1;
						board[y][x + 1] = -1;
						board[y][x + 2] = -1;
						board[y][x + 3] = -1;
					}
				} if (x - 3 >= 0) {
					if (board[y][x] == 1 && board[y][x - 1] == 1 && board[y][x - 2] == 1 && board[y][x - 3] == 1 ||
					    board[y][x] == 2 && board[y][x - 1] == 2 && board[y][x - 2] == 2 && board[y][x - 3] == 2) {
						check = true;
						board[y][x] = -1;
						board[y][x - 1] = -1;
						board[y][x - 2] = -1;
						board[y][x - 3] = -1;
					}
				} if (y + 3 < 8) {
					if (board[y][x] == 1 && board[y + 1][x] == 1 && board[y + 2][x] == 1 && board[y + 3][x] == 1 ||
						board[y][x] == 2 && board[y + 1][x] == 2 && board[y + 2][x] == 2 && board[y + 3][x] == 2) {
						check = true;
						board[y][x] = -1;
						board[y + 1][x] = -1;
						board[y + 2][x] = -1;
						board[y + 3][x] = -1;
					}
				} if (y - 3 >= 0) {
					if (board[y][x] == 1 && board[y - 1][x] == 1 && board[y - 2][x] == 1 && board[y - 3][x] == 1 ||
					    board[y][x] == 2 && board[y - 1][x] == 2 && board[y - 2][x] == 2 && board[y - 3][x] == 2) {
						check = true;
						board[y][x] = -1;
						board[y - 1][x] = -1;
						board[y - 2][x] = -1;
						board[y - 3][x] = -1;
					}
				} if (x + 3 < 8 && y + 3 < 8) {
					if (board[y][x] == 1 && board[y + 1][x + 1] == 1 && board[y + 2][x + 2] == 1 && board[y + 3][x + 3] == 1 || board[y][x] == 2 && board[y + 1][x + 1] == 2 && board[y + 2][x + 2] == 2 && board[y + 3][x + 3] == 2) {
						check = true;
						board[y][x] = -1;
						board[y + 1][x + 1] = -1;
						board[y + 2][x + 2] = -1;
						board[y + 3][x + 3] = -1;
					}
				} if (x - 3 >= 0 && y - 3 >= 0) {
					if (board[y][x] == 1 && board[y - 1][x - 1] == 1 && board[y - 2][x - 2] == 1 && board[y - 3][x - 3] == 1 || board[y][x] == 2 && board[y - 1][x - 1] == 2 && board[y - 2][x - 2] == 2 && board[y - 3][x - 3] == 2) {
						check = true;
						board[y][x] = -1;
						board[y - 1][x - 1] = -1;
						board[y - 2][x - 2] = -1;
						board[y - 3][x - 3] = -1;
					}
				} if (x + 3 < 8 && y - 3 >= 0) {
					if (board[y][x] == 1 && board[y - 1][x + 1] == 1 && board[y - 2][x + 2] == 1 && board[y - 3][x + 3] == 1 || board[y][x] == 2 && board[y - 1][x + 1] == 2 && board[y - 2][x + 2] == 2 && board[y - 3][x + 3] == 2) {
						System.out.println("ueah");
						check = true;
						board[y][x] = -1;
						board[y - 1][x + 1] = -1;
						board[y - 2][x + 2] = -1;
						board[y - 3][x + 3] = -1;
					}
				} if (x - 3 >= 0 && y + 3 < 8) {
					if (board[y][x] == 1 && board[y + 1][x - 1] == 1 && board[y + 2][x - 2] == 1 && board[y + 3][x - 3] == 1 || board[y][x] == 2 && board[y + 1][x - 1] == 2 && board[y + 2][x - 2] == 2 && board[y + 3][x - 3] == 2) {
						check = true;
						board[y][x] = -1;
						board[y + 1][x - 1] = -1;
						board[y + 2][x - 2] = -1;
						board[y + 3][x - 3] = -1;
					}
				}
			}
		}
		if (check) {
			MouseInput.maint = true;
			t1 = new Timer(250, new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if (turn == 1) {
								if (BoardPanel.c == Color.black) {
									BoardPanel.c = Color.yellow;
							  	} else {
							  		BoardPanel.c = Color.black;
							  	}
							} else {
								if (BoardPanel.c == Color.black) {
									BoardPanel.c = Color.red;
							  	} else {
							  		BoardPanel.c = Color.black;
							  	}
							}
							counter++;
						  	frame.repaint();
						  	if (counter == 5) {
						  		board = new int[8][8];
						  		counter = 0;
						  		if (turn == 1) {
								turn = 2;
								} else {
									turn = 1;
								}
						  		MouseInput.maint = false;
						  		t1.stop();
							}
					  	}
				 	});
				 	t1.start();
		}
		return check;
	}
	
	static int counter = 0;
	static Timer t1;
	
	static class BoardPanel extends JPanel {
		
		private static int col;
		private static int row = 7;
		private static Color c;
		private static int yy;
		private static int xx;
		
		public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, getWidth(), getHeight());
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 8; x++) {
					g2d.setColor(Color.blue);
					g2d.fillRect(x * 48, y * 48+48, 48, 48);
					g2d.setColor(Color.black);
					g2d.fillOval(x * 48 + 2, y * 48 + 2+48, 48 - 4, 48 - 4);
					if (!MouseInput.maint) {
						if (x == col && y <= row) {
							g2d.setColor(new Color(40, 40, 40));
							g2d.fillOval(x * 48 + 2, y * 48 + 2+48, 48 - 4, 48 - 4);
						}
					}
					if (board[y][x] == 1) {
						g2d.setColor(Color.yellow);
						g2d.fillOval(x * 48 + 2, y * 48 + 2+48, 48 - 4, 48 - 4);
					}
					if (board[y][x] == 2) {
						g2d.setColor(Color.red);
						g2d.fillOval(x * 48 + 2, y * 48 + 2+48, 48 - 4, 48 - 4);
					}
					if (board[y][x] == -1) {
						g2d.setColor(c);
						g2d.fillOval(x * 48 + 2, y * 48 + 2+48, 48 - 4, 48 - 4);
					}
					if (!MouseInput.maint) {
						if (turn == 1) {
							g2d.setColor(Color.yellow);
						} else {
							g2d.setColor(Color.red);
						}
						g2d.fillOval(xx * 48 + 2, yy + 2, 48 - 4, 48 - 4);
					}
				}
			}
		}	

	}
	
	static class MouseInput extends MouseAdapter {
		
		static boolean triger = false;
		static boolean maint = false;
		
		public void mouseClicked(MouseEvent e) {
			if (maint) {
				return;
			}
			if (e.getX() >= 0 && e.getX() < 48 * 8 && e.getY() >= 0 && e.getY() < 48 * 8) {
				int row = 7;
				for (int y = 0; y < 8; y++) {
					if (board[y][e.getX() / 48] == 1 || board[y][e.getX() / 48] == 2) {
						row = y - 1;
						break;
					} 
				}
				if (row != -1) {
					if (!triger) {
						BoardPanel.xx = e.getX() / 48;
				  		does(row, e.getX());
				  		triger = true;
				  	}
				}
				frame.repaint();
			}
		}
		
		private static Timer timer;
		
		public void does(int r, int x) {
			timer = new Timer(10, new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
						  BoardPanel.yy+=48/4;
						  System.out.println(BoardPanel.yy);
						  if (BoardPanel.yy >= r * 48 + 48) {
						  	board[r][x / 48] = turn;
						  	triger = false;
						  	check();
						  	if (!maint) {
							if (turn == 1) {
								turn = 2;
							} else {
								turn = 1;
							}
							}
						  	BoardPanel.yy = 0;
							frame.repaint();
							BoardPanel.xx = BoardPanel.col;
						  	timer.stop();
						  }
						  frame.repaint();
					  	}
				 	});
				 	timer.start();
		}
		
		public void mouseMoved(MouseEvent e) {
			if (maint) {
				return;
			}
			if (e.getX() >= 0 && e.getX() < 48 * 8 && e.getY() >= 0 && e.getY() < 48 * 8) {
				if (!triger) {
					BoardPanel.xx = e.getX() / 48;
				}
				BoardPanel.col = e.getX() / 48;
				BoardPanel.row = 7;
				for (int y = 0; y < 8; y++) {
					if (board[y][BoardPanel.col] == 1 || board[y][e.getX() / 48] == 2) {
						BoardPanel.row = y - 1;
						break;
					}
				}
				frame.repaint();
			}
		}
	}

}
