package hospital;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PatientList extends JFrame implements ActionListener {
	
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

	// 환자 목록이 보여질 테이블
    private JTable table;	
    // 테이블을 다양한 기능을 사용할 수 있도록 해주는 클래스
    private DefaultTableModel tableModel;	

    // 기본 생성자
    public PatientList() {    	
    }
   
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 환자 ArrayList가 있다.
     * @param db
     */
    public PatientList(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    	
        // 테이블 세팅
        String[] columnNames = {"환자 번호", "주민등록번호", "이름", "주소", "진료과 코드", "진료과"};
        List<Patient> patientList = db.getPatientList(); // ArrayList<Student>의 갯수 만큼 행을 생성
        Object[][] data = new Object[patientList.size()][6];
       
        for (int i = 0; i < patientList.size(); i++) {
            Patient patient = patientList.get(i);
            data[i][0] = patient.getId();
            data[i][1] = patient.getJumin();
            data[i][2] = patient.getName();
            data[i][3] = patient.getAddress();
            data[i][4] = patient.getCode();
            data[i][5] = patient.getMedicalDep();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
       
       
        // Set up the button to add a new patient
       JButton closeButton = new JButton("닫기");
       closeButton.setBackground(Color.green);
        // 액션 리스너 부착
        closeButton.addActionListener(this);	// 액션 리스터 부착
       
        JButton deleteButton = new JButton("삭제");
        deleteButton.setBackground(Color.red);
        deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) return;
				tableModel.removeRow(row);
				patientList.remove(row);
				
			}
		});

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 입력 필드들이 놓일 input 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
       
        // input 패널을 메인 패널에 다시 부착
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        // 닫기 버튼도 메인 패널에 부착
        mainPanel.add(closeButton, BorderLayout.SOUTH);
        mainPanel.add(deleteButton, BorderLayout.NORTH);

        // 프레임(윈도우 창) 설정
        setTitle("환자 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 액션 리스너
	public void actionPerformed(ActionEvent e) {
        // 현재 열려있는 환자 조회 화면을 닫음                
        this.dispose();
       
        MainMenu mainMenu = new MainMenu(db);
        mainMenu.setVisible(true);
	}
	
    /**
     * 환자 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 환자 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new PatientList(new DatabaseClass());
    }	


}
