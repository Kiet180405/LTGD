

package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;



public class JNotepad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFormat, mView, mHelp,mZoom;
    private JMenu mFile, mEdit, mFormat, mView, mHelp, mZoom;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit, itemFont,
            itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSearch, itemFind, itemFindNext, itemFindPrevious,
            itemReplace, itemGoto, itemSelectAll, itemTimeDate, itemStatusBar, itemZoomIn, itemZoomOut, itemRestore,itemStatus,
            itemReplace, itemGoto, itemSelectAll, itemTimeDate, itemZoomIn, itemZoomOut, itemRestore, itemStatus,
            itemViewHelp, itemSendFeedback, itemAbout;
    private JCheckBoxMenuItem itemWrap;
    private JCheckBoxMenuItem itemWrap, itemStatusBar;
    private JTextArea txtEditor;
    private JToolBar toolBar;
    private JButton btNew, btOpen, btSave;
    int size = 20;

    public JNotepad(String title) {

        super(title);
        createMenu();
        createGUI();
        processEvent();
        createToolBar();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
@@ -59,42 +78,42 @@  void createMenu() {
        mFile.add(itemPrint = new JMenuItem("Print..."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));
        

        //tao item va add vao menu edit
        mEdit.add(itemUndo=new JMenuItem("Undo"));
        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut=new JMenuItem("Cut"));
        mEdit.add(itemCopy=new JMenuItem("Copy"));
        mEdit.add(itemPaste=new JMenuItem("Paste"));
        mEdit.add(itemDelete=new JMenuItem("Delete"));
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));
        mEdit.add(itemDelete = new JMenuItem("Delete"));
        mFile.addSeparator();
        mEdit.add(itemSearch=new JMenuItem("Search with Bing..."));
        mEdit.add(itemFind=new JMenuItem("Find..."));
        mEdit.add(itemFindNext=new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevious=new JMenuItem("Find Previous"));
        mEdit.add(itemReplace=new JMenuItem("Replace..."));
        mEdit.add(itemGoto=new JMenuItem("Go To..."));
        mEdit.add(itemSearch = new JMenuItem("Search with Bing..."));
        mEdit.add(itemFind = new JMenuItem("Find..."));
        mEdit.add(itemFindNext = new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevious = new JMenuItem("Find Previous"));
        mEdit.add(itemReplace = new JMenuItem("Replace..."));
        mEdit.add(itemGoto = new JMenuItem("Go To..."));
        mEdit.addSeparator();
        mEdit.add(itemSelectAll=new JMenuItem("Select All"));
        mEdit.add(itemTimeDate=new JMenuItem("Time/Date"));
        
        mEdit.add(itemSelectAll = new JMenuItem("Select All"));
        mEdit.add(itemTimeDate = new JMenuItem("Time/Date"));

        //tao item va add vao menu Format
        mFormat.add(itemWrap=new JCheckBoxMenuItem("Word Wrap"));
        mFormat.add(itemFont=new JMenuItem("Font..."));
        
        mFormat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap"));
        mFormat.add(itemFont = new JMenuItem("Font..."));

        //tao item va add vao menu View
        mView.add(mZoom=new JMenu("Zoom"));
        mZoom.add(itemZoomIn=new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOut=new JMenuItem("Zoom Out"));
        mZoom.add(itemRestore=new JMenuItem("Restore Default Zoom"));
        mView.add(itemStatus=new JMenuItem("Status Bar"));
        
        mView.add(mZoom = new JMenu("Zoom"));
        mZoom.add(itemZoomIn = new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOut = new JMenuItem("Zoom Out"));
        mZoom.add(itemRestore = new JMenuItem("Restore Default Zoom"));
        mView.add(itemStatus = new JCheckBoxMenuItem("Status Bar"));

        //tao item va add vao menu View
        mHelp.add(itemViewHelp=new JMenuItem("View Help"));
        mHelp.add(itemSendFeedback=new JMenuItem("Send Feedback"));
        mHelp.add(itemViewHelp = new JMenuItem("View Help"));
        mHelp.add(itemSendFeedback = new JMenuItem("Send Feedback"));
        mHelp.addSeparator();
        mHelp.add(itemAbout=new JMenuItem("About Notepad"));
        
        mHelp.add(itemAbout = new JMenuItem("About Notepad"));

        //tao to hop phim
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
@@ -132,5 +151,116 @@ private void createGUI() {
        add(scrollEditor);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }


    private void processEvent() {
        itemZoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size += 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemZoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size -= 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itemWrap.isSelected()) {
                    txtEditor.setLineWrap(true);
                } else {
                    txtEditor.setLineWrap(false);
                }
            }
        });
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        itemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        itemCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyText();
            }
        });
        itemPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteText();
            }
        });
    }

    private void openFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(dlgFile.getSelectedFile());
                byte[] b = new byte[fis.available()];
                fis.read(b);
                txtEditor.setText(new String(b));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi doc file");
            }
        }
    }

    private void saveFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fos = new FileOutputStream(dlgFile.getSelectedFile());
                fos.write(txtEditor.getText().getBytes());
                fos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi ghi file");
            }
        }
    }

    private void copyText() {
        StringSelection selection = new StringSelection(txtEditor.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    private void pasteText() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String text = (String) clipboard.getData(DataFlavor.stringFlavor);
            txtEditor.insert(text, txtEditor.getCaretPosition());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error pasting text: " + e.getMessage());
        }
    }

    private void createToolBar() {
        toolBar = new JToolBar();

        toolBar.add(btNew = new JButton("New"));
        toolBar.add(btOpen = new JButton("Open"));
        toolBar.add(btSave = new JButton("Save"));
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/images/new.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/images/open.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/images/save.png")));
        add(toolBar, BorderLayout.NORTH);
    }
}
