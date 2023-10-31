import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    JPanel mainPnl,boardPnl,statPnl,playerPnl;
    JLabel playerTurn;
    JButton quit;

    public TicTacToeFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int height = screenSize.height;
        int width = screenSize.width;
        setSize(800,600);
        setLocation((width/4),height/10);

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI();
        setVisible(true);
    }
    private void createGUI()
    {
        mainPnl = new JPanel();


        createPlayerPnl();
        createBoardPnl();
        createBottomPnl();
        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(playerPnl, BorderLayout.NORTH);
        mainPnl.add(boardPnl, BorderLayout.CENTER);
        mainPnl.add(statPnl, BorderLayout.SOUTH);

        add(mainPnl);

    }

    private void createPlayerPnl()
    {
        playerPnl = new JPanel();
        playerTurn = new JLabel("Player X Turn");
        playerTurn.setFont(new Font("Serif", Font.PLAIN, 20));
        playerPnl.add(playerTurn);
    }

    public void createBoardPnl()
    {
        boardPnl = new JPanel();
        boardPnl.setLayout(new GridLayout(3,3));
        TicTacToeBoard.createBoard(boardPnl);
        TicTacToeBoard.onClick(playerTurn);
    }

    private void createBottomPnl()
    {
        statPnl = new JPanel();

        quit = new JButton();
        quit.setText("Exit");
        quit.setFont(new Font("Serif", Font.PLAIN, 14));
        quit.addActionListener(e ->
        {
            System.exit(0);
        });
        statPnl.add(quit);
    }
}
