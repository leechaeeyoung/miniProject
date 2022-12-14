package memoProject;
import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NoteActionListener implements ActionListener{
	Notepad frm;
	String cmd;
	
	public NoteActionListener(Notepad frm) {
		this.frm=frm;
	}
	public void actionPerformed(ActionEvent ae) {
		cmd=ae.getActionCommand();
		switch(cmd) {
		case "새파일":
			frm.newFile();
			break;
		case "열기":
			JFileChooser opchooser = new JFileChooser();
			FileNameExtensionFilter opfilter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
			opchooser.setFileFilter(opfilter);
			
			int ret = opchooser.showOpenDialog(null);
			if(ret!=JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			String oFile = opchooser.getSelectedFile().getPath();
			
			frm.setTitle(oFile);
			frm.loadFile(oFile);
			break;
		case "저장":
			if(frm.getTitle()=="새파일"||frm.getTitle()=="메모장") {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
				ret = chooser.showSaveDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "저장을 취소하셨습니다.","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			} else {
				frm.setTitle(frm.getTitle());
				frm.saveFile(frm.getTitle());
			}
			break;
		case "다른이름으로 저장":
			if(frm.getTitle()=="새파일"||frm.getTitle()=="메모장") {
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
				ret = chooser.showSaveDialog(null);
				
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "저장을 취소하셨습니다.","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			} else {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt& *.java","txt","java");
				chooser.setFileFilter(filter);
				ret = chooser.showSaveDialog(null);
				
				if(ret!=JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "다른이름으로 저장을 취소하셨습니다.","경고",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String sFile = chooser.getSelectedFile().getPath();
				frm.setTitle(sFile);
				frm.saveFile(sFile);
			}
			break;
		case "종료":
			frm.windowClosing(null);
			break;
		}
	}
}
