package com.hugolnx.washing.machine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Test implements Runnable{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Test());
    }

    JToggleButton play;
    AnimationPanel animation;

    @Override
    public void run() {
        JFrame frame = new JFrame("Simple Animation");
        JPanel content = new JPanel(new BorderLayout());

        play = new JToggleButton("Play");
        content.add(play, BorderLayout.NORTH);

        animation = new AnimationPanel(500, 50);
        content.add(animation, BorderLayout.CENTER);

        // 'true' to use a Thread
        // 'false' to use a Timer
        if(true) {
            play.addActionListener(new ThreadAnimator());
        } else {
            play.addActionListener(new TimerAnimator());
        }

        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    abstract class Animator implements ActionListener {
        final int period = ( 1000 / 60 );

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(play.isSelected()) {
                start();
            } else {
                stop();
            }
        }

        abstract void start();
        abstract void stop();

        void animate() {
            int workingPos = animation.barPosition;

            ++workingPos;

            if(workingPos >= animation.getWidth()) {
                workingPos = 0;
            }

            animation.barPosition = workingPos;

            animation.repaint();
        }
    }

    class ThreadAnimator extends Animator {
        volatile boolean isRunning;

        Runnable loop = new Runnable() {
            @Override
            public void run() {
                try {
                    while(isRunning) {
                        animate();
                        Thread.sleep(period);
                    }
                } catch(InterruptedException e) {
                    throw new AssertionError(e);
                }
            }
        };

        @Override
        void start() {
            isRunning = true;

            new Thread(loop).start();
        }

        @Override
        void stop() {
            isRunning = false;
        }
    }

    class TimerAnimator extends Animator {
        Timer timer = new Timer(period, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });

        @Override
        void start() {
            timer.start();
        }

        @Override
        void stop() {
            timer.stop();
        }
    }

    static class AnimationPanel extends JPanel {
        final int barWidth = 10;

        volatile int barPosition;

        AnimationPanel(int width, int height) {
            setPreferredSize(new Dimension(width, height));
            setBackground(Color.BLACK);

            barPosition = ( width / 2 ) - ( barWidth / 2 );
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            int currentPos = barPosition;

            g.setColor(Color.GREEN);
            g.fillRect(currentPos, 0, barWidth, height);

            if( (currentPos + barWidth) >= width ) {
                g.fillRect(currentPos - width, 0, barWidth, height);
            }
        }
    }
}