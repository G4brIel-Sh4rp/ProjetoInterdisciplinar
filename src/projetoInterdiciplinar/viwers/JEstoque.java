package projetoInterdiciplinar.viwers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import  projetoInterdiciplinar.controler.Estoque;
import  projetoInterdiciplinar.entities.Celulares;
import java.text.*;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class JEstoque extends javax.swing.JFrame {
    private Estoque etqCell = new Estoque("produtos.csv");
    DecimalFormat df = new DecimalFormat("#,###.00");
    SimpleDateFormat formatarData = new SimpleDateFormat("MMM/yyyy");
    
    public JEstoque() {
        initComponents();
        iniciar();
        addRowTblCelulares(etqCell.listar());
        tblCelulares.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblCelulares.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblCelulares.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblCelulares.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblCelulares.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblCelulares.getColumnModel().getColumn(5).setPreferredWidth(120);
        //Set-Visiveis
        comboBoxMarcas.setVisible(false);
        SpinnerId.setVisible(false);
        btnBusca.setVisible(false);
        spinnerAnoMin.setVisible(false);
        spinnerAnoMax.setVisible(false);
        spinnerPrecoMin.setVisible(false);
        spinnerPrecoMax.setVisible(false);
        lblEntre.setVisible(false);
        btnSalvar.setVisible(false);
  
        
        
        for (int i = 0; i < etqCell.getMarcas().length; i++) {
            comboBoxMarcas.addItem(etqCell.getMarcas()[i]);
        }
        Calendar c = Calendar.getInstance();
        int anoAtual = c.get(Calendar.YEAR);
        SpinnerModel sMin = new SpinnerNumberModel(anoAtual,2000,anoAtual,1);
        spinnerAnoMin.setModel(sMin);
        int anoMin = (int) spinnerAnoMin.getValue();
        SpinnerModel sMax = new SpinnerNumberModel(anoAtual,anoMin,anoAtual+1,1);
        spinnerAnoMax.setModel(sMax);
        float precoMin = (float) spinnerPrecoMin.getValue();
        SpinnerModel sPrecoMax = new SpinnerNumberModel(precoMin+200,precoMin,50000,100);
        spinnerPrecoMax.setModel(sPrecoMax);
    }
    public void addRowTblCelulares(ArrayList lista){
        
        DefaultTableModel modelo = (DefaultTableModel) tblCelulares.getModel();
        ArrayList<Celulares> list = lista;
                          
        Object rowData[] = new Object[6];
        
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getNome();
            rowData[2] = list.get(i).getMarca();
            rowData[3] = list.get(i).getQnt();
            rowData[4] = "R$  "+ df.format(list.get(i).getPreco());
            rowData[5] = formatarData.format(list.get(i).getLancamento());
            modelo.addRow(rowData);
            
        }  
    }
    private void limpaTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tblCelulares.getModel();
            if (modelo.getRowCount() > 0){
                int n =  modelo.getRowCount();
                for (int i=0;i<n;i++){
                    modelo.removeRow(0);
                }            
        }
    }
    private void limpaTudo(){
        limpaTabela();
        txtBoxId.setText("-");
        txtBoxModelo.setText("-");
        txtBoxMarca.setText("-");
        txtBoxPreco.setText("-");
        txtBoxLancamento.setText("-");
        txtBoxQntd.setText("-");
        txtBoxQntdMin.setText("-");
        txtBoxValorTotal.setText("-");
        addRowTblCelulares(etqCell.listar());
        btnSalvar.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCelulares = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SpinnerId = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnBusca = new javax.swing.JButton();
        comboBoxMarcas = new javax.swing.JComboBox<>();
        spinnerAnoMin = new javax.swing.JSpinner();
        spinnerAnoMax = new javax.swing.JSpinner();
        lblEntre = new javax.swing.JLabel();
        spinnerPrecoMin = new javax.swing.JSpinner();
        spinnerPrecoMax = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBoxId = new javax.swing.JTextField();
        txtBoxModelo = new javax.swing.JTextField();
        txtBoxMarca = new javax.swing.JTextField();
        txtBoxQntdMin = new javax.swing.JTextField();
        txtBoxPreco = new javax.swing.JTextField();
        txtBoxLancamento = new javax.swing.JTextField();
        txtBoxQntd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBoxValorTotal = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        panelAddSubtract = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnSubtract = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
        setMinimumSize(new java.awt.Dimension(400, 250));
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        tblCelulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Modelo", "Marca", "Quantidade", "Preco", "Lançamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCelulares.setGridColor(new java.awt.Color(255, 255, 255));
        tblCelulares.setOpaque(false);
        tblCelulares.setRowHeight(20);
        tblCelulares.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblCelulares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCelularesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCelulares);
        tblCelulares.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 67, 590, 450);

        jLabel1.setText("Buscar Por:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 16, 70, 30);

        SpinnerId.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        SpinnerId.setToolTipText("Id");
        getContentPane().add(SpinnerId);
        SpinnerId.setBounds(410, 20, 70, 25);

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Marca", "Preço", "Data de Lançamento" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(100, 20, 160, 25);

        btnBusca.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/LupaIcon1-2.png"))); // NOI18N
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBusca);
        btnBusca.setBounds(500, 20, 40, 25);

        comboBoxMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxMarcas);
        comboBoxMarcas.setBounds(360, 20, 120, 25);

        spinnerAnoMin.setToolTipText("");
        spinnerAnoMin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerAnoMinStateChanged(evt);
            }
        });
        getContentPane().add(spinnerAnoMin);
        spinnerAnoMin.setBounds(310, 20, 70, 25);

        spinnerAnoMax.setToolTipText("");
        spinnerAnoMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerAnoMaxStateChanged(evt);
            }
        });
        getContentPane().add(spinnerAnoMax);
        spinnerAnoMax.setBounds(410, 20, 70, 25);

        lblEntre.setText("  até");
        getContentPane().add(lblEntre);
        lblEntre.setBounds(380, 20, 30, 30);

        spinnerPrecoMin.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1000.0f), Float.valueOf(100.0f), Float.valueOf(50000.0f), Float.valueOf(100.0f)));
        spinnerPrecoMin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerPrecoMinStateChanged(evt);
            }
        });
        getContentPane().add(spinnerPrecoMin);
        spinnerPrecoMin.setBounds(310, 20, 70, 25);

        spinnerPrecoMax.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1000.0f), Float.valueOf(100.0f), Float.valueOf(50000.0f), Float.valueOf(100.0f)));
        getContentPane().add(spinnerPrecoMax);
        spinnerPrecoMax.setBounds(410, 20, 70, 25);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Qntd. Mínima");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Quantidade");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Lançamento");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Preço");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Marca");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Modelo");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("ID");

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel3.setText("  DADOS DO PRODUTO");

        txtBoxId.setEditable(false);
        txtBoxId.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxId.setText("-");
        txtBoxId.setToolTipText("");

        txtBoxModelo.setEditable(false);
        txtBoxModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxModelo.setText("-");
        txtBoxModelo.setToolTipText("");

        txtBoxMarca.setEditable(false);
        txtBoxMarca.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxMarca.setText("-");
        txtBoxMarca.setToolTipText("");
        txtBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxMarcaActionPerformed(evt);
            }
        });

        txtBoxQntdMin.setEditable(false);
        txtBoxQntdMin.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxQntdMin.setText("-");
        txtBoxQntdMin.setToolTipText("");
        txtBoxQntdMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxQntdMinActionPerformed(evt);
            }
        });

        txtBoxPreco.setEditable(false);
        txtBoxPreco.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxPreco.setText("-");
        txtBoxPreco.setToolTipText("");
        txtBoxPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxPrecoActionPerformed(evt);
            }
        });

        txtBoxLancamento.setEditable(false);
        txtBoxLancamento.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxLancamento.setText("-");
        txtBoxLancamento.setToolTipText("");
        txtBoxLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxLancamentoActionPerformed(evt);
            }
        });

        txtBoxQntd.setEditable(false);
        txtBoxQntd.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxQntd.setText("-");
        txtBoxQntd.setToolTipText("");
        txtBoxQntd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxQntdActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Valor Total");

        txtBoxValorTotal.setEditable(false);
        txtBoxValorTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtBoxValorTotal.setText("-");
        txtBoxValorTotal.setToolTipText("");
        txtBoxValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoxValorTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBoxQntdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoxLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBoxQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoxValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxQntdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoxQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(600, 10, 290, 350);

        btnLimpar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/RestartIcon.png"))); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(610, 470, 60, 50);

        btnAdd.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        btnAdd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAdd.setText("+");
        btnAdd.setToolTipText("");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSubtract.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        btnSubtract.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSubtract.setText("-");
        btnSubtract.setToolTipText("");
        btnSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubtractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddSubtractLayout = new javax.swing.GroupLayout(panelAddSubtract);
        panelAddSubtract.setLayout(panelAddSubtractLayout);
        panelAddSubtractLayout.setHorizontalGroup(
            panelAddSubtractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddSubtractLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(37, 37, 37))
        );
        panelAddSubtractLayout.setVerticalGroup(
            panelAddSubtractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddSubtractLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAddSubtractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSubtract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelAddSubtract);
        panelAddSubtract.setBounds(650, 380, 210, 50);

        btnSalvar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focus"));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoInterdiciplinar/viwers/imagem/save.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(730, 470, 60, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String aux = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        switch (aux) {
            case "Id":
                    btnBusca.setVisible(true);
                    SpinnerId.setVisible(true);
                    comboBoxMarcas.setVisible(false);
                    spinnerAnoMin.setVisible(false);
                    spinnerAnoMax.setVisible(false);
                    spinnerPrecoMin.setVisible(false);
                    spinnerPrecoMax.setVisible(false);
                    lblEntre.setVisible(false);                    
                break;
            case "Marca":
                    btnBusca.setVisible(true);
                    SpinnerId.setVisible(false);
                    comboBoxMarcas.setVisible(true);
                    spinnerAnoMin.setVisible(false);
                    spinnerAnoMax.setVisible(false);
                    spinnerPrecoMin.setVisible(false);
                    spinnerPrecoMax.setVisible(false);
                    lblEntre.setVisible(false);
                break;
            case "Preço":
                    btnBusca.setVisible(true);
                    SpinnerId.setVisible(false);
                    comboBoxMarcas.setVisible(false);
                    spinnerAnoMin.setVisible(false);
                    spinnerAnoMax.setVisible(false);
                    spinnerPrecoMin.setVisible(true);
                    spinnerPrecoMax.setVisible(true);
                    lblEntre.setVisible(true);
                    break;
            default:
                    btnBusca.setVisible(true);
                    SpinnerId.setVisible(false);
                    comboBoxMarcas.setVisible(false);
                    spinnerAnoMin.setVisible(true);
                    spinnerAnoMax.setVisible(true);
                    spinnerPrecoMin.setVisible(false);
                    spinnerPrecoMax.setVisible(false);
                    lblEntre.setVisible(true);
                break;                  
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void comboBoxMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMarcasActionPerformed
        
    }//GEN-LAST:event_comboBoxMarcasActionPerformed

    private void spinnerAnoMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerAnoMaxStateChanged
        
    }//GEN-LAST:event_spinnerAnoMaxStateChanged

    private void spinnerAnoMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerAnoMinStateChanged
        Calendar c = Calendar.getInstance();
        int anoAtual = c.get(Calendar.YEAR);
        int anoMin = (int) spinnerAnoMin.getValue();
        SpinnerModel sMax = new SpinnerNumberModel(anoMin,anoMin,anoAtual+1,1);
        spinnerAnoMax.setModel(sMax);
    }//GEN-LAST:event_spinnerAnoMinStateChanged

    private void spinnerPrecoMinStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerPrecoMinStateChanged
        float precoMin = (float) spinnerPrecoMin.getValue();
        SpinnerModel sPrecoMax = new SpinnerNumberModel(precoMin+200,precoMin,50000,100);
        spinnerPrecoMax.setModel(sPrecoMax);
    }//GEN-LAST:event_spinnerPrecoMinStateChanged

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        String aux = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        switch (aux) {
            case "Id":
                    limpaTabela();
                    int id = (int) SpinnerId.getValue();
                    Celulares c = etqCell.getProduto(id);
                    txtBoxId.setText(Integer.toString(c.getId()));
                    txtBoxModelo.setText(c.getNome());
                    txtBoxMarca.setText(c.getMarca());
                    txtBoxPreco.setText(df.format(c.getPreco()));
                    txtBoxLancamento.setText(formatarData.format(c.getLancamento()));
                    txtBoxQntd.setText(Integer.toString(c.getQnt()));
                    txtBoxQntdMin.setText(Integer.toString(c.getQntMin()));
                break;
            case "Marca":
                String marca = (String) comboBoxMarcas.getSelectedItem();
                limpaTabela();
                addRowTblCelulares(etqCell.listar(marca));
                break;
            case "Preço":
                    float pMin = (float)spinnerPrecoMin.getValue();
                    double xMax = (double) spinnerPrecoMax.getValue();
                    float pMax = (float) xMax;
                    limpaTabela();
                    addRowTblCelulares(etqCell.listar(pMin,pMax));
                    break;
            default:
                    int dMin = (int) spinnerAnoMin.getValue();
                    int dMax = (int) spinnerAnoMax.getValue();
                    limpaTabela();
                    addRowTblCelulares(etqCell.listar(dMin,dMax));
                break;                  
        }
       
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void txtBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxMarcaActionPerformed

    private void txtBoxQntdMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxQntdMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxQntdMinActionPerformed

    private void txtBoxPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxPrecoActionPerformed

    private void txtBoxLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxLancamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxLancamentoActionPerformed

    private void txtBoxQntdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxQntdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxQntdActionPerformed

    private void tblCelularesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCelularesMouseClicked
        int k = tblCelulares.getSelectedRow();
        int id = (int) tblCelulares.getValueAt(k, 0);
        Celulares c = etqCell.getProduto(id);
        txtBoxId.setText(Integer.toString(c.getId()));
        txtBoxModelo.setText(c.getNome());
        txtBoxMarca.setText(c.getMarca());
        txtBoxPreco.setText("R$ "+df.format(c.getPreco()));
        txtBoxLancamento.setText(formatarData.format(c.getLancamento()));
        txtBoxQntd.setText(Integer.toString(c.getQnt()));
        txtBoxQntdMin.setText(Integer.toString(c.getQntMin()));
        txtBoxValorTotal.setText("R$ "+ df.format(c.valorTotal()));
    }//GEN-LAST:event_tblCelularesMouseClicked
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaTudo();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtBoxValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoxValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoxValorTotalActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try{
            int qtd = Integer.parseInt(txtBoxQntd.getText());
            qtd++;
            txtBoxQntd.setText(Integer.toString(qtd));
            btnSalvar.setVisible(true);
        }
        catch (Exception c){
            JOptionPane.showMessageDialog(null,"Sem produto selecionado");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtractActionPerformed
        try{
            int qtd = Integer.parseInt(txtBoxQntd.getText());
            if(qtd>0){
            qtd--;
            txtBoxQntd.setText(Integer.toString(qtd));
            btnSalvar.setVisible(true);
            }
        }
        catch (Exception c){
            JOptionPane.showMessageDialog(null,"Sem produto selecionado");
        }
    }//GEN-LAST:event_btnSubtractActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

            int id = Integer.parseInt(txtBoxId.getText());
            Celulares c = etqCell.getProduto(id);
            int qtd = Integer.parseInt(txtBoxQntd.getText());
            c.setEstoque(qtd);
            etqCell.salvar();
            limpaTudo();
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void iniciar() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JEstoque().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerId;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSubtract;
    private javax.swing.JComboBox<String> comboBoxMarcas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntre;
    private javax.swing.JPanel panelAddSubtract;
    private javax.swing.JSpinner spinnerAnoMax;
    private javax.swing.JSpinner spinnerAnoMin;
    private javax.swing.JSpinner spinnerPrecoMax;
    private javax.swing.JSpinner spinnerPrecoMin;
    private javax.swing.JTable tblCelulares;
    private javax.swing.JTextField txtBoxId;
    private javax.swing.JTextField txtBoxLancamento;
    private javax.swing.JTextField txtBoxMarca;
    private javax.swing.JTextField txtBoxModelo;
    private javax.swing.JTextField txtBoxPreco;
    private javax.swing.JTextField txtBoxQntd;
    private javax.swing.JTextField txtBoxQntdMin;
    private javax.swing.JTextField txtBoxValorTotal;
    // End of variables declaration//GEN-END:variables
}
