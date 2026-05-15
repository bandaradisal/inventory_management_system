package EAD_APP;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.ColorUIResource;

public class UITheme {

    // Centralized Modern Color Palette
    public static final Color bgPrimary = new Color(245, 247, 250); // Very light grey blue
    public static final Color bgSecondary = new Color(255, 255, 255); // White panels
    public static final Color primaryColor = new Color(0, 114, 206); // Sleek Modern Blue
    public static final Color primaryHover = new Color(0, 89, 163); 
    public static final Color primaryText = new Color(33, 37, 41); // Dark Text
    public static final Color secondaryText = new Color(108, 117, 125); // Muted Text

    public static final Font headerFont = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font titleFont = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
    public static final Font regularFont = new Font("Segoe UI", Font.PLAIN, 14);

    public static void setup() {
        try {
            // Apply Nimbus Look and Feel as the base
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // Customize Nimbus defaults for a flatter, modern look
            UIManager.put("control", new ColorUIResource(bgPrimary)); // Global background
            UIManager.put("info", new ColorUIResource(242, 242, 242)); 
            UIManager.put("nimbusBase", new ColorUIResource(primaryColor)); // Controls blue hue
            UIManager.put("nimbusAlertYellow", new ColorUIResource(255, 220, 35));
            UIManager.put("nimbusDisabledText", new ColorUIResource(142, 143, 145));
            UIManager.put("nimbusFocus", new ColorUIResource(primaryColor));
            UIManager.put("nimbusGreen", new ColorUIResource(40, 167, 69));
            UIManager.put("nimbusInfoBlue", new ColorUIResource(23, 162, 184));
            UIManager.put("nimbusLightBackground", new ColorUIResource(bgSecondary));
            UIManager.put("nimbusOrange", new ColorUIResource(253, 126, 20));
            UIManager.put("nimbusRed", new ColorUIResource(220, 53, 69));
            UIManager.put("nimbusSelectedText", new ColorUIResource(255, 255, 255));
            UIManager.put("nimbusSelectionBackground", new ColorUIResource(primaryColor));
            UIManager.put("text", new ColorUIResource(primaryText));

            // Flatten borders and buttons
            UIManager.put("Button.arc", 10); 
            UIManager.put("Component.arc", 10);
            UIManager.put("ProgressBar.arc", 10);
            UIManager.put("TextComponent.arc", 10);

            // Table Modernization
            UIManager.put("Table.background", new ColorUIResource(Color.WHITE));
            UIManager.put("Table.alternateRowColor", new ColorUIResource(248, 249, 250));
            UIManager.put("Table.gridColor", new ColorUIResource(233, 236, 239));
            UIManager.put("TableHeader.background", new ColorUIResource(primaryColor));
            UIManager.put("TableHeader.foreground", new ColorUIResource(Color.WHITE));
            UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 14));
            UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 14));
            UIManager.put("Table.rowHeight", 35); // Better touch target and reading spacing

        } catch (Exception e) {
            System.err.println("Failed to initialize UI Theme: " + e.getMessage());
        }
    }

    // Helper method to style modern buttons universally
    public static void styleButton(JButton btn) {
        btn.setFont(labelFont);
        btn.setBackground(primaryColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Reduced to avoid word clipping
    }
    
    // Helper method to style toggle buttons used in nav
    public static void styleNavButton(JToggleButton btn) {
        btn.setFont(labelFont);
        btn.setBackground(bgSecondary);
        btn.setForeground(primaryText);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10)); // Reduced to avoid word clipping
    }

    // Helper to style panels
    public static void stylePanel(JPanel panel) {
        panel.setBackground(bgSecondary);
        // Remove old etched borders by giving them a clean soft line border or empty border
        panel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true));
    }
    
    // Adds a global icon to any frame
    public static void setupFrameIcon(JFrame frame) {
        try {
            java.net.URL imgURL = frame.getClass().getResource("/Image/logo_icon.png");
            if (imgURL != null) {
                frame.setIconImage(new javax.swing.ImageIcon(imgURL).getImage());
            }
        } catch (Exception e) {}
    }

    // Dynamically builds the navigation panel on any screen perfectly identical
    public static void buildNavPanel(JFrame frame, JPanel navPanel, boolean isHorizontal) {
        if (isHorizontal) {
            navPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0)); // 1 row, multiple columns
        } else {
            navPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 10)); // 1 column, multiple rows
        }
        navPanel.removeAll();
        
        String[] titles = {"HOME", "PRODUCTS", "CURRENT STOCK", "CUSTOMER", "SUPPLIER", "SALES", "FORECAST"};
        
        for (int i = 0; i < titles.length; i++) {
            javax.swing.JToggleButton btn = new javax.swing.JToggleButton(titles[i]);
            styleNavButton(btn);
            final int index = i;
            btn.addActionListener(e -> {
                try {
                    javax.swing.JFrame newFrame = null;
                    if (index == 0) newFrame = new Home();
                    else if (index == 1) newFrame = new Products();
                    else if (index == 2) newFrame = new CurrentStock();
                    else if (index == 3) newFrame = new Customer();
                    else if (index == 4) newFrame = new Supplier();
                    else if (index == 5) newFrame = new Sales();
                    else if (index == 6) newFrame = new DemandForecastFrame();
                    
                    if (newFrame != null) {
                        newFrame.setVisible(true);
                        frame.dispose();
                    }
                } catch (Exception ex) { ex.printStackTrace(); }
            });
            navPanel.add(btn);
        }
        navPanel.revalidate();
        navPanel.repaint();
    }
}
