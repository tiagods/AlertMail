package br.com.tiago.view;

import br.com.tiago.controller.ControllerPrincipal;
import br.com.tiago.model.Model;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;
/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
/**
 *
 * @author Tiago Dias
 * Historico de Versao
 * 1.0.0 - Projeto entregue
 * 1.0.1 - Melhoria nas mensagens e criação de tabela no html
 * 1.0.2 - Melhoria no codigo do controller
 * 1.0.3 - Melhoria no codigo do arquivo de configurações e inserindo nome no Relatorio
 * 1.0.4 - Metodo que não permite envio se o dia for feriado e remover classes extras 
 * 1.1.0 - Migrado para o hibernate
 */
public class MenuView extends javax.swing.JFrame {

    MaskFormatter formatoHora;
    
    Model model;
    ControllerPrincipal controle;
    
    SimpleDateFormat sdh = new SimpleDateFormat("HH:mm:ss");
    
    int conta_segundos=0, conta_minutos=0, conta_horas=0, conta_dias;//conta o tempo de execucao
    
    String hora, horaAlerta;
    
    public MenuView() {
        initComponents();
        //txtHora.setText(calendar.getHora());
        
        try{
            String lookandfeel ="com.birosoft.liquid.LiquidLookAndFeel";
            UIManager.setLookAndFeel(lookandfeel);
            SwingUtilities.updateComponentTreeUI(this);
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){
            System.out.println("Documentos: \n"+e);
        }
        
        ControllerPrincipal controller = new ControllerPrincipal();
        controller.iniciarDiretorios();
        iniciarThread();
        btnDocumentacao.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        timer_hora = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDocumentacao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        try{

            formatoHora = new MaskFormatter("##:##");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao converter data: \n"+e);
        }
        txtHora = new JFormattedTextField(formatoHora);
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensagem = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAlerta = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        btnStop = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        txtHoraNow = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContador = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        timer_hora.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer_horaOnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alerta de Emails");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Desenvolvido por: Tiago Dias / www.github.com/tiagods");

        btnDocumentacao.setText("Documentação");

        jLabel2.setText("Modificar tempo (hora do alerta):");

        jLabel3.setText("Obs: Por default o valor é 10:00.");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setToolTipText("O horário informado aqui será o horário usado para envio de alertas");

        txtMensagem.setColumns(20);
        txtMensagem.setLineWrap(true);
        txtMensagem.setRows(5);
        jScrollPane1.setViewportView(txtMensagem);
        txtMensagem.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AlertMail");

        jLabel5.setText("Status:");

        txtAlerta.setBackground(new java.awt.Color(0, 0, 0));
        txtAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAlerta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtStatus.setBackground(new java.awt.Color(255, 255, 255));
        txtStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtStatus.setOpaque(true);

        btnStop.setText("Parar");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnAlterar.setText("Aplicar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txtHoraNow.setBackground(new java.awt.Color(0, 0, 0));
        txtHoraNow.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("versão 1.0.4");

        txtContador.setBackground(new java.awt.Color(0, 0, 0));
        txtContador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiago/utilitarios/robot.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(btnDocumentacao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoraNow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtHoraNow, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDocumentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        iniciarThread();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        
        conta_segundos++;
        if(conta_segundos>=59){

            if(conta_segundos==60){
                conta_segundos=0;
                conta_minutos+=1;
            }
            if(conta_minutos==60){
                conta_minutos=0;
                conta_horas+=1;
            }
            if(conta_horas==60){
                conta_horas=0;
                conta_dias+=1;
            }
        }
        String valorSegundos, valorMinutos, valorHoras, valorDias;
        if(conta_segundos>=0 && conta_segundos<=9)
            valorSegundos = "0"+conta_segundos;
        else
            valorSegundos = ""+conta_segundos;
        if(conta_minutos>=0 && conta_minutos<=9)
            valorMinutos = "0"+conta_minutos;
        else
            valorMinutos = ""+conta_minutos;
        if(conta_horas>=0 && conta_horas<=9)
            valorHoras = "0"+conta_horas;
        else
            valorHoras = ""+conta_horas;
        if(conta_minutos>=0 && conta_minutos<=9)
            valorMinutos = "0"+conta_minutos;
        else
            valorMinutos = ""+conta_minutos;
        if(conta_dias>0)
            valorDias = ""+conta_dias+" dias, ";
        else
            valorDias="";

        
        txtContador.setText("Total em execução = "+valorDias+valorHoras+":"+valorMinutos+":"+valorSegundos);
        //String aux = txtMensagem.getText();
        //txtMensagem.setText(aux+"\n"+hora+"\tContando execução: "+conta_horas+":"+conta_minutos+":"+conta_segundos);
    }//GEN-LAST:event_timer1OnTime

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        String escolha = ("Deseja realmente interromper o serviço?");
        int acao = JOptionPane.showConfirmDialog(null, escolha,"Atenção", JOptionPane.YES_NO_OPTION);
        if(acao==JOptionPane.YES_OPTION){
            interromperThread();
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        interromperThread();
        ControllerPrincipal cont = new ControllerPrincipal();
        cont.alterarHora(txtHora.getText());
        iniciarThread();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void timer_horaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer_horaOnTime
        Date horaAgora = new Date();
        hora = sdh.format(horaAgora);
        
        txtHoraNow.setText(hora);
        
        if(hora.equals(horaAlerta)==true){
            ControllerPrincipal inicia = new ControllerPrincipal();
            inicia.tratandoAlerta();
        }       
        
    }//GEN-LAST:event_timer_horaOnTime

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String aviso = "Tem certeza que deseja encerrar o serviço?";
        int escolha = JOptionPane.showConfirmDialog(null, aviso, "Atenção!", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.YES_OPTION) {
            controle = new ControllerPrincipal();
            controle.gerarLog("Sistema sendo encerrado!");
            System.exit(0);
        } else {
            repaint();
        }
    }//GEN-LAST:event_formWindowClosing

    private void iniciarThread(){
        model = new Model();
        controle = new ControllerPrincipal();
        controle.lerConfig(model);
        horaAlerta = model.getHoraAlerta();
        
        if(horaAlerta.length()==8){
            txtHora.setText(horaAlerta);
            txtStatus.setText("Ativo");
            txtStatus.setBackground(Color.green);
            
            int time=1000;

            timer1.setDelay(time);
            timer_hora.setDelay(time);

            timer1.start();
            timer_hora.start();

            conta_segundos=0;
            conta_minutos=0;
            conta_segundos=0;

            model.setMensagem("Serviço iniciado!");
        }
        else
            model.setMensagem("Serviço não iniciado!");
    }
    public void interromperThread(){
        timer1.stop();
        txtStatus.setText("Inativo");
        txtStatus.setBackground(Color.red);
        controle = new ControllerPrincipal();
        controle.gerarLog("Serviço interrompido!");
    }
    
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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDocumentacao;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    private org.netbeans.examples.lib.timerbean.Timer timer_hora;
    public static javax.swing.JLabel txtAlerta;
    public static javax.swing.JLabel txtContador;
    public static javax.swing.JFormattedTextField txtHora;
    public static javax.swing.JLabel txtHoraNow;
    public static javax.swing.JTextArea txtMensagem;
    public static javax.swing.JLabel txtStatus;
    // End of variables declaration//GEN-END:variables
 
}
