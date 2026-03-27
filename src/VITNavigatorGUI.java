import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VITNavigatorGUI extends JFrame {
    private List<Course> courses;
    private DefaultTableModel tableModel;
    private JTable courseTable;
    private JTextField nameField, creditField;
    private JComboBox<String> gradeBox;

    public VITNavigatorGUI() {
        // Load existing data
        courses = FileManager.loadCourses();

        // Window Settings
        setTitle("VIT Bhopal Academic Navigator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // --- 1. Input Panel (Top) ---
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Course"));

        nameField = new JTextField();
        creditField = new JTextField();
        String[] grades = {"S", "A", "B", "C", "D", "E", "F"};
        gradeBox = new JComboBox<>(grades);
        JButton addButton = new JButton("Add Course");

        inputPanel.add(new JLabel(" Course Name:"));
        inputPanel.add(new JLabel(" Credits:"));
        inputPanel.add(new JLabel(" Grade:"));
        inputPanel.add(new JLabel("")); // Spacer
        inputPanel.add(nameField);
        inputPanel.add(creditField);
        inputPanel.add(gradeBox);
        inputPanel.add(addButton);

        // --- 2. Table Panel (Center) ---
        String[] columns = {"Course Name", "Credits", "Grade"};
        tableModel = new DefaultTableModel(columns, 0);
        courseTable = new JTable(tableModel);
        refreshTable();

        // --- 3. Bottom Panel (Actions & GPA) ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton calcButton = new JButton("Calculate GPA");
        JButton saveButton = new JButton("Save & Exit");
        JLabel gpaLabel = new JLabel("GPA: 0.00 ");
        gpaLabel.setFont(new Font("Arial", Font.BOLD, 16));

        bottomPanel.add(gpaLabel);
        bottomPanel.add(calcButton);
        bottomPanel.add(saveButton);

        // --- Button Logic ---
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int credits = Integer.parseInt(creditField.getText());
                String grade = (String) gradeBox.getSelectedItem();

                Course newCourse = new Course(name, credits, grade);
                courses.add(newCourse);
                refreshTable();

                // Clear fields
                nameField.setText("");
                creditField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid credits (number).");
            }
        });

        calcButton.addActionListener(e -> {
            double gpa = GPACalculator.calculateGPA(courses);
            gpaLabel.setText(String.format("GPA: %.2f ", gpa));
        });

        saveButton.addActionListener(e -> {
            FileManager.saveCourses(courses);
            System.exit(0);
        });

        // Add to Frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(courseTable), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Course c : courses) {
            tableModel.addRow(new Object[]{c.getCourseName(), c.getCredits(), c.getGrade()});
        }
    }

    public static void main(String[] args) {
        // Use a modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { e.printStackTrace(); }

        new VITNavigatorGUI();
    }
}