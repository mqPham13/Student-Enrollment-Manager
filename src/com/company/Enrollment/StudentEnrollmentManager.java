package com.company.Enrollment;

import com.company.Enrollment.StudentEnrollment;

import java.util.List;

public interface StudentEnrollmentManager {
    public void createStudentEnrollment(StudentEnrollment newEnrollment);
    public void updateStudentEnrollment(StudentEnrollment toBeUpdated, StudentEnrollment update);
    public void deleteStudentEnrollment(StudentEnrollment enrollment);
    public List<StudentEnrollment> getAllEnrollments();
}
