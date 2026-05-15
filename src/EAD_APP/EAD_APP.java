package EAD_APP;

import javax.swing.SwingUtilities;

public class EAD_APP {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UITheme.setup();
            new LoginPage().setVisible(true);
        });
    }
}