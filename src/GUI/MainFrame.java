/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.compData;
import Persistence.DataDB;
import java.awt.Color;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.exp;
import static java.lang.StrictMath.sin;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Pereira
 */
public class MainFrame extends javax.swing.JFrame {

    private double[] old_params; // radius, length, angle, default
    private double[] current_params; // radius, length, angle, default
    private double[] new_params; // radius, length, angle, default
    private int number_iterations;
    private boolean error;
    private compData data;
    private DataDB dataBase = new DataDB();
    private boolean first_run;

    public void transform_data_to_plot(double[][] data_from_db) {
        if (data_from_db.length != 0) {
            if (data_from_db[0].length == 5) {
                double[][] data_chart = new double[data_from_db.length][2];
                for (int i = 0; i < data_from_db.length; i++) {
                    data_chart[i][0] = data_from_db[i][0];
                    data_chart[i][1] = data_from_db[i][4];
                }
            }
        } else {
            System.err.println("Error: tranform_data_to_plot - wrong data given.");
        }
    }

    public void drawChart(double[][] data_chart) {
        XYSeries series = new XYSeries("XYGraph");
        for (double[] data_chart1 : data_chart) {
            series.add(data_chart1[0], data_chart1[1]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart("", "Iteration number", "Lift/Drag", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel CP = new ChartPanel(chart);
        chart_panel.setSize(100, 100);
        chart_panel.setLayout(new java.awt.BorderLayout());
        chart_panel.add(CP);
        chart_panel.setVisible(true);
        chart_panel.validate();

    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setBackground(Color.white);
        this.old_params = new double[4];
        this.current_params = new double[4];
        this.new_params = new double[4];
        this.first_run = true;
        this.error = false;
        double[][] arr = new double[3][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = i + 2;
        }
        drawChart(arr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        r_input = new javax.swing.JTextField();
        t_input = new javax.swing.JTextField();
        angle_input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chart_panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        n_iter = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        r_input.setText("1");
        r_input.setName("r_input"); // NOI18N

        t_input.setText("1");
        t_input.setName("t_input"); // NOI18N

        angle_input.setText("0.5");
        angle_input.setName("angle_input"); // NOI18N

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setText("Radius = ");

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setText("Length = ");

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setText("Angle = ");

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setText("meter(s)");

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setText("meter(s)");

        chart_panel.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout chart_panelLayout = new javax.swing.GroupLayout(chart_panel);
        chart_panel.setLayout(chart_panelLayout);
        chart_panelLayout.setHorizontalGroup(
            chart_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        chart_panelLayout.setVerticalGroup(
            chart_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/image.png"))); // NOI18N

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("radians");

        n_iter.setText("200");

        jLabel8.setText("iterations");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(angle_input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(n_iter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(chart_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {angle_input, n_iter, r_input, t_input});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(r_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(angle_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(n_iter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(chart_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public double lift(double r, double t, double theta) {
        double lift;
        double lift_coeff;

        lift_coeff = 1.01731 * exp(theta) - 1.01731;
        lift = lift_coeff * (5 * cos(theta) + 2 * r * sin(theta) * 2 * t * 1000 * 278 * 278 * 0.5);//We assume 5 meters wing width, 1000 g/m^3 air density, 1000 km/h = 278 m/s, all units are from the SI

        return lift;
    }

    public double drag(double r, double t, double theta) {
        double drag;
        double drag_coeff = 0.09; //Assuming Streamlined half-body shape for the wing

        drag = drag_coeff * 2 * r * t * 1000 * 278 * 278 * 0.5 / (cos(theta));
        return drag;
    }

    public double[] optimizer(double lift_drag, double old_lift_drag, double[] old_param, double[] current_param) {
        double[] new_param = new double[5];//param[0]=r, param[1]=t, param[2]=theta, param[3]= turns improving in a row, param[5]=parameter we are going to change i.e. if param[5]=1 that means that we are only increasing/decreasing param[1]
        double current_lift_drag;
        boolean improve;

        current_lift_drag = lift_drag;

        if (current_lift_drag >= old_lift_drag) {
            improve = true;
            new_param[3] = current_param[3] + 1;//total turns improving non-stop + 1
        } else {
            improve = false;
            new_param[3] = 0; //total turns improving non-stop is now 0 (this turn we didn't get a better result
        }

        if (improve == true) {
            for (int i = 0; i < 3; i++) {
                new_param[i] = current_param[i] + (current_param[i] - old_param[i]); //we need to create an old_param and a current_param when starting the code for the first time, the difference between old_param[i] and current_param[i] is the step size for each parameter.
            }
            if (new_param[2] > 0.52) { //if theta > 30 --> theta = 30 (30 degrees in radians = 0.52 aprox
                new_param[2] = 0.52;
            }
            if (new_param[2] < 0) { //if theta < 0 --> theta = 0
                new_param[2] = 0;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                new_param[i] = current_param[i] - (current_param[i] - old_param[i]);
            }
            if (new_param[2] > 0.52) { //if theta > 30 --> theta = 30 (30 degrees in radians = 0.52 aprox
                new_param[2] = 0.52;
            }
            if (new_param[2] < 0) { //if theta < 0 --> theta = 0
                new_param[2] = 0;
            }
        }
        return new_param;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double lift, drag, lift_drag, old_lift_drag = 0;

        this.current_params[0] = Double.parseDouble(r_input.getText());
        this.current_params[1] = Double.parseDouble(t_input.getText());
        this.current_params[2] = Double.parseDouble(angle_input.getText());
        this.current_params[3] = 0;

        // starts increasing
        this.old_params[0] = this.current_params[0] - 0.01; //starts increasing r with a step of 0.01
        this.old_params[1] = this.current_params[1] - 0.01; //starts increasing t with a step of 0.01
        this.old_params[2] = this.current_params[2] - 0.0001; //starts increasing theta with a step of 0.001
        this.old_params[3] = 0;
        this.number_iterations = Integer.parseInt(n_iter.getText());
        int i = 0;

        while (i < this.number_iterations) {

            lift = lift(this.current_params[0], this.current_params[1], this.current_params[2]);
            drag = drag(this.current_params[0], this.current_params[1], this.current_params[2]);
            if (lift < 0) {
                this.error = true;
            }
            if (drag <= 0) {
                this.error = true;
            }
            
            //TO DO: if error = true --> send error to GUI, don't do the optimizer step
            lift_drag = lift / drag;
            if (this.error == false) {
                this.new_params = optimizer(lift_drag, old_lift_drag, this.old_params, this.current_params);

                //TO DO: SAVE DATA lift_drag, new_param[0], new_param[1], new_param[2]
                data = new compData(i, new_params[0], new_params[1], new_params[2], lift_drag);
                try {
                    dataBase.createNewData(data);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                System.out.println("Lift: " + lift + "    Drag: " + drag + "   Lift/Drag: " + lift_drag);
                System.out.println("new_r: " + this.new_params[0] + "   new_t: " + this.new_params[1] + "   new_theta: " + this.new_params[2]);

                this.old_params = this.current_params;
                this.current_params = this.new_params;
            }

            if (!this.first_run) {
                this.r_input.setText(Double.toString(this.old_params[0]));
                this.t_input.setText(Double.toString(this.old_params[1]));
                this.angle_input.setText(Double.toString(this.old_params[2]));
            }

            this.first_run = false;
            
            i++;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField angle_input;
    private javax.swing.JPanel chart_panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField n_iter;
    private javax.swing.JTextField r_input;
    private javax.swing.JTextField t_input;
    // End of variables declaration//GEN-END:variables
}
