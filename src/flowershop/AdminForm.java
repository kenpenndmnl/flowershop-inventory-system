/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowershop;


import com.itextpdf.text.BaseColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.proteanit.sql.DbUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;



/**
 *
 * @author Earl
 */
public class AdminForm extends javax.swing.JFrame {

    AddBouquetDialog addBouquet = new AddBouquetDialog(this,true);
    AddBouquetDialog updateBouquet = new AddBouquetDialog(this,true);
    AddBouquetDialog deleteBouquet = new AddBouquetDialog(this,true);
    EmployeeDialog addEmployee = new EmployeeDialog(this,true);
    EmployeeDialog updateEmployee = new EmployeeDialog(this,true);
    EmployeeDialog deleteEmployee = new EmployeeDialog(this,true);
    int bouquetId;
    String bouquetName;
    String bouquetDesc;
    int bouquetQuantity;
    float bouquetPrice;
    int bouquetMinq;
    String bouquetStatus;
    //AddCustomerDialog
    String customerName;
    String address;
    int mobile;
    //getting current month 
    Date dateForHome = new Date();
    SimpleDateFormat dt = new SimpleDateFormat("MM");
    String setDate = dt.format(dateForHome);
      
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop", "root", "root");
    /**
     * Creates new form AdminForm
     * @throws java.sql.SQLException
     */
    public AdminForm() throws SQLException {        
        initComponents();
        try {
            setIconImage(ImageIO.read(new File("images/flower.png")));
        } catch (IOException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Manager - Flower Bouquet Management System");
        addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
                int result = confirmLogOut();
                if(result == 0){
                    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                    LoginForm login = new LoginForm();
                    login.setVisible(true);
                }
            }

            private int confirmLogOut() {
                int input = JOptionPane.showConfirmDialog(null, "Do you want to Log Out?", "Logout", JOptionPane.YES_NO_OPTION);
                return input;
            }
        });
        scaling();
        homeContents();
        ChangeListener changelistener = new ChangeListener()
        {
            //int i;
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane jTabbedPane1 = (JTabbedPane) changeEvent.getSource();
                int index = jTabbedPane1.getSelectedIndex();
                if("Bouquet".equals(jTabbedPane1.getTitleAt(index)))
                {
                        try {
                            bouquetScalingImages();
                            display();
                            next_ID();
                            //i++;
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                }
                if("Orders".equals(jTabbedPane1.getTitleAt(index)))
                {

                    try {
                        orderScalingImages();
                        orderSectionDisplay();
                        //i++;
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                    }       
                }
                if("Employees".equals(jTabbedPane1.getTitleAt(index)))
                {
                    Date date = new Date();
                    addEmployee.bDateChooser.setDate(date);
                    employeeScalingImages();
                    employee_nextId();
                    try {
                        employeeSectionDisplay();
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        jTabbedPane1.addChangeListener(changelistener);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        imgLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        thirdPanelLabel = new javax.swing.JLabel();
        homeBouquetPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        homeLabel4 = new javax.swing.JLabel();
        homeLabel2 = new javax.swing.JLabel();
        homeBouquetPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        homeLabel5 = new javax.swing.JLabel();
        homeLabel1 = new javax.swing.JLabel();
        homeBouquetPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        homeLabel6 = new javax.swing.JLabel();
        homeLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        homeDateLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        searchTF = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bouquetLabel1 = new javax.swing.JLabel();
        numbouquet = new javax.swing.JLabel();
        totalquantity = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        searchTFOrders = new javax.swing.JTextField();
        orderLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        EmployeeSearchTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addEmployeeButton = new javax.swing.JButton();
        updateEmployeeButton = new javax.swing.JButton();
        deleteEmployeeButton = new javax.swing.JButton();
        exportEmployeeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        totalEmployeesLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        employeeLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        empMonthButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        empMonthButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        accountm = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        logOutMenuItem = new javax.swing.JMenuItem();
        flowerm = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        orderm = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        imgLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel1.setMaximumSize(new java.awt.Dimension(910, 867));
        imgLabel1.setMinimumSize(new java.awt.Dimension(910, 867));
        imgLabel1.setName(""); // NOI18N
        imgLabel1.setPreferredSize(new java.awt.Dimension(910, 867));

        jLabel7.setFont(new java.awt.Font("Lucida Calligraphy", 0, 36)); // NOI18N
        jLabel7.setText("Hello, ");

        nameLabel.setFont(new java.awt.Font("Lucida Calligraphy", 0, 36)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText(" ");

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 4, true));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thirdPanelLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thirdPanelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        homeBouquetPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 4, true));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Bouquet");

        homeLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        homeLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel2.setText("     ");

        javax.swing.GroupLayout homeBouquetPanel2Layout = new javax.swing.GroupLayout(homeBouquetPanel2);
        homeBouquetPanel2.setLayout(homeBouquetPanel2Layout);
        homeBouquetPanel2Layout.setHorizontalGroup(
            homeBouquetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeBouquetPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(homeBouquetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeBouquetPanel2Layout.createSequentialGroup()
                        .addComponent(homeLabel4)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeBouquetPanel2Layout.createSequentialGroup()
                        .addGroup(homeBouquetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(homeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(34, 34, 34))))
        );
        homeBouquetPanel2Layout.setVerticalGroup(
            homeBouquetPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBouquetPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeLabel4)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        homeBouquetPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 4, true));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Employees");

        homeLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        homeLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel1.setText("   ");

        javax.swing.GroupLayout homeBouquetPanel3Layout = new javax.swing.GroupLayout(homeBouquetPanel3);
        homeBouquetPanel3.setLayout(homeBouquetPanel3Layout);
        homeBouquetPanel3Layout.setHorizontalGroup(
            homeBouquetPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBouquetPanel3Layout.createSequentialGroup()
                .addGroup(homeBouquetPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeBouquetPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(homeBouquetPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(homeBouquetPanel3Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(homeLabel5))))
                    .addGroup(homeBouquetPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12)))
                .addGap(28, 28, 28))
        );
        homeBouquetPanel3Layout.setVerticalGroup(
            homeBouquetPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBouquetPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeLabel1)
                .addGap(13, 13, 13)
                .addComponent(homeLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        homeBouquetPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 4, true));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Orders");

        homeLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        homeLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeLabel3.setText("   ");

        javax.swing.GroupLayout homeBouquetPanel4Layout = new javax.swing.GroupLayout(homeBouquetPanel4);
        homeBouquetPanel4.setLayout(homeBouquetPanel4Layout);
        homeBouquetPanel4Layout.setHorizontalGroup(
            homeBouquetPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBouquetPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(homeBouquetPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(homeBouquetPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(homeLabel6))
                    .addComponent(jLabel13))
                .addGap(38, 38, 38))
        );
        homeBouquetPanel4Layout.setVerticalGroup(
            homeBouquetPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeBouquetPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(homeLabel3)
                .addGap(13, 13, 13)
                .addComponent(homeLabel6)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Records as of");

        homeDateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        homeDateLabel.setForeground(new java.awt.Color(255, 102, 102));
        homeDateLabel.setText("    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(homeBouquetPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(homeBouquetPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(homeBouquetPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(35, 35, 35)
                        .addComponent(homeBouquetPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(homeBouquetPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(homeBouquetPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeDateLabel)
                    .addComponent(jLabel8))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(imgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Description", "Quantity", "Price", "Min. Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(10);
        }
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        jTable2.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

        //JTableHeader header = jTable2.getTableHeader();
        //header.setBackground(Color.BLACK);
        //jTable2.getTableHeader().setForeground(Color.WHITE);
        jTable2.setSelectionBackground(Color.PINK);
        jTable2.setSelectionForeground(Color.BLACK);

        searchTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(255, 102, 102));
        addButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        ImageIcon addIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\plus.png");
        //scaling image
        java.awt.Image imgAdd = addIcon.getImage();
        java.awt.Image imgAddScale = imgAdd.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledAddIcon = new ImageIcon(imgAddScale);
        addButton.setIcon(scaledAddIcon);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(255, 102, 102));
        updateButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        ImageIcon editIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\edit.png");
        //scaling image
        java.awt.Image imgEdit = editIcon.getImage();
        java.awt.Image imgEditScale = imgEdit.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledEditIcon = new ImageIcon(imgEditScale);
        updateButton.setIcon(scaledEditIcon);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        ImageIcon delIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\trash.png");
        //scaling image
        java.awt.Image imgDel = delIcon.getImage();
        java.awt.Image imgDelScale = imgDel.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledDelIcon = new ImageIcon(imgDelScale);
        deleteButton.setIcon(scaledDelIcon);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        exportButton.setBackground(new java.awt.Color(255, 102, 102));
        exportButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exportButton.setForeground(new java.awt.Color(255, 255, 255));
        exportButton.setText("Export List as PDF");
        ImageIcon exportIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\export.png");
        //scaling image
        java.awt.Image imgExport = exportIcon.getImage();
        java.awt.Image imgExportScale = imgExport.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledExportIcon = new ImageIcon(imgExportScale);
        exportButton.setIcon(scaledExportIcon);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Bouquet List:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Current bunches:");

        bouquetLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bouquetLabel1.setText(" ");

        numbouquet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numbouquet.setForeground(new java.awt.Color(255, 102, 102));
        numbouquet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numbouquet.setText("   ");

        totalquantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalquantity.setForeground(new java.awt.Color(255, 102, 102));
        totalquantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalquantity.setText("    ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(bouquetLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numbouquet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(exportButton))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bouquetLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(numbouquet)
                    .addComponent(totalquantity)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addButton.setToolTipText("Add Bouquet");

        jTabbedPane1.addTab("Bouquet", jPanel2);

        orderTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer's Name", "Collected by:", "Date Ordered", "Date to be Received", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
            orderTable.getColumnModel().getColumn(2).setResizable(false);
            orderTable.getColumnModel().getColumn(3).setResizable(false);
            orderTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            orderTable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchTFOrders.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFOrdersKeyReleased(evt);
            }
        });

        orderLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        orderLabel1.setText("   ");

        jButton8.setBackground(new java.awt.Color(255, 102, 102));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Export List as PDF");
        ImageIcon exportIcon2 = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\export.png");
        //scaling image
        java.awt.Image imgExport2 = exportIcon2.getImage();
        java.awt.Image imgExportScale2 = imgExport2.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledExportIcon2 = new ImageIcon(imgExportScale2);
        jButton8.setIcon(scaledExportIcon2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Orders this Month:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(orderLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTFOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTFOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jTabbedPane1.addTab("Orders", jPanel3);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Contact Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(employeeTable);
        if (employeeTable.getColumnModel().getColumnCount() > 0) {
            employeeTable.getColumnModel().getColumn(0).setResizable(false);
            employeeTable.getColumnModel().getColumn(1).setResizable(false);
            employeeTable.getColumnModel().getColumn(2).setResizable(false);
        }

        EmployeeSearchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmployeeSearchTFKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Employee of the Month");

        addEmployeeButton.setBackground(new java.awt.Color(255, 102, 102));
        addEmployeeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        addEmployeeButton.setText("Add");
        ImageIcon addEmpIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\plus.png");
        //scaling image
        java.awt.Image imgAddEmp = addEmpIcon.getImage();
        java.awt.Image imgAddEmpScale = imgAddEmp.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledAddEmpIcon = new ImageIcon(imgAddEmpScale);
        addEmployeeButton.setIcon(scaledAddEmpIcon);
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        updateEmployeeButton.setBackground(new java.awt.Color(255, 102, 102));
        updateEmployeeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        updateEmployeeButton.setText("Update");
        ImageIcon editEmpIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\edit.png");
        //scaling image
        java.awt.Image imgEditEmp = editEmpIcon.getImage();
        java.awt.Image imgEditEmpScale = imgEditEmp.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledEditEmpIcon = new ImageIcon(imgEditEmpScale);
        updateEmployeeButton.setIcon(scaledEditEmpIcon);
        updateEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeButtonActionPerformed(evt);
            }
        });

        deleteEmployeeButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteEmployeeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmployeeButton.setText("Delete");
        ImageIcon delEmpIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\trash.png");
        //scaling image
        java.awt.Image imgDelEmp = delEmpIcon.getImage();
        java.awt.Image imgDelEmpScale = imgDelEmp.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledDelEmpIcon = new ImageIcon(imgDelEmpScale);
        deleteEmployeeButton.setIcon(scaledDelEmpIcon);
        deleteEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeButtonActionPerformed(evt);
            }
        });

        exportEmployeeButton.setBackground(new java.awt.Color(255, 102, 102));
        exportEmployeeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exportEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        exportEmployeeButton.setText("Export to PDF");
        ImageIcon exportEmpIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\export.png");
        //scaling image
        java.awt.Image imgExportEmp = exportEmpIcon.getImage();
        java.awt.Image imgExportEmpScale = imgExportEmp.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledExportEmpIcon = new ImageIcon(imgExportEmpScale);
        exportEmployeeButton.setIcon(scaledExportEmpIcon);
        exportEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportEmployeeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total Employees:");

        totalEmployeesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalEmployeesLabel.setForeground(new java.awt.Color(255, 102, 102));
        totalEmployeesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        employeeLabel1.setText("   ");

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));

        empMonthButton1.setBackground(new java.awt.Color(255, 102, 51));
        empMonthButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        empMonthButton1.setForeground(new java.awt.Color(255, 255, 255));
        empMonthButton1.setText("jButton1");

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 2));

        empMonthButton2.setBackground(new java.awt.Color(255, 102, 51));
        empMonthButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        empMonthButton2.setForeground(new java.awt.Color(255, 255, 255));
        empMonthButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportEmployeeButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(employeeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmployeeSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalEmployeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6)
                            .addComponent(empMonthButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(empMonthButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empMonthButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(empMonthButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EmployeeSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(employeeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalEmployeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Employees", jPanel4);

        jMenuBar1.setForeground(new java.awt.Color(204, 0, 204));

        accountm.setText("Accounts");

        jMenuItem2.setText("Change Username");
        accountm.add(jMenuItem2);

        jMenuItem3.setText("Change Password");
        accountm.add(jMenuItem3);
        accountm.add(jSeparator1);

        logOutMenuItem.setText("Log Out");
        logOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutMenuItemActionPerformed(evt);
            }
        });
        accountm.add(logOutMenuItem);

        jMenuBar1.add(accountm);

        flowerm.setText("Flowers");

        jMenuItem1.setText("Export List of Flowers");
        flowerm.add(jMenuItem1);

        jMenuBar1.add(flowerm);

        orderm.setText("Orders");
        jMenuBar1.add(orderm);

        jMenu1.setText("About");

        jMenuItem5.setText("Version 1.0");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    //--------------------HOME SECTION
    public void scaling()
    {
        ImageIcon icon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\homeFlower.png");
        //scaling image to fit in jlabel
        java.awt.Image img = icon.getImage();
        java.awt.Image imgscale = img.getScaledInstance(imgLabel1.getWidth(), imgLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgscale);
        imgLabel1.setIcon(scaledIcon);
        
        ImageIcon icon2 = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\homeBouquet1.png");
        java.awt.Image img2 = icon2.getImage();
        java.awt.Image imgscale2 = img2.getScaledInstance(thirdPanelLabel.getWidth(), thirdPanelLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgscale2);
        thirdPanelLabel.setIcon(scaledIcon2);
    }
    
    public void homeContents()
    {
        LoginForm nameGet = new LoginForm();
        nameLabel.setText(nameGet.getFirstName() + '!');
        SimpleDateFormat dt2 = new SimpleDateFormat("MMMM yyyy");
        String setDate2 = dt2.format(dateForHome);
        
        
        String empNum = null, bouquetNum = null, orderNum = null; 
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT COUNT(*) FROM users a WHERE user_type_id = 2";
            Statement stmt, stmt2, stmt3;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);;
            if(rs.next())
                empNum = rs.getString(1);
            
            stmt2 = con.createStatement();
            rs = stmt2.executeQuery("SELECT COUNT(*) from flowers WHERE notes IS NULL");
            if(rs.next())
                bouquetNum = rs.getString(1);
            
            stmt3 = con.createStatement();
            rs = stmt3.executeQuery("SELECT COUNT(*) FROM orders WHERE date_to_be_received LIKE '_____"+setDate+"%'");
            if(rs.next())
                orderNum = rs.getString(1);
            
            homeLabel1.setText(empNum);
            homeLabel2.setText(bouquetNum);
            homeLabel3.setText(orderNum);
            homeDateLabel.setText(setDate2);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------------------BOUQUET SECTION- MANAGER
    
    private void bouquetScalingImages()
    {
        ImageIcon searchIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\search.png");
        //scaling image to fit into jlabel
        java.awt.Image imgSearch = searchIcon.getImage();
        java.awt.Image imgSearchScale = imgSearch.getScaledInstance(bouquetLabel1.getWidth(), bouquetLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        bouquetLabel1.setIcon(scaledSearchIcon);
        
        
    }
    
    private void logOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMenuItemActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_logOutMenuItemActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed

        try {
            String fname = "C:\\Users\\Dell\\Documents\\Second Year\\flower_files\\FlowerList.pdf";

            //cretae document object
            Document doc = new Document();
            //get pdfwriter instance
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(fname));
            
            doc.open();
            //add content
            
            //Header head = new Header("Flower Bouquet Management System");
            //Paragraph para = new Paragraph("Flowers List");
            try {
                
                PdfTemplate t;
                Image total;
                t = writer.getDirectContent().createTemplate(30, 16);
                total = Image.getInstance(t);
                total.setRole(PdfName.ARTIFACT);
                PdfPTable header = new PdfPTable(2);
                
                //header--------------------------------------------------------
                // set defaults
                header.setWidths(new int[]{2, 24});
                header.setTotalWidth(527);
                header.setLockedWidth(true);
                header.getDefaultCell().setFixedHeight(40);
                header.getDefaultCell().setBorder(Rectangle.BOTTOM);
                header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

                // add image
                Image logo = Image.getInstance("images/flower.png");
                header.addCell(logo);

                // add text
                PdfPCell text = new PdfPCell();
                text.setPaddingBottom(15);
                text.setPaddingLeft(10);
                text.setBorder(Rectangle.BOTTOM);
                text.setBorderColor(BaseColor.LIGHT_GRAY);
                text.addElement(new Phrase("Flower Bouquet Management System", new Font(Font.FontFamily.HELVETICA, 12)));
                text.addElement(new Phrase("A Flower Inventory Application", new Font(Font.FontFamily.HELVETICA, 8)));
                header.addCell(text);

                // write content
                //header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
                //doc.add(header);
                doc.add(header);
                //footer--------------------------------------------------------
                /*PdfPTable footer = new PdfPTable(3);
                // set defaults
                footer.setWidths(new int[]{24, 2, 1});
                footer.setTotalWidth(527);
                footer.setLockedWidth(true);
                footer.getDefaultCell().setFixedHeight(40);
                footer.getDefaultCell().setBorder(Rectangle.TOP);
                footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

                // add copyright
                //footer.addCell(new Phrase("\u00A9 FBMS", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

                // add current page count
                footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

                // add placeholder for total page count
                PdfPCell totalPageCount = new PdfPCell(total);
                totalPageCount.setBorder(Rectangle.TOP);
                totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
                footer.addCell(totalPageCount);

                // write page
                PdfContentByte canvas = writer.getDirectContent();
                canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
                footer.writeSelectedRows(0, -1, 34, 50, canvas);
                canvas.endMarkedContentSequence();
                    
                int totalLength = String.valueOf(writer.getPageNumber()).length();
                int totalWidth = totalLength * 5;
                ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
                    new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
                    totalWidth, 6, 0); */
            
            } catch(DocumentException | IOException de) {
                throw new ExceptionConverter(de);
            }
            

            //body----------------------------------------------------------
            //open document
            Date date = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("MMM dd, yyyy");
            Paragraph setDate = new Paragraph(dt.format(date));
            setDate.setAlignment(Element.ALIGN_RIGHT);
            Paragraph title = new Paragraph("List of Bouquet", new Font(Font.FontFamily.HELVETICA,14));
            title.setAlignment(Element.ALIGN_CENTER);
            //title.setFont(FontFactory.getFont(FontFactory.HELVETICA,18));

            //create Pdf table object with no. of columns required
            PdfPTable mainTable = new PdfPTable(7);
            mainTable.setWidthPercentage(98);
            mainTable.setSpacingBefore(10);
            mainTable.setWidths(new int[]{120,320,350,200,250,220,200});
            PdfPCell header_code = new PdfPCell(new Phrase(""));
            PdfPCell header_name = new PdfPCell(new Phrase("Name", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            PdfPCell header_desc = new PdfPCell(new Phrase("Description", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            PdfPCell header_qty = new PdfPCell(new Phrase("Qty", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            PdfPCell header_price = new PdfPCell(new Phrase("Price", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            PdfPCell header_minq = new PdfPCell(new Phrase("Min. Qty", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            PdfPCell header_status = new PdfPCell(new Phrase("Status", new Font(Font.FontFamily.HELVETICA,12, Font.BOLD)));
            header_code.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_name.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_desc.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_qty.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_price.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_minq.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_status.setHorizontalAlignment(Element.ALIGN_CENTER);

            mainTable.addCell(header_code).setVerticalAlignment(Element.ALIGN_TOP);
            mainTable.addCell(header_name).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_desc).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_qty).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_price).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_minq).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_status).setVerticalAlignment(Element.ALIGN_MIDDLE);
            try {
                PdfPCell c1,c2,c3,c4,c5,c6,c7;
                System.out.println("Connected Successfully");
                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs;
                rs=stmt.executeQuery("SELECT * FROM flowers WHERE notes IS NULL");
                while(rs.next())
                {
                    c1 = new PdfPCell(new Paragraph(rs.getString(1)));
                    c2 = new PdfPCell(new Paragraph(rs.getString(2)));
                    c3 = new PdfPCell(new Paragraph(rs.getString(3)));
                    c4 = new PdfPCell(new Paragraph(rs.getString(4)));
                    c5 = new PdfPCell(new Paragraph(Currency.getInstance("PHP") + " "+ rs.getString(5)));
                    c6 = new PdfPCell(new Paragraph(rs.getString(6)));
                    c7 = new PdfPCell(new Paragraph(rs.getString(7)));
                    mainTable.addCell(c1).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c2).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c3).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c4).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c5).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c6).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c7).setHorizontalAlignment(Element.ALIGN_CENTER);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            doc.add(setDate);
            doc.add(title);
            doc.add(mainTable);
            JOptionPane.showMessageDialog(null, "PDF file saved in 'flower_files' folder.");
            doc.close();

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_exportButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        deleteBouquet.setTitle("Delete Bouquet");
        deleteBouquet.getAddSaveBouquet().setText("Delete"); //button
        deleteBouquet.getDeleteLabel().setText("Do you really want to delete this record?");
        deleteBouquet.bouquetNameTF.setEditable(false);
        deleteBouquet.description.setEditable(false);
        deleteBouquet.comboBox.setEnabled(false);
        deleteBouquet.qty.setEnabled(false);
        deleteBouquet.bouquetPriceTF.setEditable(false);
        deleteBouquet.bouquetMinqTF.setEditable(false);

        if(jTable2.getSelectedRowCount() == 1)
        deleteBouquet.setVisible(true);
        else if(jTable2.getSelectedRowCount() == 0)
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "Table is empty.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Select a row first.");
            }
        }
        clear();
        next_ID();
        try {
            display();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        updateBouquet.setTitle("Update Bouquet");
        updateBouquet.getAddSaveBouquet().setText("Update"); //button

        if(jTable2.getSelectedRowCount() == 1)
        {
            updateBouquet.setVisible(true);
        }
        else if(jTable2.getSelectedRowCount() == 0)
        {
            if(jTable2.getRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "Table is empty.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Select a row first.");
            }
        }
        clear();
        next_ID();
        try {
            display();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addBouquet.setTitle("Add Bouquet");
        addBouquet.getAddSaveBouquet().setText("Add");
        addBouquet.setVisible(true);
        clear();
        next_ID();
        try {
            display();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased

        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        String forSearch = searchTF.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        jTable2.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + forSearch));
    }//GEN-LAST:event_searchTFKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        updateBouquet.bouquetCodeTF.setText(model.getValueAt(index,0).toString());
        updateBouquet.bouquetNameTF.setText(model.getValueAt(index,1).toString());
        updateBouquet.description.setText(model.getValueAt(index,2).toString());
        updateBouquet.qty.setValue(model.getValueAt(index,3));
        updateBouquet.bouquetPriceTF.setText(model.getValueAt(index,4).toString());
        updateBouquet.bouquetMinqTF.setText(model.getValueAt(index,5).toString());
        updateBouquet.comboBox.setSelectedItem(model.getValueAt(index,6));

        deleteBouquet.bouquetCodeTF.setText(model.getValueAt(index,0).toString());
        deleteBouquet.bouquetNameTF.setText(model.getValueAt(index,1).toString());
        deleteBouquet.description.setText(model.getValueAt(index,2).toString());
        deleteBouquet.qty.setValue(model.getValueAt(index,3));
        deleteBouquet.bouquetPriceTF.setText(model.getValueAt(index,4).toString());
        deleteBouquet.bouquetMinqTF.setText(model.getValueAt(index,5).toString());
        deleteBouquet.comboBox.setSelectedItem(model.getValueAt(index,6));
    }//GEN-LAST:event_jTable2MouseClicked

    private void searchTFOrdersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFOrdersKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
        String forSearchOrders = searchTFOrders.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        orderTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + forSearchOrders));
    }//GEN-LAST:event_searchTFOrdersKeyReleased

    private void EmployeeSearchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchTFKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        String forSearchEmployees = EmployeeSearchTF.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<> (model);
        employeeTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + forSearchEmployees));
    }//GEN-LAST:event_EmployeeSearchTFKeyReleased

    private void updateEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmployeeButtonActionPerformed
        // TODO add your handling code here:
        updateEmployee.setTitle("Update Employee");
        updateEmployee.getEmployeeApproveButton().setText("Update");
        if(employeeTable.getSelectedRowCount() == 1)
            updateEmployee.setVisible(true);
        else if(employeeTable.getSelectedRowCount() == 0)
        {
            if(employeeTable.getRowCount() == 0)
                JOptionPane.showMessageDialog(null, "Table is empty.");
            else
                JOptionPane.showMessageDialog(null, "Select a row first.");
        }
        employeeDialogClear();
        try {
            employeeSectionDisplay();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateEmployeeButtonActionPerformed

    private void exportEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportEmployeeButtonActionPerformed
        try
        {
            String fname = "C:\\Users\\Dell\\Documents\\Second Year\\flower_files\\EmployeeList.pdf";
            //create document object
            Document doc = new Document();
            //get pdfwriter instance
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(fname));
            
            doc.open();
            //add content
            try
            {
                PdfTemplate t;
                Image total;
                t = writer.getDirectContent().createTemplate(30,16);
                total = Image.getInstance(t);
                total.setRole(PdfName.ARTIFACT);
                PdfPTable header = new PdfPTable(2);
                
                //header--------------------------------------------------------
                //set defaults
                header.setWidths(new int[]{2,24});
                header.setTotalWidth(527);
                header.setLockedWidth(true);
                header.getDefaultCell().setFixedHeight(40);
                header.getDefaultCell().setBorder(Rectangle.BOTTOM);
                header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
                
                //add image
                Image logo = Image.getInstance("images/flower.png");
                header.addCell(logo);
                
                //add text
                PdfPCell text = new PdfPCell();
                text.setPaddingBottom(15);
                text.setPaddingLeft(10);
                text.setBorder(Rectangle.BOTTOM);
                text.setBorderColor(BaseColor.LIGHT_GRAY);
                text.addElement(new Phrase("Flower Bouquet Management System", new Font(Font.FontFamily.HELVETICA, 12)));
                text.addElement(new Phrase("A Flower Inventory Application", new Font(Font.FontFamily.HELVETICA, 8)));
                header.addCell(text);
                
                //write content
                doc.add(header);
            }
            catch(DocumentException | IOException de)
            {
                throw new ExceptionConverter(de);
            }
            
            //body--------------------------------------------------------------
            Date date = new Date();
            SimpleDateFormat dt = new SimpleDateFormat("MMM dd, yyyy");
            Paragraph setDate = new Paragraph(dt.format(date));
            setDate.setAlignment(Element.ALIGN_RIGHT);
            Paragraph title = new Paragraph("List of Employees", new Font(Font.FontFamily.HELVETICA, 14));
            title.setAlignment(Element.ALIGN_CENTER);
            
            //create Pdf table object with no. of columns required
            PdfPTable mainTable = new PdfPTable(4);
            mainTable.setWidthPercentage(98);
            mainTable.setSpacingBefore(10);
            mainTable.setWidths(new int[]{500, 500, 200, 450});
            PdfPCell header_lname = new PdfPCell(new Phrase("Last Name", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            PdfPCell header_fname = new PdfPCell(new Phrase("First Name", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            PdfPCell header_sex = new PdfPCell(new Phrase("Sex", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            PdfPCell header_contact = new PdfPCell(new Phrase("Contact Number", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
            header_lname.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_fname.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_sex.setHorizontalAlignment(Element.ALIGN_CENTER);
            header_contact.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            mainTable.addCell(header_lname).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_fname).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_sex).setVerticalAlignment(Element.ALIGN_MIDDLE);
            mainTable.addCell(header_contact).setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Paragraph para_totalEmp = null;
            
            try
            {
                PdfPCell c1,c2,c3,c4;
                int total_emp = 0;
                System.out.println("Connected Successfully");
                Statement stmt, stmt2;
                stmt = con.createStatement();
                ResultSet rs;
                rs = stmt.executeQuery("SELECT last_name, first_name, sex, contact_number "
                        + "FROM users WHERE user_type_id = 2");
                while(rs.next())
                {
                    //total_emp = rs.getInt(1);
                    c1 = new PdfPCell(new Paragraph(rs.getString(1)));
                    c2 = new PdfPCell(new Paragraph(rs.getString(2)));
                    c3 = new PdfPCell(new Paragraph(rs.getString(3)));
                    c4 = new PdfPCell(new Paragraph(rs.getString(4)));
                    mainTable.addCell(c1).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c2).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c3).setHorizontalAlignment(Element.ALIGN_CENTER);
                    mainTable.addCell(c4).setHorizontalAlignment(Element.ALIGN_CENTER);
                }
                
                stmt2 = con.createStatement();
                rs = stmt2.executeQuery("SELECT COUNT(*) FROM users WHERE user_type_id = 2");
                while(rs.next())
                {
                    total_emp = rs.getInt(1);
                }
                para_totalEmp = new Paragraph("* " + total_emp + " employees in the list.", new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
                para_totalEmp.setAlignment(Element.ALIGN_RIGHT);
            } 
            catch (SQLException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            doc.add(setDate);
            doc.add(title);
            doc.add(mainTable);
            doc.add(para_totalEmp);
            JOptionPane.showMessageDialog(null, "PDF file saved in 'flower_files' folder.");
            doc.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_exportEmployeeButtonActionPerformed

    private void deleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeButtonActionPerformed
        // TODO add your handling code here:
        deleteEmployee.setTitle("Delete Employee Record");
        deleteEmployee.getEmpDeleteLabel().setText("Do you really want to delete this record?");
        deleteEmployee.getEmployeeApproveButton().setText("Delete");
        deleteEmployee.employeeFNTF.setEditable(false);
        deleteEmployee.employeeLNTF.setEditable(false);
        deleteEmployee.bDateChooser.setEnabled(false);
        deleteEmployee.maleRadioButton.setEnabled(false);
        deleteEmployee.femaleRadioButton.setEnabled(false);
        deleteEmployee.contactNoTF.setEditable(false);
        if(employeeTable.getSelectedRowCount() == 1)
            deleteEmployee.setVisible(true);
        else if(employeeTable.getSelectedRowCount() == 0)
        {
            if(employeeTable.getRowCount() == 0)
                JOptionPane.showMessageDialog(null, "Table is empty.");
            else
                JOptionPane.showMessageDialog(null, "Select a row first.");
        }
        employeeDialogClear();
        try {
            employeeSectionDisplay();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteEmployeeButtonActionPerformed

    private void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButtonActionPerformed
        // TODO add your handling code here:
        addEmployee.setTitle("Add Employee");
        addEmployee.getEmployeeApproveButton().setText("Add");
        addEmployee.setVisible(true);
        Date date = new Date();
        addEmployee.bDateChooser.setDate(date);
        employee_nextId();
        try {
            employeeSectionDisplay();
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addEmployeeButtonActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        int index = employeeTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
        int empId = 0;
        String empsex = "";
        Date empbdate = null;
        
        String empFName = model.getValueAt(index, 0).toString();
        String empLName = model.getValueAt(index, 1).toString();
        String empContactNo = model.getValueAt(index, 2).toString();
        
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT id, birth_date, sex "
                + "FROM users WHERE first_name = '"+empFName+"' AND last_name = '"+empLName+"' "
                + "AND contact_number = '"+empContactNo+"'";
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                empId = rs.getInt(1);
                empbdate = rs.getDate(2);
                empsex = rs.getString(3);
            }
            System.out.println(empbdate);
            System.out.println(empsex);
            //String editEmpbdate = bdateFormat.format(empbdate);
            //SimpleDateFormat bdateFormat = new SimpleDateFormat("MM/dd/yyyy");
            //String stringBdate = empbdate.toString();
            //String editEmpbdate = bdateFormat.format(stringBdate.replace("-", "/"));
            //Date dt = new SimpleDateFormat("yyyy/MM/dd").parse(editEmpbdate);
            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(empbdate));
            updateEmployee.employeeCodeTF.setText(String.valueOf(empId));
            updateEmployee.employeeLNTF.setText(empLName);
            updateEmployee.employeeFNTF.setText(empFName);
            updateEmployee.bDateChooser.setDate(dt); 
            if("M".equals(empsex))
            {
                updateEmployee.maleRadioButton.setSelected(true);
                updateEmployee.femaleRadioButton.setSelected(false);
            }
            else
            {
                updateEmployee.femaleRadioButton.setSelected(true);
                updateEmployee.maleRadioButton.setSelected(false);
            }
            updateEmployee.contactNoTF.setText(empContactNo);
            
            deleteEmployee.employeeCodeTF.setText(String.valueOf(empId));
            deleteEmployee.employeeLNTF.setText(empLName);
            deleteEmployee.employeeFNTF.setText(empFName);
            deleteEmployee.bDateChooser.setDate(dt); 
            if("M".equals(empsex))
            {
                deleteEmployee.maleRadioButton.setSelected(true);
                deleteEmployee.femaleRadioButton.setSelected(false);
            }
            else
            {
                deleteEmployee.femaleRadioButton.setSelected(true);
                deleteEmployee.maleRadioButton.setSelected(false);
            }
            deleteEmployee.contactNoTF.setText(empContactNo);
            
            
        } catch (ClassNotFoundException | SQLException | ParseException  ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_employeeTableMouseClicked

    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    public void updateSaveBouquetExt(int bouquetId, String bouquetName, String bouquetDesc, int bouquetQuantity,
            float bouquetPrice, int bouquetMinq, String bouquetStatus)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "UPDATE flowers SET flower_name = ?, flower_description = ?, "
                    + "quantity = ?, flowers_price = ?, minimum_quantity = ?, status = ?"
                    + " WHERE id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setString(1, bouquetName);
            pst.setString(2, bouquetDesc);
            pst.setInt(3, bouquetQuantity);
            pst.setFloat(4, bouquetPrice);
            pst.setInt(5, bouquetMinq);
            pst.setString(6, bouquetStatus);
            pst.setInt(7, bouquetId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bouquet updated successfully."); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void addSaveBouquetExt(int bouquetId, String bouquetName, String bouquetDesc, int bouquetQuantity,
            float bouquetPrice, int bouquetMinq, String bouquetStatus)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "INSERT INTO flowers(id, flower_name, flower_description, "
                    + "quantity, flowers_price, minimum_quantity, status)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(query);

            pst.setInt(1, bouquetId);
            pst.setString(2, bouquetName);
            pst.setString(3, bouquetDesc);
            pst.setInt(4, bouquetQuantity);
            pst.setFloat(5, bouquetPrice);
            pst.setInt(6, bouquetMinq);
            pst.setString(7, bouquetStatus);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bouquet added successfully.");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void display() throws SQLException
    {
        jTable2.setAutoCreateColumnsFromModel(false);
        jTable2.setAutoCreateRowSorter(true);
        System.out.println("Connected Successfully");
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs;
        rs=stmt.executeQuery("SELECT * FROM flowers WHERE notes IS NULL");
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    private void next_ID()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT max(id)+1 FROM flowers";
            PreparedStatement pst, pst2;
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int nextId = 0, totalbouquet = 0, totalminq = 0;
            while(rs.next())
            {
                nextId = rs.getInt(1);
            }
            
            String query2 = "SELECT count(*), SUM(minimum_quantity) FROM flowers WHERE notes IS NULL";
            pst2 = con.prepareStatement(query2);
            rs = pst2.executeQuery();
            while(rs.next())
            {
                totalbouquet = rs.getInt(1);
                totalminq = rs.getInt(2);
            }
            addBouquet.bouquetCodeTF.setText(String.valueOf(nextId));
            numbouquet.setText(String.valueOf(totalbouquet));
            totalquantity.setText(String.valueOf(totalminq));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void clear()
    {
        addBouquet.bouquetNameTF.setText("");
        addBouquet.bouquetPriceTF.setText("");
        addBouquet.bouquetMinqTF.setText("");
        addBouquet.description.setText("");
        addBouquet.qty.setValue(0);
        addBouquet.bouquetNameTF.setText("");
    }
           
    public void deleteSaveBouquetExt(int bouquetId)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "UPDATE flowers SET notes = 'deleted' WHERE id = ?"; 
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setInt(1, bouquetId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bouquet deleted successfully.");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //--------------------ORDER SECTION- MANAGER
    private void orderScalingImages()
    {
        ImageIcon searchOrderIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\search.png");
        //scaling image
        java.awt.Image imgSearchOrder = searchOrderIcon.getImage();
        java.awt.Image imgSearchOrderScale = imgSearchOrder.getScaledInstance(orderLabel1.getWidth(), orderLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledSearchOrderIcon = new ImageIcon(imgSearchOrderScale);
        orderLabel1.setIcon(scaledSearchOrderIcon);
    }
    
    public void orderSectionDisplay() throws SQLException
    {
        //DefaultTableModel orderModel = (DefaultTableModel) orderTable.getModel();
        orderTable.setAutoCreateColumnsFromModel(false);
        orderTable.setAutoCreateRowSorter(true);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT a.customer_name, CONCAT(b.first_name, ' ', b.last_name), "
                    + "a.date_ordered, a.date_to_be_received, c.delivery_status_name "
                    + "FROM orders a INNER JOIN users b INNER JOIN delivery_status c WHERE "
                    + "a.user_id = b.id AND a.delivery_status_id = c.id AND a.date_ordered LIKE '_____"+setDate+"%'";
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            orderTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //--------------------EMPLOYEE SECTION- MANAGER
    private void employeeScalingImages()
    {
        ImageIcon searchEmpIcon = new ImageIcon("C:\\Users\\Dell\\Documents\\Second Year\\NetBeansProjects\\FlowerShop\\images\\search.png");
        //scaling image
        java.awt.Image imgSearchEmp = searchEmpIcon.getImage();
        java.awt.Image imgSearchEmpScale = imgSearchEmp.getScaledInstance(employeeLabel1.getWidth(), employeeLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledSearchEmpIcon = new ImageIcon(imgSearchEmpScale);
        employeeLabel1.setIcon(scaledSearchEmpIcon);
    }
    
    public void employeeSectionDisplay() throws SQLException
    {
        employeeTable.setAutoCreateColumnsFromModel(false);
        employeeTable.setAutoCreateRowSorter(true);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT first_name, last_name, contact_number FROM users "
                    + "WHERE user_type_id = 2";
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            employeeTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void employee_nextId()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "SELECT max(id)+1 FROM users";
            PreparedStatement pst, pst2;
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int nextId = 0, totalEmployee = 0;
            if(rs.next())
            {
                nextId = rs.getInt(1);
            }
            
            String query2 = "SELECT count(*) FROM users WHERE user_type_id != 3 AND user_type_id != 1";
            pst2 = con.prepareStatement(query2);
            rs = pst2.executeQuery();
            if(rs.next())
            {
                totalEmployee = rs.getInt(1);
            }
                            
            addEmployee.employeeCodeTF.setText(String.valueOf(nextId));
            totalEmployeesLabel.setText(String.valueOf(totalEmployee));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void employeeDialogClear()
    {
        addEmployee.employeeLNTF.setText("");
        addEmployee.employeeFNTF.setText("");
        addEmployee.maleRadioButton.setSelected(false);
        addEmployee.femaleRadioButton.setSelected(false);
        addEmployee.contactNoTF.setText("");
    }
    
    public void addEmployeeExt(int emp_id, String emp_last, String emp_first, String emp_sex, String emp_bdate, String emp_contact)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "INSERT INTO users(id, last_name, first_name, sex, birth_date, contact_number, username, pwd, "
                    + "user_type_id) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            
            pst.setInt(1, emp_id);
            pst.setString(2, emp_last);
            pst.setString(3, emp_first);
            pst.setString(4, emp_sex);
            pst.setString(5, emp_bdate);
            pst.setString(6, emp_contact);
            
            String subDate = emp_bdate.substring(8);
            String employee_usernamePass = emp_first + subDate;
            
            pst.setString(7, employee_usernamePass);
            pst.setString(8, employee_usernamePass);
            pst.setInt(9, 2);
            
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Username: " + employee_usernamePass + "\nPassword: " + employee_usernamePass);
            System.out.println("Employee added successfully");
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //employeeTableMouseClicked ----- FOR UPDATE EMPLOYEE
    public void updateEmployeeExt(int emp_id, String emp_last, String emp_first, String emp_sex, String emp_bdate, String emp_contact)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "UPDATE users SET last_name = ?, first_name = ?, sex = ?, birth_date = ?, "
                    + "contact_number = ? WHERE id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            
            pst.setString(1, emp_last);
            pst.setString(2, emp_first);
            pst.setString(3, emp_sex);
            pst.setString(4, emp_bdate);
            pst.setString(5, emp_contact);
            pst.setInt(6, emp_id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee record edited successfully.");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteEmployeeExt(int emp_id)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected Successfully");
            String query = "UPDATE users SET user_type_id = 3 WHERE id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            
            pst.setInt(1, emp_id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Employee record deleted successfully.");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmployeeSearchTF;
    private javax.swing.JMenu accountm;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JLabel bouquetLabel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteEmployeeButton;
    private javax.swing.JButton empMonthButton1;
    private javax.swing.JButton empMonthButton2;
    private javax.swing.JLabel employeeLabel1;
    private javax.swing.JTable employeeTable;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton exportEmployeeButton;
    private javax.swing.JMenu flowerm;
    private javax.swing.JPanel homeBouquetPanel2;
    private javax.swing.JPanel homeBouquetPanel3;
    private javax.swing.JPanel homeBouquetPanel4;
    private javax.swing.JLabel homeDateLabel;
    private javax.swing.JLabel homeLabel1;
    private javax.swing.JLabel homeLabel2;
    private javax.swing.JLabel homeLabel3;
    private javax.swing.JLabel homeLabel4;
    private javax.swing.JLabel homeLabel5;
    private javax.swing.JLabel homeLabel6;
    private javax.swing.JLabel imgLabel1;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable2;
    private javax.swing.JMenuItem logOutMenuItem;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel numbouquet;
    private javax.swing.JLabel orderLabel1;
    public javax.swing.JTable orderTable;
    private javax.swing.JMenu orderm;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField searchTFOrders;
    private javax.swing.JLabel thirdPanelLabel;
    private javax.swing.JLabel totalEmployeesLabel;
    private javax.swing.JLabel totalquantity;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateEmployeeButton;
    // End of variables declaration//GEN-END:variables

}
