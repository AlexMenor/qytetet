
package vistagraficaqytetet;

import controladorqytetet.*;
import java.awt.Color;
import java.util.ArrayList;
import modeloqytetet.Qytetet;
public class VistaGraficaQytetet extends javax.swing.JFrame {

    /**
     * Creates new form VistaGraficaQytetet
     */
    public VistaGraficaQytetet() {
        ArrayList <String> nombres = obtenerNombreJugadores();
        modelo = Qytetet.getInstance();
        controlador = ControladorQytetet.getInstance(nombres);
        initComponents();
        creaMenuOperacion();
        creaMenuCasilla();
        update();
    }
    
    
    private ControladorQytetet controlador;
    private modeloqytetet.Qytetet modelo;
    private int operacionElegida;

    public void creaMenuOperacion () {
        for (OpcionMenu opcion : OpcionMenu.values()){
            javax.swing.JMenuItem opcionGrafica = new javax.swing.JMenuItem();
            opcionGrafica.setText(opcion.toString());
            opcionGrafica.setVisible(true);
            opcionGrafica.addActionListener(new java.awt.event.ActionListener(){
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    itemOpcionMenuActionPerformed(evt);
                }
            });
            jMenuOperacion.add(opcionGrafica);     
        }
    }
    
    public void itemOpcionMenuActionPerformed(java.awt.event.ActionEvent evt){
        
        for (int i = 0 ; i < jMenuOperacion.getMenuComponentCount() ; i++)
            if (jMenuOperacion.getMenuComponent(i) == evt.getSource()){
                operacionElegida = i;
                break;
            }
        if (OpcionMenu.values()[operacionElegida] == OpcionMenu.TERMINARJUEGO)
            System.exit(0);
        
        if(controlador.necesitaElegirCasilla(operacionElegida))
            updateJMenuCasillas(operacionElegida);
        else
            areaMensajes.setText(controlador.realizarOperacion(operacionElegida, 0));     
        
        update();
    
    }
    
    public void creaMenuCasilla () {
        for (modeloqytetet.Casilla casilla : modelo.getTablero().getCasillas()){
            javax.swing.JMenuItem opcionGrafica = new javax.swing.JMenuItem();
            opcionGrafica.setText(Integer.toString(casilla.getNumeroCasilla()));
            opcionGrafica.setVisible(true);
            opcionGrafica.addActionListener(new java.awt.event.ActionListener(){
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    itemCasillaMenuActionPerformed(evt);
                }
            });
            jMenuCasilla.add(opcionGrafica);     
        }
    }
    
    public void itemCasillaMenuActionPerformed(java.awt.event.ActionEvent evt){
        int casillaElegida = 0;
        
        for (int i = 0 ; i < modeloqytetet.Tablero.NUMERO_CASILLAS ; i++)
            if(jMenuCasilla.getMenuComponent(i) == evt.getSource()){
                casillaElegida = i;
                break;
            }
        
        areaMensajes.setText(controlador.realizarOperacion(operacionElegida, casillaElegida));
    }
    
    public void updateJMenuOperaciones(){
        ArrayList <Integer> operacionesValidas = controlador.obtenerOperacionesJuegoValidas();
        
        for (int i = 0 ; i < jMenuOperacion.getItemCount() ; i++)
            if (operacionesValidas.contains(i))
                jMenuOperacion.getItem(i).setVisible(true);
            else
                jMenuOperacion.getItem(i).setVisible(false);
    }
    
    public void updateJMenuCasillas(int opcionMenu){
        ArrayList <Integer> casillasValidas = controlador.obtenerCasillasValidas(opcionMenu);
        
        for (int i = 0 ; i < jMenuCasilla.getItemCount() ; i++)
            if (casillasValidas.contains(i))
                jMenuCasilla.getItem(i).setVisible(true);
            else
                jMenuCasilla.getItem(i).setVisible(false);
    }
    
    public void update(){
        areaJugadorActual.setText("Le toca a: " + modelo.getJugadorActual().getNombre());
        if (modelo.getCartaActual()!= null)
            areaCartaActual.setText("Ha salido la carta:\n" + modelo.getCartaActual().toString());
        areaJugadores.setText("JUGADORES:\n" + modelo.getJugadores().toString());
        updateJMenuOperaciones();
        updateJMenuCasillas(operacionElegida);
        repaint();
    }
    
    public ArrayList<String> obtenerNombreJugadores() {
        DialogoNombres dialogo = new DialogoNombres(this, true);
        dialogo.setVisible(true);
        return dialogo.getNombres();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMensajes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaJugadores = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaJugadorActual = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaCartaActual = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMensajes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelJugadorActual = new javax.swing.JPanel();
        panelCartaActual = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        panelJugadores = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        jMenuOperacion = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuCasilla = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaJugadores.setColumns(20);
        areaJugadores.setRows(5);
        jScrollPane5.setViewportView(areaJugadores);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        areaJugadorActual.setColumns(20);
        areaJugadorActual.setRows(5);
        jScrollPane2.setViewportView(areaJugadorActual);

        areaCartaActual.setColumns(20);
        areaCartaActual.setRows(5);
        jScrollPane3.setViewportView(areaCartaActual);

        areaMensajes.setColumns(20);
        areaMensajes.setRows(5);
        jScrollPane1.setViewportView(areaMensajes);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tablero500x500.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Jugador actual");

        jLabel3.setText("Mensajes");

        jLabel4.setText("Jugadores");

        jLabel5.setText("Carta actual");

        jLabel6.setFont(new java.awt.Font("Carlito", 1, 36)); // NOI18N
        jLabel6.setText("QYTETET");

        javax.swing.GroupLayout panelMensajesLayout = new javax.swing.GroupLayout(panelMensajes);
        panelMensajes.setLayout(panelMensajesLayout);
        panelMensajesLayout.setHorizontalGroup(
            panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMensajesLayout.createSequentialGroup()
                        .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMensajesLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(219, 219, 219))
                            .addGroup(panelMensajesLayout.createSequentialGroup()
                                .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelMensajesLayout.createSequentialGroup()
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelMensajesLayout.createSequentialGroup()
                                        .addGap(243, 243, 243)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)))
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(panelMensajesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(204, 204, 204))))
            .addGroup(panelMensajesLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMensajesLayout.setVerticalGroup(
            panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMensajesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMensajesLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(493, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelJugadorActualLayout = new javax.swing.GroupLayout(panelJugadorActual);
        panelJugadorActual.setLayout(panelJugadorActualLayout);
        panelJugadorActualLayout.setHorizontalGroup(
            panelJugadorActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        panelJugadorActualLayout.setVerticalGroup(
            panelJugadorActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCartaActualLayout = new javax.swing.GroupLayout(panelCartaActual);
        panelCartaActual.setLayout(panelCartaActualLayout);
        panelCartaActualLayout.setHorizontalGroup(
            panelCartaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        panelCartaActualLayout.setVerticalGroup(
            panelCartaActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelJugadoresLayout = new javax.swing.GroupLayout(panelJugadores);
        panelJugadores.setLayout(panelJugadoresLayout);
        panelJugadoresLayout.setHorizontalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        panelJugadoresLayout.setVerticalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        jMenuOperacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuOperacion.setText("Elige operación");
        barraMenu.add(jMenuOperacion);

        jMenu1.setText("  ");
        barraMenu.add(jMenu1);

        jMenuCasilla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuCasilla.setText("Casilla a la que aplicar la operación");
        barraMenu.add(jMenuCasilla);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(panelCartaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(panelMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJugadorActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJugadorActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMensajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCartaActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaGraficaQytetet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGraficaQytetet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGraficaQytetet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGraficaQytetet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGraficaQytetet().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCartaActual;
    private javax.swing.JTextArea areaJugadorActual;
    private javax.swing.JTextArea areaJugadores;
    private javax.swing.JTextArea areaMensajes;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuCasilla;
    private javax.swing.JMenu jMenuOperacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelCartaActual;
    private javax.swing.JPanel panelJugadorActual;
    private javax.swing.JPanel panelJugadores;
    private javax.swing.JPanel panelMensajes;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
}
