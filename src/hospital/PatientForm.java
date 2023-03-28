package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PatientForm extends JFrame implements ActionListener {
	
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

    private JTextField idField;
    private JTextField juminField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField codeField;
    private JTextField medicalDepField;
    //private JTable table;

    // 기본 생성자
    public PatientForm() {    	
    }
   
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 환자 ArrayList가 있다.
     * @param db
     */
    public PatientForm(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;

        // 텍스트필드(입력칸)와 레이블 설정
        idField = new JTextField(10);
        juminField = new JTextField(10);
        nameField = new JTextField(10);
        addressField = new JTextField(10);
        codeField = new JTextField(10);
        medicalDepField = new JTextField(10);

        JLabel idLabel = new JLabel("번호:");
        JLabel juminLabel = new JLabel("주민등록번호:");
        JLabel nameLabel = new JLabel("이름:");
        JLabel addressLabel = new JLabel("주소:");
        JLabel codeLabel = new JLabel("진료과 코드:");
        JLabel medicalDepLabel = new JLabel("진료과:");

        // 환자 추가 버튼 생성
        JButton addButton = new JButton("추가");
       
        // 액션 리스너 부착(추가 버튼 클릭시 할일 정의)
        // 버튼 클릭시 actionPerformed()가 호출됨.
        addButton.addActionListener(this);	// 액션 리스터 부착

        // 버튼, 레이블, 텍스트 필드를 배치할 input 패널을 배치할 메인 패널 생성
        // 즉, 메인 패널 위에 inputPanel이 놓이게 됨.
        JPanel mainPanel = new JPanel();

        // 메인 패널을 BoarderLayout으로 만들겠다.
        mainPanel.setLayout(new BorderLayout());

        // 버튼, 레이블, 텍스트 필드를 배치할 input 패널
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));        
        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(juminLabel);
        inputPanel.add(juminField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(codeLabel);
        inputPanel.add(codeField);
        inputPanel.add(medicalDepLabel);
        inputPanel.add(medicalDepField);

        // 메인 패널에 input패널 부착
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        // 메인 패널에 "추가"버튼 부착
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // 프레임(윈도우 창) 설정
        setTitle("환자 정보 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 메인 패널을 프레임의 루트 컨텐트에 저장
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
       
        /**
         * 컴포넌트(버튼, 텍스트필드, 레이블)가 프레임에 쌓이는 순서
         *  - 프레임 > 루트 컨텐트 > 메인 패널 > input패널 > 버튼,텍스트필드,레이블
         */
    }

    /**
     * 액션 리스너
     *  - 환자 추가 버튼 클릭시 실행되는 메소드로 데이터베이스 클래스에 환자를 추가시킨다.
     *    즉, 환자 ArrayList에 환자 한명 추가함.
     */
	public void actionPerformed(ActionEvent e) {
		// 화면에서 입력된 값을 임시 변수에 저장
		int id = Integer.parseInt(idField.getText());
        String jumin = juminField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String code = codeField.getText();
        String medicalDep = medicalDepField.getText();

        // 화면에서 입력받은 데이터로 환자 객체 생성
        Patient patient = new Patient(id, jumin, name, address, code, medicalDep);
       
        // 생성한 환자 객체를 ArrayList<Patient> patientList에 저장
        this.db.addPatient(patient);
       
		// 환자 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "등록완료");
		
		// 현재까지 등록된 환자수 확인
        System.out.println("환자 객체 등록 완료 환자수 : " + db.getPatientCount());
		
        // 환자 등록 끝나서 현재의 화면 닫기                
        this.dispose();
       
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
       
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
	
    /**
     * 환자 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 환자 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new PatientForm(new DatabaseClass());
    }


}
