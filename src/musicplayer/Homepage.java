package musicplayer;

import java.awt.CardLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import com.mpatric.mp3agic.*;
import java.awt.Image;
import java.io.FileOutputStream;
/**
 *
 * @author tejas
 */
public class Homepage extends javax.swing.JFrame {
    
    // Declarations
    DefaultListModel<String> listModel;
    File[] FileArray;
    File FileFinder;
    File myFile;
    Player player;
    long totalLength, pauseLength;
    boolean isPlaying = false;
    boolean isFirstTime = true;
    FileInputStream FIS;
    BufferedInputStream BIS; 
    int i;
    int totalNumSongs, currentSongIndex;
    String displaySongName;
    String songNamewithmp3;
    

    
    // Initializing all the components of Homepage
    CardLayout cardLayout;
    public Homepage() {
        initComponents();
        cardLayout = (CardLayout)(cardPanel.getLayout());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Body = new javax.swing.JPanel();
        ButtonList = new javax.swing.JPanel();
        songList = new javax.swing.JButton();
        openFolder = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        Card1 = new javax.swing.JPanel();
        jFileChooser1 = new javax.swing.JFileChooser();
        Card2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        SongButtonList = new javax.swing.JPanel();
        songPicture = new javax.swing.JLabel();
        nextSong = new javax.swing.JButton();
        prevSong = new javax.swing.JButton();
        playPause = new javax.swing.JButton();
        songState = new javax.swing.JLabel();
        songName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Body.setBackground(new java.awt.Color(15, 20, 29));

        ButtonList.setBackground(new java.awt.Color(15, 20, 29));

        songList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        songList.setForeground(new java.awt.Color(255, 255, 255));
        songList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/list.png"))); // NOI18N
        songList.setBorderPainted(false);
        songList.setContentAreaFilled(false);
        songList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        songList.setFocusPainted(false);
        songList.setIconTextGap(7);
        songList.setLabel("Song List");
        songList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songListActionPerformed(evt);
            }
        });

        openFolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        openFolder.setForeground(new java.awt.Color(255, 255, 255));
        openFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/open-file.png"))); // NOI18N
        openFolder.setText("Open Folder");
        openFolder.setBorderPainted(false);
        openFolder.setContentAreaFilled(false);
        openFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFolder.setFocusPainted(false);
        openFolder.setIconTextGap(7);
        openFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonListLayout = new javax.swing.GroupLayout(ButtonList);
        ButtonList.setLayout(ButtonListLayout);
        ButtonListLayout.setHorizontalGroup(
            ButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonListLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(ButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openFolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ButtonListLayout.setVerticalGroup(
            ButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(songList, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardPanel.setBackground(new java.awt.Color(29, 31, 47));
        cardPanel.setDoubleBuffered(false);
        cardPanel.setLayout(new java.awt.CardLayout());

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Users\\tejas"));
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Card1Layout = new javax.swing.GroupLayout(Card1);
        Card1.setLayout(Card1Layout);
        Card1Layout.setHorizontalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Card1Layout.setVerticalGroup(
            Card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardPanel.add(Card1, "getFolder");

        Card2.setBackground(new java.awt.Color(29, 31, 47));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jList1.setBackground(new java.awt.Color(29, 31, 47));
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.setDragEnabled(true);
        jList1.setFocusable(false);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout Card2Layout = new javax.swing.GroupLayout(Card2);
        Card2.setLayout(Card2Layout);
        Card2Layout.setHorizontalGroup(
            Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Card2Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Card2Layout.setVerticalGroup(
            Card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardPanel.add(Card2, "songList");

        SongButtonList.setBackground(new java.awt.Color(38, 40, 61));

        songPicture.setBackground(new java.awt.Color(255, 255, 255));
        songPicture.setForeground(new java.awt.Color(255, 255, 255));
        songPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        nextSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/next-song.png"))); // NOI18N
        nextSong.setBorderPainted(false);
        nextSong.setContentAreaFilled(false);
        nextSong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextSong.setFocusPainted(false);
        nextSong.setPreferredSize(new java.awt.Dimension(25, 25));
        nextSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextSongActionPerformed(evt);
            }
        });

        prevSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/previous-song.png"))); // NOI18N
        prevSong.setBorderPainted(false);
        prevSong.setContentAreaFilled(false);
        prevSong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prevSong.setFocusPainted(false);
        prevSong.setPreferredSize(new java.awt.Dimension(25, 25));
        prevSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevSongActionPerformed(evt);
            }
        });

        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/play.png"))); // NOI18N
        playPause.setBorderPainted(false);
        playPause.setContentAreaFilled(false);
        playPause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playPause.setFocusPainted(false);
        playPause.setPreferredSize(new java.awt.Dimension(25, 25));
        playPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseActionPerformed(evt);
            }
        });

        songState.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        songState.setForeground(new java.awt.Color(255, 255, 255));
        songState.setText("No Song Selected ");

        songName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        songName.setForeground(new java.awt.Color(255, 255, 255));
        songName.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout SongButtonListLayout = new javax.swing.GroupLayout(SongButtonList);
        SongButtonList.setLayout(SongButtonListLayout);
        SongButtonListLayout.setHorizontalGroup(
            SongButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SongButtonListLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(songPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SongButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SongButtonListLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(prevSong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(nextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(SongButtonListLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(songState, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(songName, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        SongButtonListLayout.setVerticalGroup(
            SongButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SongButtonListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(SongButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(songName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(songState, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(SongButtonListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevSong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SongButtonListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(songPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(ButtonList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(SongButtonList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SongButtonList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // EventListener for Song List button
    private void songListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songListActionPerformed
        cardLayout.show(cardPanel, "songList");
    }//GEN-LAST:event_songListActionPerformed
    
    // EventListener for Get Folder button
    private void openFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderActionPerformed
        cardLayout.show(cardPanel, "getFolder");
    }//GEN-LAST:event_openFolderActionPerformed
    
    // EventListener for jFileChooser OPEN button
    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        listModel = new DefaultListModel<>();
        int result = 0;
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = jFileChooser1.getSelectedFile();
            File[] mp3Files = selectedDirectory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".mp3");
                }
            });
            FileArray = mp3Files;
            totalNumSongs = FileArray.length;
            if (mp3Files != null && mp3Files.length > 0) {
                System.out.println("MP3 files in selected directory:");
                System.out.println(mp3Files.length);
                for (File mp3File : mp3Files) {
                    displaySongName = mp3File.getName().replace(".mp3", "");
                    System.out.println(mp3File.getName());
                    listModel.addElement(displaySongName);
                    jList1.setModel(listModel);
                }
                System.out.println("--------------------");
                cardLayout.show(cardPanel, "songList");
            } else {
                JOptionPane.showMessageDialog(null, "No MP3 files found in the selected directory.");
                System.out.println("No MP3 files found in the selected directory.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No directory selected.");
            System.out.println("No directory selected.");
        }
    }//GEN-LAST:event_jFileChooser1ActionPerformed
    
    // EventListener for Modal click
    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        i = -1;
        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/play.png")));
        songNamewithmp3 = jList1.getSelectedValue() + ".mp3";
        for (File FileFinder : FileArray) {  
            i++;
            if (songNamewithmp3.equals(FileFinder.getName())){
                displaySongName = FileFinder.getName().replace(".mp3", "");
                songState.setText("Now Selected :");
                songName.setText(displaySongName);
                currentSongIndex = i;
                System.out.println(currentSongIndex);
                System.out.println(FileFinder.getName());
               
                if (player!=null) {
                    System.out.println("The player is not empty");
                    stop();
                    player = null;
                    myFile = FileFinder;
                    setImage(myFile);
                } else if (player == null) {
                    myFile = FileFinder;
                    setImage(myFile);
                    
                }
                if (evt.getClickCount() == 2){
                    isPlaying=true;
                    songState.setText("Now Playing :");
                    playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/pause.png")));
                    play();
                    System.out.println(totalLength);
                } 
            }
        }
    }//GEN-LAST:event_jList1MouseClicked
    
    // EventListener for Play/Pause button
    private void playPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseActionPerformed
        if (player==null) {
            play();
            isPlaying = true;
            isFirstTime = false;
            songState.setText("Now Playing :");
            System.out.println("Song has started playing");
            playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/pause.png")));

        } else if (player!=null && isPlaying==false ) {
            System.out.println("Song has resumed playing");
            resume();
            songState.setText("Now Playing :");
            isPlaying = true;
            playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/pause.png")));
        } else if (player!=null && isPlaying==true) {
            System.out.println("Song has been paused");
            songState.setText("Now Selected :");
            pause();
            isPlaying = false;
            playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/play.png")));
        }
  
    }//GEN-LAST:event_playPauseActionPerformed
    
    // EventListener for Previous Song button
    private void prevSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevSongActionPerformed
        stop();
        player=null;
        if (currentSongIndex == 0) {
            currentSongIndex = totalNumSongs-1;
            myFile = FileArray[currentSongIndex];
        } else {
            currentSongIndex--;
            myFile = FileArray[currentSongIndex];
        }
        displaySongName = myFile.getName().replace(".mp3", "");
        songName.setText(displaySongName);
        setImage(myFile);
        play();
        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/pause.png")));
        isPlaying = true;
    }//GEN-LAST:event_prevSongActionPerformed
    
    // EventListener for Next Song button
    private void nextSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextSongActionPerformed
        stop();
        player=null;
        if (currentSongIndex == totalNumSongs-1) {
            currentSongIndex=0;
            myFile = FileArray[currentSongIndex];
        } else {
            currentSongIndex += 1;
            System.out.println(currentSongIndex);
            myFile = FileArray[currentSongIndex];
        }
        displaySongName = myFile.getName().replace(".mp3", "");
        songName.setText(displaySongName);
        setImage(myFile);
        play();
        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musicplayer/Icon/pause.png")));
        isPlaying = true;
    }//GEN-LAST:event_nextSongActionPerformed
    
    // Audio Control methods
    public void stop() {
        if (player != null) {
            player.close();
        }
    }
    
    public void pause() {
        if (player != null) {
            try {
                pauseLength = FIS.available();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void play() {
        try {
            FIS = new FileInputStream(myFile);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            totalLength = FIS.available();
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread() {
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    
    public void resume() {
        try {
            FIS = new FileInputStream(myFile);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(totalLength - pauseLength);
        } catch (FileNotFoundException | JavaLayerException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread() {
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }
    
    public void setImage(File randofile){
        Mp3File mp3file;
        try {
            mp3file = new Mp3File(randofile.getAbsolutePath());
            if (mp3file.hasId3v2Tag() && mp3file.getId3v2Tag().getAlbumImage() != null) {
                byte[] coverArtData = mp3file.getId3v2Tag().getAlbumImage();
                File coverArtFile = new File(randofile.getParent(), "cover_" + System.currentTimeMillis() + ".jpg");
                FileOutputStream fos = new FileOutputStream(coverArtFile);
                fos.write(coverArtData);
                fos.close();
                ImageIcon icon = new ImageIcon(coverArtData);
                Image scaledImage = icon.getImage().getScaledInstance(songPicture.getWidth(), songPicture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                songPicture.setIcon(scaledIcon);
                coverArtFile = null;
                coverArtData = null;
                mp3file = null; 
            } else {
                System.out.println("No cover art found in the MP3 file.");
                songPicture.setIcon(null);
                songPicture.setText("No Image");
            }
        } catch (IOException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedTagException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidDataException ex) {
            Logger.getLogger(Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel ButtonList;
    private javax.swing.JPanel Card1;
    private javax.swing.JPanel Card2;
    private javax.swing.JPanel SongButtonList;
    public javax.swing.JPanel cardPanel;
    public javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextSong;
    private javax.swing.JButton openFolder;
    private javax.swing.JButton playPause;
    private javax.swing.JButton prevSong;
    private javax.swing.JButton songList;
    private javax.swing.JLabel songName;
    private javax.swing.JLabel songPicture;
    private javax.swing.JLabel songState;
    // End of variables declaration//GEN-END:variables
}
