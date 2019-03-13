# STUDENT ENROLLMENT MANAGER

### Instructions:

        - To see all the students available in the system press 8 at the main menu

        - To see all the courses available in the system press 9 at the main menu

        - To see all the enrollments available in the system press 4 at the main menu

        - To create a new enrollment, input student id, course id and semester

        - To update an enrollment, input the original student id, course id and semester, then input new info as requested

        - To delete an enrollment, input the original student id, course id and semester

        - To see all enrollments of a student, press 5 at the main menu and input student id

        - To see all enrollments of a semester, press 6 at the main menu and input semester

        - To see all enrollments of a course, press 7 at the main menu and input course id

        - To quit the program press 0 at the main menu


     NOTICE: Please noted that any changes to the enrollment will be prompted with n undo option,
                if you want to undo input "y", else input "n"


### Assumptions:

        - Two enrollments are considered duplicated if their studentId, courseId and semester are identical


### Design patterns used:

        - Builder: is used to build Student objects

        - Singleton: is used to create and maintain only 1 instance of the MemoryStudentEnrollmentManager class

        - Visitor: is used to provide the ability to check for duplicated object (CheckDuplicated Visitor)
                    from a list of objects of 3 different classes Student, Course and StudentEnrollment

        - Command: is used to dispense command to CRUD StudentEnrollment objects and provide undo ability

        - Chain of Responsibility: a chain of instances to print student enrollment data based on
                                    the correct criteria (studentId/courseId/semester)

        - Composite: the Course class holds an array list of Course itself

        - Iterator: is used to create the class StudentList

        - Facade: is used to implement getStudentId() and getCourseId() from Student and Course into StudentEnrollment

        - Dependency Injection: is used to inject Student and Class into StudentEnrollment (constructor and setters)

        - Factory: is used to create objects of class Course
