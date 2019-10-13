/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static javax.management.Query.lt;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Marta
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     * 
     * Los datos son
     * bbdd = deportes
     * usuario = root
     * password = ""
     */
    
    Conexiones gesConn;
    
    
    public Ventana() {
        initComponents();
        
        jDialog1.setVisible(true);
        jDialog1.setSize(900,600);
        jDialog1.setAlwaysOnTop(true);
        
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
    }
    
    //Método para guardar archivo utilizando un JFileChooser
    
//    private void guardaArchivo(){
//        FileOutputStream excelFos = null;
//        XSSFWorkbook excelJTableExport = null;
//        BufferedOutputStream excelBos = null;
//        
//        
//        
//                JFileChooser fc=new JFileChooser();
//               fc.setMultiSelectionEnabled(false); //Nos impide seleccionar más de un archivo.
//               fc.setDialogType(JFileChooser.OPEN_DIALOG);
//
//               int seleccion= fc.showSaveDialog(this);
//
//               if(seleccion==JFileChooser.APPROVE_OPTION){
//                 //Si llego aquí es que el usuario ha pulsado en guardar cuando ha salido el menú de jFileChooser.
//                 //Tenemos la opción de guardar el contenido sobre un fichero.
//                 File fichero= fc.getSelectedFile();
//                 String nombre= fichero.getName();
//                 //Necesitamos saber La extensión, para poder guardarlo y que no de error.
//                 String extension=nombre.substring(nombre.lastIndexOf('.')+1);
//
//                 if(extension.equalsIgnoreCase("xml")){
//                         System.out.println("Ha entrado");
//                        // gesDom.guardarDomComoFile(nombre);
//                         System.out.println(nombre);
//                 }
//               }
//        
//
//    }
    
    public void exportDataToExcel() {
 
        //First Download Apache POI Library For Dealing with excel files.
        //Then add the library to the current project
        FileOutputStream excelFos = null;
        XSSFWorkbook excelJTableExport = null;
        BufferedOutputStream excelBos = null;
        try {
 
            //Choosing Saving Location
            //Set default location to C:\Users\Authentic\Desktop or your preferred location
            JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Marta\\Documentos");
            //Dialog box title
            excelFileChooser.setDialogTitle("Save As ..");
            //Filter only xls, xlsx, xlsm files
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
            //Setting extension for selected file names
            excelFileChooser.setFileFilter(fnef);
            int chooser = excelFileChooser.showSaveDialog(null);
            //Check if save button has been clicked
            if (chooser == JFileChooser.APPROVE_OPTION) {
                //If button is clicked execute this code
                excelJTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExport.createSheet("Jtable Export");
                //Loop through the jtable columns and rows to get its values
                for (int i = 0; i < tablaPerros.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tablaPerros.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tablaPerros.getValueAt(i, j).toString()); 
                    }
                    
                    
                }
                //System.out.println(excelSheet.toString());
                excelFos = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBos = new BufferedOutputStream(excelFos);
                excelJTableExport.write(excelBos);
                excelFos.flush();
                excelBos.flush();
                JOptionPane.showMessageDialog(null, "Exported Successfully");
            }
 
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            
            try {
                if (excelFos != null) {
                    excelFos.close();
                }
                if (excelBos != null) {
                    excelBos.close();
                }
                if (excelJTableExport != null) {
                    excelJTableExport.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                System.out.println("Ex 2");
            }
        }
    } 


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaUser = new javax.swing.JTextField();
        cajaPass = new javax.swing.JTextField();
        cajaBBDD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPerros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cajaBuscaPerro = new javax.swing.JTextField();
        desplegable = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("CONECTAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("USUARIO;");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONTRASEÑA;");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BASE DE DATOS;");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cajaBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cajaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cajaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaPass, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPerros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPerros);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Cerrar Conexión");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("BUSCAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        desplegable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        desplegable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chip", "Nombre", "Afijo", "Raza", "Deporte", "Grado", "Sexo" }));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Exportar a Excel");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(desplegable, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cajaBuscaPerro, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(cajaBuscaPerro)
                    .addComponent(desplegable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        String bbdd= cajaBBDD.getText();
        String usuario= cajaUser.getText();
        String pass= cajaPass.getText();
        
        String parametroBBDD = "jdbc:mysql://localhost:3306/" + bbdd + "?serverTimezone=UTC";
        
        gesConn = new Conexiones(parametroBBDD,usuario,pass);
 
         jDialog1.setVisible(false);
         jPanel3.setVisible(true);
        
        
        
        
        System.out.println(gesConn);
        
       
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
       
       //Obtenemos el valor del desplegable y lo guardamos en una variable string.
       String cajaSeleccionada=(String) desplegable.getSelectedItem();     
       String opcion="%"+cajaBuscaPerro.getText()+"%"; //Obtenemos el texto de la caja de texto.
       String consulta=""; //Declaramos un string donde vamos a guardar la consulta que pasaremos como parámetro de entrada.
       
        //Si el textarea no está vacío, ejecutamos una consulta con prepared Statement.
        //Esto lo hacemos para que, en caso en que la caja esté vacía, nos haga un Select de toda la tabla y nos
        //saque los resultados por el jTable.
        if(!cajaBuscaPerro.getText().equals("")){
             if(cajaSeleccionada.equals("Chip")){
                 //Le cambiamos la opción (parámetro) a un valor absoluto para evitar problemas con la consulta equivalente. 
                 //Es decir, que si ponemos el chip 10 no nos salgan todos los que contengan un 1 o un 0.
                 opcion=cajaBuscaPerro.getText();
                 //Guardamos la consulta que vamos a pasar como parámetro de entrada en una variable String.
                 consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND chip= ?";
                 //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                  cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Nombre")){
                 consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND p.nombre LIKE ?";
                 //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Afijo")){
                 consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND afijo LIKE ?";
                 //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Raza")){
                  consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND raza LIKE ?";
                  //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Deporte")){
                  consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND deporte LIKE ?";
                  //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Grado")){
                  consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND grado LIKE ?";
                  //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }else if(cajaSeleccionada.equals("Sexo")){
                  consulta="SELECT * FROM perro p, propietario pr WHERE p.propietario=pr.DNI AND sexo LIKE ?";
                  //Ejecutamos la función y lo guardamos en la tabla.
                  tablaPerros.setModel(gesConn.consultaPerroPS(consulta, opcion));
                  //Reseteamos el textbox
                 cajaBuscaPerro.setText("");
             }
            
        }else{
            //Si nos encontramos con una cadena vacía en el textbox, ejecuta una consulta SELECT * y nos muestra todos los resultados
            //de la tabla en el jTable.
            tablaPerros.setModel(gesConn.consultaPerros());
        }
        
       
       
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        gesConn.cerrarConn();
        jDialog1.setVisible(true);
        jPanel3.setVisible(false);
        //Retornamos los valores de las cajas a su inicial.
        cajaUser.setText("");
        cajaPass.setText("");
        cajaBBDD.setText("");
        
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        //Exportar a EXCEL
        exportDataToExcel();
    }//GEN-LAST:event_jButton4MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaBBDD;
    private javax.swing.JTextField cajaBuscaPerro;
    private javax.swing.JTextField cajaPass;
    private javax.swing.JTextField cajaUser;
    private javax.swing.JComboBox<String> desplegable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPerros;
    // End of variables declaration//GEN-END:variables
}
