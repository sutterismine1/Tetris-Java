import java.awt.*;
import javax.swing.*;

public class Render extends JPanel {

    public static JFrame frame = new JFrame();
    public static KeyBoard keyboard = new KeyBoard();
    public static int DeltaTitle = 0;

    public static void construc() {

        frame.getContentPane().add(new Render());

        frame.setTitle("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.red);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 600);
        frame.setVisible(true);

        keyboard.addKeyListener(keyboard);
        keyboard.setFocusable(true);
        frame.add(keyboard);
        frame.getKeyListeners();
    }

    public void paint(Graphics g) {
        // colors

        Color colors[] = { new Color(80, 80, 80), new Color(255, 255, 255), new Color(255, 50, 50),
                new Color(50, 255, 50), new Color(50, 50, 255), new Color(225, 225, 50), new Color(225, 50, 225),
                new Color(50, 225, 225), new Color(250, 170, 0), new Color(255, 50, 50, 50), new Color(50, 255, 50, 50),
                new Color(50, 50, 255, 50), new Color(225, 225, 50, 50), new Color(225, 50, 225, 50),
                new Color(50, 225, 225, 50), new Color(250, 170, 0, 50) };

        // black0,white1,red2,green3,blue4,yellow5,purple6,cyan7,orange8,
        // ,red9,green10,blue11,yellow12,purple13,cyan14,orange15,

        g.setColor(colors[0]);
        g.fillRect(0, 0, 1000, 1000);

        if (GameStateManager.CurrentState != "GameOver") {

            if (GameStateManager.CurrentState != "Menu") {

                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 10; j++) {

                        int x = 25 * j + (j + 25);
                        int y = 25 * i + (i + 25);
                        int width = 25;
                        int height = 25;

                        var color = colors[0];

                        if (Blocks.GameMatrix[i][j] != 0) {

                            if (Blocks.GameMatrix[i][j] == 1) {

                                color = colors[2];
                            } else if (Blocks.GameMatrix[i][j] == 2) {
                                color = colors[3];
                            } else if (Blocks.GameMatrix[i][j] == 3) {
                                color = colors[4];
                            } else if (Blocks.GameMatrix[i][j] == 4) {
                                color = colors[5];
                            } else if (Blocks.GameMatrix[i][j] == 5) {
                                color = colors[6];
                            } else if (Blocks.GameMatrix[i][j] == 6) {
                                color = colors[7];
                            } else if (Blocks.GameMatrix[i][j] == 7) {
                                color = colors[8];
                            }

                        } else {

                            if (Blocks.FuturePosition[i][j] == 1) {
                                color = colors[9];
                            } else if (Blocks.FuturePosition[i][j] == 2) {
                                color = colors[10];
                            } else if (Blocks.FuturePosition[i][j] == 3) {
                                color = colors[11];
                            } else if (Blocks.FuturePosition[i][j] == 4) {
                                color = colors[12];
                            } else if (Blocks.FuturePosition[i][j] == 5) {
                                color = colors[13];
                            } else if (Blocks.FuturePosition[i][j] == 6) {
                                color = colors[14];
                            } else if (Blocks.FuturePosition[i][j] == 7) {
                                color = colors[15];
                            } else {
                                color = colors[1];
                            }

                        }
                        g.setColor(color);
                        g.fillRect(x, y, width, height);

                    }
                }

                /////

                String HighscoreString = Integer.toString(ScoreManager.Highscore);
                String ScoreString = Integer.toString(ScoreManager.score);

                int[][] ScoreArr = AssetManager.AssetCreater(ScoreString);

                int[][] HighScoreArr = AssetManager.AssetCreater(HighscoreString);

                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < ScoreString.length() + (ScoreString.length() * 3); i++) {

                        int x = 5 * i + 300;
                        int y = 5 * j + 250;
                        int width = 5;
                        int height = 5;

                        var color = colors[1];

                        if (ScoreArr[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);

                        }

                    }
                }

                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < HighscoreString.length() + (HighscoreString.length() * 3); i++) {

                        int x = 5 * i + 300;
                        int y = 5 * j + 400;
                        int width = 5;
                        int height = 5;

                        var color = colors[1];

                        if (HighScoreArr[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);

                        }

                    }
                }

                for (int j = 0; j < 40; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 5 * j + 300;
                        int y = 5 * i + 20;
                        int width = 5;
                        int height = 5;

                        var color = colors[1];

                        if (AssetManager.NextPieceText[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

                int xx = 300;
                int yy = 50;

                g.setColor(colors[1]);
                g.drawLine(xx, yy + 100 - 1, xx, yy);
                g.drawLine(xx, yy, xx + 100 - 1, yy);
                g.drawLine(xx + 1, yy + 100 - 1, xx + 100 - 1, yy + 100 - 1);
                g.drawLine(xx + 100 - 1, yy + 100 - 1, xx + 100 - 1, yy + 1);

                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 4; i++) {

                        int x = 20 * j + (j + 310);
                        int y = 20 * i + (i + 60);
                        int width = 20;
                        int height = 20;

                        var color = colors[0];

                        if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] != 0) {

                            if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 1) {

                                color = colors[2];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 2) {
                                color = colors[3];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 3) {
                                color = colors[4];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 4) {
                                color = colors[5];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 5) {
                                color = colors[6];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 6) {
                                color = colors[7];
                            } else if (Blocks.GetCurrent(Blocks.BlockQueue[Blocks.BlockQueuePlace])[i][j] == 7) {
                                color = colors[8];
                            }

                            g.setColor(color);
                            g.fillRect(x, y, width, height);

                        }

                    }
                }

                for (int j = 0; j < 20; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 5 * j + 300;
                        int y = 5 * i + 200;
                        int width = 5;
                        int height = 5;

                        var color = colors[2];

                        if (AssetManager.ScoreText[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

                for (int j = 0; j < 38; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 5 * j + 300;
                        int y = 5 * i + 350;
                        int width = 5;
                        int height = 5;

                        var color = colors[2];

                        if (AssetManager.HighScoreText[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

                if (GameStateManager.CurrentState == "Pause") {

                    for (int j = 0; j < 6; j++) {
                        for (int i = 0; i < 4; i++) {

                            int x = 25 * j + (j + 25 + 50 + 2);
                            int y = 25 * i + (i + 25 + 150 + 6);
                            int width = 25;
                            int height = 25;

                            if (AssetManager.Pause[i][j] != 0) {

                                g.setColor(colors[0]);
                                g.fillRect(x, y, width, height);
                            }
                        }
                    }
                }

            } else {
                // Titele screen

                int[] ColorWave1 = { 2, 3, 4, 5, 6, 7 };
                int[] ColorWave2 = { 7, 2, 3, 4, 5, 6 };
                int[] ColorWave3 = { 6, 7, 2, 3, 4, 5 };
                int[] ColorWave4 = { 5, 6, 7, 2, 3, 4 };
                int[] ColorWave5 = { 4, 5, 6, 7, 2, 3 };
                int[] ColorWave6 = { 3, 4, 5, 6, 7, 2 };

                int[] ColorWave = new int[6];

                if (DeltaTitle > 2000) {
                    ColorWave = ColorWave6;
                } else if (DeltaTitle > 1600) {
                    ColorWave = ColorWave5;
                } else if (DeltaTitle > 1200) {
                    ColorWave = ColorWave4;
                } else if (DeltaTitle > 800) {
                    ColorWave = ColorWave3;
                } else if (DeltaTitle > 400) {
                    ColorWave = ColorWave2;
                } else {
                    ColorWave = ColorWave1;
                }

                for (int j = 0; j < 23; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 20 * j + 10;
                        int y = 20 * i + 200;
                        int width = 20;
                        int height = 20;

                        var color = colors[2];

                        if (j < 3) {
                            color = colors[ColorWave[0]];
                        } else if (j > 3 && j < 7) {
                            color = colors[ColorWave[1]];
                        } else if (j > 6 && j < 11) {
                            color = colors[ColorWave[2]];
                        } else if (j > 11 && j < 16) {
                            color = colors[ColorWave[3]];
                        } else if (j > 15 && j < 20) {
                            color = colors[ColorWave[4]];
                        } else if (j > 19) {
                            color = colors[ColorWave[5]];
                        }

                        if (AssetManager.Title[i][j] != 0) {

                            g.setColor(color);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

                for (int j = 0; j < 41; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 10 * j + 35;
                        int y = 10 * i + 350;
                        int width = 10;
                        int height = 10;

                        if (AssetManager.PressStart[i][j] != 0) {

                            g.setColor(colors[ColorWave[0]]);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

            }

        } else {

            for (int j = 0; j < 36; j++) {
                for (int i = 0; i < 5; i++) {

                    int x = 13 * j + 13;
                    int y = 13 * i + 150;
                    int width = 13;
                    int height = 13;

                    if (AssetManager.GameOverText[i][j] != 0) {

                        g.setColor(colors[2]);
                        g.fillRect(x, y, width, height);
                    }
                }
            }

            if (ScoreManager.NewHighScore) {

                for (int j = 0; j < 53; j++) {
                    for (int i = 0; i < 5; i++) {

                        int x = 8 * j + 40;
                        int y = 8 * i + 250;
                        int width = 8;
                        int height = 8;

                        if (AssetManager.NewHighScoreText[i][j] != 0) {

                            g.setColor(colors[2]);
                            g.fillRect(x, y, width, height);
                        }
                    }
                }

            }

        }

        // g.drawString("Hello to JavaTutorial.net", 10, 10);

        // https://javatutorial.net/display-text-and-graphics-java-jframe

    }

    public static void Update() {

        frame.validate();
        frame.repaint();

    }

}