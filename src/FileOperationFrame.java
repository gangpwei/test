import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import org.apache.poi.ss.usermodel.DateUtil;

public class FileOperationFrame extends JFrame {
	String path1;
	String path2;
	/**
	 * Launch the application
	 * @param args
	 */
	FileOperation f=new FileOperation();
	public static void main(String args[]) {
//		File f=new File("E://04FlashBuilderWorkspace/flex_xinjiang/bin-debug/Index.swf");
//		f.lastModified();
//		Date d=new Date(f.lastModified());
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
//        String dd=sdf.format(d);
//        System.out.println(dd);
		
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String pathname = chooser.getSelectedFile().getAbsolutePath();
			String name = chooser.getSelectedFile().getName();
			chooser = null;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileOperationFrame frame = new FileOperationFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Component getThis(){
		return this;
	}
	/**
	 * Create the frame
	 */
	public FileOperationFrame() {
		super();
		setResizable(false);
		setTitle("文件操作");
		getContentPane().setLayout(null);
		setBounds(100, 100, 532, 301);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JFormattedTextField field1 = new JFormattedTextField();
		field1.setBounds(135, 89, 257, 22);
		getContentPane().add(field1);

		final JFormattedTextField field2 = new JFormattedTextField();
		field2.setBounds(135, 139, 257, 22);
		getContentPane().add(field2);

		final JButton btn1 = new JButton();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				f.copyFolder(path1,field2.getText());
				//	JOptionPane.showMessageDialog(null, "复制成功！");
			}
		});
		btn1.setText("复制");
		btn1.setBounds(100, 195, 71, 28);
		getContentPane().add(btn1);

		final JButton btn2 = new JButton();
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				f.copyFolder(path1,field2.getText());
				f.delAllFile(path1);
			//	JOptionPane.showMessageDialog(null, "剪切成功！");
			}
		});
		btn2.setText("剪切");
		btn2.setBounds(186, 195, 71, 28);
		getContentPane().add(btn2);

		final JButton btn3 = new JButton();
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				f.delAllFile(path1);
				//	JOptionPane.showMessageDialog(null, "删除成功！");
			}
		});
		btn3.setText("删除");
		btn3.setBounds(263, 195, 71, 28);
		getContentPane().add(btn3);

		final JButton btn4 = new JButton();
		btn4.setText("压缩");
		btn4.setBounds(340, 195, 71, 28);
		getContentPane().add(btn4);

		final JButton btn5 = new JButton();
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JFileChooser chooser1=new JFileChooser();
				chooser1.setFileSelectionMode(chooser1.FILES_AND_DIRECTORIES);
				chooser1.showDialog(getThis(),"请选择");
				File f1=chooser1.getSelectedFile();
				path1=f1.getPath();
				field1.setText(path1);
			
			}
		});
		
		btn5.setText("打开");
		btn5.setBounds(425, 86, 71, 28);
		getContentPane().add(btn5);

		final JButton btn6 = new JButton();
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JFileChooser chooser2=new JFileChooser();
				chooser2.setFileSelectionMode(chooser2.FILES_AND_DIRECTORIES);
				chooser2.showDialog(getThis(),"请选择");
				File f2=chooser2.getSelectedFile();
//				path2=f2.getPath();
//				field2.setText(path2);
			}
		});
		btn6.setText("打开");
		btn6.setBounds(425, 136, 71, 28);
		getContentPane().add(btn6);

		final JLabel label1 = new JLabel();
		label1.setText("源文件或文件夹:");
		label1.setBounds(26, 89, 103, 22);
		getContentPane().add(label1);

		final JLabel label2 = new JLabel();
		label2.setText("目的文件或文件夹:");
		label2.setBounds(10, 139, 119, 22);
		getContentPane().add(label2);
		//
	}

}
