package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
/**
 * 초기화면 - 메인 메뉴
 *  - 프로그램 구동후 가장 먼저 보여지는 화면
 *  - 여기에서 다른 화면으로 이동함.
 */
public class MainMenu  extends JFrame implements ActionListener {
	
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;
	
    // 화면에서 사용할 입력필드, 버튼, 레이블 변수 선언(GUI components)
    private JLabel titleLabel;
    private JButton patientButton;
    private JButton doctorButton;
    private JButton medicalDepartmentButton;
    private JButton patientListButton;
    private JButton doctorListButton;
    private JButton medicalDepartmentListButton;
    private JButton exitButton;
   
    // 본 클래스에는 기본 생성자 생성 금지 //
   
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 환자 ArrayList 등이 있다.
     * @param db
     */
    public MainMenu(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;
    			
        // 프레임 설정
        setTitle("Registration Form");
        // setLayout(new GridLayout(8, 1));
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(470, 500);
       
        // 프레임 타이틀 설정
        titleLabel = new JLabel("목록");
        titleLabel.setBounds(-80, -20, 600, 80);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
       
        // 각 화면을 버튼으로 만들어서 프레임에 부착 - 환자등록
        patientButton = new JButton("환자 등록");
        patientButton.setBounds(0, 60, 200, 80);
        patientButton.addActionListener(this);	// 버튼에 액션 리스너 부착
        add(patientButton); // 버튼을 프레임에 부착(별도의 패널 안쓰고 바로 부착)
       
        // Doctor Register button
        doctorButton = new JButton("의사 등록");
        doctorButton.setBounds(0, 160, 200, 80);
        doctorButton.addActionListener(this);
        add(doctorButton);
       
        // MedicalDepartment Register button
        medicalDepartmentButton = new JButton("진료과 등록");
        medicalDepartmentButton.setBounds(0, 260, 200, 80);
        medicalDepartmentButton.addActionListener(this);
        add(medicalDepartmentButton);
       
       
        // Patient List button
        patientListButton = new JButton("환자 목록");
        patientListButton.setBounds(250, 60, 200, 80);
        patientListButton.addActionListener(this);
        add(patientListButton);
       
        // Doctor List button
        doctorListButton = new JButton("의사 목록");
        doctorListButton.setBounds(250, 160, 200, 80);
        doctorListButton.addActionListener(this);
        add(doctorListButton);
       
        // MedicalDepartment List button
        medicalDepartmentListButton = new JButton("진료과 목록");
        medicalDepartmentListButton.setBounds(250, 260, 200, 80);
        medicalDepartmentListButton.addActionListener(this);
        add(medicalDepartmentListButton);
       
       
        // Exit button
        exitButton = new JButton("나가기");
        exitButton.setBounds(0, 400, 450, 40);
        exitButton.setBackground(Color.cyan);
        exitButton.addActionListener(this);
        add(exitButton);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    // 각 메뉴 버튼 클릭시 할일 정의
    public void actionPerformed(ActionEvent e) {
        // 환자 등록폼이 눌렸냐?
        if (e.getSource() == patientButton) {
            System.out.println("환자 등록");
           
            // 현재의 메인 메뉴 화면 닫기                
            this.dispose();
           
            // 이동해갈 화면 객체 생성(환자등록폼)
            PatientForm patientForm = new PatientForm(db);
           
            // 이동해갈 화면 보이기
            patientForm.setVisible(true);
           
        } else if (e.getSource() == doctorButton) {
            System.out.println("의사 등록");
            this.dispose();
            DoctorForm doctorForm = new DoctorForm(db);
            doctorForm.setVisible(true);            
        } else if (e.getSource() == medicalDepartmentButton) {
            System.out.println("진료과 등록");
            this.dispose();
            MedicalDepartmentForm medicalDepartmentForm = new MedicalDepartmentForm(db);
            medicalDepartmentForm.setVisible(true);              
        } else if (e.getSource() == patientListButton) {
            System.out.println("환자 목록");            
            // 현재 화면 닫기                
            this.dispose();            
            // 이동해갈 화면 객체 생성
            PatientList patientList = new PatientList(db);            
            // 이동해갈 화면 보이기
            patientList.setVisible(true);            
        } else if (e.getSource() == doctorListButton) {
            System.out.println("의사 목록");
            this.dispose();
            DoctorList doctorList = new DoctorList(db);
            doctorList.setVisible(true);
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == medicalDepartmentListButton) {
            System.out.println("진료과 목록");
            this.dispose();
            MedicalDepartmentList medicalDepartmentList = new MedicalDepartmentList(db);
            medicalDepartmentList.setVisible(true);
            /////////// JTable로 구현 //////////            
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
   
    public static void main(String[] args) {
        new MainMenu(new DatabaseClass());
    }


}
