package hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * 오직 데이터를 보관하는 데이터베이스 역할
 */

public class DatabaseClass {
	
	// 필드
		public List<Patient> patientList; // 환자 ArrayList
		public List<Doctor> doctorList; // 의사 ArrayList
		public List<MedicalDepartment> medicalDepartmentList; // 진료과 ArrayList

		
		 // 생성자
		public DatabaseClass() {
			patientList = new ArrayList<Patient>(); // 환자 ArrayList
			doctorList = new ArrayList<Doctor>(); // 의사 ArrayList
			medicalDepartmentList = new ArrayList<MedicalDepartment>(); // 진료과 ArrayList
		}

		// 환자 목록 출력화면에서 사용할 메소드 - 환자 ArrayList를 보내줌
		public List<Patient> getPatientList() {
			return patientList;
		}

		public void setPatientList(List<Patient> patientList) {
			this.patientList = patientList;
		}

		// 의사 목록 출력화면에서 사용할 메소드 - 의사 ArrayList를 보내줌
		public List<Doctor> getDoctorList() {
			return doctorList;
		}

		public void setDoctorList(List<Doctor> doctorList) {
			this.doctorList = doctorList;
		}

		// 진료과 목록 출력화면에서 사용할 메소드 - 진료과 ArrayList를 보내줌
		public List<MedicalDepartment> getMedicalDepartmentList() {
			return medicalDepartmentList;
		}

		public void setMedicalDepartmentList(List<MedicalDepartment> medicalDepartmentList) {
			this.medicalDepartmentList = medicalDepartmentList;
		}


		// 환자 추가 메소드 - 환자 등록 화면에서 한명의 환자를 추가했을 때 사용되는 메소드
		public void addPatient(Patient patient) {
			this.patientList.add(patient);
		}
		
		// 의사 추가 메소드 - 의사 등록 화면에서 한명의 의사를 추가했을 때 사용되는 메소드
		public void addDoctor(Doctor doctor) {
			this.doctorList.add(doctor);
		}
		
		// 진료과 추가 메소드 - 진료과 등록 화면에서 진료과를 추가했을 때 사용되는 메소드
		public void addMedicalDepartment(MedicalDepartment medicalDepartment) {
			this.medicalDepartmentList.add(medicalDepartment);
		}

		// 현재 등록된 환자수 확인
		public int getPatientCount() {
			return patientList.size();
		}
		

		// 현재 등록된 의사 숫자
		public int getDoctorCount() {
			return doctorList.size();
		}

		// 현재 등록된 진료과수
		public int getMedicalDepartmentCount() {
			return medicalDepartmentList.size();
		}



}
