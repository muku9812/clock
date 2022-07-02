import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;

    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Watch");
        this.setLayout(new FlowLayout());
        this.setSize(380,250);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");


        timeLabel = new JLabel();

        dayLabel = new JLabel();
       dayLabel.setFont(new Font("Ink Free",Font.PLAIN,50));
       day = dayFormat.format(calendar.getInstance().getTime());
       dayLabel.setText(day);


       dateLabel = new JLabel();
       dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));
        date = dateFormat.format(calendar.getInstance().getTime());
        dateLabel.setText(date);



        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        UpdateTime();

    }
    public void UpdateTime(){
        while(true) {
            time = timeFormat.format(calendar.getInstance().getTime());
            timeLabel.setText(time);
            timeLabel.setFont(new Font("verdana",Font.BOLD,50));
            timeLabel.setForeground(Color.blue);
            timeLabel.setBackground(Color.cyan);
            timeLabel.setOpaque(true);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


}
