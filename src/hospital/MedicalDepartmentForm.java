package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MedicalDepartmentForm extends JFrame implements ActionListener {
	
	/*
	 * 데이터베이스 역할을 하는 DatabaseClass 변수 선언
	 * 생성자에서 전달 받음. 가장 중요함.
	 */
	public DatabaseClass db;

    private JTextField codeField;
    private JTextField medicalDepField;
    private JTextField wardField;
   
    // 기본 생성자
    public MedicalDepartmentForm() {    	
    }
   
    /**
     * 생성자
     *  - 메인 메뉴에서 불려질 때 데이터베이스 클래스의 주소를 전달 받는다.
     *  - 전달 받은 데이터베이스 클래스에는 진료과 ArrayList가 있다.
     * @param db
     */
    public MedicalDepartmentForm(DatabaseClass db) {
    	// 데이터베이스 전담 클래스의 객체를 전달받아서 내가 선언한 변수에 저장함
    	this.db = db;

        // 텍스트필드(입력칸)와 레이블 설정
        codeField = new JTextField(10);
        medicalDepField = new JTextField(10);
        wardField = new JTextField(10);

        JLabel codeLabel = new JLabel("진료과 코드:");
        JLabel medicalDepLabel = new JLabel("진료과:");
        JLabel wardLabel = new JLabel("병동:");

        // 진료과 추가 버튼 생성
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
        inputPanel.setLayout(new GridLayout(3, 2));        
        inputPanel.add(codeLabel);
        inputPanel.add(codeField);
        inputPanel.add(medicalDepLabel);
        inputPanel.add(medicalDepField);
        inputPanel.add(wardLabel);
        inputPanel.add(wardField);

        // 메인 패널에 input패널 부착
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        // 메인 패널에 "추가"버튼 부착
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // 프레임(윈도우 창) 설정
        setTitle("진료과 정보 입력");
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
     *  - 진료과 추가 버튼 클릭시 실행되는 메소드로 데이터베이스 클래스에 진료과를 추가시킨다.
     *    즉, 진료과 ArrayList에 진료과 하나가 추가함.
     */
	public void actionPerformed(ActionEvent e) {
		// 화면에서 입력된 값을 임시 변수에 저장
        String code = codeField.getText();
        String medicalDep = medicalDepField.getText();
        String ward = wardField.getText();

        // 화면에서 입력받은 데이터로 진료과 객체 생성
        MedicalDepartment medicalDepartment = new MedicalDepartment(code, medicalDep, ward);
       
        // 생성한 진료과 객체를 ArrayList<MedicalDepartment> medicalDepartmentList에 저장
        this.db.addMedicalDepartment(medicalDepartment);
       
		// 진료과 객체 성공적으로 등록 완료 메시지
		JOptionPane.showMessageDialog(this, "등록완료");
		
		// 현재까지 등록된 진료과수 확인
        System.out.println("진료과 객체 등록 완료 진료과수 : " + db.getMedicalDepartmentCount());
		
        // 진료과 등록 끝나서 현재의 화면 닫기                
        this.dispose();
       
        // 이동해갈 메인 메뉴 생성
        MainMenu mainMenu = new MainMenu(db);
       
        // 메인 메뉴 보이기
        mainMenu.setVisible(true);
	}
	
    /**
     * 진료과 등록폼을 직접 실행할 경우에 사용하는 메소드
     *  - 프로그램 전체를 실행할 때는 사용되지 않음
     *  - 진료과 등록폼을 만들면서 테스트 할 때 이 프로그램을 실행시킬때 사용됨
     */
    public static void main(String[] args) {
    	new MedicalDepartmentForm(new DatabaseClass());
    }


}
