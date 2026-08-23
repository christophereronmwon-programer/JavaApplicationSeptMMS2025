package chapter14;
import javax.swing.*;import java.awt.*;import java.util.*;
public class HealthyRecipe extends JFrame {
    JTextArea recipe=new JTextArea(12,55),out=new JTextArea(12,55);
    Map<String,String> subs=Map.of("sour cream","yogurt","milk","soy milk","sugar","honey","butter","margarine","flour","rye or rice flour","mayonnaise","cottage cheese","white bread","whole-grain bread","egg","egg whites");
    public HealthyRecipe(){super("14.26 Cooking with Healthier Ingredients");out.setEditable(false);JButton b=new JButton("Suggest Replacements");b.addActionListener(e->suggest());
        add(new JScrollPane(recipe),BorderLayout.NORTH);add(new JScrollPane(out),BorderLayout.CENTER);add(b,BorderLayout.SOUTH);setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(700,550);setLocationRelativeTo(null);}
    void suggest(){String s=recipe.getText(),r=s.toLowerCase();StringBuilder x=new StringBuilder();for(var e:subs.entrySet())if(r.contains(e.getKey()))x.append(e.getKey()).append(" -> ").append(e.getValue()).append("\n");x.append("\nAlways consult your physician before making significant changes to your diet.");out.setText(x.toString());}
    public static void main(String[]z){new HealthyRecipe().setVisible(true);}
}
