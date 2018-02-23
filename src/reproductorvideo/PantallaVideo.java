
package reproductorvideo;

import java.io.File;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class PantallaVideo extends javax.swing.JFrame {

   
    public PantallaVideo() {

        initComponents();      
        
        add(player);       
     
        setVisible(true);

        player.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter(){
            public void positionChanged(MediaPlayer mp, float posicion){
	             
                
                if(AccionProgres){
                    int value = Math.min(100, Math.round(posicion * 100.0f));        
                    jSlider_progreso.setValue(value);
                    
                }
        }
        public void finished(MediaPlayer mediaPlayer){}//Este metodo no se utiliza....

       });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSlider_progreso = new javax.swing.JSlider();
        jSliderVolumen = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(300, 300, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(800, 800));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pausar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Stop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSlider_progreso.setValue(0);
        jSlider_progreso.setOpaque(false);
        jSlider_progreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_progresoStateChanged(evt);
            }
        });
        jSlider_progreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider_progresoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider_progresoMouseReleased(evt);
            }
        });

        jSliderVolumen.setOpaque(false);
        jSliderVolumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderVolumenStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSlider_progreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addComponent(jSliderVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jSlider_progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jSliderVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        JFileChooser fileChooser = new JFileChooser("Escritorio");
	 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "swf","avi","mkv","mp4","mp3","mpg","wmv","ogv","webm");		//                  
	 
        fileChooser.addChoosableFileFilter(filter);
	
         if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){       
             
             file = fileChooser.getSelectedFile();                                     
	               
            
             if (file!=null){                    

                
                 player.getMediaPlayer().playMedia(file.getAbsolutePath());    
                
                 player.getMediaPlayer().setVolume(vol);           
                
                 jSlider_progreso.setValue(0);
                 
                 setTitle(file.getName() + " - VLCJ Player");
                	            
                player.getMediaPlayer().setBrightness(2f);
            }
	                
	            }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        player.getMediaPlayer().setPause( player.getMediaPlayer().isPlaying()?true:false ); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        player.getMediaPlayer().stop();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSlider_progresoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_progresoMousePressed
        AccionProgres=false;	
    }//GEN-LAST:event_jSlider_progresoMousePressed

    private void jSlider_progresoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider_progresoMouseReleased
        AccionProgres=true;
    }//GEN-LAST:event_jSlider_progresoMouseReleased

    private void jSlider_progresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_progresoStateChanged
        
        if(!AccionProgres){
					                  
            float posicion = jSlider_progreso.getValue()/100f; 

            player.getMediaPlayer().setPosition(posicion); 
        }
    }//GEN-LAST:event_jSlider_progresoStateChanged

    private void jSliderVolumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderVolumenStateChanged
       
        vol = jSliderVolumen.getValue();

        player.getMediaPlayer().setVolume(vol);

        System.out.println(vol);
    }//GEN-LAST:event_jSliderVolumenStateChanged

    
    public static void main(String[] args) {
        // TODO code application logic here
        new PantallaVideo();
        
    }

    private EmbeddedMediaPlayerComponent player = new EmbeddedMediaPlayerComponent();
    private File file;
	
	//lectura de las dll
	static{	
	    NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC/");
	    Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
	}
    
   
        private int vol=50;
        private boolean AccionProgres = true;
        private int x=0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSliderVolumen;
    private javax.swing.JSlider jSlider_progreso;
    // End of variables declaration//GEN-END:variables
}
/*
player.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode()==10){
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
                if (evt.getKeyCode()==27){
                    setExtendedState(JFrame.NORMAL);
                }
                System.out.println(evt.getKeyChar()+" "+evt.getKeyCode()); 

                    }
        });

*/