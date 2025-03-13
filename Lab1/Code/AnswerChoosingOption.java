import javax.swing.JOptionPane;
public class AnswerChoosingOption{
    public static void main(String[] args){
        Object[] options = {"I do", "I don’t"}; 

        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (option == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "You've chosen: I do");
        }else if (option == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "You've chosen: I don’t");
        }
        System.exit(0);
    }
}
