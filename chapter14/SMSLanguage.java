package chapter14;
import javax.swing.*;import java.awt.*;import java.util.*;
public class SMSLanguage extends JFrame {
    JTextArea in=new JTextArea(6,50),out=new JTextArea(6,50);Map<String,String> sms=new LinkedHashMap<>();
    public SMSLanguage(){super("14.28 SMS Language");sms.put("in my opinion","imo");sms.put("be right back","brb");sms.put("as soon as possible","asap");sms.put("laughing out loud","lol");sms.put("by the way","btw");sms.put("for your information","fyi");sms.put("thank you","ty");sms.put("see you","c u");sms.put("you","u");sms.put("are","r");
        out.setEditable(false);JButton e=new JButton("English -> SMS"),d=new JButton("SMS -> English");JPanel p=new JPanel();p.add(e);p.add(d);e.addActionListener(x->convert(true));d.addActionListener(x->convert(false));
        add(new JScrollPane(in),BorderLayout.NORTH);add(p,BorderLayout.CENTER);add(new JScrollPane(out),BorderLayout.SOUTH);setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(650,500);setLocationRelativeTo(null);}
    void convert(boolean toSms){String s=in.getText();if(toSms)for(var e:sms.entrySet())s=s.replaceAll("(?i)\\b"+java.util.regex.Pattern.quote(e.getKey())+"\\b",e.getValue());else for(var e:sms.entrySet())s=s.replaceAll("(?i)\\b"+java.util.regex.Pattern.quote(e.getValue())+"\\b",e.getKey());out.setText(s);}
    public static void main(String[]z){new SMSLanguage().setVisible(true);}
}
